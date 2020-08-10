package com.hmtmcse.student.service;

import com.hmtmcse.student.dto.student.StudentDto;
import com.problemfighter.apiprocessor.rr.RequestResponse;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements RequestResponse {


    public MessageResponse save(RequestData<StudentDto> data) {
        req().dataValidate(data);
        return null;
    }

}
