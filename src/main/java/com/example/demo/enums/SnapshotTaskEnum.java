package com.example.demo.enums;

/**
 * @author wan yu
 * @date 2022/4/25 下午4:11
 */
public enum SnapshotTaskEnum {

    /**
     * 影投
     */
    COMPANY("company", "影投"),
    WAIMAI("waimai", "外卖"),
    ;

    private String beanName;

    private String desc;

    SnapshotTaskEnum(String beanName, String desc){
        this.beanName = beanName;
        this.desc = desc;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
