package au.edu.jcu.cp3406.assignmentageconverter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;


import au.edu.jcu.cp3406.assignmentageconverter.Helper.LocaleHelper;
import io.paperdb.Paper;


public class MainLanguageChange extends AppCompatActivity {





    // Select variables that need to be translated
    TextView tV_begin;
    TextView tV_header;
    TextView tV_instructions;
    TextView tV_change_language;



    // Uses MainApplication code to set language as English
    @Override
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // refer to OnClick button to change activities
//        configurebutton_begin_settings();
//        configurebutton_home_settings();


        // Finds strings to translate

        tV_begin = findViewById(R.id.begin);
        tV_header = findViewById(R.id.header_main);
        tV_instructions = findViewById(R.id.instructions);
        tV_change_language = findViewById(R.id.activity_change_language);


        // Init Paper first:
        Paper.init(this);


        //Default language is English, empty 'if' statement required
        String language = Paper.book().read("language");
        if (null == language) {
        }
        Paper.book().write("language", "en");


    }

    // LocalHelper used to translate language
    private void updateView(String lang) {

        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();

        tV_begin.setText(resources.getString(R.string.begin));
        tV_header.setText(resources.getString(R.string.header_main));
        tV_instructions.setText(resources.getString(R.string.instructions));
        tV_change_language.setText(R.string.activity_main_settings);

    }

    // Create setting in action bar with two options
    @Override
    public boolean onCreateOptionsMenu(Menu settings_menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, settings_menu);
        return true;    }



    // Activate settings in action bar to change language ie English/Spanish
    @Override
    public boolean onOptionsItemSelected(MenuItem settings) {
        if (settings.getItemId() == R.id.settings_english) {
            Paper.book().write("language", "en");
            updateView((String) Paper.book().read("language"));

        } else if (settings.getItemId() == R.id.settings_spanish) {
            Paper.book().write("language", "es");
            updateView((String) Paper.book().read("language"));

        }
        return true;
//    }
////    // On click button - Change Language - sends to change language activity
//    private void configurebutton_begin_settings() {
//        Button back_home = findViewById(R.id.settings_begin);
//        back_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View activity_change_language) {
//                startActivity(new Intent(MainLanguageChange.this, MainActivity.class));
//            }
//        });
//    }
//
////    // On click button - Begin - sends to calculation activity
//    private void configurebutton_home_settings() {
//        Button btn_begin_language = findViewById(R.id.begin);
//        btn_begin_language.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View begin) {
//                startActivity(new Intent(MainLanguageChange.this, MainCalculatorResult.class));
//            }
//        });
    }

}
