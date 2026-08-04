package com.mbc.project.dao;

import com.mbc.project.dto.StoreDiscountDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StoreDiscountDao {

    // [C] 새로운 할인 기록 추가 (서비스가 필요할 때 호출)
    int insertStoreDiscount(StoreDiscountDto dto);

    // [R] 관리자 화면용: 시스템 전체 할인 기록 리스트 조회
    List<StoreDiscountDto> selectAllDiscounts();

    // [R] 정산 서비스용: 특정 주차 기록(차량)에 누적된 할인 리스트 조회
    List<StoreDiscountDto> selectDiscountsByRecordId(Long recordId);

    // [R] 통계/조회용: 특정 점포가 등록한 할인 리스트 조회 (시간 될 때 차트 통계 추가)
    // List<StoreDiscountDto> selectDiscountsByStoreNum(Integer storeNum);

    // [R] 정산 서비스용: 특정 주차 기록의 총 무료 제공 시간(분) 합산 조회
    int selectTotalFreeMinByRecordId(Long recordId);

    // [D] 할인 취소용: 특정 할인 기록 삭제
    int deleteStoreDiscount(Long discountId);
}