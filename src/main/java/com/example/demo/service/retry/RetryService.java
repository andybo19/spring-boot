package com.example.demo.service.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author wan yu
 * @date 2022/1/26 下午4:45
 */
@Service
@Slf4j
public class RetryService {

    @Retryable
    public void callChannel() throws Exception {
        queryOrder();
    }

    @Recover
    public void channelNotResp() throws Exception {
        log.info("没有获取到渠道的返回信息,发送预警!");
    }

    private void queryOrder() throws Exception {
        throw new RuntimeException("调用订单接口超时异常啦");
    }
}
