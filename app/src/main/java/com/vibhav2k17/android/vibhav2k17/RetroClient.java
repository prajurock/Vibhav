package com.vibhav2k17.android.vibhav2k17;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prajwal on 21/10/17.
 */

public class RetroClient {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://graph.facebook.com/vibhav.iitismdhanbad/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
