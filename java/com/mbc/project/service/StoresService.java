package com.mbc.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbc.project.dao.StoresDao;
import com.mbc.project.dto.StoresDto;

@Service
public class StoresService {

    private final StoresDao dao;

    // Service 와 Dao 연결
    public StoresService(StoresDao dao) {
        this.dao = dao;
    }

    // 상가 전체 목록 조회
    public List<StoresDto> getStoresDto() {
        return dao.allstores();
    }

    // 층별 상가 조회
    public List<StoresDto> getStoresFloor(int floor) {
        return dao.storesfloor(floor);
    }
}

