package online.yudream.yudreamlibrary.api;

public interface ActivityInit {
    default void init(){
        initActivity(); //初始化活动
        initView(); //初始化视图
        initController(); //初始化控制器
        initResource(); //初始化资源
        initListener(); //初始化监听器
        initAdapter(); //初始化适配器
        initIntent(); //初始化意图
        initActionBar(); //初始化状态栏
    }
    default void initActivity(){}
    default void initController(){}
    default void initView(){}
    default void initActionBar(){}
    default void initListener(){}
    default void initResource(){}
    default void initIntent(){}
    default void initAdapter(){}

}
