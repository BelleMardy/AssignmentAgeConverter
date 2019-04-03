//package au.edu.jcu.cp3406.assignmentageconverter;
//
//// Dog age conversion cheat sheet //https://www.centralvet.ca/senior-dog-wellness
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Resources;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.SeekBar;
//import android.widget.TextView;
//
//import au.edu.jcu.cp3406.assignmentageconverter.Helper.LocaleHelper;
//import io.paperdb.Paper;
//
//public class MainCalculatorResult extends AppCompatActivity {
//
//    SeekBar sb_weight;
//    TextView val_weight;
//
//    SeekBar sb_year;
//    TextView val_year;
//
//    SeekBar sb_month;
//    TextView val_month;
//
//    int val_dog_size;
//    int val_dog_year;
//    int val_dog_month;
//
//
//    // Select variables that need to be translated
//
//    //TextView tV_header_cal;
//    //TextView tV_select_dog_weight;
//    //TextView tV_text_weight_description;
//    //TextView tV_header_dog_age_years;
//    //TextView tV_text_description_year;
//    //TextView tV_header_dog_age_months;
//    //TextView tV_text_description_month;
//    //TextView tV_text_calculate_human_year;
//    //TextView tV_value_human_age;
//    //TextView tV_button_home;
//
//    //tV_header_cal = findViewById(R.id.header_main);
//    //tV_select_dog_weight = findViewById(R.id.header_select_dog_weight);
//    //tV_txt_weight_description = findViewById(R.id.text_weight_description);
//    //tV_header_dog_age_years = findViewById(R.id.header_dog_age_years);
//    //tV_text_description_year = findViewById(R.id.text_description_year);
//    //tV_header_dog_age_months = findViewById(R.id.header_dog_age_months);
//    //tV_text_description_month = findViewById(R.id.text_description_month);
//    //tV_text_calculate_human_year = findViewById(R.id.text_calculate_human_year);
//    //tV_value_human_age = findValueById(R.id.value_human_age);
//    //tV_button_home = findValueById(R.id.button_home);
//
//    //tv_header_cal.setText(resources.getString(R.string.header_main));
//    //tv_select_dog_weight(resources.getString(R.string.header_select_dog_weight);
//    //tv_text_weight_description(resources.getString(R.string.text_weight_description);
//    //tv_header_dog_age_years(resources.getString(R.string.header_dog_age_years);
//    //tv_header_dog_age_years(resources.getString(R.string.text_description_year);
//    //tV_header_dog_age_months(resources.getString(R.string.header_dog_age_months);
//    //tV_text_description_month(resources.getString(R.string.text_description_month);
//    //tV_text_calculate_human_year(resources.getString(R.string.text_calculate_human_year);
//    //tv_value_human_age(resources.getString(R.string.value_human_age);
//    //tv_button_home(resources.getString(R.sting.button_home);
//
//    // Uses MainApplication code to set language as English
//    @Override
//
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
//    }
//
//
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_age_calculator);
//
//        // refer to OnClick button to change activities
//
//        configurebutton_home();
//
//        // sets functionality of seek bars
//
//
//
//        sb_weight = this.findViewById(R.id.seekbar_weight);
//        val_weight = this.findViewById(R.id.value_seekbar_weight);
//
//        sb_year = this.findViewById(R.id.seekbar_year);
//        val_year = this.findViewById(R.id.value_seekbar_year);
//
//        sb_month = this.findViewById(R.id.seekbar_month);
//        val_month = this.findViewById(R.id.value_seekbar_month);
//
//
//        sb_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//            // set print option based on seek bar weight of dog
//
//            @Override
//            public void onProgressChanged(SeekBar sb_weight, int dog_size, boolean fromUser) {
//                val_weight.setText(String.valueOf(dog_size));
//                int dog_size_null = 0;
//                int dog_size_small = 1;
//                int dog_size_medium = 2;
//                int dog_size_large = 3;
//                int dog_size_xlarge = 4;
//
//                if (dog_size == dog_size_null) {
//                    TextView size_desc = findViewById(R.id.text_weight_description);
//                    size_desc.setText(getString(R.string.blank));
//                } else if (dog_size == dog_size_small) {
//                    TextView size_desc = findViewById(R.id.text_weight_description);
//                    size_desc.setText(getString(R.string.small));
//                } else if (dog_size == dog_size_medium) {
//                    TextView size_desc = findViewById(R.id.text_weight_description);
//                    size_desc.setText(getString(R.string.medium));
//                } else if (dog_size == dog_size_large) {
//                    TextView size_desc = findViewById(R.id.text_weight_description);
//                    size_desc.setText(getString(R.string.large));
//                } else if (dog_size == dog_size_xlarge) {
//                    TextView size_desc = findViewById(R.id.text_weight_description);
//                    size_desc.setText(getString(R.string.xlarge));
//                }
//                val_dog_size = dog_size;
//                age_output();
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar sb_weight) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar sb_weight) {
//            }
//        });
//
//        // set print option based on seek bar year of dog
//
//        sb_year.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar sb_year, int year, boolean fromUser) {
//                val_year.setText(String.valueOf(year));
//
//
//                if (year == 0) {
//                    TextView size_desc = findViewById(R.id.text_description_year);
//                    size_desc.setText(getString(R.string.blank));
//                } else if (year == 1) {
//                    TextView size_desc = findViewById(R.id.text_description_year);
//                    size_desc.setText(getString(R.string.one_year));
//                } else if (year > 1) {
//                    TextView size_desc = findViewById(R.id.text_description_year);
//                    size_desc.setText(getString(R.string.years));
//                }
//                if (year == 18) {
//                    sb_month.setEnabled(false);
//                } else {
//                    sb_month.setEnabled(true);
//                }
//                if (year == 18) {
//                    sb_month.setEnabled(false);
//                    val_dog_month = 0;
//                    val_month.setText(Integer.toString(0));
//                }
//                val_dog_year = year;
//                age_output();
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        // set print option based on seek bar month of dog
//
//        sb_month.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar sb_month, int month, boolean fromUser) {
//                val_month.setText(String.valueOf(month));
//
//
//                if (month == 0) {
//                    TextView size_desc = findViewById(R.id.text_description_month);
//                    size_desc.setText(getString(R.string.blank));
//                } else if (month == 1) {
//                    TextView size_desc = findViewById(R.id.text_description_month);
//                    size_desc.setText(getString(R.string.month));
//                } else if (month > 1) {
//                    TextView size_desc = findViewById(R.id.text_description_month);
//                    size_desc.setText(getString(R.string.months));
//                }
//
//                val_dog_month = month;
//                age_output();
//            }
//
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//    }
//
//    // output of age calculator
//    public void age_output() {
//
//        TextView val_age = findViewById(R.id.value_human_age);
//        MainAgeCalculator ageCalc = new MainAgeCalculator();
//        String result = ageCalc.age_cal(val_dog_size, val_dog_year, val_dog_month);
//
//        val_age.setText(String.valueOf(result));
//    }
//
//    // Create setting in action bar with two options
//    @Override
//    public boolean onCreateOptionsMenu(Menu settings_menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.settings, settings_menu);
//        return true;
//    }
//
//    // On click button - Begin - sends to calculation activity
//    private void configurebutton_home() {
//        Button btn_home = findViewById(R.id.home);
//        btn_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view){
//                startActivity(new Intent(MainCalculatorResult.this, MainActivity.class));
//            }
//
//        });
//    }}
