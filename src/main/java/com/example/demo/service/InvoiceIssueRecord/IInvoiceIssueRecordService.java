package com.example.demo.service.InvoiceIssueRecord;

import com.example.demo.domain.InvoiceIssueRecordDO;

import java.util.List;

/**
 * @author wan yu
 * @date 2022/3/24 下午3:40
 */
public interface IInvoiceIssueRecordService {

    List<InvoiceIssueRecordDO>  getRecordByRequestNo(String requestNo);

    int updateById(InvoiceIssueRecordDO record);
}
