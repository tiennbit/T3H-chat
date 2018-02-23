package t3hchat.thaivh.com.t3hchat.view.contactlist;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import t3hchat.thaivh.com.t3hchat.dto.ContactDto;
import t3hchat.thaivh.com.t3hchat.webservice.ServiceBuilder;

/**
 * Created by thais on 2/4/2018.
 */

public class ContactListPresenterImpl implements ContactListPresenter {
    private String TAG = this.getClass().getSimpleName();

    private ContactListView view;

    public ContactListPresenterImpl(ContactListView view) {
        Log.d(TAG, "ContactListPresenterImpl");
        this.view = view;
    }

    @Override
    public void getContact() {
        ServiceBuilder.getService().getContact().enqueue(new Callback<List<ContactDto>>() {
            @Override
            public void onResponse(Call<List<ContactDto>> call, Response<List<ContactDto>> response) {
                Log.d(TAG, "onResponse");
                if(response.isSuccessful()) {
                    view.getContactSuccess(response.body());
                } else {
                    view.getContactFailure("Unknown error");
                }
            }

            @Override
            public void onFailure(Call<List<ContactDto>> call, Throwable t) {
                Log.d(TAG, "onFailure");
                view.getContactFailure(t.getMessage());
            }
        });
    }
}
