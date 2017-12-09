// ISimp.aidl
package app.mabel.com.mylib;

import app.mabel.com.mylib.CustomType;
// Declare any non-default types here with import statements

interface ISimp {
    int add(int a,int b);
    int sub(int a,int b);
    int addrr(in int[] arr);
    String getCustom(in CustomType ct);
}
