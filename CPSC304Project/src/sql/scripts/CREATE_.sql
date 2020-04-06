CREATE TABLE Passenger(
  pid int NOT NULL,
  last_name char(100) NOT NULL,
  first_name char(100) NOT NULL,
  PRIMARY KEY (pid)
);

CREATE TABLE Class(
  class char(100) NOT NULL,
  price int NOT NULL,
  PRIMARY KEY(class),
  Check (price >=0)
);

CREATE TABLE Ticket (
  ticket_no int NOT NULL,
  pid int NOT NULL,
  class char(100) NOT NULL,
  PRIMARY KEY(ticket_no),
  FOREIGN KEY (pid) REFERENCES Passenger(pid) ON DELETE CASCADE,
  FOREIGN KEY (class) REFERENCES Class(class)
);

CREATE TABLE Ticket_book_status(
  ticket_no int NOT NULL,
  pid int NOT NULL,
  book_status char(100) NOT NULL,
  PRIMARY KEY(ticket_no),
  FOREIGN KEY (ticket_no) REFERENCES Ticket(ticket_no) ON DELETE CASCADE
);

CREATE TABLE Train_Status(
  status_id int NOT NULL,
  booked_seats int NOT NULL,
  max_seats int NOT NULL,
  avail_seats int NOT NULL,
  waitlist int NOT NULL,
  PRIMARY KEY(status_id)
);


CREATE TABLE Train(
  train_id int NOT NULL,
  train_type char(100) NOT NULL,
  train_name char(100) NOT NULL,
  status_id int NOT NULL,
  PRIMARY KEY(train_id),
  UNIQUE(status_id),
  FOREIGN KEY (status_id) REFERENCES Train_Status(status_id)
);


CREATE TABLE Seat(
  row_ int NOT NULL,
  seat_no int NOT NULL,
  train_id int NOT NULL,
  PRIMARY KEY(row_, seat_no, train_id),
  FOREIGN KEY (train_id) REFERENCES Train(train_id)
);

CREATE TABLE Ticket_Seat (
    ticket_no int NOT NULL,
    row_ int NOT NULL,
    seat_no int NOT NULL,
    train_id int NOT NULL,
    PRIMARY KEY(ticket_no, row_, seat_no, train_id),
    UNIQUE(row_, seat_no),
    UNIQUE(ticket_no),
    FOREIGN KEY (ticket_no) REFERENCES Ticket(ticket_no) 
    ON DELETE CASCADE,
    FOREIGN KEY (train_id) REFERENCES Train(train_id)  
    ON DELETE CASCADE,
    FOREIGN KEY (row_, seat_no, train_id) REFERENCES Seat(row_, seat_no, train_id)  
    ON DELETE CASCADE
);


CREATE TABLE First_Class(
  row_ int NOT NULL,
  seat_no int NOT NULL,
  train_id int NOT NULL,
  meal_option char(100),
  drink_option char(100),
  entertainment char(100),
  PRIMARY KEY(row_, seat_no, train_id),
  FOREIGN KEY (row_, seat_no, train_id) REFERENCES Seat(row_, seat_no, train_id)
);

CREATE TABLE Economy(
  row_ int NOT NULL,
  seat_no int NOT NULL,
  train_id int NOT NULL,
  PRIMARY KEY(row_, seat_no, train_id),
  FOREIGN KEY (row_, seat_no, train_id) REFERENCES Seat(row_, seat_no, train_id)
);

CREATE TABLE Station(
  station_name char(100) NOT NULL,
  location char(100) NOT NULL,
  PRIMARY KEY(station_name, location)
);

CREATE TABLE Route_Details(
  route_name char(100) NOT NULL,
  start_station_name char(100) NOT NULL,
  start_station_location char(100) NOT NULL,
  end_station_name char(100) NOT NULL,
  end_station_location char(100) NOT NULL,
  UNIQUE (start_station_location, end_station_location),
  PRIMARY KEY(route_name),
  FOREIGN KEY (start_station_name, start_station_location)
    REFERENCES Station(station_name, location),
  FOREIGN KEY (end_station_name, end_station_location)
    REFERENCES Station(station_name, location)
);

CREATE TABLE Route_name(
  route_id int NOT NULL,
  route_name char(100) NOT NULL,
  PRIMARY KEY(route_id),
  FOREIGN KEY (route_name) REFERENCES Route_Details(route_name)
);

CREATE TABLE Station_On_Route(
  route_id int NOT NULL,
  station_name char(100) NOT NULL,
  location char(100) NOT NULL,
  PRIMARY KEY(route_id, station_name,location),
  FOREIGN KEY (route_id) REFERENCES Route_name(route_id),
  FOREIGN KEY (station_name, location) REFERENCES Station(station_name, location)
);

CREATE TABLE Train_Operates_On_Route(
  train_id int NOT NULL,
  route_id int NOT NULL,
  PRIMARY KEY(train_id, route_id),
  FOREIGN KEY (train_id) REFERENCES Train(train_id),
  FOREIGN KEY (route_id) REFERENCES Route_name(route_id)
);


CREATE TABLE Arrives(
  train_id int NOT NULL,
  station_name char(100) NOT NULL,
  location char(100) NOT NULL,
  sched_time timestamp NOT NULL,
  actual_time timestamp NOT NULL,
  PRIMARY KEY(train_id, station_name, location),
  FOREIGN KEY (train_id) REFERENCES Train(train_id),
  FOREIGN KEY (station_name, location) REFERENCES Station(station_name, location)
);

CREATE TABLE Departs(
  train_id int NOT NULL,
  station_name char(100) NOT NULL,
  location char(100) NOT NULL,
  sched_time timestamp NOT NULL,
  actual_time timestamp NOT NULL,
  PRIMARY KEY(train_id, station_name, location),
  FOREIGN KEY (train_id) REFERENCES Train(train_id),
  FOREIGN KEY (station_name, location) REFERENCES Station(station_name, location)
);
