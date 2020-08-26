package com.hmtmcse.student.model.dto.department;


import com.hmtmcse.oc.annotation.DataMappingInfo;
import com.hmtmcse.student.model.intercept.DepartmentIntercept;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Department Details DTO")
@DataMappingInfo(customProcessor = DepartmentIntercept.class)
public class DepartmentUpdateDTO extends DepartmentMasterDTO {
    public Long id;
}
