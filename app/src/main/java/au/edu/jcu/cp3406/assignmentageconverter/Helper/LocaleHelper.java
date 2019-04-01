package au.edu.jcu.cp3406.assignmentageconverter.Helper;

//Code location - https://www.youtube.com/watch?v=ywF-ySiBAsc

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Locale;

// Create translate coding

public class LocaleHelper {

    public static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";


    public static Context onAttach(Context context, String defaultLanguage) {
        String lang = getPersistedData(context, defaultLanguage);
        return setLocale(context, lang);
    }

    public static Context setLocale(Context context, String lang) {
        persist(context, lang);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            return updateResources(context, lang);

        return updatedResourcesLegacy(context, lang);
    }


    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateResources(Context context, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration config = context.getResources().getConfiguration();
        config.setLocale(locale);
        config.setLayoutDirection(locale);

        return context.createConfigurationContext(config);

    }


    @SuppressWarnings("deprecation")
    private static Context updatedResourcesLegacy(Context context, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.locale = locale;
        config.setLayoutDirection(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
        return context;


    }


    private static void persist(Context context, String lang) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(SELECTED_LANGUAGE, lang);
        editor.apply();
    }


    private static String getPersistedData(Context context, String language) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(SELECTED_LANGUAGE, language);

    }
}
