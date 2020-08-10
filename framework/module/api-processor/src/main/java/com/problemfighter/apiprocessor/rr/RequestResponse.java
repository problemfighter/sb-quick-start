package com.problemfighter.apiprocessor.rr;

public interface RequestResponse {

    default ReqProcessor req() {
        return new ReqProcessor();
    }

    default ResProcessor res() {
        return ResProcessor.instance();
    }
}
