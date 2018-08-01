package net.honeyflower.lecturing.microservices.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@GetMapping("/message")
    public String sendMessage(){
        return "Hi, this is message from user-service";
    }

}
