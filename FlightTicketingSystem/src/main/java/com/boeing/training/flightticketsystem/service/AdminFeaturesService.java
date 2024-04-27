package com.boeing.training.flightticketsystem.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boeing.training.flightticketsystem.model.AddFlightResponseObject;
import com.boeing.training.flightticketsystem.model.Airport;
import com.boeing.training.flightticketsystem.model.BookingInfo;
import com.boeing.training.flightticketsystem.model.Flight;
import com.boeing.training.flightticketsystem.model.FlightDTO;
import com.boeing.training.flightticketsystem.model.FlightID;
import com.boeing.training.flightticketsystem.model.FlightLeg;
import com.boeing.training.flightticketsystem.model.FlightLegDTO;
import com.boeing.training.flightticketsystem.model.FlightModelValue;
import com.boeing.training.flightticketsystem.model.FlightRemovalResponseObject;
import com.boeing.training.flightticketsystem.model.Passenger;
import com.boeing.training.flightticketsystem.model.Payment;
import com.boeing.training.flightticketsystem.model.Seat;
import com.boeing.training.flightticketsystem.model.Ticket;
import com.boeing.training.flightticketsystem.model.TicketCancellation;
import com.boeing.training.flightticketsystem.model.TicketCancellationDTO;
import com.boeing.training.flightticketsystem.model.UserBookingDTO;
import com.boeing.training.flightticketsystem.model.UserDetail;
import com.boeing.training.flightticketsystem.model.legInstance;
import com.boeing.training.flightticketsystem.repository.AirportRepository;
import com.boeing.training.flightticketsystem.repository.BookingInfoRepository;
import com.boeing.training.flightticketsystem.repository.FlightLegRepository;
import com.boeing.training.flightticketsystem.repository.FlightRepository;
import com.boeing.training.flightticketsystem.repository.LegInstanceRepository;
import com.boeing.training.flightticketsystem.repository.PassengerRepository;
import com.boeing.training.flightticketsystem.repository.PaymentRepository;
import com.boeing.training.flightticketsystem.repository.SeatRepository;
import com.boeing.training.flightticketsystem.repository.TicketCancellationRepository;
import com.boeing.training.flightticketsystem.repository.TicketRepository;
import com.boeing.training.flightticketsystem.repository.UserRepository;

@Service
public class AdminFeaturesService {
	
	@Autowired
	private FlightRepository flightrepository;
	

	@Autowired
	private FlightLegRepository flightlegrepository;
	
	@Autowired
	private AirportRepository airportrepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired(required=true)
	public UserRepository userRepository;
	
	@Autowired
	private BookingInfoRepository bookinginforepository;
	
	@Autowired
	private TicketRepository ticketrepository;
	
	@Autowired
	private TicketCancellationRepository ticketcancellationRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private PaymentRepository paymentrepository;
	
	@Autowired
	private LegInstanceRepository leginstancerepository;
	
	@Autowired
	private SeatRepository seatrepository;
	
	//To list all cancellation requests made
	public List<TicketCancellationDTO> getcancellationlist() {
		
		Optional<List<TicketCancellation>> proxylist = ticketcancellationRepository.findByStatus("PENDING") ;
		try{
			if(proxylist.get().get(0)!=null) {
				System.out.println(proxylist.get().get(0));
				return proxylist.get()
							.stream()
							.map(this::convertToTicketCancellationDTO)
							.collect(Collectors.toList());
			}	
		}catch(IndexOutOfBoundsException e) {
			
		}
		return new ArrayList<TicketCancellationDTO>();
		}
	
	
	//method to check existence of user
	public boolean isUserPresent(UserDetail user) {
		Optional<UserDetail> proxyuser = userRepository.findByUname(user.getUname());
		if(proxyuser.isPresent()) {
			List<String> userrole= Arrays.stream(proxyuser.get().getAdmin().split(",")).collect(Collectors.toList());
			if(userrole.contains("ROLE_ADMIN")) {
				return false;
			}
			return true;
		}else {
			return false;
		}
	}
	
