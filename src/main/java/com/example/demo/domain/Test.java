package com.example.demo.domain;

import org.apache.lucene.util.RamUsageEstimator;

public class Test {
    public static void main(String[] args) {
        GwAdsCinemaScheduleSummaryDO summaryDO = new GwAdsCinemaScheduleSummaryDO();
        summaryDO.setCinemaId(20086L);
        summaryDO.setShowId(130483L);
        summaryDO.setCityId(1039L);
        summaryDO.setCityLevel(-4L);
        summaryDO.setHallCnt(5);
        summaryDO.setTotalHallCnt(5);
        summaryDO.setSoldSeatCnt(150L);
        summaryDO.setScheduleCnt(19);

        summaryDO.setBoxOffice(663064L);
        summaryDO.setTotalHallSeatCnt(2592L);
        summaryDO.setTotalSoldSeatCnt(153L);
        summaryDO.setTotalScheduleCnt(22);
        summaryDO.setTotalBoxOffice(673864L);
        summaryDO.setPredictScheduleCnt(28);
        summaryDO.setAttractiveness(22.9D);
        summaryDO.setStandardId(33082101L);

        summaryDO.setCinemaName("丽水云和横店电影城");
        summaryDO.setProvinceName("浙江省");
        summaryDO.setCityName("丽水");
        summaryDO.setMerchantCode(1010L);
        summaryDO.setCompanyCode("1010");
        summaryDO.setMerchantName("横店影视股份有限公司");
        summaryDO.setCompanyName("横店");
        summaryDO.setCinemaAddress("山水购物广场3层");

        summaryDO.setCinemaHallCount(5);
        summaryDO.setSeatCount(593);
        summaryDO.setPrimeBoxOffice(452821L);
        summaryDO.setPrimeScheduleCnt(4L);
        summaryDO.setPrimeSoldSeatCnt(89L);
        summaryDO.setPrimeTotalBoxOffice(452821L);
        summaryDO.setPrimeTotalScheduleCnt(4L);
        summaryDO.setPrimeTotalSoldSeatCnt(89L);


        summaryDO.setBusinessDays(1);
        summaryDO.setBusinessDayHallCount(5L);

        System.out.println("summaryDO value is " + RamUsageEstimator.sizeOf(summaryDO));
        System.out.println("summaryDO value is " + RamUsageEstimator.humanSizeOf(summaryDO));

        System.out.println(Long.MAX_VALUE);


    }
}
