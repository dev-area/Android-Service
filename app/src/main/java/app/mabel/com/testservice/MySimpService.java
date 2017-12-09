package app.mabel.com.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by developer on 12/6/17.
 */

public class MySimpService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new SimpServiceImp();
    }
}
