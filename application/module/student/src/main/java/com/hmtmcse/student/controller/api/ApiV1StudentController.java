package com.hmtmcse.student.controller.api;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/student")
public class ApiV1StudentController {

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        List<String> list = new ArrayList<>();
        list.add("Dhaka");
        list.add("Rangpur");
        list.add("Rajshahi");
        return ResponseEntity.ok(list);
    }
}
