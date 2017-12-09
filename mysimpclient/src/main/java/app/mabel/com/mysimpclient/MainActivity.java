package app.mabel.com.mysimpclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import app.mabel.com.mylib.CustomType;
import app.mabel.com.mylib.IAsync;
import app.mabel.com.mylib.IAsyncListener;
import app.mabel.com.mylib.ISimp;

public class MainActivity extends AppCompatActivity implements ServiceConnection{
    private ISimp service;
    private IAsync asyncService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    CustomType c=new CustomType();
                    c.setNum1(100);
                    c.setS1("hello");
                    Log.d("tag","res:"+service.getCustom(c));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
        Button btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    asyncService.calcSum(new int[]{2, 3, 4, 5}, new IAsyncListener.Stub() {
                        @Override
                        public void OnResponse(int res) throws RemoteException {

                                Log.d("tag","resp:"+res);

                        }
                    });
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            asyncService = IAsync.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent("app.mabel.com.testservice.MySimpService"),this,BIND_AUTO_CREATE);
        bindService(new Intent("app.mabel.com.testservice.AsyncService"),con,BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        service = ISimp.Stub.asInterface(iBinder);

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
