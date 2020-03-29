
package com.seniorsteps.mvvm.API.Responses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("data")
    private User mUser;
    @SerializedName("status")
    private String mStatus;

    public User getData() {
        return mUser;
    }

    public void setData(User user) {
        mUser = user;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
