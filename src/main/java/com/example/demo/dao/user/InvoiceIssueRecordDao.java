package com.example.demo.dao.user;

import com.example.demo.dao.user.sql.InvoiceIssueRecordDaoSql;
import com.example.demo.domain.InvoiceIssueRecordDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author wan yu
 * @date 2022/3/24 下午3:20
 */
@Mapper
public interface InvoiceIssueRecordDao {

    @Select("SELECT * from `invoice_issue_record`  where request_no = #{requestNo} for update ")
    List<InvoiceIssueRecordDO> getRecordByRequestNo(@Param("requestNo") String requestNo);

    @UpdateProvider(type = InvoiceIssueRecordDaoSql.class,method = "updateSql")
    int update(InvoiceIssueRecordDO recordDO);

    @Select("SELECT * from `invoice_issue_record`  where request_no = #{requestNo} and invoice_no =#{invoiceNo} ")
    InvoiceIssueRecordDO getRecordByRequestNoAndInvoiceNo(@Param("requestNo") String requestNo, @Param("invoiceNo") String invoiceNo);

    @UpdateProvider(type = InvoiceIssueRecordDaoSql.class,method = "updateByRequestNoSql")
    int updateByRequestNoAndInvoiceId(InvoiceIssueRecordDO recordDO);
}
