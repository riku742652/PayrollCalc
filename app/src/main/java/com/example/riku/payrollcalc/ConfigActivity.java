package com.example.riku.payrollcalc;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Riku on 2016/05/25.
 */
public class ConfigActivity extends AppCompatActivity {

    Globals globals;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        globals = (Globals)this.getApplication();

        final EditText hourly_wage = (EditText) findViewById(R.id.hourly_wage);
        final EditText goal_money = (EditText) findViewById(R.id.goal_money);

        Button btn = (Button) findViewById(R.id.btn_set);

        final Intent intent = new Intent(this, MainActivity.class);

        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hourly_wage.getText().toString().equals("")) {
                }else {
                    globals.setMoney(Integer.parseInt((hourly_wage.getText().toString())));
                }
                if(goal_money.getText().toString().equals("")) {
                }
                else {
                    globals.setGoal_money(Integer.parseInt((goal_money.getText().toString())));
                }
                if (hourly_wage.getText().toString().equals("") && goal_money.getText().toString().equals("")) {
                }else {
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}