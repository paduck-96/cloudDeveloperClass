package di.persistence;

import org.springframework.stereotype.Repository;

import di.entity.MemberEntity;

// bean 자동 생성 어노테이션
@Repository
public class MemberRepositoryImpl implements MemberRepository {

	public MemberEntity findById(String id) {
		MemberEntity memberEntity = MemberEntity.builder().id("adam").password("1234").nickname("����").build();
		return memberEntity;
	}

}
