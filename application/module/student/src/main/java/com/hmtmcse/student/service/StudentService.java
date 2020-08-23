package com.hmtmcse.student.service;


import com.hmtmcse.student.model.dto.student.StudentDetailDTO;
import com.hmtmcse.student.model.entity.Student;
import com.hmtmcse.student.repository.StudentRepository;
import com.problemfighter.apiprocessor.rr.RequestResponse;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements RequestResponse {


    @Autowired
    private StudentRepository studentRepository;


    public MessageResponse save(RequestData<StudentDetailDTO> data) {
        Student student = req().process(data, Student.class);
        studentRepository.save(student);
        return res().successMessage("Created");
    }

}
