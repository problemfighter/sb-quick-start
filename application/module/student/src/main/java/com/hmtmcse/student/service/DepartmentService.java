package com.hmtmcse.student.service;

import com.hmtmcse.oc.annotation.DataMapping;
import com.hmtmcse.student.model.dto.department.DepartmentDetailDTO;
import com.hmtmcse.student.model.dto.department.DepartmentMasterDTO;
import com.hmtmcse.student.model.dto.department.DepartmentUpdateDTO;
import com.hmtmcse.student.model.entity.Department;
import com.hmtmcse.student.repository.DepartmentRepository;
import com.problemfighter.apiprocessor.inter.MethodStructure;
import com.problemfighter.apiprocessor.rr.RequestResponse;
import com.problemfighter.apiprocessor.rr.request.RequestBulkData;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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


    //    @Override
    public PageableResponse<DepartmentMasterDTO> list(Integer page, Integer size, String sort, String field, String search) {
        return res().pageableResponse(departmentRepository.list(req().paginationNSort(page, size, sort, field)), DepartmentMasterDTO.class);
    }

    public PageableResponse<DepartmentMasterDTO> trash(Integer page, Integer size, String sort, String field, String search) {
        return res().pageableResponse(departmentRepository.list(req().paginationNSort(page, size, sort, field)), DepartmentMasterDTO.class);
    }

    //    @Override
    public PageableResponse<DepartmentDetailDTO> detailList(Integer page, Integer size, String sort, String field, String search) {
        return res().pageableResponse(departmentRepository.list(req().paginationNSort(page, size, sort, field)), DepartmentDetailDTO.class);
    }

    @Override
    public DetailsResponse<DepartmentDetailDTO> details(Long id) {
        return res().detailsResponse(departmentRepository.findById(id), DepartmentDetailDTO.class, "Item not found");
    }

    public Department validateAndGetDepartmentById(Long id){
        Optional<Department> optional = departmentRepository.findById(req().validateId(id, "Id not found"));
        return req().validateNOp2Entity(optional, "Content not found");
    }

    //    @Override
    public MessageResponse update(RequestData<DepartmentUpdateDTO> data) {
        Department department = validateAndGetDepartmentById(req().getId(data));
        department = req().process(data, department);
        departmentRepository.save(department);
        return res().successMessage("Updated");
    }

    @Override
    public BulkResponse<DepartmentDetailDTO> bulkCreate(RequestBulkData<DepartmentDetailDTO> data) {
        BulkErrorDst<DepartmentDetailDTO, Department> bulkErrorDst = req().bulkProcess(data, Department.class);
        if (bulkErrorDst.dstList.size() != 0) {
            departmentRepository.saveAll(bulkErrorDst.dstList);
        }
        return res().bulkResponse(bulkErrorDst, DepartmentDetailDTO.class);
    }

    //    @Override
    public BulkResponse<DepartmentDetailDTO> bulkUpdate(RequestBulkData<DepartmentUpdateDTO> data) {
        BulkErrorDst<DepartmentUpdateDTO, DepartmentUpdateDTO> bulkErrorDst = req().bulkProcess(data, DepartmentUpdateDTO.class);
        List<Long> ids = du().getAllId(bulkErrorDst.dstList);
        Iterable<Department> departments = departmentRepository.findAllById(ids);
        return null;
    }

//    @Override
    public BulkResponse<Long> bulkDelete(RequestBulkData<Long> data) {
        Iterable<Department> departmentList = departmentRepository.findAllById(data.getData());
        du().markAsDeleted(departmentList);
        departmentRepository.saveAll(departmentList);
        return null;
    }

//    @Override
    public BulkResponse<Long> hardDelete(RequestBulkData<Long> ids) {
        return null;
    }

//    @Override
    public MessageResponse delete(Long id) {
        Department department = validateAndGetDepartmentById(id);
        du().markAsDeleted(department);
        departmentRepository.save(department);
        return res().successMessage("Deleted");
    }
}
