package com.example.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ws47033
 * @date 2018/7/17 11:57
 */

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://sevice-client-hi/hi?name="+name,String.class);
    }
}
