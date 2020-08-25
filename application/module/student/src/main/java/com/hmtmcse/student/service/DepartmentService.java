package com.hmtmcse.student.service;

import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.dto.department.DepartmentMasterDTO;
import com.hmtmcse.student.model.entity.Department;
import com.hmtmcse.student.repository.DepartmentRepository;
import com.problemfighter.apiprocessor.inter.MethodStructure;
import com.problemfighter.apiprocessor.rr.RequestResponse;
import com.problemfighter.apiprocessor.rr.request.RequestBulkData;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DepartmentService implements RequestResponse, MethodStructure<DepartmentMasterDTO, DepartmentDetailDTO> {


    @Autowired
    private DepartmentRepository departmentRepository;


    public Boolean isCodeAlreadyExist(String code) {
        Department department = departmentRepository.findDepartmentByCode(code);
        if (department == null) {
            return false;
        }
        return true;
    }

    @Override
    public MessageResponse create(RequestData<DepartmentDetailDTO> data) {
        Department department = req().process(data, Department.class);
        departmentRepository.save(department);
        return res().successMessage("Created");
    }

    @Override
    public BulkResponse<DepartmentDetailDTO> bulkCreate(RequestBulkData<DepartmentDetailDTO> data) {
        BulkErrorDst<DepartmentDetailDTO, Department> bulkErrorDst = req().bulkProcess(data, Department.class);
        if (bulkErrorDst.dstList.size() != 0) {
            departmentRepository.saveAll(bulkErrorDst.dstList);
//            try {
//                departmentRepository.saveAll(bulkErrorDst.dstList);
//            } catch (Exception e) {
//
//            }
        }
        return res().bulkResponse(bulkErrorDst, DepartmentDetailDTO.class);
    }

    @Override
    public PageableResponse<DepartmentMasterDTO> list() {
        return null;
    }

    @Override
    public PageableResponse<DepartmentDetailDTO> detailList() {
        return null;
    }

    @Override
    public DetailsResponse<DepartmentDetailDTO> details(Long id) {
        return null;
    }

    @Override
    public MessageResponse update(RequestBulkData<DepartmentDetailDTO> data) {
        return null;
    }

    @Override
    public BulkResponse<DepartmentDetailDTO> bulkUpdate(RequestBulkData<DepartmentDetailDTO> data) {
        return null;
    }

    @Override
    public BulkResponse<Long> bulkDelete(RequestBulkData<Long> ids) {
        return null;
    }

    @Override
    public BulkResponse<Long> hardDelete(RequestBulkData<Long> ids) {
        return null;
    }

    @Override
    public MessageResponse delete(Long id) {
        return null;
    }
}
