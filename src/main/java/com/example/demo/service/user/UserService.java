package com.example.demo.service.user;

import com.example.demo.dao.user.UserDao;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;

    public Integer update(User user){
        int i = userDao.update(user);
        return i;
    }

    @Override
    @Transactional
    public Integer insert(User user){
        int i = userDao.insert(user);
        //System.out.println(1/0);
        return i;
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    @Transactional
    public void doNeedTx() {
        String result = this.toString();
        System.out.println("+++++++++++++++"+result);
    }

    @Override
    public void doNotneedTx() {
        String result = this.toString();
        System.out.println("+++++++++++++++"+result);
    }
}
