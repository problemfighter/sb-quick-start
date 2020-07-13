package com.hmtmcse.student.controller.api;

import com.hmtmcse.student.dto.SwaggerDTO;
import com.hmtmcse.student.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/swagger")
@Api(tags = "Swagger API")
public class ApiV1SwaggerController {

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    @ApiOperation(value = "Swagger DTO Test")
    public ResponseEntity<List<SwaggerDTO>> list() {
        List<SwaggerDTO> list = new ArrayList<>();
        list.add(new SwaggerDTO().age(20).name("Name 20"));
        list.add(new SwaggerDTO().age(10).name("Name 10"));
        list.add(new SwaggerDTO().age(15).name("Name 15"));
        return ResponseEntity.ok(list);
    }

}
