package com.courses.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courses.docker.dto.ObjectResponse;
import com.courses.docker.services.ObjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DemoController {

    private final ObjectService objectService;

    @GetMapping("/object")
    public ObjectResponse getObject() {
        return objectService.getObject();
    }

}
