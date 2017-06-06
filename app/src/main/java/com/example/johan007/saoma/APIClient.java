package com.example.johan007.saoma;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Johan007 on 2017/6/2.
 */

public interface APIClient {
    @GET("JW/Goods/getByCode")
    Observable<NObject<ObjectEntity>> getDataTest(
            @Query("uid") String uid,
            @Query("lCode") String length
    );
}
