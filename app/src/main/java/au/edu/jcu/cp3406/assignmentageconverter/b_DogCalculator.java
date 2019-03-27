package au.edu.jcu.cp3406.assignmentageconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class b_DogCalculator extends AppCompatActivity {

    SeekBar sb_weight;
    TextView val_weight;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_dog_calculator);

        configurebutton_name();
        sb_weight = findViewById(R.id.seekbar_weight);
        val_weight = findViewById(R.id.value_weight);

        sb_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar sb_weight, int dog_size, boolean fromUser) {
                val_weight.setText(String.valueOf(dog_size));
                int dog_size_null = 0;
                int dog_size_small = 1;
                int dog_size_medium = 2;
                int dog_size_large = 3;

                if (dog_size == dog_size_null){
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.no_age));
                }

                else if (dog_size == dog_size_small) {
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.small));
                }

                else if (dog_size == dog_size_medium) {
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.medium));
                }

                else if (dog_size == dog_size_large) {
                    TextView size_desc = (TextView) findViewById(R.id.size_type);
                    size_desc.setText(getString(R.string.large));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb_weight) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar sb_weight) {
            }
        });
    }



    private void configurebutton_name() {
        Button btn_home = (Button) findViewById(R.id.button_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();            }
        });
    }
}