	//method to check if an user's booking exists
	public List<UserBookingDTO> getuserbooking(UserDetail user){
		Optional<UserDetail> userdetail = userRepository.findByUname(user.getUname());
		Optional<List<BookingInfo>> proxybookinginfo = bookinginforepository.findByUserIdOrderByBookingId(userdetail.get().getUserid());
		List<Ticket> ticketlist = new ArrayList<Ticket>();
		try {
			
		if(proxybookinginfo.get().get(0)!=null) {
			for(BookingInfo bookinfo:proxybookinginfo.get()) {
				Optional<Ticket> ticket  = ticketrepository.findByBookingid(bookinfo);
				if(ticket.isPresent()) {
					ticketlist.add(ticket.get());
				}
			}
			return ticketlist.stream()
					.map(this::convertToUserBookingDTO)
					.collect(Collectors.toList());
		}
		
	}catch(IndexOutOfBoundsException e) {
		
	}
		
	return new ArrayList<UserBookingDTO>();
	}
	
	
	//To remove flight
	@Transactional
	public FlightRemovalResponseObject removeFlight(FlightLegDTO fmv) {
		FlightRemovalResponseObject res = new FlightRemovalResponseObject();
		Flight flight;
		Optional<Flight> proxyflight = flightrepository.findByFlightid(fmv.getFlightno());
		// To remove just an instance in the flight leg
		if(fmv.getLegno()!=null && fmv.getFlightno()!=null && proxyflight.isPresent()) {
			Optional<FlightLeg> proxyFlightLeg = flightlegrepository.findByFlightnoAndLegno(fmv.getFlightno(), fmv.getLegno());
			Optional<List<FlightLeg>> proxylegs = flightlegrepository.findByFlightno(fmv.getFlightno());
			flight = proxyflight.get();
			int i=0;
			if(proxylegs.isPresent()) {
				for(FlightLeg flightleg:proxylegs.get()) {
					flightleg.getClass();
					i++;
				}
			}
			if(proxyFlightLeg.isPresent()) {
				flightlegrepository.delete(proxyFlightLeg.get());
				if(i==1) {
					flightrepository.delete(flight);
				}
				res.setLeginstance(true);
				return res;
			}else {
				res.setLeginstance(false);
				return res;
			}
		}
		
		if(fmv.getFlightno()!=null) {
			Optional<List<FlightLeg>> proxylegs = flightlegrepository.findByFlightno(fmv.getFlightno());
			if(proxylegs.isPresent()) {
				flightlegrepository.deleteAll(proxylegs.get());
				flight = proxyflight.get();
				flightrepository.delete(flight);
				res.setAllflights(true);
				return res;
			}else {
				res.setAllflights(false);
				return res;
			}
		}else {
			res.setAllflights(false);
			return res;
		}
	}
		
		
	
	public long findLegNo(Flight flight) {
		List<FlightLeg> list = new ArrayList<FlightLeg>();
		Optional<List<FlightLeg>> proxylist = flightlegrepository.findByFlightOrderByLegnoDesc(flight);
		if(proxylist.isPresent()) {
			list=proxylist.get();
			Optional<FlightLeg> flightleg1=list.stream().findFirst();
			if(flightleg1.isPresent()) {
				return flightleg1.get().getLegno()+1;
			}else {
				return 1;
			}
			
		}else {
			return 1;
		}
	}
		
