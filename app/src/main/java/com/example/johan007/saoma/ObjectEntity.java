package com.example.johan007.saoma;

import java.io.Serializable;

/**
 * Created by Johan007 on 2017/6/2.
 */

public class ObjectEntity implements Serializable {
    public final String error;
    public final String status;
    private Object result;

   /* public NObject(boolean opValid, T data, boolean isRqstSuccess, String errorMsg) {
        OpValid = opValid;
        this.Info = data;
        IsRqstSuccess = isRqstSuccess;
        ErrorMsg = errorMsg;
    }*/

    public ObjectEntity(String error, String status, Object result) {
        this.error = error;
        this.status = status;
        this.result = result;
    }


}
