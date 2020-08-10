package com.hmtmcse.student.service;

import com.hmtmcse.student.dto.student.StudentDto;
import com.hmtmcse.student.entity.Student;
import com.problemfighter.apiprocessor.rr.RequestResponse;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements RequestResponse {


    public MessageResponse save(RequestData<StudentDto> data) {
        Student student = req().process(data, Student.class);
        return res().successMessage("Created");
    }

}
