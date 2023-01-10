package springapplicationsampled;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.controller.MemberController;
import domain.Item;
import persistence.ItemRepository;
import persistence.RepositoryFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ٸ� ��Ű�������� �ν��Ͻ� ������ ���ϵ���
		//�������� ���� �����ڸ� pkg�� ����
		//ItemRepository itemRepository = new ItemRepository();
		
		// �ν��Ͻ� ������ �ٸ� ���丮 Ŭ������ �̿��ؼ� ����
		//�ٸ� Ŭ������ �޼��带 �̿��ؼ� �ν��Ͻ��� �����ϴ� ��
		//ItemRepository itemRepository = RepositoryFactory.create();
		//ItemRepository itemRepository1 = RepositoryFactory.create();
		
		// �������� �ν��Ͻ��� ����
		//������̼� �̿�
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RepositoryFactory.class);
		
		// RepositoryFactory Ŭ������ create �޼��� ȣ����
		//ItemRepository Ŭ������ �ν��Ͻ� ����
		//ItemRepository itemRepository = context.getBean("create", ItemRepository.class);
		
		//System.out.println(System.identityHashCode(itemRepository));
		//System.out.println(System.identityHashCode(itemRepository1));
		
		//Item item = itemRepository.get();
		//System.out.println(item);
		//ItemRepository itemRepository1 = context.getBean("create", ItemRepository.class);
		
		// �������� �̱��� �������� �����ϹǷ� 2���� �ؽ��ڵ� ��ġ
		//System.out.println(System.identityHashCode(itemRepository));
		//System.out.println(System.identityHashCode(itemRepository1));
		
		//context.close();
		
		// XML�� �̿��� bean ����
		try(GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml")){
			// bean �±��� id �� Ŭ���� ����
			/*
			ItemRepository itemRepository = context.getBean("itemRepository", ItemRepository.class);
			Item item = itemRepository.get();
			System.out.print(item);
			*/
//			Item item = context.getBean("item", Item.class);
//			System.out.println(item+"2");
			// Controller 가져오기
//			MemberController controller = context.getBean("memberController", MemberController.class);
//			controller.findById("1");
			SqlSessionFactory sqlFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
			System.out.println(sqlFactory);
			SqlSession session = sqlFactory.openSession();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
