package com.luiscasas;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
	
	private final Map<String, StockItem> list;
	
	public StockList() {
		this.list = new LinkedHashMap<>();
	}

	public int addStock(StockItem item) {
		if(item != null) {
			StockItem inStock = list.getOrDefault(item.getName(), item);
			
			if(inStock != item) {
				item.adjustStock(inStock.quantityInStock());
			}
			
			list.put(item.getName(), item);
			return item.quantityInStock();
		}
		
		return 0;
	}
	
	public int sellStock(String item, int quantity) {
		StockItem inStock = list.getOrDefault(item, null);
		
		if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
			inStock.adjustStock(-quantity);
			return quantity;
		}
		
		return 0;
	}
	
	public StockItem get(String key) {
		return list.get(key);
	}
	
	public Map<String, Double> priceList(){
		Map<String, Double> prices = new LinkedHashMap<>();
		
		for(Map.Entry<String, StockItem> item : list.entrySet()) {
			prices.put(item.getKey(), item.getValue().getPrice());
		}
		
		return Collections.unmodifiableMap(prices);
	}
	
	public Map<String, StockItem> Items(){
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nStock List\n";
		double totalCost = 0.0;
		for(Map.Entry<String, StockItem> item : list.entrySet()) {
			StockItem stockItem = item.getValue();
			
			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
			
			s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. "
					+ "Value of items: ";
			s = s + String.format("%.2f", itemValue) + "\n";
			totalCost += itemValue;
		}
		
		return s + "Total stock value " + String.format("%.2f", totalCost);
	}
	
	
}