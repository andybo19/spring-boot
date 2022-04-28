package com.example.demo;

import com.example.demo.dao.user.DictDao;
import com.example.demo.dao.user.GoodsDao;
import com.example.demo.dao.user.UserDao;
import com.example.demo.designpatterns.strategy.Strategy;
import com.example.demo.designpatterns.strategy.StrategyContext;
import com.example.demo.domain.Goods;
import com.example.demo.domain.MyDict;
import com.example.demo.domain.User;
import com.example.demo.enums.SnapshotTaskEnum;
import com.example.demo.service.user.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/7 15:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcdemoApplicationTests {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DictDao dictDao;

    @Autowired
    private IUserService userService;

    @Test
    public void addGoods() {
        Goods good = new Goods();
        good.setGname("小米手机");
        good.setUuId(100L);
        good.setGstatus(1);
        goodsDao.insert(good);
    }

    @Test
    public  void batchAddGoods() {
        for (int i = 0; i < 10; i++) {
            Goods good = new Goods();
            good.setGname("小米手机" + i);
            good.setUuId(100L);
            good.setGstatus(1);
            goodsDao.insert(good);
        }
    }

    @Test
    public void getGoods() {
        Goods goods = goodsDao.getById(542789059680927744L,101L);
        System.out.println("+++++++++++++++"+goods);
        Goods goods1 = goodsDao.getByUuId(101L);
        System.out.println("+++++++++++++++"+goods1);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("mayongbo");
        user.setMobileNumber("15136456879");
        user.setAge("29");
        userDao.insert(user);
    }

    @Test
    public void addDict() {
        MyDict dict = new MyDict();
        dict.setDictName("andy");
        dict.setDictCode("101");
        dictDao.insert(dict);
    }

    @Test
    public void deleteDict() {
        int delete = dictDao.deleteByDictId(543078360285184001L);
        System.out.println("++++++++++++++++"+delete);
    }

    @Test
    public void getDict() {
        MyDict dict = dictDao.getByDictId(543080087650566145L);
        System.out.println("++++++++++++++++"+dict);
    }

    @Test
    public void getUser() {
        User user = userDao.findByMobile("15136456879");
        System.out.println("+++++++++++++++"+user);
    }

    @Test
    public void testStrategy(){
        Strategy strategy = StrategyContext.getStrategy(SnapshotTaskEnum.WAIMAI.name());
        strategy.issue(new Object());
    }


}
