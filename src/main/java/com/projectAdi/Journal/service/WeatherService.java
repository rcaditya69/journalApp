package com.projectAdi.Journal.service;

import com.projectAdi.Journal.entity.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherService {
    @Value("${api.key}")
    private  String apikey;
    public static final String api="http://api.weatherstack.com/current?access_key=APIKEY&query=CITY";
    @Autowired
    RestTemplate restTemplate;
    public WeatherResponse getWeather(String city){
        String finalApi=api.replace("APIKEY",apikey).replace("CITY",city);
        ResponseEntity<WeatherResponse> response=restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body=response.getBody();
        return body;
    }
}
