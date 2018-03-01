package com.luiscasas;

import java.util.Map;

public class Main {
	
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		
		StockItem temp = new StockItem("bread", 0.56, 50);
		stockList.addStock(temp);
		
		temp = new StockItem("chocolate", 1.21, 20);
		stockList.addStock(temp);

		temp = new StockItem("juice", 1.86, 100);
		stockList.addStock(temp);
		
		temp = new StockItem("juice", 1.72, 80);
		stockList.addStock(temp);		
		
		temp = new StockItem("milk", 0.49, 22);
		stockList.addStock(temp);
		
		temp = new StockItem("potatoes", 1.32, 40);
		stockList.addStock(temp);
		
		temp = new StockItem("tomatoes", 0.59, 50);
		stockList.addStock(temp);

		System.out.println(stockList);
		
		for(String s : stockList.Items().keySet()) {
			System.out.println(s);
		}
		
		Basket myBasket = new Basket("Luis");
		sellItem(myBasket, "milk", 3);
		System.out.println(myBasket);
		
		sellItem(myBasket, "juice", 2);
		System.out.println(myBasket);		
		
		sellItem(myBasket, "milk", 300);
		sellItem(myBasket, "cars", 3);
		sellItem(myBasket, "potatoes", 32);
		sellItem(myBasket, "tomatoes", 22);
		
		System.out.println(myBasket);
		System.out.println(stockList);
		
		stockList.Items().get("milk").adjustStock(1000);
		stockList.get("milk").adjustStock(-500);
		
		System.out.println(stockList);
		
		System.out.println("\n\nItems and prices:");
		for(Map.Entry<String, Double> price :  stockList.priceList().entrySet()) {
			System.out.println(price.getKey() + " costs " + price.getValue());
		}
		
	}
	
	public static int sellItem(Basket basket, String item, int quantity) {
		
		StockItem stockItem = stockList.get(item);
		
		if(stockItem == null) {
			System.out.println("Item " + item + " not available.");
			return 0;
		}
		
		if(stockList.sellStock(item, quantity) != 0) {
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		
		return 0;
	}

}
