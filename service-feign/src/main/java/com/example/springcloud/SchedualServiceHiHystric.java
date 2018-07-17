package com.example.springcloud;

import org.springframework.stereotype.Component;

/**
 * @author ws47033
 * @date 2018/7/17 14:52
 */

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+name;
    }
}
