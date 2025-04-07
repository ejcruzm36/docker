package com.courses.docker.services;

import org.springframework.stereotype.Service;

import com.courses.docker.dto.ObjectResponse;

@Service
public class ObjectService {

    public ObjectResponse getObject() {
        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setMessage("Hello, Docker!");
        objectResponse.setStatus("success");
        return objectResponse;
    }

}
