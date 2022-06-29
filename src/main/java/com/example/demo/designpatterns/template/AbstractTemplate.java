package com.example.demo.designpatterns.template;

import com.example.demo.dao.user.UserDao;
import com.example.demo.domain.User;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wan yu
 * @date 2022/5/19 下午3:41
 */
public abstract class AbstractTemplate implements ApplicationContextAware {

    private ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext context){
        this.context = context;
    }


/*    @Autowired
    private UserDao userDao;*/

    public void prepareBeverageTemplate() {
        // 步骤1:将水煮沸
        boilWater();
        // 步骤2:泡制饮料
        brew();
        // 步骤3:将饮料倒入杯中
        pourInCup();
    }

    private void boilWater() {
        UserDao userDao = context.getBean(UserDao.class);
        User user = userDao.findByMobile("15136456879");
        System.out.println("将水煮沸");
        System.out.println(new Gson().toJson(user));
    }

    /** * 抽象的基本方法 * 泡制饮料 * 注意访问权限为protected */
    protected abstract void brew();


    /** * 通用方法 * 将饮料倒入杯中 */
    private void pourInCup() {
        System.out.println("将饮料倒入杯子中");
    }


}
