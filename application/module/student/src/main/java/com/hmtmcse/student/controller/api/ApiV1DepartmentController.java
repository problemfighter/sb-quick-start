package com.hmtmcse.student.controller.api;


import com.hmtmcse.student.dto.department.DepartmentDto;
import com.problemfighter.apiprocessor.rr.response.DetailsResponse;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import com.problemfighter.apiprocessor.rr.response.PageableResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/department")
public class ApiV1DepartmentController {

    @RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.POST)
    public MessageResponse create() {
        return null;
    }

    @RequestMapping(value = "/update", produces = "application/json", method = RequestMethod.PATCH)
    public MessageResponse update() {
        return null;
    }

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public PageableResponse<DepartmentDto> list() {
        return null;
    }

    @RequestMapping(value = "/details", produces = "application/json", method = RequestMethod.GET)
    public DetailsResponse<DepartmentDto> details() {
        return null;
    }

    @RequestMapping(value = "/delete", produces = "application/json", method = RequestMethod.DELETE)
    public MessageResponse delete() {
        return null;
    }
}
