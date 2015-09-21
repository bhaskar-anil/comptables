package com.bhaskar.tabcom;

import java.util.List;

public class CompareMetadata {
	TableMetadata tmdt = new TableMetadata();
	List<String[]> tgt =  tmdt.getTableMetadata("products");
	List<String[]> src =  tmdt.getTableMetadata("test");
	
	

}
