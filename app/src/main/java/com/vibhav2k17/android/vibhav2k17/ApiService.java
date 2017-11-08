package com.vibhav2k17.android.vibhav2k17;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by prajwal on 21/10/17.
 */

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("feed?fields=full_picture,id,link,story,created_time,message&access_token=266494063684850%7C799f6a5b3246ceeecae7e95af945da24&limit=20")
    Call<ContactList> getMyJSON();
}
