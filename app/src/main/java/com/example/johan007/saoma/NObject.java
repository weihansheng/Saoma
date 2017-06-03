package com.example.johan007.saoma;

import java.io.Serializable;

/**
 * Created by Johan007 on 2017/6/2.
 */

public class NObject <T> implements Serializable {
    final public static int DEFAULTE_ID_VALUE = -1;

  /*  public final boolean OpValid ;  // 操作是否合法(主要和uid的权限有关)
    public final T Info;
    public final boolean IsRqstSuccess;// 若false, ErrorMsg不为空，否则为空c
    public final String ErrorMsg ;*/
  public final String error;
    public final String status;
    public final String result;

   /* public NObject(boolean opValid, T data, boolean isRqstSuccess, String errorMsg) {
        OpValid = opValid;
        this.Info = data;
        IsRqstSuccess = isRqstSuccess;
        ErrorMsg = errorMsg;
    }*/

    public NObject(String error, String status, String result) {
        this.error = error;
        this.status = status;
        this.result = result;
    }
}