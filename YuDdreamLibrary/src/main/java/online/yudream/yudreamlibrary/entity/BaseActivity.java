package online.yudream.yudreamlibrary.entity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import online.yudream.yudreamlibrary.api.ActivityInit;
import online.yudream.yudreamlibrary.utils.ActionBarUtils;

public class BaseActivity extends FragmentActivity implements View.OnClickListener, ActivityInit {
    protected Activity activity;
    protected int layoutId;
    protected Bundle savedInstanceState;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //继承父类方法
        this.savedInstanceState = savedInstanceState; //保存状态
        setContentView(layoutId); //设置布局文件
        init(); //初始化
    }
    /**
     * 初始化活动
     */
    @Override
    public void initActivity() {
        ActivityInit.super.initActivity();
        activity = this; //获取活动
    }
    /**
     * 初始化状态栏
     */
    @Override
    public void initActionBar() {
        ActivityInit.super.initActionBar();
        ActionBarUtils.setColor2(this, Color.BLACK); //设置状态栏颜色
    }
    /**
     * 重写监听器
     */
    @Override
    public void onClick(View view) {}
}
