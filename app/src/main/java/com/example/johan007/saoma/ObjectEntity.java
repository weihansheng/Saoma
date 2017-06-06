package com.example.johan007.saoma;

import java.io.Serializable;

/**
 * Created by Johan007 on 2017/6/2.
 */

public class ObjectEntity implements Serializable {
    public final String data;
    //public final String status;
   // private Object result;

   /* public NObject(boolean opValid, T data, boolean isRqstSuccess, String errorMsg) {
        OpValid = opValid;
        this.Info = data;
        IsRqstSuccess = isRqstSuccess;
        ErrorMsg = errorMsg;
    }*/

   /* public ObjectEntity(String error, String status, Object result) {
        this.error = error;
        this.status = status;
        this.result = result;
    }

    @Override
    public String toString() {
        return "ObjectEntity{" +
                "error='" + error + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
                '}';
    }*/

    public ObjectEntity(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ObjectEntity{" +
                "data='" + data + '\'' +
                '}';
    }
}
