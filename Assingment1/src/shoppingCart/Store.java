package shoppingCart;

import java.util.*;

public class Store {
	
	private static HashMap<Integer,Item> allItems = new HashMap<Integer,Item>();

	public void updateStore(Item item) {
		allItems.put(item.itemNo,item);
	}
	
	public void displayItems()
	{
		System.out.println("Choose from below items: \n");
		for(Integer itemNo : allItems.keySet()){
			Item item = allItems.get(itemNo);
			String displayText = String.valueOf(item.itemNo) + ") " +item.itemName+" Price: " + String.valueOf(item.itemPrice);
			System.out.println(displayText);
			
		}
	}
	
	public static void main(String[] args){
		
		Store store = new Store();
		
		for(int itemNo = 101; itemNo <= 110; itemNo++){
			
			Item item = new Item(itemNo,"Toothpaste",20);
			store.updateStore(item);				
		}
		
		store.displayItems();
		
		ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in); 
		
		boolean start = true;
				
		while(start == true){
			
			System.out.println("\nEnter 0 to end purchasing. \nEnter 1 to add item to cart.\nEnter 2 to remove item from cart.");
			int choice = sc.nextInt();
			
			if(choice == 0){
				cart.showBill();
				break;
			}else if(choice == 1){
				System.out.println("Enter item number to add to cart: ");
				int itemNo = sc.nextInt();
				cart.addItem(allItems.get(itemNo));
			}else{
				System.out.println("Enter item number to remove from cart: ");
				int itemNo = sc.nextInt();
				cart.removeItem(allItems.get(itemNo));
			}
		}	
	}
}
