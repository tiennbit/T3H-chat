package t3hchat.thaivh.com.t3hchat.webservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import t3hchat.thaivh.com.t3hchat.dto.ContactDto;

/**
 * Created by thais on 2/4/2018.
 */

public interface Service {
    @GET("/?get=contacts")
    Call<List<ContactDto>> getContact();
}
