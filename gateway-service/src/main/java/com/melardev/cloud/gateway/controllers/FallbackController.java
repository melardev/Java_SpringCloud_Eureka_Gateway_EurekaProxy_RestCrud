package com.melardev.cloud.gateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping
    public Map<String, Object> onMicroserviceError() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("full_messages", Collections.singletonList("Oops! Something went wrong"));
        return response;
    }

    @GetMapping("proxy")
    public Map<String, Object> onProxyError() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("full_messages", Collections.singletonList("Oops! Proxy may not be working"));
        return response;
    }
}
