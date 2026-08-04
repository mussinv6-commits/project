package com.mbc.project.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StoreDiscountDto implements Serializable{
    private Long discountId;         // 할인 기록 ID (PK)
    private Long recordId;           // 주차 기록 ID (FK)
    private Integer storeNum;        // 할인 등록 점포 번호 (FK)
    private Integer freeMin;         // 할인 제공 시간 (분)
    private LocalDateTime createdAt; // 할인 등록 시간

    public StoreDiscountDto() {}

	public StoreDiscountDto(Long discountId, Long recordId, Integer storeNum, Integer freeMin,
			LocalDateTime createdAt) {
		super();
		this.discountId = discountId;
		this.recordId = recordId;
		this.storeNum = storeNum;
		this.freeMin = freeMin;
		this.createdAt = createdAt;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Integer getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}

	public Integer getFreeMin() {
		return freeMin;
	}

	public void setFreeMin(Integer freeMin) {
		this.freeMin = freeMin;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
}


