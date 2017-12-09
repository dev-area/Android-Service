package app.mabel.com.mylib;

import android.os.Parcel;
import android.os.Parcelable;


public class CustomType implements Parcelable {
    int num1;
    String s1;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(num1);
        parcel.writeString(s1);
    }

    public static final Parcelable.Creator<CustomType> CREATOR = new Parcelable.Creator<CustomType>(){

        @Override
        public CustomType createFromParcel(Parcel parcel) {
            CustomType res=new CustomType();
            res.num1 = parcel.readInt();
            res.s1 = parcel.readString();
            return res;
        }

        @Override
        public CustomType[] newArray(int size) {
            return new CustomType[size];
        }
    };
}
