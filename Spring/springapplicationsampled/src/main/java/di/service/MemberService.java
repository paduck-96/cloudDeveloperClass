package di.service;

import di.dto.MemberDTO;

public interface MemberService {
	// 기본키 1개 받아 하나의 데이터 리턴
	//매개변수 나 리턴 타입에 Entity Type을 사용하면 안됨
	public MemberDTO findById(String id);

}
