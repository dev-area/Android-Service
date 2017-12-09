// IAsync.aidl
package app.mabel.com.mylib;

import app.mabel.com.mylib.IAsyncListener;
// Declare any non-default types here with import statements

oneway interface IAsync {
    void calcSum(in int []arr, in IAsyncListener lis);
}
