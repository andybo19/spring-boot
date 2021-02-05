package com.example.demo.pipeline;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/5 11:28
 */
public interface Handler {
    void channelRead(HandlerContext ctx, Object msg);
}
