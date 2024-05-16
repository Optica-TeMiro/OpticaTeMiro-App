package org.mywire.temiroapp.ui.user;

import org.mywire.temiroapp.data.prefs.ConfigAPI;
import org.mywire.temiroapp.data.remote.UserService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApiClient {

    private static String UbicacionAPI = ConfigAPI.webapi_URL + ":" + ConfigAPI.webapi_PORT + "/";

    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(UbicacionAPI)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static UserService getService() {
        UserService userService = getRetrofit().create(UserService.class);
        return userService;
    }

}
