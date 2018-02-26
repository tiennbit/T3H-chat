package t3hchat.thaivh.com.t3hchat.webservice;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import t3hchat.thaivh.com.t3hchat.util.Common;

/**
 * Created by thais on 2/4/2018.
 */

public class ServiceBuilder {
    private static Service service;

    public static Service getService() {
        if(service == null) {
            createSerVice();
            return  service;
        }
        return service;
    }



    private ServiceBuilder() {
    }


    private static void createSerVice() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Common.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(Service.class);
    }
}
