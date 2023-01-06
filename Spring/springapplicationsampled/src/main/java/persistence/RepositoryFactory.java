package persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//�ν��Ͻ� �������ִ� Factory Ŭ����
@Configuration //���丮 Ŭ������� ������̼�
public class RepositoryFactory {
	//create ��ſ� newInstance ����ص� ���� �ǹ�
	//�Ź� �ν��Ͻ� ������ ����
	@Bean //�ν��Ͻ��� ������ִ� �޼���
	public static ItemRepository create() {
		
		return new ItemRepository();
	}

}
