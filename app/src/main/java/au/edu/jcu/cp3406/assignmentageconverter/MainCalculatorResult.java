package au.edu.jcu.cp3406.assignmentageconverter;

// Dog age conversion cheat sheet //https://www.centralvet.ca/senior-dog-wellness

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import au.edu.jcu.cp3406.assignmentageconverter.Helper.LocaleHelper;
import io.paperdb.Paper;



public class MainCalculatorResult extends AppCompatActivity {


    // Select variables that need to be translated
    SeekBar sb_weight;
    TextView val_weight;

    SeekBar sb_year;
    TextView val_year;

    SeekBar sb_month;
    TextView val_month;

    int val_dog_size;
    int val_dog_year;
    int val_dog_month;

    TextView tV_header_main;
    TextView tV_select_dog_weight;
    TextView tV_dog_age_years;
    TextView tV_dog_age_months;
    TextView tV_calculate_human_age;
    TextView tV_home;
    TextView tV_change_language;


    // Uses MainApplication code to set language as English
    @Override

    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));

    } // 46. protected void attachBaseContext(Context newBase)


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sb_weight = this.findViewById(R.id.seekbar_weight);
        val_weight = this.findViewById(R.id.value_seekbar_weight);

        sb_year = this.findViewById(R.id.seekbar_year);
        val_year = this.findViewById(R.id.value_seekbar_year);

        sb_month = this.findViewById(R.id.seekbar_month);
        val_month = this.findViewById(R.id.value_seekbar_month);

        // refer to OnClick button to change activities

        configurebutton_home();
        configurebutton_settings_change_language_calculator();

        // Finds strings to translate
        tV_header_main = findViewById(R.id.header_main);
        tV_select_dog_weight = findViewById(R.id.select_dog_weight);
        tV_dog_age_years = findViewById(R.id.dog_age_years);
        tV_dog_age_months = findViewById(R.id.dog_age_months);
        tV_calculate_human_age = findViewById(R.id.calculate_human_age);
        tV_home = findViewById(R.id.home);
        tV_change_language = findViewById(R.id.activity_change_language_calculator);


        // Init Paper first:
        Paper.init(this);

        //Default language is English, empty 'if' statement required
        String language = Paper.book().read("language");
        if (null == language) {
        }
        Paper.book().write("language", "en");
        updateView((String)Paper.book().read("language"));



        // LocalHelper used to translate language

        sb_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // set print option based on seek bar weight of dog

            @Override
            public void onProgressChanged(SeekBar sb_weight, int dog_size, boolean fromUser) {
                val_weight.setText(String.valueOf(dog_size));
                updateView((String) Paper.book().read("language"));

                int dog_size_null = 0;
                int dog_size_small = 1;
                int dog_size_medium = 2;
                int dog_size_large = 3;
                int dog_size_xlarge = 4;

                if (dog_size == dog_size_null) {
                    TextView size_desc = findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.blank));
                } else if (dog_size == dog_size_small) {
                    TextView size_desc = findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.small));
                } else if (dog_size == dog_size_medium) {
                    TextView size_desc = findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.medium));
                } else if (dog_size == dog_size_large) {
                    TextView size_desc = findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.large));
                } else if (dog_size == dog_size_xlarge) {
                    TextView size_desc = findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.xlarge));
                }

                val_dog_size = dog_size;
                age_output();

            }

            @Override
            public void onStartTrackingTouch(SeekBar sb_weight) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar sb_weight) {
            }
        });

        // set print option based on seek bar year of dog

        sb_year.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar sb_year, int year, boolean fromUser) {
                val_year.setText(String.valueOf(year));


                if (year == 0) {
                    TextView size_desc = findViewById(R.id.text_description_year);
                    size_desc.setText(getString(R.string.blank));
                } else if (year == 1) {
                    TextView size_desc = findViewById(R.id.text_description_year);
                    size_desc.setText(getString(R.string.one_year));
                } else if (year > 1) {
                    TextView size_desc = findViewById(R.id.text_description_year);
                    size_desc.setText(getString(R.string.years));
                }
                if (year == 18) {
                    sb_month.setEnabled(false);
                } else {
                    sb_month.setEnabled(true);
                }
                if (year == 18) {
                    sb_month.setEnabled(false);
                    val_dog_month = 0;
                    val_month.setText(Integer.toString(0));
                }
                val_dog_year = year;
                age_output();
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb_year) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar sb_year) {

            }
        });

        // set print option based on seek bar month of dog

        sb_month.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb_month, int month, boolean fromUser) {
                val_month.setText(String.valueOf(month));


                if (month == 0) {
                    TextView size_desc = findViewById(R.id.text_description_month);
                    size_desc.setText(getString(R.string.blank));
                } else if (month == 1) {
                    TextView size_desc = findViewById(R.id.text_description_month);
                    size_desc.setText(getString(R.string.month));
                } else if (month > 1) {
                    TextView size_desc = findViewById(R.id.text_description_month);
                    size_desc.setText(getString(R.string.months));
                }

                val_dog_month = month;
                age_output();
            }


            @Override
            public void onStartTrackingTouch(SeekBar sb_month) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb_month) {

            }
        });
    }

    private void updateView(String lang) {

        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();
        tV_header_main.setText(resources.getString(R.string.header_main));
        tV_select_dog_weight.setText(resources.getString(R.string.select_dog_weight));
        tV_dog_age_years.setText(resources.getString(R.string.dog_age_years));
        tV_dog_age_months.setText(resources.getString(R.string.dog_age_months));
        tV_calculate_human_age.setText(resources.getString(R.string.calculate_human_age));
        tV_home.setText(resources.getString(R.string.home));
        tV_change_language.setText(R.string.activity_main_settings);
    }
