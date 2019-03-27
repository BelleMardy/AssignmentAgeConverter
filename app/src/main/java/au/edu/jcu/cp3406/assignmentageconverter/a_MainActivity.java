package au.edu.jcu.cp3406.assignmentageconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class a_MainActivity extends AppCompatActivity{

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_main);

        configurebutton_calculate();

    }

private void configurebutton_calculate() {
    Button btn_calculate = (Button) findViewById(R.id.button_calculate);
    btn_calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(a_MainActivity.this, b_DogCalculator.class));
        }
    });
}
}


