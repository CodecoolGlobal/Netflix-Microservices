CREATE TABLE recommendations (
  id int AUTO_INCREMENT  PRIMARY KEY,
  rating VARCHAR(250) NOT NULL,
  comment VARCHAR(250) NOT NULL,
  videoId int
  );
