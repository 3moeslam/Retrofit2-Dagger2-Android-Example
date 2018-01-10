package com.randove.eslam.retrofitdagger.di.modules;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eslam on 1/10/2018.
 */

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides Application provideApplication(){
        return application;
    }
}
