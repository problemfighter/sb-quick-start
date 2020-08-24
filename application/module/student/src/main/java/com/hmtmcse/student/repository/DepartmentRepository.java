package com.hmtmcse.student.repository;

import com.hmtmcse.student.model.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}
