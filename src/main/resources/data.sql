INSERT INTO branch (branch_name)
VALUES ('delhi'),('mumbai'),('pune')

INSERT INTO patient (email,name)
VALUES ('abc@gmail.com','archit'),('rahul@gmail.com','rahul')
,('piyush@gmail.com','piyush'),('himanshu@gmail.com','himanshu'),
('puneet@gmail.com','puneet')
,('sumit@gmail.com','sumit')

INSERT INTO vaccines (vcc_name)
VALUES ('type1'),('type2'),('type3')

INSERT INTO vaccine_availability
 (left_vaccine , total_vaccine, branch_id,vaccines_id)
VALUES (5,10,1,1),(23,40,1,2),(15,120,1,3),(51,100,2,3),
(51,100,2,2),(53,100,3,3)



INSERT INTO time_availability
 (booked_date , payment_type, slot_date,slot_status,
  slot_time,branch_id,patient_id)
VALUES 
('2020-12-08','CASH','2020-12-13','BOOKED','9:30-9:45',1,1)


INSERT INTO time_availability
 (booked_date , payment_type, slot_date,slot_status,
  slot_time,branch_id,patient_id)
VALUES 
('2020-12-08','CASH','2020-12-13','PENDING','9:30-9:45',2,3)



INSERT INTO time_availability
 (booked_date , payment_type, slot_date,slot_status,
  slot_time,branch_id,patient_id)
VALUES 
('2020-12-08','CASH','2020-12-13','CONFIRMED','9:30-9:45',1,2)



