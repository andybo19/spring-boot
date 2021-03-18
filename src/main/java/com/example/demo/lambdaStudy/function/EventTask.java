package com.example.demo.lambdaStudy.function;

/**
 * 最小任务单元
 */
@FunctionalInterface
public interface EventTask<R> {

    R call() throws Exception;
}
