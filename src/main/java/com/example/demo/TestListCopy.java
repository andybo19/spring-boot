package com.example.demo;

import com.example.demo.util.TestListNode;

import java.io.Serializable;
import java.util.List;

/**
 * @author wan yu
 * @date 2022/12/15 下午6:51
 */
public class TestListCopy implements Serializable {

    List<TestListNode> list;

    public List<TestListNode> getList() {
        return list;
    }

    public void setList(List<TestListNode> list) {
        this.list = list;
    }
}
