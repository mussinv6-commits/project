package com.mbc.project.controller;

import com.mbc.project.dto.StoreDiscountDto;
import com.mbc.project.service.StoreDiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class StoreDiscountController {

    private final StoreDiscountService service;

    public StoreDiscountController(StoreDiscountService service) {
        this.service = service;
    }

    /**
     * 1. [C] 새로운 할인 등록 
     * ➡️ 서비스의 리턴 타입이 'int'이므로, 그 숫자가 0보다 큰지 비교 처리합니다.
     */
    @PostMapping
    public ResponseEntity<String> createDiscount(@RequestBody StoreDiscountDto dto) {
        int result = service.insertStoreDiscount(dto); // 💡 int 수신
        if (result > 0) {
            return ResponseEntity.ok("할인이 등록되었습니다.");
        }
        return ResponseEntity.badRequest().body("할인 등록 실패");
    }

    /**
     * 2. [R] 관리자용: 시스템 전체 할인 기록 목록 조회
     * ➡️ 여러 줄의 목록이므로 서비스로부터 'List'를 넘겨받아 그대로 리턴합니다.
     */
    @GetMapping
    public ResponseEntity<List<StoreDiscountDto>> getAllDiscounts() {
        List<StoreDiscountDto> list = service.selectAllDiscounts(); // 💡 List 수신
        return ResponseEntity.ok(list);
    }

    /**
     * 3. [R] 특정 주차 기록(차량)에 누적된 할인 리스트 조회
     * ➡️ 여러 개의 할인 내역이 올 수 있으므로 'List' 구조를 취합니다.
     */
    @GetMapping("/record/{recordId}")
    public ResponseEntity<List<StoreDiscountDto>> getDiscountsByRecordId(@PathVariable("recordId") Long recordId) {
        List<StoreDiscountDto> list = service.selectDiscountsByRecordId(recordId); // 💡 List 수신
        return ResponseEntity.ok(list);
    }

    /**
     * 4. [R] 특정 점포가 등록한 할인 리스트 조회
     * ➡️ 매장이 준 할인 목록들을 한꺼번에 가져오므로 당연히 'List'가 맞습니다.
     */
    @GetMapping("/store/{storeNum}")
    public ResponseEntity<List<StoreDiscountDto>> getDiscountsByStoreNum(@PathVariable("storeNum") Integer storeNum) {
        List<StoreDiscountDto> list = service.selectDiscountsByStoreNum(storeNum); // 💡 List 수신
        return ResponseEntity.ok(list);
    }

    /**
     * 5. [R] 특정 주차 기록의 총 무료 제공 시간(분) 조회
     * ➡️ 총 합산된 "시간(분)" 데이터는 '60분', '120분' 처럼 숫자 단 하나이므로 'Integer(int)'를 씁니다.
     */
    @GetMapping("/record/{recordId}/total-minutes")
    public ResponseEntity<Integer> getTotalFreeMinByRecordId(@PathVariable("recordId") Long recordId) {
        int totalMinutes = service.selectTotalFreeMinByRecordId(recordId); // 💡 int 수신
        return ResponseEntity.ok(totalMinutes);
    }

    /**
     * 6. [D] 등록된 할인 취소/삭제
     * ➡️ 삭제 성공한 행의 개수가 오기 때문에 서비스로부터 'int'를 받습니다.
     */
    @DeleteMapping("/{discountId}/record/{recordId}")
    public ResponseEntity<String> cancelDiscount(
            @PathVariable("discountId") Long discountId,
            @PathVariable("recordId") Long recordId) {
        
        int result = service.deleteStoreDiscount(discountId, recordId); // 💡 int 수신
        if (result > 0) {
            return ResponseEntity.ok("할인이 취소되었습니다.");
        }
        return ResponseEntity.badRequest().body("할인 취소 실패");
    }
}
