package persistence;

import domain.Item;

public class ItemRepository {
	
	ItemRepository(){
		
	}
	public Item get() {
		Item item = null;
		
		item = new Item();
		item.setItemId(1);
		item.setItemName("����");
		item.setDescription("���� �����ϴ� ����");
		item.setPrice(3000);
		item.setPictureUrl("mango.png");
		
		return item;
	}
}
