package com.jennyli.bookminder.bee;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Retrofit of the Beeminder Api
 * @see <a href="https://www.beeminder.com/api">https://www.beeminder.com/api</a>
 * @author jennyli
 */
public interface Beeminder {

    @GET("users/me.json")
    Call<Object> getUserInfo();
}
