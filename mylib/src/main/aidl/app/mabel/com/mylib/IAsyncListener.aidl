// IAsyncListener.aidl
package app.mabel.com.mylib;

// Declare any non-default types here with import statements

oneway interface IAsyncListener {
    void OnResponse(int res);
}
