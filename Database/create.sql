CREATE TABLE weather.statistics (
                                    id serial  NOT NULL,
                                    city varchar(255)  NOT NULL,
                                    temp decimal  NOT NULL,
                                    wind decimal  NOT NULL,
                                    humidity int  NOT NULL,
                                    time time  NOT NULL,
                                    tracked boolean NOT NULL,
                                    CONSTRAINT contact_pk PRIMARY KEY (id)
);