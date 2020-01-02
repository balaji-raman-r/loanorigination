package com.project.dm.loanorigination.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankruptcyDatabase {
	
	private static List<String> bankruptcyDb = 
				new ArrayList<String>(Arrays.asList("1111","2222"));
	
	public static boolean containsId(String uniqueID) {
			return bankruptcyDb.contains(uniqueID);
	}

}
