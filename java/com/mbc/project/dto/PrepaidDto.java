package com.mbc.project.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PrepaidDto implements Serializable{
    private Integer regId;        // 정기권 등록 고유 ID (PK)
    private String carNum;        // 정기 등록 차량 번호
    private String ownerName;     // 소유자 이름 또는 매장명
    private LocalDate startDate;  // 정기권 시작 날짜
    private LocalDate endDate;    // 정기권 만료 날짜
    private String type;          // 구분 (STORE_OWNER, MONTHLY 등)

    public PrepaidDto() {}

    public PrepaidDto(Integer regId, String carNum, String ownerName, LocalDate startDate, LocalDate endDate, String type) {
        this.regId = regId;
        this.carNum = carNum;
        this.ownerName = ownerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public Integer getRegId() { return regId; }
    public void setRegId(Integer regId) { this.regId = regId; }

    public String getCarNum() { return carNum; }
    public void setCarNum(String carNum) { this.carNum = carNum; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}