package com.mbc.project.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ParkingRecordDto implements Serializable{
	private Long recordId;              // 입출차 기록 고유 ID (PK)
    private String carNum;              // 차량 번호
    private Integer parkingFloor;       // 주차 층수
    private LocalDateTime entryTime;    // 입차 시간
    private LocalDateTime exitTime;     // 출차 시간 (미출차 시 null)
    private Integer totalMin;           // 총 주차 시간 (분)
    private Integer rawFee;             // 정산 전 요금
    private Integer discountFee;        // 총 할인받은 금액
    private Integer finalFee;           // 최종 결제 금액
    private String parkingType;         // 주차구역 구분 (general, ev, disabled, pregnant)

    public ParkingRecordDto() {}

    public ParkingRecordDto(Long recordId, String carNum, Integer parkingFloor, LocalDateTime entryTime, LocalDateTime exitTime, Integer totalMin, Integer rawFee, Integer discountFee, Integer finalFee, String parkingType) {
        this.recordId = recordId;
        this.carNum = carNum;
        this.parkingFloor = parkingFloor;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.totalMin = totalMin;
        this.rawFee = rawFee;
        this.discountFee = discountFee;
        this.finalFee = finalFee;
        this.parkingType = parkingType;
    }

    public Long getRecordId() { return recordId; }
    public void setRecordId(Long recordId) { this.recordId = recordId; }

    public String getCarNum() { return carNum; }
    public void setCarNum(String carNum) { this.carNum = carNum; }

    public Integer getParkingFloor() { return parkingFloor; }
    public void setParkingFloor(Integer parkingFloor) { this.parkingFloor = parkingFloor; }

    public LocalDateTime getEntryTime() { return entryTime; }
    public void setEntryTime(LocalDateTime entryTime) { this.entryTime = entryTime; }

    public LocalDateTime getExitTime() { return exitTime; }
    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }

    public Integer getTotalMin() { return totalMin; }
    public void setTotalMin(Integer totalMin) { this.totalMin = totalMin; }

    public Integer getRawFee() { return rawFee; }
    public void setRawFee(Integer rawFee) { this.rawFee = rawFee; }

    public Integer getDiscountFee() { return discountFee; }
    public void setDiscountFee(Integer discountFee) { this.discountFee = discountFee; }

    public Integer getFinalFee() { return finalFee; }
    public void setFinalFee(Integer finalFee) { this.finalFee = finalFee; }

    public String getParkingType() { return parkingType; }
    public void setParkingType(String parkingType) { this.parkingType = parkingType; }
}
