package di.persistence;

import di.entity.MemberEntity;

public interface MemberRepository {

	//�⺻Ű�� ������ �ϳ��� �����͸� ã�ƿ��� �޼���
	public MemberEntity findById(String id);
}
