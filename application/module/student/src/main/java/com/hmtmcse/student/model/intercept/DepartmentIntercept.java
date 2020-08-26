package com.hmtmcse.student.model.intercept;

import com.hmtmcse.oc.common.ProcessCustomCopy;
import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.entity.Department;
import com.hmtmcse.student.service.DepartmentService;
import com.problemfighter.apiprocessor.common.ApiProcessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentIntercept implements ProcessCustomCopy<Department, DepartmentDetailDTO> {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void meAsSrc(DepartmentDetailDTO source, Department destination) {
        if (source.code != null && departmentService.isCodeAlreadyExist(destination.code)) {
            ApiProcessorException.otherError("Department code already exist");
        }
    }

    @Override
    public void meAsDst(Department source, DepartmentDetailDTO destination) {

    }
}
