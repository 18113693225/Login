package com.lj.apps.login.model;


import android.os.Parcel;
import android.os.Parcelable;

public class LoginResponse implements Parcelable {

    public int resultcode;
    public String reason;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resultcode);
        dest.writeString(this.reason);
    }

    public LoginResponse() {
    }

    protected LoginResponse(Parcel in) {
        this.resultcode = in.readInt();
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
