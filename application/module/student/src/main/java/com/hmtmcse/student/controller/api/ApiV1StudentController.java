package com.hmtmcse.student.controller.api;


import com.hmtmcse.student.model.dto.student.StudentDetailDTO;
import com.hmtmcse.student.model.dto.student.StudentMasterDTO;
import com.hmtmcse.student.service.StudentService;
import com.problemfighter.apiprocessor.common.ApiProcessorException;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.DetailsResponse;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import com.problemfighter.apiprocessor.rr.response.PageableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/student")
public class ApiV1StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public MessageResponse create(@RequestBody RequestData<StudentDetailDTO> data) {
        return studentService.save(data);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public MessageResponse update(@RequestBody RequestData<StudentMasterDTO> data) {
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageableResponse<StudentDetailDTO> list() {
        return null;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public DetailsResponse<StudentMasterDTO> details(@PathVariable(name = "id") Long id) {
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public MessageResponse delete(@PathVariable(name = "id") Long id) {
        return null;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public PageableResponse<StudentMasterDTO> error() {
        throw new ApiProcessorException();
    }
}
