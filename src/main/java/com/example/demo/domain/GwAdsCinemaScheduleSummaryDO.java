package com.example.demo.domain;



import java.util.List;

/**
 * @author daoquan.ldq
 * @date 2019年04月23日 13:54
 */
public class GwAdsCinemaScheduleSummaryDO extends BaseDO {
    private static final long serialVersionUID = -1988739072868737275L;

    /**
     * 影院ID gw_ads_schedule_rt.cinema_id
     */
    private Long cinemaId;

    /**
     * 影片ID gw_ads_schedule_rt.show_id
     */
    private Long showId;


    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 票仓编码
     */
    private Long cityLevel;

    /**
     * 影院影片维度影厅数
     */
    private Integer hallCnt;

    /**
     * 影院总影厅数
     */
    private Integer totalHallCnt;

    /**
     * 影院影片维度影厅座位数 gw_ads_schedule_rt.hall_seat_cnt
     */
    private Long hallSeatCnt;

    /**
     * 影厅已售座位数 gw_ads_schedule_rt.sold_seat_cnt
     */
    private Long soldSeatCnt;

    /**
     * 排期数 gw_ads_schedule_rt.count(1)
     */
    private Integer scheduleCnt;

    /**
     * 影厅票房 gw_ads_schedule_rt.avg_ticket_price * gw_ads_schedule_rt.sold_seat_cnt <br/>
     * <p>
     * 由于算法只能拿到座位图里的已售座位数，但并不知道具体的售票金额，因此只能根据场次给出一个预估的平均售价用于计算票房
     */
    private Long boxOffice;

    private Long totalHallSeatCnt;

    private Long totalSoldSeatCnt;

    private Integer totalScheduleCnt;

    private Long totalBoxOffice;

    /**
     * 影院预估排场数 gw_ads_cinema_schedule_fcst.scd_cnt_fcst
     */
    private Integer predictScheduleCnt;

    private GwAdsCinemaScheduleSummaryDO compareData;
    private List<GwAdsCinemaScheduleSummaryDO> compareDataList;

    /**
     * 影院总票房
     */
    private Long cinemaTotalBoxOffice;

    /**
     * 影院总人次
     */
    private Long cinemaTotalSoldSeatCount;
    /**
     * 影院的座位数
     */
    private Integer cinemaSeatCount;


    /**
     * 影院信息
     */
    private Double attractiveness;
    private Long standardId;
    private String cinemaName;
    private String provinceName;
    private String cityName;
    private Long merchantCode;
    private String companyCode;
    private String merchantName;
    private String companyName;
    private String cinemaAddress;
    private Integer cinemaHallCount;
    private Integer seatCount;

    /**
     * 影院影片黄金场票房
     */
    private Long primeBoxOffice;

    /**
     * 影院影片黄金场场次
     */
    private Long primeScheduleCnt;

    /**
     * 影院影片黄金场人次
     */
    private Long primeSoldSeatCnt;

    /**
     * 影院黄金场票房
     */
    private Long primeTotalBoxOffice;

    /**
     * 影院黄金场场次
     */
    private Long primeTotalScheduleCnt;

    /**
     * 影院黄金场人次
     */
    private Long primeTotalSoldSeatCnt;

    /**
     * 营业天数
     */
    private Integer businessDays;

    /**
     * 营业影厅数
     */
    private Long businessDayHallCount;


    public Integer getBusinessDays() {
        return businessDays;
    }

    public void setBusinessDays(Integer businessDays) {
        this.businessDays = businessDays;
    }

    public Long getBusinessDayHallCount() {
        return businessDayHallCount;
    }

    public void setBusinessDayHallCount(Long businessDayHallCount) {
        this.businessDayHallCount = businessDayHallCount;
    }


    public Integer getCinemaHallCount() {
        return cinemaHallCount;
    }

    public void setCinemaHallCount(Integer cinemaHallCount) {
        this.cinemaHallCount = cinemaHallCount;
    }

    public Double getAttractiveness() {
        return attractiveness;
    }

