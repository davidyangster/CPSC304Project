INSERT INTO Passenger VALUES (1,'Abdelfattah','Mazen');
INSERT INTO Passenger VALUES (2,'Yang','David');
INSERT INTO Passenger VALUES (3,'Chiu','Clarence');

INSERT INTO Class VALUES ('first class',100);
INSERT INTO Class VALUES ('economy',50);

INSERT INTO Ticket VALUES (11,1,'first class');
INSERT INTO Ticket VALUES (22,2,'economy');
INSERT INTO Ticket VALUES (33,3,'economy');

INSERT INTO Ticket_book_status VALUES (11,1,'unsuccessful');
INSERT INTO Ticket_book_status VALUES (22,2,'unsuccessful');
INSERT INTO Ticket_book_status VALUES (33,3,'successful');

INSERT INTO Train_Status VALUES (111,120,120,0,10);
INSERT INTO Train_Status VALUES (222,0,150,150,0);
INSERT INTO Train_Status VALUES (333,150,150,0,50);
INSERT INTO Train_Status VALUES (444,10,130,120,0);
INSERT INTO Train_Status VALUES (555,130,130,0,0);

INSERT INTO Train VALUES (101,'Mark 1','A',111);
INSERT INTO Train VALUES (202,'Mark 1','B',222);
INSERT INTO Train VALUES (303,'Mark 2','B',333);
INSERT INTO Train VALUES (404,'Mark 3','A',444);

INSERT INTO Seat VALUES (23,1,101);
INSERT INTO Seat VALUES (24,2,202);
INSERT INTO Seat VALUES (52,3,303);

INSERT INTO Ticket_Seat VALUES (11,23,1,101);
INSERT INTO Ticket_Seat VALUES (22,24,2,202);
INSERT INTO Ticket_Seat VALUES (33,52,3,303);

INSERT INTO First_Class VALUES (23,1,101,'pizza','coke','TV');

INSERT INTO Economy VALUES (24,2,202);
INSERT INTO Economy VALUES (52,3,303);


INSERT INTO Station VALUES ('Brighouse Station','Richmond Center');
INSERT INTO Station VALUES ('Waterfront Station','Waterfront Center');
INSERT INTO Station VALUES ('King George Station','King George Center');

INSERT INTO Route_Details VALUES ('Canada Line','Brighouse Station','Richmond Center','Waterfront Station','Waterfront Center');
INSERT INTO Route_Details VALUES ('Expo Line','Waterfront Station','Waterfront Center','King George Station','King George Center');

INSERT INTO Route_name VALUES (1010,'Canada Line');
INSERT INTO Route_name VALUES (2020,'Expo Line');

INSERT INTO Station_On_Route VALUES (1010,'Brighouse Station','Richmond Center');
INSERT INTO Station_On_Route VALUES (1010,'Waterfront Station','Waterfront Center');
INSERT INTO Station_On_Route VALUES (2020,'Waterfront Station','Waterfront Center');
INSERT INTO Station_On_Route VALUES (2020,'King George Station','King George Center');

INSERT INTO Train_Operates_On_Route VALUES (101,1010);
INSERT INTO Train_Operates_On_Route VALUES (202,1010);
INSERT INTO Train_Operates_On_Route VALUES (303,2020);
INSERT INTO Train_Operates_On_Route VALUES (404,2020);

INSERT INTO Arrives VALUES (101,'Brighouse Station','Richmond Center',TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Arrives VALUES (202,'Waterfront Station','Waterfront Center', TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Arrives VALUES (303,'King George Station','King George Center',TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Arrives VALUES (404,'Brighouse Station','Richmond Center',TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO Departs VALUES (101,'Brighouse Station','Richmond Center',TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Departs VALUES (202,'Waterfront Station','Waterfront Center',TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Departs VALUES (303,'King George Station','King George Center',TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Departs VALUES (404,'Brighouse Station','Richmond Center',TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2020-04-05 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));
