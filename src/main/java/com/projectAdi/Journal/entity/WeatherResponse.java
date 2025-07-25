package com.projectAdi.Journal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class WeatherResponse{

    public Current current;
    @Getter
    @Setter
    public class Current{
        public int temperature;
        @JsonProperty("weather_descriptions")
        public List<String> weatherDescriptions;
    }

}




