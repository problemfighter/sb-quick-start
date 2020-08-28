package com.hmtmcse.student.model.intercept;

import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.dto.department.DepartmentUpdateDTO;
import com.hmtmcse.student.model.entity.Department;
import com.hmtmcse.student.service.DepartmentService;
import com.problemfighter.apiprocessor.common.ApiProcessorException;
import com.problemfighter.apiprocessor.inter.CopyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentIntercept implements CopyInterceptor<Department, DepartmentDetailDTO, DepartmentUpdateDTO> {

    @Autowired
    private DepartmentService departmentService;


    private void chekCodeAlreadyExist(String code) throws ApiProcessorException {
        if (code != null && departmentService.isCodeAlreadyExist(code)) {
            ApiProcessorException.otherError("Department code already exist");
        }
    }

    @Override
    public void meAsSrc(DepartmentDetailDTO source, Department destination) {
        chekCodeAlreadyExist(source.code);
    }

    @Override
    public void meAsDst(Department source, DepartmentDetailDTO destination) {
        System.out.println("======= meAsDst ED =======");
    }

    @Override
    public void meAsSrc(DepartmentUpdateDTO source, Department destination) {
        if (departmentService.findByIdAndCode(source.code, source.id) == null) {
            chekCodeAlreadyExist(source.code);
        }
        System.out.println("======= meAsSrc UE =======");
    }

    @Override
    public void meAsDst(Department source, DepartmentUpdateDTO destination) {
        System.out.println("======= meAsDst EU =======");
    }
}