    public void setAttractiveness(Double attractiveness) {
        this.attractiveness = attractiveness;
    }

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }


    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public List<GwAdsCinemaScheduleSummaryDO> getCompareDataList() {
        return compareDataList;
    }

    public void setCompareDataList(
            List<GwAdsCinemaScheduleSummaryDO> compareDataList) {
        this.compareDataList = compareDataList;
    }

    public Integer getCinemaSeatCount() {
        return cinemaSeatCount;
    }

    public void setCinemaSeatCount(Integer cinemaSeatCount) {
        this.cinemaSeatCount = cinemaSeatCount;
    }


    public Long getCinemaTotalBoxOffice() {
        return cinemaTotalBoxOffice;
    }

    public void setCinemaTotalBoxOffice(Long cinemaTotalBoxOffice) {
        this.cinemaTotalBoxOffice = cinemaTotalBoxOffice;
    }

    public Long getCinemaTotalSoldSeatCount() {
        return cinemaTotalSoldSeatCount;
    }

    public void setCinemaTotalSoldSeatCount(Long cinemaTotalSoldSeatCount) {
        this.cinemaTotalSoldSeatCount = cinemaTotalSoldSeatCount;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long id) {
        this.cinemaId = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(Long merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(Long cityLevel) {
        this.cityLevel = cityLevel;
    }

    public Integer getHallCnt() {
        return hallCnt;
    }

    public void setHallCnt(Integer hallCnt) {
        this.hallCnt = hallCnt;
    }

    public Long getHallSeatCnt() {
        return hallSeatCnt;
    }

    public Integer getTotalHallCnt() {
        return totalHallCnt;
    }

    public void setTotalHallCnt(Integer totalHallCnt) {
        this.totalHallCnt = totalHallCnt;
    }

    public void setHallSeatCnt(Long hallSeatCnt) {
        this.hallSeatCnt = hallSeatCnt;
    }

    public Long getSoldSeatCnt() {
        return soldSeatCnt;
    }

    public void setSoldSeatCnt(Long soldSeatCnt) {
        this.soldSeatCnt = soldSeatCnt;
    }

    public Integer getScheduleCnt() {
        return scheduleCnt;
    }

    public void setScheduleCnt(Integer scheduleCnt) {
        this.scheduleCnt = scheduleCnt;
    }

    public Long getTotalHallSeatCnt() {
        return totalHallSeatCnt;
    }

    public void setTotalHallSeatCnt(Long totalHallSeatCnt) {
        this.totalHallSeatCnt = totalHallSeatCnt;
    }

    public Long getTotalSoldSeatCnt() {
        return totalSoldSeatCnt;
    }

    public void setTotalSoldSeatCnt(Long totalSoldSeatCnt) {
        this.totalSoldSeatCnt = totalSoldSeatCnt;
    }

    public Integer getTotalScheduleCnt() {
        return totalScheduleCnt;
    }

    public void setTotalScheduleCnt(Integer totalScheduleCnt) {
        this.totalScheduleCnt = totalScheduleCnt;
    }

    public Long getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(Long boxOffice) {
        this.boxOffice = boxOffice;
    }

    public Long getTotalBoxOffice() {
        return totalBoxOffice;
    }

    public void setTotalBoxOffice(Long totalBoxOffice) {
        this.totalBoxOffice = totalBoxOffice;
    }

    public Integer getPredictScheduleCnt() {
        return predictScheduleCnt;
    }

    public void setPredictScheduleCnt(Integer predictScheduleCnt) {
        this.predictScheduleCnt = predictScheduleCnt;
    }

    public GwAdsCinemaScheduleSummaryDO getCompareData() {
        return compareData;
    }

    public void setCompareData(GwAdsCinemaScheduleSummaryDO compareData) {
        this.compareData = compareData;
    }

    public Long getPrimeBoxOffice() {
        return primeBoxOffice;
    }

    public void setPrimeBoxOffice(Long primeBoxOffice) {
        this.primeBoxOffice = primeBoxOffice;
    }

    public Long getPrimeScheduleCnt() {
        return primeScheduleCnt;
    }

    public void setPrimeScheduleCnt(Long primeScheduleCnt) {
        this.primeScheduleCnt = primeScheduleCnt;
    }

    public Long getPrimeSoldSeatCnt() {
        return primeSoldSeatCnt;
    }

    public void setPrimeSoldSeatCnt(Long primeSoldSeatCnt) {
        this.primeSoldSeatCnt = primeSoldSeatCnt;
    }

    public Long getPrimeTotalBoxOffice() {
        return primeTotalBoxOffice;
    }

    public void setPrimeTotalBoxOffice(Long primeTotalBoxOffice) {
        this.primeTotalBoxOffice = primeTotalBoxOffice;
    }

    public Long getPrimeTotalScheduleCnt() {
        return primeTotalScheduleCnt;
    }

    public void setPrimeTotalScheduleCnt(Long primeTotalScheduleCnt) {
        this.primeTotalScheduleCnt = primeTotalScheduleCnt;
    }

    public Long getPrimeTotalSoldSeatCnt() {
        return primeTotalSoldSeatCnt;
    }

    public void setPrimeTotalSoldSeatCnt(Long primeTotalSoldSeatCnt) {
        this.primeTotalSoldSeatCnt = primeTotalSoldSeatCnt;
    }
}
