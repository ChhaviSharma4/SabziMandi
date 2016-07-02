package com.example.zeus.gharkimandi.Networking;

import com.example.zeus.gharkimandi.CommodityClass;
import com.example.zeus.gharkimandi.JsonReturn;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Zeus on 4/18/2016.
 */
public interface ApiInterface {

    @GET("resource.json")
    Call<JsonReturn> getMandiListFromState(@Query("api-key")String API_KEY,@Query("fields") String field ,@Query("resource_id")String RESOURCE_ID,@Query("filters[state]") String stateName);

    @GET("resource.json")
    Call<JsonReturn> getCommodityFromMandi(@Query("api-key")String API_KEY,@Query("resource_id")String RESOURCE_ID,@Query("filters[market]") String mandiName);


}
