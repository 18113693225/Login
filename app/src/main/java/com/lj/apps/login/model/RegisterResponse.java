package com.lj.apps.login.model;


import android.os.Parcel;
import android.os.Parcelable;

public class RegisterResponse implements Parcelable {

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

    public RegisterResponse() {
    }

    protected RegisterResponse(Parcel in) {
        this.resultcode = in.readInt();
        this.reason = in.readString();
    }

    public static final Creator<RegisterResponse> CREATOR = new Creator<RegisterResponse>() {
        @Override
        public RegisterResponse createFromParcel(Parcel source) {
            return new RegisterResponse(source);
        }

        @Override
        public RegisterResponse[] newArray(int size) {
            return new RegisterResponse[size];
        }
    };
}
