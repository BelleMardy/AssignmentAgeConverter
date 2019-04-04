package au.edu.jcu.cp3406.assignmentageconverter;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;


public class MainLanguageChange extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        configurebutton_settings_home();
        configurebutton_settings_calculator();
    }

    // On click button - Begin - sends to calculation activity
    private void configurebutton_settings_calculator () {
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
        private void configurebutton_settings_home () {
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

    // Select variables that need to be translated
//    TextView tV_settings_english;
//    TextView tV_settings_spanish;
//    TextView tV_settings_home;
//    TextView tV_settings_calculator;
//
//        tV_settings_english = findViewById(R.id.settings_english);
//        tV_settings_spanish = findViewById(R.id.settings_spanish);
//        tV_settings_home = findViewById(R.id.settings_home);
//        tV_settings_calculator = findViewById(R.id.settings_calculator);
//
//        tV_settings_english.setText(resources.getString(R.string.begin));
//        tV_settings_spanish.setText(resources.getString(R.string.header_main));
//        tV_settings_home.setText(resources.getString(R.string.instructions));
//        tV_settings_calculator.setText(R.string.activity_main_settings);
//
//
