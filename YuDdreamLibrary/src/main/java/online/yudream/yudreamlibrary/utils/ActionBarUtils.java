package online.yudream.yudreamlibrary.utils;

import android.app.Activity;
import android.view.View;

public class ActionBarUtils {
    /**
     * 设置状态栏颜色
     * @param activity 当前活动
     * @param color 颜色
     * 状态栏包括在试图内
     */
    public static void setColor(Activity activity, int color){
        activity.getWindow().setStatusBarColor(color);
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
    /**
     * 设置状态栏颜色
     * @param activity 当前活动
     * @param color 颜色
     * 状态栏包括在试图外
     */
    public static void setColor2(Activity activity,int color){
        activity.getWindow().setStatusBarColor(color);
    }
}
