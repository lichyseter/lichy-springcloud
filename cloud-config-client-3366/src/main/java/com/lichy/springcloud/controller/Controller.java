package com.lichy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Controller {
    @Value("${lichy.config}")
    private String value;

    @RequestMapping("/getLichyConfig")
    public String getLichyConfig() {
        return value;
    }
}
