package au.edu.jcu.cp3406.assignmentageconverter;

//https://www.centralvet.ca/senior-dog-wellness

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.math.BigDecimal;


public class b_DogCalculator extends AppCompatActivity {

    SeekBar sb_weight; // define variable for Seekbar weight (relates to b_dog_calculator)
    TextView val_weight; // define variable for TextView value weight (relates to b_dog_calculator)

    SeekBar sb_year; // define variable for Seekbar year (relates to b_dog_calculator)
    TextView val_year; // define variable for TextView value year (relates to b_dog_calculator)

    SeekBar sb_month; // define variable for Seekbar month (relates to b_dog_calculator)
    TextView val_month; // define variable for TextView value month (relates to b_dog_calculator)

    int val_dog_size; // define variable for value of dog weight (relates to (b_DogCalulator)
    int val_dog_year; // define variable for value of dog age in year/s (relates to (b_DogCalulator)
    int val_dog_month; // define variable for value of dog age in month/s (relates to (b_DogCalulator)

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_dog_calculator);

        configurebutton_name(); // refer to OnClick button to change screens

        sb_weight = this.findViewById(R.id.seekbar_weight); // define variable for seekbar weight b_dog_calculator
        val_weight = this.findViewById(R.id.value_seekbar_weight); // define variable for text weight b_dog_calculator

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
                    TextView size_desc = (TextView) findViewById(R.id.text_size_description);
                    size_desc.setText(getString(R.string.no_age));
                } else if (dog_size == dog_size_small) {
                    TextView size_desc = (TextView) findViewById(R.id.text_size_description);
                    size_desc.setText(getString(R.string.small));
                } else if (dog_size == dog_size_medium) {
                    TextView size_desc = (TextView) findViewById(R.id.text_size_description);
                    size_desc.setText(getString(R.string.medium));
                } else if (dog_size == dog_size_large) {
                    TextView size_desc = (TextView) findViewById(R.id.text_size_description);
                    size_desc.setText(getString(R.string.large));
                } else if (dog_size == dog_size_xlarge) {
                    TextView size_desc = (TextView) findViewById(R.id.text_size_description);
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
        String result = c_CalculateAge.age_cal(val_dog_size, val_dog_year, val_dog_month);

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

} // end public b_DogCalculator class extends

