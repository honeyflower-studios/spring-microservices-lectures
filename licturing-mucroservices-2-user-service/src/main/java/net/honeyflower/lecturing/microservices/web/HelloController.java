package net.honeyflower.lecturing.microservices.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello/client")
public class HelloController {


    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    @GetMapping("/sayhello")
    public String hello() {
        String url = "http://payment-service/payments/pay";
        return restTemplate.getForObject(url, String.class)+ " including client";
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }

}
