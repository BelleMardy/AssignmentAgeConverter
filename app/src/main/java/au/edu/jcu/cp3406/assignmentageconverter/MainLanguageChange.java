package au.edu.jcu.cp3406.assignmentageconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import au.edu.jcu.cp3406.assignmentageconverter.Helper.LocaleHelper;
import io.paperdb.Paper;

public class MainLanguageChange extends AppCompatActivity {

    // Select variables that need to be translated
    TextView tV_settings_english;
    TextView tV_settings_spanish;
    TextView tV_settings_home;
    TextView tV_settings_calculator;

    // Uses MainApplication code to set language as English
    @Override
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // refer to OnClick button to change activities
        configurebutton_settings_home();
        configurebutton_settings_calculator();

        // Finds strings to translate
        tV_settings_english = findViewById(R.id.settings_english);
        tV_settings_spanish = findViewById(R.id.settings_spanish);
        tV_settings_home = findViewById(R.id.settings_home);
        tV_settings_calculator = findViewById(R.id.settings_calculator);

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
        tV_settings_english.setText(resources.getString(R.string.settings_english));
        tV_settings_spanish.setText(resources.getString(R.string.settings_spanish));
        tV_settings_home.setText(resources.getString(R.string.settings_home));
        tV_settings_calculator.setText(resources.getString(R.string.settings_calculator));
    }

    // Create setting in action bar with two options
    @Override
    public boolean onCreateOptionsMenu(Menu settings_menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, settings_menu);
        return true;
    }

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
    private void configurebutton_settings_calculator() {
        Button btn_settings_calculator = findViewById(R.id.settings_calculator);
        btn_settings_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn_settings_calculator) {
                startActivity(new Intent(MainLanguageChange.this, MainCalculatorResult.class));
            }
        });
    }
//___________________________________________________________________________

    // On click button - Begin - sends to calculation activity
    private void configurebutton_settings_home() {
        Button btn_calculator = findViewById(R.id.settings_home);
        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View begin) {
                startActivity(new Intent(MainLanguageChange.this, MainActivity.class));
            }
        });
    }
}

//___________________________________________________________________________

