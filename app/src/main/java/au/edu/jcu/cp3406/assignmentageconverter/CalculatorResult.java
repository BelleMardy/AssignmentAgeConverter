package au.edu.jcu.cp3406.assignmentageconverter;

//https://www.centralvet.ca/senior-dog-wellness

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import au.edu.jcu.cp3406.assignmentageconverter.Helper.LocaleHelper;


public class CalculatorResult extends AppCompatActivity {

    SeekBar sb_weight; // define variable for Seekbar weight (relates to activity_age_calculator)
    TextView val_weight; // define variable for TextView value weight (relates to activity_age_calculator)

    SeekBar sb_year; // define variable for Seekbar year (relates to activity_age_calculator)
    TextView val_year; // define variable for TextView value year (relates to activity_age_calculator)

    SeekBar sb_month; // define variable for Seekbar month (relates to activity_age_calculator)
    TextView val_month; // define variable for TextView value month (relates to activity_age_calculator)

    int val_dog_size; // define variable for value of dog weight (relates to (b_DogCalulator)
    int val_dog_year; // define variable for value of dog age in year/s (relates to (b_DogCalulator)
    int val_dog_month; // define variable for value of dog age in month/s (relates to (b_DogCalulator)

//    <string name="header_main">Age Converter</string> android:id="@+id/header_main"
//    <string name="button_home">Home</string> android:id="@+id/button_home"
//    <string name="text_weight_range">Select Dog Weight</string> ndroid:id="@+id/header_select_dog_weight"
//    <string name="text_year_range">Select Dog Age - Year(s)</string> android:id="@+id/header_dog_age_years"
//    <string name="text_month_range">Select Dog Age - Month(s)</string> android:id="@+id/header_dog_age_months"
//    <string name="text_calculate_human_year">Calculate Human Years</string> android:id="@+id/text_calculate_human_year"
//    <string name="result"><font size="20">Human Years</font></string> android:id="@+id/value_human_age"

//    <string name="small">Small dog (under 9.9 kg)</string>
//    <string name="no_age">No weight entered</string>
//    <string name="medium">Medium dog (10 kg to 24.9 kg)</string>
//    <string name="large">Large dog (25 kg to 39.9 kg)</string>
//    <string name="txt_year">Year(s)</string>
//    <string name="blank" />
//    <string name="one_year">year</string>
//    <string name="years">years</string>
//    <string name="month">month</string>
//    <string name="months">months</string>
//    <string name="xlarge">X-Large dog (over 40 kg)</string>
//    <string name="hint"><font size="20">Human Years</font></string>
//
    @Override

    protected void attachBaseContext (Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        configurebutton_name(); // refer to OnClick button to change screens

        sb_weight = this.findViewById(R.id.seekbar_weight); // define variable for seekbar weight activity_age_calculator
        val_weight = this.findViewById(R.id.value_seekbar_weight); // define variable for text weight activity_age_calculator

        sb_year = this.findViewById(R.id.seekbar_year);
        val_year = this.findViewById(R.id.value_seekbar_year);

        sb_month = this.findViewById(R.id.seekbar_month);
        val_month = this.findViewById(R.id.value_seekbar_month);


        sb_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar sb_weight, int dog_size, boolean fromUser) {
                val_weight.setText(String.valueOf(dog_size));
                int dog_size_null = 0;
                int dog_size_small = 1;
                int dog_size_medium = 2;
                int dog_size_large = 3;
                int dog_size_xlarge = 4;

                if (dog_size == dog_size_null) {
                    TextView size_desc = (TextView) findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.no_age));
                } else if (dog_size == dog_size_small) {
                    TextView size_desc = (TextView) findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.small));
                } else if (dog_size == dog_size_medium) {
                    TextView size_desc = (TextView) findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.medium));
                } else if (dog_size == dog_size_large) {
                    TextView size_desc = (TextView) findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.large));
                } else if (dog_size == dog_size_xlarge) {
                    TextView size_desc = (TextView) findViewById(R.id.text_weight_description);
                    size_desc.setText(getString(R.string.xlarge));
                }
                val_dog_size = dog_size;// defined variable for weight value
                age_output(); // end seekbar year class
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb_weight) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar sb_weight) {
            } // end seekbar weight onStopTrackingTouch
        }); // end seekbar weight class

        sb_year.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int year, boolean fromUser) {
                val_year.setText(String.valueOf(year));


                if (year == 0) {
                    TextView size_desc = (TextView) findViewById(R.id.text_description_year);
                    size_desc.setText(getString(R.string.blank));
                } else if (year == 1) {
                    TextView size_desc = (TextView) findViewById(R.id.text_description_year);
                    size_desc.setText(getString(R.string.one_year));
                } else if (year > 1) {
                    TextView size_desc = (TextView) findViewById(R.id.text_description_year);
                    size_desc.setText(getString(R.string.years));
                }
                if (year == 18) {
                    sb_month.setEnabled(false);
                }
                else {
                    sb_month.setEnabled(true);
                }
                if (year == 18) {
                    sb_month.setEnabled(false);
                    val_dog_month = 0;
                    val_month.setText(Integer.toString(0));
                }
                val_dog_year = year; // defined variable for year value
                age_output(); // end seekbar year class
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }  // end public void onClick
        }); // end btn_home CnClickListener

        sb_month.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int month, boolean fromUser) {
                val_month.setText(String.valueOf(month));


                if (month == 0) {
                    TextView size_desc = (TextView) findViewById(R.id.text_description_month);
                    size_desc.setText(getString(R.string.blank));
                } else if (month == 1) {
                    TextView size_desc = (TextView) findViewById(R.id.text_description_month);
                    size_desc.setText(getString(R.string.month));
                } else if (month > 1) {
                    TextView size_desc = (TextView) findViewById(R.id.text_description_month);
                    size_desc.setText(getString(R.string.months));
                }

                val_dog_month = month; // defined variable for month value
                age_output(); // result of age_output Class
            } // end seekbar month onProgressChange


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            } // end seebar month onStartTrackingTouch

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            } // end seekbar month onStopTrackingTouch
        }); // end seekbar month class
    } // end protected onCreate class

    public void age_output() {

        TextView val_age = (TextView) findViewById(R.id.value_human_age);
        AgeCalculator ageCalc = new AgeCalculator();
        String result = ageCalc.age_cal(val_dog_size, val_dog_year, val_dog_month);

        val_age.setText(String.valueOf(result));
    } // end public age_output class

    private void configurebutton_name() {
        Button btn_home = (Button) findViewById(R.id.button_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }  // end public void onClick
        }); // end btn_home CnClickListner
    } // end private configurebutton_name class

    @Override
    public boolean onCreateOptionsMenu(Menu settings_menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate (R.menu.settings, settings_menu);
        return true;
    }

} // end public CalculatorResult class extends

