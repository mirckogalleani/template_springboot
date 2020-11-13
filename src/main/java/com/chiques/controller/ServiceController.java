package com.chiques.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ServiceController {

    @GetMapping("/")
    public ResponseEntity<String> defaultEnpoint() {
        return new ResponseEntity<>(HttpStatus.OK.name(), HttpStatus.OK);
    }

    @GetMapping("/readiness")
    public ResponseEntity<String> testLiveness() {
        return new ResponseEntity<>(HttpStatus.OK.name(), HttpStatus.OK);
    }
   
    @PostMapping (value = "/test")
    @ResponseBody
    public ResponseEntity<String> method(@RequestBody String request) {
        try {
            
            // Service service = new Service(encoder, parser);
            // service.invoke(request);
            
            return new ResponseEntity<>(HttpStatus.OK.name(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}