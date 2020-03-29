package com.seniorsteps.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.seniorsteps.mvvm.API.ApiManager;
import com.seniorsteps.mvvm.API.Responses.LoginResponse;
import com.seniorsteps.mvvm.API.Responses.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    MutableLiveData<User> user;
    MutableLiveData<String> Message;

    public LoginViewModel(){
        user = new MutableLiveData<>();
        Message = new MutableLiveData<>();
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    public MutableLiveData<String> getMessage() {
        return Message;
    }

    public void login(String username, String password){

        ApiManager.getAPIs()
                .Login(username,password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if("success".equals(response.body().getStatus())){
                            user.postValue(response.body().getData());
                            Message.postValue("login success");
                        }else {
                            Message.postValue("login failed");
                            user.postValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

    }

}
