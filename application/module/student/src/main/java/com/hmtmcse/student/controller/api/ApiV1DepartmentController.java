package com.hmtmcse.student.controller.api;


import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.dto.department.DepartmentMasterDTO;
import com.hmtmcse.student.model.dto.department.DepartmentUpdateDTO;
import com.hmtmcse.student.service.DepartmentService;
import com.problemfighter.apiprocessor.inter.MethodStructure;
import com.problemfighter.apiprocessor.rr.request.RequestBulkData;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.BulkResponse;
import com.problemfighter.apiprocessor.rr.response.DetailsResponse;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import com.problemfighter.apiprocessor.rr.response.PageableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/department")
public class ApiV1DepartmentController implements MethodStructure<DepartmentMasterDTO, DepartmentDetailDTO> {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public MessageResponse create(@RequestBody RequestData<DepartmentDetailDTO> data) {
        return departmentService.create(data);
    }

    @RequestMapping(value = "/bulk-create", method = RequestMethod.POST)
    public BulkResponse<DepartmentDetailDTO> bulkCreate(@RequestBody RequestBulkData<DepartmentDetailDTO> data) {
        return departmentService.bulkCreate(data);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageableResponse<DepartmentMasterDTO> list(
            @RequestParam(value = "page", defaultValue = "") Integer page,
            @RequestParam(value = "size", defaultValue = "") Integer size,
            @RequestParam(value = "sort", defaultValue = "") String sort,
            @RequestParam(value = "field", defaultValue = "") String field,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        return departmentService.list(page, size, sort, field, search);
    }

    @RequestMapping(value = "/detail-list", method = RequestMethod.GET)
    public PageableResponse<DepartmentDetailDTO> detailList(
            @RequestParam(value = "page", defaultValue = "") Integer page,
            @RequestParam(value = "size", defaultValue = "") Integer size,
            @RequestParam(value = "sort", defaultValue = "") String sort,
            @RequestParam(value = "field", defaultValue = "") String field,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        return departmentService.detailList(page, size, sort, field, search);
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public DetailsResponse<DepartmentDetailDTO> details(@PathVariable(name = "id") Long id) {
        return departmentService.details(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public MessageResponse update(@RequestBody RequestData<DepartmentUpdateDTO> data) {
        return departmentService.update(data);
    }

    @RequestMapping(value = "/bulk-update", method = RequestMethod.PATCH)
    public BulkResponse<DepartmentDetailDTO> bulkUpdate(@RequestBody RequestBulkData<DepartmentUpdateDTO> data) {
        return departmentService.bulkUpdate(data);
    }

    @RequestMapping(value = "/bulk-delete", method = RequestMethod.DELETE)
    public BulkResponse<Long> bulkDelete(@RequestBody RequestBulkData<Long> ids) {
        return departmentService.bulkDelete(ids);
    }

    @RequestMapping(value = "/hard-delete", method = RequestMethod.DELETE)
    public BulkResponse<Long> hardDelete(@RequestBody RequestBulkData<Long> ids) {
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public MessageResponse delete(@PathVariable(name = "id") Long id) {
        return departmentService.delete(id);
    }
}
