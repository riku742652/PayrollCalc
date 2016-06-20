package com.example.riku.payrollcalc;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView today_time = (TextView)findViewById(R.id.today_time);
        TextView today_money = (TextView)findViewById(R.id.today_money);
        TextView month_time = (TextView)findViewById(R.id.month_time);
        TextView month_money = (TextView)findViewById(R.id.month_money);
        TextView next_time = (TextView)findViewById(R.id.next_time);
        TextView next_money = (TextView)findViewById(R.id.next_money);
        TextView goal = (TextView)findViewById(R.id.goal);

        globals = (Globals) this.getApplication();

        int t_time = globals.find_t_time();
        int t_money = t_time/60 * globals.getMoney();
        int m_time = globals.sum_m_time();
        int m_money = m_time * globals.getMoney();
        int n_time = globals.sum_next_time();
        int n_money = n_time * globals.getMoney();

        today_time.setText("今日の勤務時間: " + t_time + "時間");
        today_time.setText("今日の勤務時間: " +  (globals.fin_hour[0] - globals.start_hour[0]) + "時間");
        if (t_time  ==  0){
            today_time.setText("今日は休みです！");
            today_money.setText("");

        }else {
            today_time.setText("今日の勤務時間:"+ Integer.toString(t_time/60) + "時間"+ Integer.toString(t_time%60) + "分");
            today_money.setText("今日の給与金額: " + t_money + "円");
        }
        month_time.setText("今月の勤務時間: " + Integer.toString(m_time) + "時間");
        month_money.setText("今月の給与金額: " + Integer.toString(m_money) + "円");
        next_time.setText("来月の勤務時間: " + Integer.toString(n_time) + "時間");
        next_money.setText("来月の給与金額: " + Integer.toString(n_money) + "円");
        goal.setText("目標金額まであと " + Integer.toString(globals.getGoal_money() - m_money) + "円です！");

        findViewById(R.id.button_set).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SetActivity.class);

                startActivity(intent);

            }
        });

        findViewById(R.id.button_config).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ConfigActivity.class);

                startActivity(intent);

            }
        });
    }
}
