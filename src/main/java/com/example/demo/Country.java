package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import java.util.Arrays;

@RestController
public class Country {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ip/5.6.7.8/country")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "https://api.ip2country.info/ip?5.6.7.8", HttpMethod.GET, entity, String.class).getBody();

        //http://localhost:9002/ip/5.6.7.8/country

    }}
