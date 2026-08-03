package com.mbc.project.dto;

import java.io.Serializable;

public class FloorDto implements Serializable{
    private Integer floor;               // 층수 (PK)
    private Integer generalCapacity;     // 일반석 총면수
    private Integer generalCount;        // 일반석 사용수
    private Integer evCapacity;          // 전기차 총면수
    private Integer evCount;             // 전기차 사용수
    private Integer disabledCapacity;    // 장애인석 총면수
    private Integer disabledCount;       // 장애인석 사용수
    private Integer pregnantCapacity;    // 임산부석 총면수
    private Integer pregnantCount;       // 임산부석 사용수

    public FloorDto() {}

    public FloorDto(Integer floor, Integer generalCapacity, Integer generalCount, Integer evCapacity, Integer evCount, Integer disabledCapacity, Integer disabledCount, Integer pregnantCapacity, Integer pregnantCount) {
        this.floor = floor;
        this.generalCapacity = generalCapacity;
        this.generalCount = generalCount;
        this.evCapacity = evCapacity;
        this.evCount = evCount;
        this.disabledCapacity = disabledCapacity;
        this.disabledCount = disabledCount;
        this.pregnantCapacity = pregnantCapacity;
        this.pregnantCount = pregnantCount;
    }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public Integer getGeneralCapacity() { return generalCapacity; }
    public void setGeneralCapacity(Integer generalCapacity) { this.generalCapacity = generalCapacity; }

    public Integer getGeneralCount() { return generalCount; }
    public void setGeneralCount(Integer generalCount) { this.generalCount = generalCount; }

    public Integer getEvCapacity() { return evCapacity; }
    public void setEvCapacity(Integer evCapacity) { this.evCapacity = evCapacity; }

    public Integer getEvCount() { return evCount; }
    public void setEvCount(Integer evCount) { this.evCount = evCount; }

    public Integer getDisabledCapacity() { return disabledCapacity; }
    public void setDisabledCapacity(Integer disabledCapacity) { this.disabledCapacity = disabledCapacity; }

    public Integer getDisabledCount() { return disabledCount; }
    public void setDisabledCount(Integer disabledCount) { this.disabledCount = disabledCount; }

    public Integer getPregnantCapacity() { return pregnantCapacity; }
    public void setPregnantCapacity(Integer pregnantCapacity) { this.pregnantCapacity = pregnantCapacity; }

    public Integer getPregnantCount() { return pregnantCount; }
    public void setPregnantCount(Integer pregnantCount) { this.pregnantCount = pregnantCount; }
}