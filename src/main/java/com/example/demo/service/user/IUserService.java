package com.example.demo.service.user;

import com.example.demo.domain.User;

/**
 * @author mayongbo
 * @Description
 * @date 2020/11/13 14:44
 */
public interface IUserService {

    void doNeedTx();

    void doNotneedTx();

    Integer insert(User user);

}
