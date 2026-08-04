package com.mbc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.project.dao.ParkingRecordDao;
import com.mbc.project.dao.StoreDiscountDao;
import com.mbc.project.dto.ParkingRecordDto;
import com.mbc.project.dto.StoreDiscountDto;



@Service
public class StoreDiscountService {

    @Autowired
    private StoreDiscountDao storeDiscountDao;

    @Autowired
    private ParkingRecordDao parkingRecordDao;

    // (참고) 요금 정책을 DB에서 조회해오는 DAO가 있다고 가정합니다.
    // @Autowired
    // private FeePolicyDao feePolicyDao; 

    /**
     * [C] 할인 등록 + 동적 요금 정책 수식 적용
     */
    @Transactional
    public int insertStoreDiscount(StoreDiscountDto dto) {
        int result = storeDiscountDao.insertStoreDiscount(dto);
        if (result > 0) {
            calculateAndUpdateParkingFee(dto.getRecordId());
        }
        return result;
    }

    /**
     * [D] 할인 취소 + 동적 요금 정책 수식 적용
     */
    @Transactional
    public int deleteStoreDiscount(Long discountId, Long recordId) {
        int result = storeDiscountDao.deleteStoreDiscount(discountId);
        if (result > 0) {
            calculateAndUpdateParkingFee(recordId);
        }
        return result;
    }

    /**
     * 🧮 [핵심 정산 수식] fee_policies 테이블의 규칙에 맞춰 금액을 계산
     */
    private void calculateAndUpdateParkingFee(Long recordId) {
        // 1. 주차 기록 정보 조회
        ParkingRecordDto parkingDto = parkingRecordDao.findByRecordId(recordId);
        if (parkingDto == null || parkingDto.getTotalMin() == null) return;

        // 2. 현재 적용 중인 최신 요금 정책 정보를 DB에서 조회 (가상의 데이터셋으로 대체 표현)
        // FeePolicyDto policy = feePolicyDao.getLatestPolicy();
        // 아래 변수들은 제공해주신 fee_policies 테이블의 컬럼 값들입니다.
        int baseTime = 30;       // 기본 시간 (분)
        int baseFee = 2000;      // 기본 요금 (원)
        int extraTime = 10;      // 추가 단위 시간 (분)
        int extraFee = 1000;     // 추가 단위 요금 (원)
        int dailyMax = 30000;     // 일일 최대 요금 (원)
        int gracePeriod = 15;    // 무료 회차 시간 (분)

        // 3. 수식 연산 시작
        int totalMin = parkingDto.getTotalMin(); // 이 차량이 주차한 총 시간(분)
        int rawFee = 0;                          // 정산 전 원금 요금
        int discountFee = 0;                     // 할인 금액
        int finalFee = 0;                        // 최종 결제 금액

        // [수식 ①] 회차 시간 미만이면 0원 처리
        if (totalMin <= gracePeriod) {
            parkingDto.setRawFee(0);
            parkingDto.setDiscountFee(0);
            parkingDto.setFinalFee(0);
            parkingRecordDao.exitparking(parkingDto);
            return;
        }

        // [수식 ②] 원금 요금(rawFee) 계산 (할인 전 순수 주차 시간에 대한 요금)
        if (totalMin <= baseTime) {
            rawFee = baseFee;
        } else {
            int overTime = totalMin - baseTime;
            // 올림 계산 처리를 통해 1분만 초과해도 추가 단위 요금 부과
            int extraBlocks = (int) Math.ceil((double) overTime / extraTime);
            rawFee = baseFee + (extraBlocks * extraFee);
        }
        // 일일 최대 요금 적용
        if (rawFee > dailyMax) {
            rawFee = dailyMax;
        }

        // [수식 ③] 할인 적용 후 최종 요금(finalFee) 계산
        // 이 차량이 매장들로부터 받은 총 무료 주차 시간 합산
        int totalFreeMin = storeDiscountDao.selectTotalFreeMinByRecordId(recordId);
        
        // 실제 요금 부과 대상 시간 = 총 주차 시간 - 무료 할인 시간
        int chargeableTime = totalMin - totalFreeMin;

        if (chargeableTime <= gracePeriod) {
            finalFee = 0;
        } else if (chargeableTime <= baseTime) {
            finalFee = baseFee;
        } else {
            int overTime = chargeableTime - baseTime;
            int extraBlocks = (int) Math.ceil((double) overTime / extraTime);
            finalFee = baseFee + (extraBlocks * extraFee);
        }

        if (finalFee > dailyMax) {
            finalFee = dailyMax;
        }
        if (finalFee < 0) {
            finalFee = 0;
        }

        // [수식 ④] 할인 금액 = 원금 요금 - 최종 요금
        discountFee = rawFee - finalFee;

        // 4. 계산 결과 DB 업데이트 반영
        parkingDto.setRawFee(rawFee);
        parkingDto.setDiscountFee(discountFee);
        parkingDto.setFinalFee(finalFee);
        
        parkingRecordDao.exitparking(parkingDto);
    }

    // 기본 조회 메서드 생략...
}