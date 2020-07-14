package com.problemfighter.apiprocessor.controller;



import com.problemfighter.apiprocessor.dto.SwaggerDTO;
import com.problemfighter.apiprocessor.rr.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/swagger")
@Tag(name = "Swagger API")
public class ApiV1SwaggerController {

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    @Operation(summary = "Swagger DTO Test")
    public ResponseEntity<SwaggerDTO> list() {
        List<SwaggerDTO> list = new ArrayList<>();
        list.add(new SwaggerDTO().age(20).name("Name 20"));
        list.add(new SwaggerDTO().age(10).name("Name 10"));
        list.add(new SwaggerDTO().age(15).name("Name 15"));

        ResponseDTO<List<SwaggerDTO>> responseDTO = ResponseDTO.<List<SwaggerDTO>>builder()
                .status(HttpStatus.OK.toString())
                .data(list).build();

        return null;
    }

    @RequestMapping(value = "/list2", produces = "application/json", method = RequestMethod.GET)
    @Operation(summary = "Swagger DTO Test")
    public ResponseDTO<List<SwaggerDTO>> list2() {
        List<SwaggerDTO> list = new ArrayList<>();
        list.add(new SwaggerDTO().age(20).name("Name 20"));
        list.add(new SwaggerDTO().age(10).name("Name 10"));
        list.add(new SwaggerDTO().age(15).name("Name 15"));

        ResponseDTO<List<SwaggerDTO>> responseDTO = ResponseDTO.<List<SwaggerDTO>>builder()
                .status(HttpStatus.OK.toString())
                .data(list).build();

        return responseDTO;
    }

}
