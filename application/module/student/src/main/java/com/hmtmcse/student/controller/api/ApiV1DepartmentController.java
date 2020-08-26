package com.hmtmcse.student.controller.api;


import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.dto.department.DepartmentMasterDTO;
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
    public PageableResponse<DepartmentMasterDTO> list() {
        return departmentService.list();
    }

    @RequestMapping(value = "/detail-list", method = RequestMethod.GET)
    public PageableResponse<DepartmentDetailDTO> detailList() {
        return null;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public DetailsResponse<DepartmentDetailDTO> details(@PathVariable(name = "id") Long id) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public MessageResponse update(@RequestBody RequestBulkData<DepartmentDetailDTO> data) {
        return null;
    }

    @RequestMapping(value = "/bulk-update", method = RequestMethod.PATCH)
    public BulkResponse<DepartmentDetailDTO> bulkUpdate(@RequestBody RequestBulkData<DepartmentDetailDTO> data) {
        return null;
    }

    @RequestMapping(value = "/bulk-delete", method = RequestMethod.DELETE)
    public BulkResponse<Long> bulkDelete(@RequestBody RequestBulkData<Long> ids) {
        return null;
    }

    @RequestMapping(value = "/hard-delete", method = RequestMethod.DELETE)
    public BulkResponse<Long> hardDelete(@RequestBody RequestBulkData<Long> ids) {
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public MessageResponse delete(@PathVariable(name = "id") Long id) {
        return null;
    }
}
