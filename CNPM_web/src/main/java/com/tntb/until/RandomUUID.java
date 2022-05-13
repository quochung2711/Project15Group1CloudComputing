package com.tntb.until;

import java.util.UUID;

public class RandomUUID {
	public static String getRandomID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public static void main(String[] args) {
		 System.out.printf(getRandomID());
	}
}	
