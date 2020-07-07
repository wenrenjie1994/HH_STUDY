package com.hr;

import java.io.Serializable;
import java.net.ServerSocket;

public class RequestInfo implements Serializable {
    private static final long serialVersionUID = 1111;
    private Resume curResume;
    private Resume newResume;
    private OpType opType;
    public RequestInfo(OpType opType, Resume resume){
        this.curResume = resume;
        this.opType = opType;
    }
    public RequestInfo(OpType opType, Resume curResume, Resume newResume){
        this.opType = opType;
        this.curResume = curResume;
        this.newResume = newResume;
    }
    public OpType getOpType(){
        return this.opType;
    }
    public Resume getCurResume(){
        return this.curResume;
    }
    public Resume getNewResume(){
        return this.newResume;
    }
}
