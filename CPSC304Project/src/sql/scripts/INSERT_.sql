INSERT INTO Passenger VALUES (1,'Abdelfattah','Mazen');
INSERT INTO Passenger VALUES (2,'Yang','David');
INSERT INTO Passenger VALUES (3,'Chiu','Clarence');

INSERT INTO Class VALUES ('First',100);
INSERT INTO Class VALUES ('Economy',50);

INSERT INTO Ticket_book_status VALUES (11,1,'unsuccessful');
INSERT INTO Ticket_book_status VALUES (22,2,'unsuccessful');
INSERT INTO Ticket_book_status VALUES (33,3,'successful');

INSERT INTO Ticket_Seat VALUES (1,101,23,1);
INSERT INTO Ticket_Seat VALUES (2,202,10,5);
INSERT INTO Ticket_Seat VALUES (3,303,7,1);

INSERT INTO Ticket VALUES (11,1,101,'First');
INSERT INTO Ticket VALUES (22,2,202,'Economy',10,5);
INSERT INTO Ticket VALUES (33,3,303,'Economy',7,1);

INSERT INTO Train_Status VALUES (111,130,120,0,10);
INSERT INTO Train_Status VALUES (222,0,150,150,0);
INSERT INTO Train_Status VALUES (333,200,150,0,50);
INSERT INTO Train_Status VALUES (444,10,130,120,0);
INSERT INTO Train_Status VALUES (555,130,130,0,0);

INSERT INTO Train VALUES (101,'Mark 1','A',111);
INSERT INTO Train VALUES (202,'Mark 1','B',222);
INSERT INTO Train VALUES (303,'Mark 2','B',333);
INSERT INTO Train VALUES (404,'Mark 3','A',444);

INSERT INTO Seat VALUES (101,23,1);
INSERT INTO Seat VALUES (101,23,2);
INSERT INTO Seat VALUES (101,23,3);
INSERT INTO Seat VALUES (202,10,4);
INSERT INTO Seat VALUES (202,10,5);
INSERT INTO Seat VALUES (202,10,6);
INSERT INTO Seat VALUES (303,7,1);
INSERT INTO Seat VALUES (303,7,2);
INSERT INTO Seat VALUES (303,7,3);
INSERT INTO Seat VALUES (404,60,6);
INSERT INTO Seat VALUES (404,63,3);
INSERT INTO Seat VALUES (404,67,4);

INSERT INTO First_Class VALUES (23,1,'pizza','coke','TV');

INSERT INTO Economy VALUES (10,5);
INSERT INTO Economy VALUES (7,1);

INSERT INTO Route_name VALUES (1010,'Canada Line');
INSERT INTO Route_name VALUES (2020,'Expo Line');

INSERT INTO Route_Details VALUES ('Canada Line','Brighouse Station','Richmond Center','Waterfront Station','Waterfront Center');
INSERT INTO Route_Details VALUES ('Expo Line','Waterfront Station','Waterfront Center','King George Station','King George');

INSERT INTO Station_On_Route VALUES (1010,'Brighouse Station','Richmond Center');
INSERT INTO Station_On_Route VALUES (1010,'Waterfront Station','Waterfront Center');
INSERT INTO Station_On_Route VALUES (2020,'Waterfront Station','Waterfront Center');
INSERT INTO Station_On_Route VALUES (2020,'King George Station','King George');

INSERT INTO Train_Operates_On_Route VALUES (101,1010);
INSERT INTO Train_Operates_On_Route VALUES (202,1010);
INSERT INTO Train_Operates_On_Route VALUES (303,2020);
INSERT INTO Train_Operates_On_Route VALUES (404,2020);

INSERT INTO Station VALUES ('Brighouse Station','Richmond Center');
INSERT INTO Station VALUES ('Waterfront Station','Waterfront Center');
INSERT INTO Station VALUES ('King George Station','King George Center');

INSERT INTO Arrives VALUES (101,'Brighouse Station','Richmond Center',2020-04-05 07:00:00,2020-04-05 07:05:00);
INSERT INTO Arrives VALUES (202,'Waterfront Station','Waterfront Center',2020-04-05 07:01:00,2020-04-05 07:00:00);
INSERT INTO Arrives VALUES (303,'King George Station','King George',2020-04-05 19:00:00,2020-04-05 19:01:00);
INSERT INTO Arrives VALUES (404,'Brighouse Station','Richmond Center',2020-04-05 07:10:00,2020-04-05 07:10:00);

INSERT INTO Departs VALUES (101,'Brighouse Station','Richmond Center',2020-04-05 07:06:00,2020-04-05 07:07:00);
INSERT INTO Departs VALUES (202,'Waterfront Station','Waterfront Center',2020-04-05 07:02:00,2020-04-05 07:01:00);
INSERT INTO Departs VALUES (303,'King George Station','King George',2020-04-05 19:02:00,2020-04-05 19:03:00);
INSERT INTO Departs VALUES (404,'Brighouse Station','Richmond Center',2020-04-05 07:11:00,2020-04-05 07:11:00);

#INSERT INTO Status VALUES ('','','');
#INSERT INTO Waitlist VALUES ('','','');
#INSERT INTO Train_Status_Seats VALUES ('','','');
#INSERT INTO Ticket_class VALUES ('','');
#INSERT INTO Ticket_status VALUES ('','','');
#INSERT INTO Schedule VALUES ('','','');
