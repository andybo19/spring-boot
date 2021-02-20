package com.example.demo.page;

import org.apache.ibatis.session.RowBounds;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/20 16:02
 */
public class PageBounds extends RowBounds {

    /**
     * PageBounds构造方法
     *
     * @param index 第几页 从1开始
     * @param size 每页数据大小
     */
    private PageBounds(int index, int size) {
        super(index, size);
    }

    public int getIndex() {
        return super.getOffset();
    }

    public int getSize() {
        return super.getLimit();
    }

    /**
     * PageBounds静态包装方法
     *
     * @param index 第几页 从1开始
     * @param size 每页数据大小
     * @return
     */
    public static PageBounds wrap(int index, int size) {
        if (index < 1) {
            index = 1;
        }
        if (size < 1) {
            size = 10;
        }
        return new PageBounds(index, size);
    }

    /**
     * PageBounds静态包装方法
     *
     * @param index 第几页 从1开始
     * @param size 每页数据大小
     * @return
     */
    public static PageBounds page(int index, int size) {
        return wrap(index, size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[index=");
        builder.append(getIndex());
        builder.append(", size=");
        builder.append(getSize());
        builder.append("]");
        return builder.toString();
    }

}
