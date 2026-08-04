package com.mbc.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mbc.project.dto.BoardDto;
import com.mbc.project.dto.StoresDto;

@Mapper // 스프링부트에 DB와의 소통한다고 알려주는 애노테이션(Annotation)
public interface StoresDao {
    // 1. 상가 전체 목록 (Stores)
    List<StoresDto> allstores();      // 상가 전체 목록 조회
    
    // 2. 층별 상가 위치
    List<StoresDto> storesfloor(int floor);   // 지정한 층의 상가 목록 조회
}
