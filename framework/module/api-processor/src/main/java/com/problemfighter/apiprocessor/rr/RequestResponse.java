package com.problemfighter.apiprocessor.rr;

import com.problemfighter.apiprocessor.common.DataUtil;

public interface RequestResponse {

    default ReqProcessor req() {
        return new ReqProcessor();
    }

    default ResProcessor res() {
        return ResProcessor.instance();
    }

    default DataUtil du(){
        return DataUtil.instance();
    }
}
