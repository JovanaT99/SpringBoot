package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

//da bi Content-Type bio JSON
@Configuration
class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation( ContentNegotiationConfigurer configurer )
    {
        configurer.defaultContentType( MediaType.APPLICATION_JSON );
    }
}

@RestController
public class Task2 
{
    final
    RestTemplate restTemplate;
//Koriscenje spoljnog api-ja
    public Task2(RestTemplate restTemplate)
    {

        this.restTemplate = restTemplate;
    }
    
    @RequestMapping(value = "/search")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://api.tvmaze.com/search/shows?q=girls", HttpMethod.GET, entity, String.class).getBody();

        //localhost:9005/search
        //api tvmaze searcha
    }
//search po id-iju
    @GetMapping("/search/{id}")
    public String getById(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://api.tvmaze.com/shows/"+id, HttpMethod.GET, entity, String.class).getBody();
        //id
        //api tvmaze id
        //localhost:9005/search/139
    }
}
