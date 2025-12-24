package com.yeditepe.swaggerusage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @GetMapping("/welcome/{userId}")
    public ResponseEntity<String> welcome(@PathVariable("userId")
                              String userId) {

        return ResponseEntity.ok("Welcome " + userId);
    }
}
