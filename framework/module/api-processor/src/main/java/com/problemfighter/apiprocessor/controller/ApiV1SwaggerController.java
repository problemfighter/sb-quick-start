package com.problemfighter.apiprocessor.controller;



import com.problemfighter.apiprocessor.dto.SwaggerDTO;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.DetailsResponse;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import com.problemfighter.apiprocessor.rr.response.PageableResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/v1/swagger")
public class ApiV1SwaggerController {

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public PageableResponse<List<SwaggerDTO>> list() {
        return null;
    }

    @RequestMapping(value = "/details", produces = "application/json", method = RequestMethod.GET)
    public DetailsResponse<SwaggerDTO> details() {
        return null;
    }

    @RequestMapping(value = "/message", produces = "application/json", method = RequestMethod.GET)
    public MessageResponse message() {
        return null;
    }

    @RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.GET)
    public MessageResponse create(RequestData<SwaggerDTO> data) {
        return null;
    }

}

// Validation
// Mapping
// Testing
// Scaffolding
