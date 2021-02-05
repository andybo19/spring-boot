package com.example.demo.pipeline;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/5 11:30
 */
public class MyPipeline {

    private HandlerContext head;//链表头
    private HandlerContext tail;//链表尾，如果是一个双向链表，这个成员将会被用到，netty就使用的双向链表，因为是全双工的。
    public void addFirst(Handler handler){//这里仅仅实现了一个简单的插入操作，即在链表的头部出入一个handler。
        HandlerContext ctx=new HandlerContext(handler);
        HandlerContext tmp=head;
        head=ctx;
        head.setNext(tmp);
    }
    public MyPipeline(){
        head=tail=new HeadContext(new HeadHandler());
    }
    public void Request(Object msg){//封装了外部调用接口
        head.doWork(msg);
    }
    final class HeadContext extends HandlerContext{//这是一个内部类，为默认handler的context
        public HeadContext(Handler handler) {
            super(handler);
        }
    }
    final class HeadHandler implements Handler{//这是一个内部类，是pipeline的默认处理handler。
        @Override
        public void channelRead(HandlerContext ctx, Object msg) {
            String result=(String)msg+"end";
            System.out.println(result);
        }
    }

}
