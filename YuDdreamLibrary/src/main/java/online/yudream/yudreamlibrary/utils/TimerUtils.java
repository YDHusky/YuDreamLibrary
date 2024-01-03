package online.yudream.yudreamlibrary.utils;

import android.app.Activity;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUtils {
    /**
     * 延时跳转
     * @param time 延时时间(s)
     * @param startActivity 起始活动
     * @param endActivity 目标活动
     */
    public static void timerToJumpActivity(int time, Activity startActivity, Class<?> endActivity){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(startActivity,endActivity);
                startActivity.startActivity(intent);
                startActivity.finish();
            }
        };
        timer.schedule(timerTask,time* 1000L);
    }
}
