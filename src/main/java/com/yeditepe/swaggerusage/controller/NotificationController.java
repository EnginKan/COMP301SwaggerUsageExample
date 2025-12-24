package com.yeditepe.swaggerusage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @GetMapping("/welcome/{userId}")
    public ResponseEntity<String> welcome(@PathVariable("userId")
                              String userId) {

        return ResponseEntity.ok("Welcome " + userId);
    }

    @PostMapping("/message/{from}/{to}")
    public void sendMessage(@PathVariable("from") int from,
                            @PathVariable("to") int to,
                            @RequestBody String message) {
        //TODO: Complete app logic for this function
    }
}
