package com.mbc.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.project.dto.StoresDto;
import com.mbc.project.service.StoresService;

@RestController
public class StoresController {

    private final StoresService service;

    public StoresController(StoresService service) {
        this.service = service;
    }

    // 전체 상가 조회
    @PostMapping("/allstores")
    public List<StoresDto> allstores() {
        System.out.println("StoresController allstores() " + new Date());

        return service.getStoresDto();
    }
    
    
    // 2. 층별 상가 위치
    @GetMapping("/storesfloor")
    public List<StoresDto> storesfloor(@RequestParam int floor) { // @RequestParam은 URL의 파라미터 값을 메서드 매개변수로 받는 어노테이션
        System.out.println("StoresController storesfloor() " + new Date());

        return service.getStoresFloor(floor);
    }
}