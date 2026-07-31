package com.mbc.project.dto;

import java.io.Serializable;

public class StoresDto implements Serializable{
	private Integer storeNum;   // 점포 고유 ID (PK)
    private String storeName;   // 상호명/점포명
    private Integer floor;      // 위치 층수
    private String contact;     // 점포 연락처
    
    public StoresDto() {}

    public StoresDto(Integer storeNum, String storeName, Integer floor, String contact) {
        this.storeNum = storeNum;
        this.storeName = storeName;
        this.floor = floor;
        this.contact = contact;

    }

    public Integer getStoreNum() { return storeNum; }
    public void setStoreNum(Integer storeNum) { this.storeNum = storeNum; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }


}
