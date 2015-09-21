package com.bhaskar.tabcom;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		TableMetadata tmdt = new TableMetadata();
		List<String[]> l =  tmdt.getTableMetadata("category");
		
		for (int i = 0; i < l.size(); i++) {
		    String[] strings = l.get(i);
		    for (int j = 0; j < strings.length; j++) {
		        System.out.print(strings[j] + " ");
		    }
		    System.out.println();
		}
		

	}

}