//_______________________________________________________________________________________

    // output of age calculator
    public void age_output() {

        TextView val_age = findViewById(R.id.value_human_age);
        MainAgeCalculator ageCalc = new MainAgeCalculator();
        String result = ageCalc.age_cal(val_dog_size, val_dog_year, val_dog_month);

        val_age.setText(String.valueOf(result));
    } // 233. public void age_output()

//_______________________________________________________________________________________


    // Create setting in action bar with two options
    @Override
    public boolean onCreateOptionsMenu(Menu settings_menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, settings_menu);
        return true;
    }

//_______________________________________________________________________________________

    // Create setting in action bar with two options
    @Override
    public boolean onOptionsItemSelected(MenuItem settings) {
        if (settings.getItemId() == R.id.settings_spanish) {
            Paper.book().write("language", "es");
            updateView((String) Paper.book().read("language"));
        }//if (settings.getItemId() == R.id.settings_english)

        else if (settings.getItemId() == R.id.settings_english) {
            Paper.book().write("language", "en");
            updateView((String) Paper.book().read("language"));
        } // else if (settings.getItemId() == R.id.settings_spanish)
        return true;
    } // 244. public boolean onCreateOptionsMenu(Menu settings_menu)

//_______________________________________________________________________________________



//    // On click button - Begin - sends to calculation activity
    private void configurebutton_settings_change_language_calculator () {
        Button btn_change_language_calculator = findViewById(R.id.activity_change_language_calculator);
        btn_change_language_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View settings_change_language_calculator) {
                startActivity(new Intent(MainCalculatorResult.this, MainLanguageChange.class));
            }
            });
        }
//_______________________________________________________________________________________


    // On click button - Home - sends to calculation activity
    private void configurebutton_home() {
        Button btn_calculator = findViewById(R.id.home);
        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View begin) {
                startActivity(new Intent(MainCalculatorResult.this, MainActivity.class));
            }
        });

    }// 20. public class MainCalculatorResult extends AppCompatActivity
}


//_______________________________________________________________________________________














