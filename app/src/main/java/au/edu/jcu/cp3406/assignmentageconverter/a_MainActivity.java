package au.edu.jcu.cp3406.assignmentageconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;



public class a_MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_main);

        configurebutton_calculate();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu settings_menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate (R.menu.settings, settings_menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem change_background) {
        switch (change_background.getItemId()) {
            case R.id.settings:
        }
        return super.onOptionsItemSelected(change_background);
    }

    private void configurebutton_calculate() {
        Button btn_calculate = findViewById(R.id.text_calculate_human_year);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(a_MainActivity.this, b_DogCalculator.class));
            }
        });
    }
}


