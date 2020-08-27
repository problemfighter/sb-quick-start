package com.problemfighter.apiprocessor.inter;

import com.hmtmcse.oc.common.ProcessCustomCopy;
import com.problemfighter.appcommon.model.DTOCommon;
import com.problemfighter.appcommon.model.EntityCommon;

public interface CopyInterceptor<E extends EntityCommon, D extends DTOCommon, U> extends ProcessCustomCopy<E, D> {

    void meAsSrc(U source, E destination);

    void meAsDst(E source, U destination);
}
