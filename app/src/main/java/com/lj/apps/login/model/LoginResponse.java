package com.lj.apps.login.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LoginResponse implements Parcelable {

    @SerializedName("resultcode")
    public int resultCode;
    public String reason;


    public LoginResponse() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resultCode);
        dest.writeString(this.reason);
    }

    protected LoginResponse(Parcel in) {
        this.resultCode = in.readInt();
        this.reason = in.readString();
    }

    public static final Creator<LoginResponse> CREATOR = new Creator<LoginResponse>() {
        @Override
        public LoginResponse createFromParcel(Parcel source) {
            return new LoginResponse(source);
        }

        @Override
        public LoginResponse[] newArray(int size) {
            return new LoginResponse[size];
        }
    };
}
