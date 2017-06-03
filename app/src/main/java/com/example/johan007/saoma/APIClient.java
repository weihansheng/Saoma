package com.example.johan007.saoma;

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Johan007 on 2017/6/2.
 */

public interface APIClient {
    @GET("list")
    Call<ObjectEntity> getDataTest(
            @Query("uid") String uid,
            @Query("pn") String pn,
            @Query("length") String length
    );
}
