package com.mbc.project.dto;

import java.io.Serializable;

public class FeePolicyDto implements Serializable{
	private Integer policyId;      // 정책 ID (PK)
    private Integer baseTime;      // 기본 시간 (분)
    private Integer baseFee;       // 기본 요금 (원)
    private Integer extraTime;     // 추가 단위 시간 (분)
    private Integer extraFee;      // 추가 단위 요금 (원)
    private Integer dailyMax;      // 일일 최대 요금 (원)
    private Integer gracePeriod;   // 무료 회차 시간 (분)

    public FeePolicyDto() {}

    public FeePolicyDto(Integer policyId, Integer baseTime, Integer baseFee, Integer extraTime, Integer extraFee, Integer dailyMax, Integer gracePeriod) {
        this.policyId = policyId;
        this.baseTime = baseTime;
        this.baseFee = baseFee;
        this.extraTime = extraTime;
        this.extraFee = extraFee;
        this.dailyMax = dailyMax;
        this.gracePeriod = gracePeriod;
    }

    public Integer getPolicyId() { return policyId; }
    public void setPolicyId(Integer policyId) { this.policyId = policyId; }

    public Integer getBaseTime() { return baseTime; }
    public void setBaseTime(Integer baseTime) { this.baseTime = baseTime; }

    public Integer getBaseFee() { return baseFee; }
    public void setBaseFee(Integer baseFee) { this.baseFee = baseFee; }

    public Integer getExtraTime() { return extraTime; }
    public void setExtraTime(Integer extraTime) { this.extraTime = extraTime; }

    public Integer getExtraFee() { return extraFee; }
    public void setExtraFee(Integer extraFee) { this.extraFee = extraFee; }

    public Integer getDailyMax() { return dailyMax; }
    public void setDailyMax(Integer dailyMax) { this.dailyMax = dailyMax; }

    public Integer getGracePeriod() { return gracePeriod; }
    public void setGracePeriod(Integer gracePeriod) { this.gracePeriod = gracePeriod; }
}

