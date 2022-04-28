package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author wan yu
 * @date 2022/3/24 下午3:19
 */
@Data
public class InvoiceIssueRecordDO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 灯塔发票编号
     */
    private String requestNo;

    /**
     * 税协发票id
     */
    private Long invoiceId;

    /**
     * 税协发票编码
     */
    private String invoiceCode;

    /**
     * 发票号
     */
    private String invoiceNo;

    /**
     * 发票材质 0:纸质 1:电子 2:形式发票
     */
    private Integer invoiceMaterial;

    /**
     * 发票类型 0:营业税 1:普通发票 2:专用发票 3:形式发票 4:收款凭据
     */
    private Integer invoiceClass;

    /**
     * 0:开具中 1:开具成功 2:发票退回 3:发票冲红 4:发票作废 5:发票寄送 6:退票申请驳回
     */
    private Integer status;

    /**
     * oss文件名，电子票专属
     */
    private String fileName;

    /**
     * 物流单号，纸质票专属
     */
    private String trackingNumber;

    /**
     * 重开发票对应的蓝票发票号
     */
    private String originalInvoiceNo;

}
