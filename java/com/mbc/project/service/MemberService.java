package com.mbc.project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mbc.project.dao.MemberDao;
import com.mbc.project.dto.MemberDto;

@Service
@Transactional
public class MemberService {
    
    // 1. [주석 해제] final 키워드와 함께 dao 변수를 정상 활성화합니다.
    private final MemberDao dao; 
	
    // 2. [주석 해제 및 복구] 생성자를 통해 스프링 부트가 MemberDao를 안전하게 주입하도록 복구합니다.
    public MemberService(MemberDao dao) {
        this.dao = dao;
    }

    // 3. 진짜 DB의 usermember 테이블 전체 목록을 긁어오도록 복구
    public List<MemberDto> allMemberDao(){
        return dao.allmember(); 
    }
    // 회원가입
    public boolean addmember(MemberDto dto) {

        int count = dao.addmember(dto);
        return count > 0;
	}
    // 로그인
	public MemberDto login(MemberDto dto) {
        return dao.login(dto);
    }
    // 아이디 중복확인
	public boolean idcheck(String id) {
	    int count = dao.idcheck(id);
	    return count > 0;
	}

}
