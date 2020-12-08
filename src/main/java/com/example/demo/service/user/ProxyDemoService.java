package com.example.demo.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mayongbo
 * @Description
 * @date 2020/11/13 15:15
 */
@Service
public class ProxyDemoService {

    @Transactional
    public void doNeedTx() {
        String result = this.toString();
        System.out.println("+++++++++++++++"+result);
    }

    public void doNotneedTx() {
        String result = this.toString();
        System.out.println("+++++++++++++++"+result);
    }
}
