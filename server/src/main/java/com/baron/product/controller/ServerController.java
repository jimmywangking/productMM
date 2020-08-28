package com.baron.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 @package com.baron.order.controller
 @author Baron
 @create 2020-08-13-3:09 PM
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is a message!";
    }
}
