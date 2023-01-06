package persistence;

import domain.Item;

public class ItemRepository {
	
	ItemRepository(){
		
	}
	public Item get() {
		Item item = null;
		
		item = new Item();
		item.setItemId(1);
		item.setItemName("망고");
		item.setDescription("가장 좋아하는 과일");
		item.setPrice(3000);
		item.setPictureUrl("mango.png");
		
		return item;
	}
}
