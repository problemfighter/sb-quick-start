package com.problemfighter.apiprocessor.inter;

import com.problemfighter.apiprocessor.rr.request.RequestBulkData;
import com.problemfighter.apiprocessor.rr.request.RequestData;
import com.problemfighter.apiprocessor.rr.response.BulkResponse;
import com.problemfighter.apiprocessor.rr.response.DetailsResponse;
import com.problemfighter.apiprocessor.rr.response.MessageResponse;
import com.problemfighter.apiprocessor.rr.response.PageableResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface MethodStructure<M, D> {

    MessageResponse create(RequestData<D> data);
    BulkResponse<D> bulkCreate(RequestBulkData<D> data);
//    PageableResponse<M> list();
//    PageableResponse<D> detailList();
    DetailsResponse<D> details(Long id);
//    MessageResponse update(RequestBulkData<D> data);
//    BulkResponse<D> bulkUpdate(RequestBulkData<D> data);
    BulkResponse<Long> bulkDelete(RequestBulkData<Long> ids);
    BulkResponse<Long> hardDelete(RequestBulkData<Long> ids);
    MessageResponse delete(Long id);
}
