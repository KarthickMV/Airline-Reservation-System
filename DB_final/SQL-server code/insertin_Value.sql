--CREATE TRIGGER mytrigger
--  BEFORE 
--  INSERT
--  ON dbo.Aircraft
--  FOR EACH ROW
--  SET new.aircraft_id =  CONCAT('B', cast(aircraft_id as varchar(11)));


SET IDENTITY_INSERT dbo.Aircraft ON

insert into dbo.Aircraft (
	aircarft_id,
	arcft_type,
	mfg_date
)
values (1,737,'2010-07-07'),
(2,747,'2010-08-05');
select * from Aircraft;

SET IDENTITY_INSERT dbo.Aircraft off

SET IDENTITY_INSERT dbo.Route ON
insert into dbo.Route( rout_id, souce, destination, route_code )
values 
(1, 'Delhi', 'Banglore', 101),
(2, 'Banglore', 'Chennai', 102),
(3, 'Delhi', 'Chennai', 103),
(4, 'Delhi', 'Hyderabad', 104),
(5, 'Hyderabad', 'Chennai', 105);

select * from Route;
SET IDENTITY_INSERT dbo.Route off

SET IDENTITY_INSERT dbo.Airfare ON


insert into dbo.Airfare(Af_Id,route_id,fare)
values 
(20,1,4000),
(21,2,3000),
(22,3,5000),
(24,4,4000),
(25,5,3000);

SET IDENTITY_INSERT dbo.Airfare Off

SET IDENTITY_INSERT dbo.flight_schedule On
insert into dbo.flight_schedule (fid,flight_date,departure_time,arrival_time,aircraft,netfare)
values
(70, '2021-05-06', '2021-05-06 13:23:44', '2021-05-06 15:45:21', 2,20 ),
(71, '2021-05-06', '2021-05-06 16:23:44', '2021-05-06 17:45:21', 2,21),
(72, '2021-05-06', '2021-05-06 14:23:44', '2021-05-06 18:45:21', 2,22),
(73, '2021-05-06', '2021-05-06 16:23:44', '2021-05-06 18:45:21', 1,24),
(74, '2021-05-06', '2021-05-06 19:23:44', '2021-05-06 20:45:21', 1,25);


delete from dbo.flight_schedule;

(select dbo.Airfare.route_id, dbo.flight_schedule.fid, dbo.flight_schedule.flight_date, dbo.Airfare.fare, 
dbo.Route.souce, dbo.Route.destination,  dbo.flight_schedule.departure_time, dbo.flight_schedule.arrival_time
from
((flight_schedule  inner join Airfare on flight_schedule.netfare=Airfare.Af_Id))
inner join Route on Route.rout_id = Airfare.route_id
where souce = 'Delhi' and destination = 'Chennai') 


select dbo.Airfare.route_id, dbo.flight_schedule.fid, dbo.flight_schedule.flight_date, dbo.Airfare.fare, 
dbo.Route.souce, dbo.Route.destination,  dbo.flight_schedule.departure_time, dbo.flight_schedule.arrival_time
from
((flight_schedule  inner join Airfare on flight_schedule.netfare=Airfare.Af_Id))
inner join Route on Route.rout_id = Airfare.route_id
where dbo.Route.souce= 'Delhi' and destination IN 
(
select destination
from
((flight_schedule  inner join Airfare on flight_schedule.netfare=Airfare.Af_Id))
inner join Route on Route.rout_id = Airfare.route_id
where souce = 'Delhi' and destination != 'Chennai') 



(select dbo.Airfare.route_id, dbo.flight_schedule.fid, dbo.flight_schedule.flight_date, dbo.Airfare.fare, 
dbo.Route.souce, dbo.Route.destination,  dbo.flight_schedule.departure_time, dbo.flight_schedule.arrival_time
from
((flight_schedule  inner join Airfare on flight_schedule.netfare=Airfare.Af_Id))
inner join Route on Route.rout_id = Airfare.route_id
where dbo.Route.souce IN 
(select destination
from
((flight_schedule  inner join Airfare on flight_schedule.netfare=Airfare.Af_Id))
inner join Route on Route.rout_id = Airfare.route_id
where souce = 'Delhi' and destination != 'Chennai') and destination='Chennai')





SELECT        dbo.Airfare.route_id, dbo.flight_schedule.fid, dbo.flight_schedule.flight_date, dbo.Airfare.fare, 
dbo.Route.souce, dbo.Route.destination, dbo.Aircraft.arcft_type, dbo.flight_schedule.departure_time, dbo.flight_schedule.arrival_time
FROM            dbo.Aircraft INNER JOIN
                         dbo.flight_schedule ON dbo.Aircraft.aircarft_id = dbo.flight_schedule.aircraft INNER JOIN
                         dbo.Airfare ON dbo.flight_schedule.netfare = dbo.Airfare.Af_Id INNER JOIN
                         dbo.Route ON dbo.Airfare.route_id = dbo.Route.rout_id