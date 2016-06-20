package com.example.riku.payrollcalc;
import android.app.Application;
import android.util.Log;
import java.util.Calendar;
/**
 * Created by Riku on 2016/05/26.
 */
public class Globals extends Application{

    @Override
    public void onCreate(){
    }

    // SetActivity
    // １件目、２件目・・・１０２４件目
    // for(;;) if(set_month[○] == int（今月の関数）)　時間差*給料
    static int[] set_year = new int[1024];
    static int[] set_month = new int[1024];//１ずれているので１月が０
    static int[] set_day = new int[1024];

    static int[] start_hour = new int[1024];
    static int[] fin_hour = new int[1024];
    static int[] start_min = new int[1024];
    static int[] fin_min = new int[1024];
    static int count = 1;//データ番号

    //ConfigActivity
    static int money = 800;
    static int goal_money = 40000;

//    public void zero_clear(){
//        Arrays.fill(this.fin_hour, 0);
//        Arrays.fill(this.start_hour,0);
//    }

    public int getStart_hour(){
        return this.start_hour[this.count - 1];
    }
    public int getFin_hour(){
        return this.fin_hour[this.count - 1];
    }
    public int getStart_min(){
        return this.start_min[this.count - 1];
    }
    public int getFin_min(){
        return this.fin_min[this.count - 1];
    }
    public int getMonth(){
        return this.set_month[this.count - 1];
    }
    public int getDay(){
        return this.set_day[this.count - 1];
    }
    public int getCount(){
        return this.count;
    }

    public int getMoney(){
        return this.money;
    }

    public int getGoal_money(){
        return this.goal_money;
    }


    Calendar cal = Calendar.getInstance();

    public int sum_m_time(){
        int sum = 0;
        for (int i = 0; i < 1024; i++){
            if (this.set_month[i] == cal.get(Calendar.MONTH))
                sum += this.fin_hour[i] - this.start_hour[i];
        }
        return sum;
    }

    public int sum_next_time(){
        int sum = 0;
        for (int i = 0; i < 1024; i++){
            if (this.set_month[i] == (cal.get(Calendar.MONTH) + 1))
                sum += this.fin_hour[i] - this.start_hour[i];
        }
        return sum;
    }

    public int find_t_time(){
        int sum = 0;
        for(int i = 0; i < 1024; i++){
            if (this.set_month[i] ==(cal.get(Calendar.MONTH)) && this.set_day[i] == (cal.get(Calendar.DAY_OF_MONTH)))
                sum += ((this.fin_hour[i]*60 + this.fin_min[i]) - (this.start_hour[i]*60 + this.start_min[i]));
        }
        return  sum;
    }

    public void setStart_hour(int c, int hour){
        this.count = c;
        this.start_hour[this.count] = hour;
        Log.d("VarDebug", "start_hour["+this.count+"]:" + this.start_hour[this.count]);
    }

    public void setFin_hour(int c, int hour){
        this.count = c;
        this.fin_hour[this.count] = hour;
        Log.d("VarDebug", "fin_hour["+this.count+"]:" + this.fin_hour[this.count]);

    }

    public void setStart_min(int c, int min){
        this.count = c;
        this.start_min[this.count] = min;
        Log.d("VarDebug", "start_min["+this.count+"]:" + this.start_min[this.count]);

    }

    public void setFin_min(int c, int min){
        this.count = c;
        this.fin_min[this.count] = min;
        Log.d("VarDebug", "fin_min["+this.count+"]:" + this.fin_min[this.count]);

    }


    public void setMonth(int c, int month){
        this.count = c;
        this.set_month[this.count] = month;
        Log.d("VarDebug", "set_month["+this.count+"]:" + this.set_month[this.count]);

    }

    public void setDay(int c, int day){
        this.count = c;
        this.set_day[this.count] = day;
        Log.d("VarDebug", "set_day["+this.count+"]:" + this.set_day[this.count]);
    }

    public void setCount(){
        this.count++;
        Log.d("VarDebug", "count:"+ this.count);
    }

    public void setMoney(int m){
        this.money = m;
        Log.d("VarDebug", "money:"+ money);
    }
    public void setGoal_money(int gm){
        this.goal_money = gm;
        Log.d("VarDebug", "goal_money:"+ goal_money);
    }

    //MainActivitys

}
