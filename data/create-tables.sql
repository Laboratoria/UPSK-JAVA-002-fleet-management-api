CREATE TABLE taxis(
   id INT PRIMARY KEY,
   plate VARCHAR(9) NOT NULL
);

-- INSERT INTO trajectories (taxi_id, date, latitude, longitude )
-- VALUES ('10133','2008-02-02 16:18:49',116.34692,39.93064);

CREATE TABLE trajectories (
    id INT GENERATED ALWAYS AS IDENTITY,
    taxi_id INT NOT NULL,
    date TIMESTAMP NOT NULL,
    latitude BIGINT NOT NULL,
    longitude BIGINT NOT NULL,
    CONSTRAINT fk_taxi FOREIGN KEY(taxi_id) REFERENCES taxis(id)
);