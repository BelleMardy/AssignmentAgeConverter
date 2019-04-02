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


public class MainActivity extends AppCompatActivity {

    // Select variables that need to be translated
    TextView tV_begin;
    TextView tV_header;
    TextView tV_instructions;



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
        configurebutton_begin();


        // Finds strings to translate

        tV_begin = findViewById(R.id.begin);
        tV_header = findViewById(R.id.header_main);
        tV_instructions = findViewById(R.id.instructions);


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
    }

    // On click button - Begin - sends to calculation activity
    private void configurebutton_begin() {
        Button btn_calculate = findViewById(R.id.begin);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View begin) {
                startActivity(new Intent(MainActivity.this, CalculatorResult.class));
            }
        });
    }
}


