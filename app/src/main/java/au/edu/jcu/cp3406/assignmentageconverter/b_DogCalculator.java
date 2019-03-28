package au.edu.jcu.cp3406.assignmentageconverter;

//https://www.centralvet.ca/senior-dog-wellness

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class b_DogCalculator extends AppCompatActivity {

    SeekBar sb_weight;
    TextView val_weight;

    SeekBar sb_year;
    TextView val_year;

    SeekBar sb_month;
    TextView val_month;

    int val_dog_size;
    int val_dog_year;
    int val_dog_month;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_dog_calculator);

        configurebutton_name();


        sb_weight = this.findViewById(R.id.seekbar_weight);
        val_weight = this.findViewById(R.id.value_weight);

        sb_year = this.findViewById(R.id.seekbar_year);
        val_year = this.findViewById(R.id.value_year);

        sb_month = this.findViewById(R.id.seekbar_month);
        val_month = this.findViewById(R.id.value_month);


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
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.no_age));
                } else if (dog_size == dog_size_small) {
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.small));
                } else if (dog_size == dog_size_medium) {
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.medium));
                } else if (dog_size == dog_size_large) {
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.large));
                } else if (dog_size == dog_size_xlarge) {
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
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

        sb_year.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int year, boolean fromUser) {
                val_year.setText(String.valueOf(year));


                if (year == 0) {
                    TextView size_desc = (TextView) findViewById(R.id.display_year);
                    size_desc.setText(getString(R.string.blank));
                } else if (year == 1) {
                    TextView size_desc = (TextView) findViewById(R.id.display_year);
                    size_desc.setText(getString(R.string.one_year));
                } else if (year > 1) {
                    TextView size_desc = (TextView) findViewById(R.id.display_year);
                    size_desc.setText(getString(R.string.years));


                }
                if (year == 18) {
                    sb_month.setEnabled(false);
                }
                else {
                    sb_month.setEnabled(true);
                }
                val_dog_year = year;
                age_output();
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_month.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int month, boolean fromUser) {
                val_month.setText(String.valueOf(month));


                if (month == 0) {
                    TextView size_desc = (TextView) findViewById(R.id.display_month);
                    size_desc.setText(getString(R.string.blank));
                } else if (month == 1) {
                    TextView size_desc = (TextView) findViewById(R.id.display_month);
                    size_desc.setText(getString(R.string.month));
                } else if (month > 1) {
                    TextView size_desc = (TextView) findViewById(R.id.display_month);
                    size_desc.setText(getString(R.string.months));
                }
                val_dog_month = month;
                age_output();
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void age_output() {

        TextView val_age = (TextView) findViewById(R.id.human_age);
        int result = c_calculate_age.age_cal(val_dog_size, val_dog_year, val_dog_month);

        val_age.setText(String.valueOf(result));

    }

    private void configurebutton_name() {
        Button btn_home = (Button) findViewById(R.id.button_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

