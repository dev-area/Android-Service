package app.mabel.com.testservice;

import android.os.RemoteException;

import app.mabel.com.mylib.IAsync;
import app.mabel.com.mylib.IAsyncListener;

/**
 * Created by developer on 12/6/17.
 */

public class IAsyncImp extends IAsync.Stub {

    @Override
    public void calcSum(int[] arr, IAsyncListener lis) throws RemoteException {
        int res=0;
        for(int i=0;i<arr.length;i++)
            res+=arr[i];
        lis.OnResponse(res);
    }
}
