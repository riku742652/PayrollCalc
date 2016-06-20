package com.example.riku.payrollcalc;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created by Riku on 2016/05/23.
 */

public class SetActivity extends AppCompatActivity {
    Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        globals = (Globals)this.getApplication();

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final TimePicker start_time = (TimePicker) findViewById(R.id.start_time);
        final TimePicker fin_time = (TimePicker) findViewById(R.id.fin_time);

        start_time.setIs24HourView(true);
        fin_time.setIs24HourView(true);


        start_time.setHour(0);
        start_time.setMinute(0);
        fin_time.setHour(0);
        fin_time.setMinute(0);


        Button button = (Button) findViewById(R.id.btn_set);

        final Intent intent = new Intent(this, MainActivity.class);

        assert button != null;
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                globals.set_month[globals.count] = datePicker.getMonth();   //0から数えるので１月が0
                globals.set_day[globals.count] = datePicker.getDayOfMonth();
                globals.start_hour[globals.count] =  start_time.getHour();
                globals.start_min[globals.count] =  start_time.getMinute();
                globals.fin_hour[globals.count] =  fin_time.getHour();
                globals.fin_min[globals.count] =  fin_time.getMinute();

                globals.setStart_hour(globals.count, globals.start_hour[globals.count]);
                globals.setFin_hour(globals.count, globals.fin_hour[globals.count]);
                globals.setStart_min(globals.count, globals.start_min[globals.count]);
                globals.setFin_min(globals.count, globals.fin_min[globals.count]);
                globals.setMonth(globals.count, globals.set_month[globals.count]);
                globals.setDay(globals.count, globals.set_day[globals.count]);

                globals.setCount();

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

}
