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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public MessageResponse create() {
        return null;
    }

    @RequestMapping(value = "/bulk-create", method = RequestMethod.POST)
    public MessageResponse bulkCreate() {
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageableResponse<DepartmentDto> list() {
        return null;
    }

    @RequestMapping(value = "/detail-list", method = RequestMethod.GET)
    public PageableResponse<DepartmentDto> detailList() {
        return null;
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public DetailsResponse<DepartmentDto> details() {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public MessageResponse update() {
        return null;
    }

    @RequestMapping(value = "/bulk-update", method = RequestMethod.PATCH)
    public MessageResponse bulkUpdate() {
        return null;
    }

    @RequestMapping(value = "/bulk-delete", method = RequestMethod.DELETE)
    public MessageResponse bulkDelete() {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public MessageResponse delete() {
        return null;
    }
}
