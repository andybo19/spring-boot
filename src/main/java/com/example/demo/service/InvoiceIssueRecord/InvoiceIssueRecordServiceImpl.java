package com.example.demo.service.InvoiceIssueRecord;

import com.example.demo.dao.user.InvoiceIssueRecordDao;
import com.example.demo.domain.InvoiceIssueRecordDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author wan yu
 * @date 2022/3/24 下午3:40
 */
@Service
public class InvoiceIssueRecordServiceImpl implements IInvoiceIssueRecordService{

    @Autowired
    private InvoiceIssueRecordDao invoiceIssueRecordDao;

    @Transactional
    @Override
    public List<InvoiceIssueRecordDO> getRecordByRequestNo(String requestNo) {
        List<InvoiceIssueRecordDO> invoiceIssueRecordDOS = invoiceIssueRecordDao.getRecordByRequestNo(requestNo);
        InvoiceIssueRecordDO recordDO = invoiceIssueRecordDOS.get(0);
        recordDO.setStatus(6);
        int result = invoiceIssueRecordDao.updateByRequestNoAndInvoiceId(recordDO);
        return invoiceIssueRecordDOS;
    }

    @Transactional
    @Override
    public int updateById(InvoiceIssueRecordDO record) {
        record = invoiceIssueRecordDao.getRecordByRequestNoAndInvoiceNo("12345678923", "16012296");
        record.setGmtModified(new Date());
        record.setStatus(9);
        return invoiceIssueRecordDao.update(record);
    }
}
