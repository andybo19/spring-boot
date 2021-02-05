package com.example.demo.pipeline;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/5 11:37
 */
public class PipeLineMain {

    public static void main(String[] args) {
        MyPipeline pipeline=new MyPipeline();
        pipeline.addFirst(new TestHandler2());//添加handler1
        pipeline.addFirst(new TestHandler1());//添加handler2
        for(int i=0;i<10;i++){//提交多个任务
            pipeline.Request("hello"+i);
        }
    }

}
