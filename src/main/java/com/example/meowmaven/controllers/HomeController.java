package com.example.meowmaven.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    // Custom application.properties uses my own versioning number system.
    // Retrieve the app version number with this code
    @Value("{app.version}") // Values come from application.properties
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map<String, String> getStatus() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }
}