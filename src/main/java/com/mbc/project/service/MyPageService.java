package com.mbc.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.project.dao.MyPageDao;
import com.mbc.project.dto.CarLocationDto;
import com.mbc.project.dto.MemberDto;
import com.mbc.project.dto.MyCarDto;

@Service
@Transactional
public class MyPageService {
	
	private final MyPageDao dao;

    public MyPageService(MyPageDao dao) {
        this.dao = dao;
    }
 // 1. 내 정보 조회
    @Transactional(readOnly = true)
    public MemberDto getMember(String id) {
        return dao.getMember(id);
    }

    // 2. 내 정보 수정
    public boolean updateMember(MemberDto dto) {
        return dao.updateMember(dto) > 0;
    }

    // 3. 내 차량 위치 조회
    @Transactional(readOnly = true)
    public CarLocationDto getCarLocation(String id) {
        // ① 유저 ID로 등록된 차량 번호 가져오기
        MemberDto member = dao.getMember(id);
        if (member == null || member.getCarNum() == null || member.getCarNum().trim().isEmpty()) {
            return null; // 등록된 차량이 없는 경우
        }

        // ② 차량 번호로 주차 위치 조회
        return dao.getCarLocation(member.getCarNum());
    }
    // 4. 내 차량 정보 조회
    @Transactional(readOnly = true)
    public MyCarDto getMyCar(String id) {
        return dao.getMyCar(id);
    }
    
    
    // 5 & 6. 차량 등록 및 변경
    public boolean updateCarNum(String id, String carNum, String carTypes) {
        return dao.updateCarNum(id, carNum, carTypes) > 0;
    }

    // 7. 차량 삭제
    public boolean deleteCarNum(String id) {
        return dao.deleteCarNum(id) > 0;
    }
}
    
    
    
    
