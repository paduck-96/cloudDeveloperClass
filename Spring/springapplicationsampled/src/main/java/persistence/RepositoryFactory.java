package persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//인스턴스 생성해주는 Factory 클래스
@Configuration //팩토리 클래스라는 어노테이션
public class RepositoryFactory {
	//create 대신에 newInstance 사용해도 같은 의미
	//매번 인스턴스 생성해 제공
	@Bean //인스턴스를 만들어주는 메서드
	public static ItemRepository create() {
		
		return new ItemRepository();
	}

}
