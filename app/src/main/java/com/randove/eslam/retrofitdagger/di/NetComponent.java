package com.randove.eslam.retrofitdagger.di;

import com.randove.eslam.retrofitdagger.MainActivity;
import com.randove.eslam.retrofitdagger.di.modules.ApplicationModule;
import com.randove.eslam.retrofitdagger.di.modules.NetModule;

import dagger.Component;

/**
 * Created by Eslam on 1/10/2018.
 */

@Component (modules = {ApplicationModule.class,NetModule.class})
public interface NetComponent {
    void injectMainActivity(MainActivity mainActivity);
}