	//to add flights along with validation for airport,timings,airport runway timings, and success
	@Transactional
	public AddFlightResponseObject addFlight(FlightModelValue fmv,AddFlightResponseObject res) {
		Flight flight = new Flight();
		Optional<Flight> proxyflight = flightrepository.findByFlightid(fmv.getFlightno());
		if(proxyflight.isPresent()) {
			flight = proxyflight.get();
			flight.setAirline(fmv.getAirline());
			flight.setMaxseats(fmv.getMaxseats());
			flight.setOccurence(fmv.getOccurence());
			flight.setStartdate(Date.valueOf(fmv.getStartdate()));
			flight = flightrepository.save(flight);
		}else {
			flight.setAirline(fmv.getAirline());
			flight.setFlightid(fmv.getFlightno());
			flight.setMaxseats(fmv.getMaxseats());
			flight.setOccurence(fmv.getOccurence());
			flight.setStartdate(Date.valueOf(fmv.getStartdate()));
			flight = flightrepository.save(flight);
		}
		Airport depairport,arrairport = new Airport();
		depairport= airportrepository.findByAirportcode(fmv.getDepairport());
		arrairport= airportrepository.findByAirportcode(fmv.getArrairport());
		

		//To check airport runway timings
			if(depairport!=null && arrairport!=null ) {
				while(true) {	
					Optional<List<FlightLeg>> proxydepair = flightlegrepository.findByDepairport(depairport);
					if(!proxydepair.isPresent()) {
						break ;
					}
					for(FlightLeg f : proxydepair.get()) {
						Time t1 = f.getDeptime();
						LocalTime lcltime1 = t1.toLocalTime();
						 LocalTime lcltime2 = t1.toLocalTime();
						 lcltime1 = lcltime1.plusMinutes(2);
						 lcltime2 = lcltime2.minusMinutes(2);
						 if((Time.valueOf(fmv.getDeptime()).toLocalTime().isAfter(lcltime2)&&Time.valueOf(fmv.getDeptime()).toLocalTime().isBefore(lcltime1))){
								 res.setDepairportrunwaynotavailable(true);
							 break;
						 }
					}
					break;
				}
				
				while(true) {	
					Optional<List<FlightLeg>> proxydepair = flightlegrepository.findByArrairport(depairport);
					if(!proxydepair.isPresent()) {
						break ;
					}
					for(FlightLeg f : proxydepair.get()) {
						 Time t2 = f.getArrtime();
							LocalTime lcltime3 = t2.toLocalTime();
							 LocalTime lcltime4 = t2.toLocalTime();
							 lcltime3 = lcltime3.plusMinutes(2);
							 lcltime4 = lcltime4.minusMinutes(2);
						 if((Time.valueOf(fmv.getDeptime()).toLocalTime().isAfter(lcltime4)&&Time.valueOf(fmv.getDeptime()).toLocalTime().isBefore(lcltime3))){
							 res.setDepairportrunwaynotavailable(true);
							 break;
						 }
					}
					break;
				}
			
				while(true) {
					Optional<List<FlightLeg>> proxyarrair = flightlegrepository.findByArrairport(arrairport);
					if(!proxyarrair.isPresent()) {
						break ;
					}
					for(FlightLeg f : proxyarrair.get()) {
						Time t2 = f.getArrtime();
						LocalTime lcltime3 = t2.toLocalTime();
						 LocalTime lcltime4 = t2.toLocalTime();
						 lcltime3 = lcltime3.plusMinutes(2);
						 lcltime4 = lcltime4.minusMinutes(2);
						 //String output = localtime.toString();
						 if((Time.valueOf(fmv.getArrtime()).toLocalTime().isAfter(lcltime4)&&Time.valueOf(fmv.getArrtime()).toLocalTime().isBefore(lcltime3))){
							 res.setArrairportrunwaynotavailable(true);
							 break ;
						 }
					}
					break;
				}
				
				while(true) {
					Optional<List<FlightLeg>> proxyarrair = flightlegrepository.findByDepairport(arrairport);
					if(!proxyarrair.isPresent()) {
						break ;
					}
					for(FlightLeg f : proxyarrair.get()) {
						Time t1 = f.getDeptime();
						LocalTime lcltime1 = t1.toLocalTime();
						 LocalTime lcltime2 = t1.toLocalTime();
						 lcltime1 = lcltime1.plusMinutes(2);
						 lcltime2 = lcltime2.minusMinutes(3);
						 if((Time.valueOf(fmv.getArrtime()).toLocalTime().isAfter(lcltime2)&&Time.valueOf(fmv.getArrtime()).toLocalTime().isBefore(lcltime1))){
							 res.setArrairportrunwaynotavailable(true);
							 break ;
						 }
					}
					break;
				}	
			}
		
	//To validate the airport (src and dest) for multiple leg instances 
		if(findLegNo(flight)>1) {
			List<FlightLeg> list = flightlegrepository.findByFlightOrderByDeptime(flight);
			FlightLeg f1 = list.stream().findFirst().get();
			for(FlightLeg listflights: list) {
				if(Time.valueOf(fmv.getDeptime()).before(listflights.getDeptime())) {
					Time t1 = Time.valueOf(fmv.getArrtime());
					 LocalTime localtime = t1.toLocalTime();
					 localtime = localtime.plusMinutes(60);
					if(localtime.isAfter(listflights.getDeptime().toLocalTime())) {
						res.setNotavailable(true);
					}
				}
				if(Time.valueOf(fmv.getDeptime()).after(listflights.getDeptime())) {
					Time t1 = Time.valueOf(fmv.getDeptime());
					 LocalTime localtime = t1.toLocalTime();
					 localtime = localtime.minusMinutes(60);
					if(localtime.isBefore(listflights.getArrtime().toLocalTime())) {
						res.setNotavailable(true);
					}
				}
				if(Time.valueOf(fmv.getDeptime()).equals(listflights.getDeptime())) {
					res.setNotavailable(true);
				}
			}
			List<FlightLeg> reverselist = flightlegrepository.findByFlightOrderByDeptimeDesc(flight);
			FlightLeg lastflight = reverselist.stream().findFirst().get();
				if(Time.valueOf(fmv.getDeptime()).before(f1.getDeptime())) {
					if(Time.valueOf(fmv.getArrtime()).before(f1.getDeptime())) {
						if(!fmv.getArrairport().equals(f1.getDepairport().getAirportcode())) {
							res.setFlight(true);
						}
					}
				}
				else if(Time.valueOf(fmv.getDeptime()).after(lastflight.getDeptime())) {
					
					if(Time.valueOf(fmv.getDeptime()).after(lastflight.getArrtime())) {
						if(!fmv.getDepairport().equals(lastflight.getArrairport().getAirportcode())) {
							res.setFlight(true);
						}
					}
				}else {
					res.setFlight(true);
				}	
		}
		
		//To check for the validation variables
		if(res.isDepairportrunwaynotavailable()||res.isArrairportrunwaynotavailable()||res.isFlight()||res.isNotavailable()) {
			if(findLegNo(flight)==1) {
				flightrepository.delete(flight);
			}
			return res;
		}
		
		//To save the flight leg object
		FlightID flightid= new FlightID();
		flightid.setFlightno(flight.getFlightid());
		flightid.setLegno(findLegNo(flight));
		FlightLeg flightleg = new FlightLeg();
		flightleg.setId(flightid);
		flightleg.setArrairport(arrairport);
		flightleg.setDepairport(depairport);
		flightleg.setFlight(flight);
		flightleg.setArrtime(Time.valueOf(fmv.getArrtime()));
		flightleg.setDeptime(Time.valueOf(fmv.getDeptime()));
		flightleg.setBasefare(fmv.getBasefare());
		flightleg = flightlegrepository.save(flightleg);
		res.setSuccess(true);
		res.setAddedflight(flightleg);
		return res;
	}
	
