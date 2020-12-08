package com.example.demo.netty.httpserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;

/**
 * @author mayongbo
 * @Description
 * @date 2020/11/26 10:45
 */
public class HttpClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
            System.out.println("+++++++++++++++++++++++接收返回结果开始");
            System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
            System.out.println("+++++++++++++++++++++++接收返回结果结束");
            buf.release();
        }
    }
}
