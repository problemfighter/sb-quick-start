package com.hmtmcse.student.model.intercept;

import com.hmtmcse.oc.common.ProcessCustomCopy;
import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.entity.Department;
import com.hmtmcse.student.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentIntercept implements ProcessCustomCopy<DepartmentDetailDTO, Department> {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void meAsSrc(DepartmentDetailDTO source, Department destination, String fieldName) {
        System.out.println("-------------");
    }

    @Override
    public void meAsDst(Department source, DepartmentDetailDTO destination, String fieldName) {
        System.out.println("-------------");
    }

    @Override
    public void meAsSrc(DepartmentDetailDTO source, Department destination) {
        System.out.println("------------- meAsSrc");
    }

    @Override
    public void meAsDst(Department source, DepartmentDetailDTO destination) {
        System.out.println("------------- meAsDst");
    }
}
