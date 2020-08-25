package com.hmtmcse.student.repository;

import com.hmtmcse.student.model.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

    @Query("SELECT d FROM Department d WHERE d.code = :code")
    Department findDepartmentByCode(String code);
}
