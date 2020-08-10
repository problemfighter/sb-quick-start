package com.problemfighter.apiprocessor.rr;

public interface RequestResponse {

    public default ReqProcessor req() {
        return new ReqProcessor();
    }

    public default ResProcessor res() {
        return ResProcessor.instance();
    }
}
