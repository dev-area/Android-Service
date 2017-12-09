package app.mabel.com.testservice;

import android.os.RemoteException;

import app.mabel.com.mylib.CustomType;
import app.mabel.com.mylib.ISimp;

/**
 * Created by developer on 12/6/17.
 */

public class SimpServiceImp extends ISimp.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a-b;
    }

    @Override
    public int addrr(int[] arr) throws RemoteException {
        int sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        return sum;
    }

    @Override
    public String getCustom(CustomType ct) throws RemoteException {
       return ct.getS1() + " return";
    }
}
