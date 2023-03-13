package com.example.demo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author wan yu
 * @date 2023/1/5 下午3:46
 */
public class BaseDO implements Serializable {
    private static final long serialVersionUID = -839116540502696663L;

    public BaseDO() {
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
