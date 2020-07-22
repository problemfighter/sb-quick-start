package com.hmtmcse.student.controller.api;


import com.hmtmcse.student.dto.student.StudentDetailsDto;
import com.hmtmcse.student.dto.student.StudentDto;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.DetailsResponse;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import com.problemfighter.apiprocessor.rr.response.PageableResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/student")
public class ApiV1StudentController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public MessageResponse create(@RequestBody RequestData<StudentDto> data) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public MessageResponse update() {
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageableResponse<StudentDetailsDto> list() {
        return null;
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public DetailsResponse<StudentDetailsDto> details() {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public MessageResponse delete() {
        return null;
    }
}
