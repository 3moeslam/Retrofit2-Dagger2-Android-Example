package com.randove.eslam.retrofitdagger;

import android.app.Application;

import com.randove.eslam.retrofitdagger.di.DaggerNetComponent;
import com.randove.eslam.retrofitdagger.di.NetComponent;
import com.randove.eslam.retrofitdagger.di.modules.ApplicationModule;
import com.randove.eslam.retrofitdagger.di.modules.NetModule;

/**
 * Created by Eslam on 1/10/2018.
 */

public class App extends Application {

    NetComponent netComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }
}
