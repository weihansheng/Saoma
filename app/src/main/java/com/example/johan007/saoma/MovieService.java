package com.example.johan007.saoma;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Johan007 on 2017/6/2.
 */

public interface MovieService {
    @GET("top250")
    Call<ObjectEntity> getTopMovie(@Query("start") int start , @Query("count") int count);
}
