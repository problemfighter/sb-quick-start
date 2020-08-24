package com.hmtmcse.student.service;

import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.entity.Department;
import com.hmtmcse.student.repository.DepartmentRepository;
import com.problemfighter.apiprocessor.rr.RequestResponse;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements RequestResponse {


    @Autowired
    DepartmentRepository departmentRepository;

    public MessageResponse save(RequestData<DepartmentDetailDTO> data) {
        Department department = req().process(data, Department.class);
        departmentRepository.save(department);
        return res().successMessage("Created");
    }

    public MessageResponse bulkSave(){
        List<Department> departmentList = new ArrayList<>();
        departmentRepository.saveAll(departmentList);
        return res().successMessage("Created");
    }


}
