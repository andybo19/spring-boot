package com.example.demo.dao.user.sql;

import com.example.demo.domain.InvoiceIssueRecordDO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class InvoiceIssueRecordDaoSql {

    public String updateSql(final InvoiceIssueRecordDO recordDO){
        return new SQL(){

            {
                UPDATE("invoice_issue_record");

                SET("gmt_modified = now()");
                if(recordDO.getStatus() != null){
                    SET("status = #{status}");
                }

                if(recordDO.getInvoiceId() != null){
                    SET("invoice_id = #{invoiceId}");
                }

                if(StringUtils.isNotBlank(recordDO.getInvoiceCode())){
                    SET("invoice_code = #{invoiceCode}");
                }

                if(StringUtils.isNotBlank(recordDO.getInvoiceNo())){
                    SET("invoice_no = #{invoiceNo}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String updateByRequestNoSql(final InvoiceIssueRecordDO recordDO){
        return new SQL(){

            {
                UPDATE("invoice_issue_record");

                SET("gmt_modified = now()");
                if(recordDO.getStatus() != null){
                    SET("status = #{status}");
                }

                if(recordDO.getInvoiceId() != null){
                    SET("invoice_id = #{invoiceId}");
                }

                if(StringUtils.isNotBlank(recordDO.getInvoiceCode())){
                    SET("invoice_code = #{invoiceCode}");
                }

                if(StringUtils.isNotBlank(recordDO.getInvoiceNo())){
                    SET("invoice_no = #{invoiceNo}");
                }
                WHERE("request_no = #{requestNo} and invoice_id = #{invoiceId}");
            }
        }.toString();
    }
}
