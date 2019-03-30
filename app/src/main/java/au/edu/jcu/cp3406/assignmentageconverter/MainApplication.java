package au.edu.jcu.cp3406.assignmentageconverter;

import android.app.Application;
import android.content.Context;

import au.edu.jcu.cp3406.assignmentageconverter.Helper.LocaleHelper;

public class MainApplication extends Application {


    @Override
    protected void attachBaseContext (Context base){
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));

    }


}
