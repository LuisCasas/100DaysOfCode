package com.luiscasas;

public class Main {
	
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		
		StockItem temp = new StockItem("bread", 0.56, 50);
		stockList.addStock(temp);
		
		temp = new StockItem("chocolate", 1.21, 20);
		stockList.addStock(temp);

		temp = new StockItem("juice", 1.86, 100);
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
	}

}
