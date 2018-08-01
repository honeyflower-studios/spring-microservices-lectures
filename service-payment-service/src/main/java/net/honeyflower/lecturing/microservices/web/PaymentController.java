package net.honeyflower.lecturing.microservices.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @GetMapping(value = "/message")
    public String getMessage(){
        return "Hi, this is message from payment-service";
    }
    
    @GetMapping("pay")
    public String pay() {
        return "payment approved";
    }
}
