package com.example.demo.service.user;

import com.example.demo.dao.user.UserDao;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Integer update(User user){
        int i = userDao.update(user);
        return i;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insert(User user){
        int i = userDao.insert(user);
        try {
            System.out.println(1/0);
        }catch (Exception e){
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return i;
    }

}
