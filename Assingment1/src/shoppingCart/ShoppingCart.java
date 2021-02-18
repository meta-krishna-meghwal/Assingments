package shoppingCart;

import java.util.*;


public class ShoppingCart {
		
	public HashMap<Integer,Item> items = new HashMap<Integer,Item>();
	
	private int totalAmount = 0,totalItems = 0;
	
	public void addItem(Item item){
		
		totalItems += 1;
		totalAmount += item.itemPrice;
		items.put(item.itemNo,item);
	}
	
	public void removeItem(Item item){
		totalAmount -= item.itemPrice;
		totalItems -= 1;
		items.remove(item.itemNo);
	}
	
	public int getTotalAmount()
	{
		return totalAmount;
	}
	
	public int getTotalItems()
	{
		return totalItems;
	}
	
	public void showBill()
	{
		System.out.println("Items in the cart: \n");
		
		for(Integer itemNo : items.keySet()){
			
			Item item = items.get(itemNo);
			String displayText = String.valueOf(item.itemNo) + " " +item.itemName+" " + String.valueOf(item.itemPrice) + ".\n";
			System.out.println(displayText);
			
		}
		System.out.println("Toatl items: " + String.valueOf(totalItems) + " Total amount: " + String.valueOf(totalAmount));
		System.out.println("Happy purchasing!!\n");
	}
	
	
}