	//to add values inside of leg instance
	public AddFlightResponseObject addLegInstance(FlightModelValue fmv,AddFlightResponseObject res) {
		addFlight(fmv,res);
		if(res.getAddedflight()!=null) {
			leginstancerepository.addLegInstance(res.getAddedflight().getId().getFlightno(), res.getAddedflight().getFlight().getStartdate().toLocalDate(),res.getAddedflight().getId().getLegno().intValue());
		}
		return res;
	}

	//to list all flights for a given leg
	public List<FlightLegDTO> getleginstances(String flightno) {
		Optional<List<FlightLeg>> proxyleg = flightlegrepository.findByFlightno(flightno);
		if(proxyleg.isPresent()) {
			return proxyleg
					.get()
					.stream()
					.map(this::convertToFlightLegDTO)
					.collect(Collectors.toList());
		}else {
			return new ArrayList<FlightLegDTO>(); 
		}		
	}
	
	//Mapper method
	private FlightLegDTO convertToFlightLegDTO(FlightLeg leg) { 
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
		FlightLegDTO dto = modelMapper
                .map(leg, FlightLegDTO.class);	
        return dto;
    }
	
	//mapper method for userbookingdto
	private UserBookingDTO convertToUserBookingDTO(Ticket ticket) {
		modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.LOOSE);
		UserBookingDTO dto = modelMapper
				.map(ticket, UserBookingDTO.class);
		BookingInfo bookinfo = ticket.getBookingid();
		Optional<FlightLeg> proxyflightleg = flightlegrepository.findByFlightnoAndLegno(bookinfo.getFlightNo(),(long) bookinfo.getLegNo());
		if(proxyflightleg.isPresent()) {
			dto.setDepairportcode(proxyflightleg.get().getDepairportcode());
			dto.setArrairportcode(proxyflightleg.get().getArrairportcode());
		}
		return dto;
	}

	//mapper method for ticketcancellation
	private TicketCancellationDTO convertToTicketCancellationDTO(TicketCancellation ticketcancellation) {
		TicketCancellationDTO dto = new TicketCancellationDTO();
		dto.setCancelid(ticketcancellation.getCancelId());
		dto.setStatus(ticketcancellation.getStatus());
		Ticket ticket = ticketcancellation.getTicketid();
		dto.setTicketid(ticket.getTicketId());
		BookingInfo bookinfo = ticket.getBookingid();
		dto.setBookingDate(bookinfo.getBookingDate());
		dto.setDepDate(bookinfo.getDepDate());
		dto.setFlightno(bookinfo.getFlightNo());
		Optional<FlightLeg> proxyflightleg = flightlegrepository.findByFlightnoAndLegno(bookinfo.getFlightNo(),(long) bookinfo.getLegNo());
		if(proxyflightleg.isPresent()) {
			dto.setDepairportcode(proxyflightleg.get().getDepairportcode());
			dto.setArrairportcode(proxyflightleg.get().getArrairportcode());
		}
		return dto;
	}
	
	//mapper method for FlightDTO
	private FlightDTO convertToFlightDTO(String flightno) {
		Optional<List<FlightLeg>> proxyleg = flightlegrepository.findByFlightno(flightno);
		//Optional<List<BookingInfo>> proxybooking = bookinginforepository.findByFlightNo(flightno);
		FlightDTO dto= new FlightDTO();
		try {
			if(proxyleg.get().get(0)!=null) {
				FlightLeg leg = proxyleg.get().get(0);
				dto.setAirline(leg.getFlight().getAirline());
				dto.setFlightno(leg.getFlightno());
				dto.setOccurence(leg.getFlight().getOccurence());
				dto.setStartdate(leg.getFlight().getStartdate());
				dto.setNoOfPassenger((int)(leg.getFlight().getMaxseats()));
			}
		}catch(IndexOutOfBoundsException e) { 
		}
		
		return dto;
	}

	
	//for dynamic validation for flight
	public FlightDTO isFlightPresent(String flightno) {
		FlightDTO dto = this.convertToFlightDTO(flightno);
		return dto;
	}

	//method to alter cancellation status and make appropriate changes
	@Transactional
	public boolean changeCancellationStatus(TicketCancellationDTO dto) {
		int cancelid = dto.getCancelid();
		String status = dto.getStatus();
		if(status.equalsIgnoreCase("declined")) {
			TicketCancellation ticketcancellation = ticketcancellationRepository.findByCancelId(cancelid);
			ticketcancellation.setStatus("DECLINED");
			ticketcancellationRepository.save(ticketcancellation);
			return true;
		}else if(status.equalsIgnoreCase("approved")) {
			TicketCancellation ticketcancellation = ticketcancellationRepository.findByCancelId(cancelid);
			ticketcancellation.setStatus("APPROVED");
			ticketcancellation = ticketcancellationRepository.save(ticketcancellation);
			boolean success = makeDBChangesbyCancellation(ticketcancellation);
			if(success) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	//method to make changes in the db when cancellation request is set to approved
	@Transactional
	public boolean makeDBChangesbyCancellation(TicketCancellation ticketcancel) {
		Ticket ticket = ticketcancel.getTicketid();
		Payment payment = ticket.getPayid();
		BookingInfo bookinfo = ticket.getBookingid();
		List<Passenger> passengers = passengerRepository.findByBookingid(bookinfo);
		List<Seat> seating=new ArrayList<Seat>();
		for(Passenger passenger: passengers) {
			Optional<Seat> seat = seatrepository.findByDepdateAndLegnoAndFlightnoAndPassenger(bookinfo.getDepDate(), bookinfo.getLegNo(), bookinfo.getFlightNo(), passenger);
			if(seat.isPresent()) {
				seating.add(seat.get());
				legInstance leginstance= leginstancerepository.findByDepdateAndFlightnoAndLegno(bookinfo.getDepDate(), bookinfo.getFlightNo(),(long) bookinfo.getLegNo());
				int seats = leginstance.getAvailableSeats();
				leginstance.setAvailableSeats(seats+1);
				leginstancerepository.save(leginstance);
			}
		}
		seatrepository.deleteAll(seating);
		passengerRepository.deleteAll(passengers);
		paymentrepository.delete(payment);
		ticketcancellationRepository.delete(ticketcancel);
		ticketrepository.delete(ticket);
		paymentrepository.delete(payment);
		return true;
	}
	
}
