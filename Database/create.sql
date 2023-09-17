CREATE TABLE weather.statistics (
                                    id serial  NOT NULL,
                                    city varchar(255)  NOT NULL,
                                    temp decimal  NOT NULL,
                                    wind decimal  NOT NULL,
                                    humidity int  NOT NULL,
                                    time varchar,
                                    CONSTRAINT statistics_pk PRIMARY KEY (id)
);

CREATE TABLE weather.city (
                                    id serial  NOT NULL,
                                    city varchar(255)  NOT NULL,
                                    CONSTRAINT city_pk PRIMARY KEY (id)
);