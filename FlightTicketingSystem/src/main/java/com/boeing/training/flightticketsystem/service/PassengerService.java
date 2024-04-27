package com.boeing.training.flightticketsystem.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boeing.training.flightticketsystem.model.BookingInfo;
import com.boeing.training.flightticketsystem.model.FlightLeg;
//import com.boeing.training.flightticketsystem.model.FlightLegDTO;
import com.boeing.training.flightticketsystem.model.Passenger;
import com.boeing.training.flightticketsystem.model.PassengerDTO;
import com.boeing.training.flightticketsystem.model.Payment;
import com.boeing.training.flightticketsystem.model.Seat;
import com.boeing.training.flightticketsystem.model.SeatID;
import com.boeing.training.flightticketsystem.model.Ticket;
import com.boeing.training.flightticketsystem.model.TicketDTO;
import com.boeing.training.flightticketsystem.model.UserDetail;
import com.boeing.training.flightticketsystem.repository.BookingInfoRepository;
import com.boeing.training.flightticketsystem.repository.FlightLegRepository;
import com.boeing.training.flightticketsystem.repository.LegInstanceRepository;
import com.boeing.training.flightticketsystem.repository.PassengerRepository;
import com.boeing.training.flightticketsystem.repository.PaymentRepository;
import com.boeing.training.flightticketsystem.repository.SeatRepository;
import com.boeing.training.flightticketsystem.repository.TicketRepository;
import com.boeing.training.flightticketsystem.repository.UserRepository;

@Service
public class PassengerService {
	
	@Autowired(required=true)
	private BookingInfoRepository bookingInfoRepository;
	@Autowired(required=true)
	private PassengerRepository passengerRepository;
	@Autowired(required=true)
	private PaymentRepository paymentRepository;
	@Autowired(required=true)
	private TicketRepository ticketRepository;
	@Autowired(required=true)
	private UserRepository userRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private FlightLegRepository flightlegrepository;
	@Autowired
	private SeatRepository seatrepository;
	@Autowired
	private LegInstanceRepository leginstancerepository;
	
	public Boolean SaveBooking(BookingInfo bookinf,HttpSession htsession) {
        int userid = (int)htsession.getAttribute("userid");
        UserDetail user=userRepository.findByUserid(userid);
        bookinf.setUserdetail(user);
        bookinf.setBookingDate(Date.valueOf(bookinf.getBookDate()));
        bookinf.setDepDate(Date.valueOf(bookinf.getDepartureDate()));
		BookingInfo book1 = bookingInfoRepository.save(bookinf);
		int id = (int) book1.getBookingId();
		System.out.println(id);
	    htsession.setAttribute("bookingId", id);
		return true;
	}

	@Transactional
	public Boolean addPassenger(List<Passenger> passinfo, HttpSession htsession) {
		List <Passenger> list1=new ArrayList<Passenger>();
		int id=(int)htsession.getAttribute("bookingId");
		for(Passenger p:passinfo) {
	    BookingInfo bkinfo = bookingInfoRepository.findByBookingId(id);
		p.setBookingid(bkinfo);
		p=passengerRepository.save(p);
		list1.add(p);
}
		return true;
	}

	//to find the seat number
	public int findSeatNumber(BookingInfo bkinfo) {
		Optional<List<Seat>> proxyseatlist = seatrepository.findByDepdateAndLegnoAndFlightnoOrderBySeatnoDesc(bkinfo.getDepDate(), bkinfo.getLegNo(), bkinfo.getFlightNo());
		try{
			if(proxyseatlist.get().get(0)!=null) {
			Optional<Seat> seat = proxyseatlist.get().stream().findFirst();
			return seat.get().getSeatno()+1;
		}}catch(IndexOutOfBoundsException e) {
			
		}
		return 1;
	}
	
	@Transactional
	public Boolean addpaytype(Payment info,HttpSession htsession) {
		int id=(int)htsession.getAttribute("bookingId");
		BookingInfo bkinfo = bookingInfoRepository.findByBookingId(id);
		Payment pay=info;
		pay.setBookingid(bkinfo);
		pay=paymentRepository.save(info);
		long id1 = pay.getPayId();
		int i = findSeatNumber(bkinfo);
		if(id1!=0) {
			List<Passenger> passengerlist = passengerRepository.findByBookingno(id);
			for(Passenger passenger:passengerlist) {
				SeatID seatid = new SeatID();
				seatid.setSeatno(i);
				seatid.setFlightno(bkinfo.getFlightNo());
				seatid.setLegno(bkinfo.getLegNo());
				seatid.setDepdate(bkinfo.getDepDate());
				Seat seat = new Seat();
				seat.setSeatid(seatid);
				seat.setPassenger(passenger);
				seat = seatrepository.save(seat);
				passenger.setSeatno(seatid.getSeatno());
				passengerRepository.save(passenger);
				i++;
			}
			Ticket ticket= new Ticket();
			ticket.setBookingid(bookingInfoRepository.findByBookingId(id));
			ticket.setPayid(pay);
			ticket = ticketRepository.save(ticket);
			leginstancerepository.updateAvailableSeats(bkinfo.getDepDate().toLocalDate(), bkinfo.getLegNo(), bkinfo.getFlightNo());
		}
		htsession.setAttribute("payId", id1);
		return true;
	}
    public TicketDTO getLatestTicket(HttpSession htsession) {
        int userid = (int)htsession.getAttribute("userid");
        if(userid==0) {
        	System.out.println("Invalid");
        }
        Optional<List<BookingInfo>> proxybookinfo = bookingInfoRepository.findByUserIdOrderByBookingIdDesc(userid);
        if(proxybookinfo.isPresent()) {
            List<BookingInfo> list = proxybookinfo.get();
        	for(BookingInfo bookinfo:list) {
        		Optional<Ticket> ticket = ticketRepository.findByBookingid(bookinfo);
        		if(ticket.isPresent()) {
        			TicketDTO ticketdto = converttoticketDto(ticket.get());
        			return ticketdto;
        		}
        	}
        }
        return new TicketDTO();
   }

	public TicketDTO converttoticketDto(Ticket ticket) {
		BookingInfo bookinfo = ticket.getBookingid();
		TicketDTO dto= new TicketDTO();
		dto.setTicketId(ticket.getTicketId());
		dto.setBookingDate(bookinfo.getBookingDate());
		dto.setDepDate(bookinfo.getDepDate());
		dto.setFlightno(bookinfo.getFlightNo());
		List<Passenger> passengers = passengerRepository.findByBookingno(bookinfo.getBookingId());
		dto.setPassengerlist(passengers.stream().map(this::convertToPassengerDTO).collect(Collectors.toList()));
		Optional<FlightLeg> flightleg = flightlegrepository.findByFlightnoAndLegno(bookinfo.getFlightNo(),(long)bookinfo.getLegNo());
		dto.setArrairportcode(flightleg.get().getArrairportcode());
		dto.setDepairportcode(flightleg.get().getDepairportcode());
		dto.setDeptime(flightleg.get().getDeptime());
		dto.setArrtime(flightleg.get().getArrtime());
		return dto;
	}
	
	public PassengerDTO convertToPassengerDTO(Passenger pass) {
		 modelMapper.getConfiguration()
         .setMatchingStrategy(MatchingStrategies.LOOSE);
	PassengerDTO dto = modelMapper
         .map(pass, PassengerDTO.class);	
	return dto;
	}

}
