package au.edu.jcu.cp3406.assignmentageconverter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import au.edu.jcu.cp3406.assignmentageconverter.Helper.LocaleHelper;
import io.paperdb.Paper;


public class MainActivity extends AppCompatActivity {

    TextView tV_header;
    TextView tV_instructions;
    TextView tV_begin;
    @Override
    protected void attachBaseContext (Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurebutton_calculate();
        tV_header = (TextView) findViewById(R.id.header_main);
        tV_instructions = (TextView) findViewById(R.id.instructions);
        tV_begin = (TextView) findViewById(R.id.begin);

        // Init Paper first:
        Paper.init(this);


        //Default Language is English
        String language = Paper.book().read("language");
        if(language == null);
            Paper.book().write("language", "en");

            updateView((String)Paper.book().read("language"));
    }

    private void updateView(String lang) {

        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();

        tV_header.setText(resources.getString(R.string.header_main));
        tV_instructions.setText(resources.getString(R.string.instructions));
        tV_begin.setText(resources.getString(R.string.begin));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings_english) {
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));

    }
    else if (item.getItemId() == R.id.settings_spanish) {
            Paper.book().write("language","es");
            updateView((String)Paper.book().read("language"));

        }
        return true;
    }

    private void configurebutton_calculate() {
        Button btn_calculate = findViewById(R.id.begin);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CalculatorResult.class));
            }
        });
    }
}


