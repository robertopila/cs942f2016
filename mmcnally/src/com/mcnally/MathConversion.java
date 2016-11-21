package com.mcnally;

import java.util.HashMap;
import java.lang.Math;

public class MathConversion {
	static char[] symbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N', 
		'O','P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};

	public static int toDecimal(String number, int base) {
	    HashMap<Character, Integer> symbolValues = new HashMap<Character, Integer>();
	    for (int i=0; i<symbols.length; i++) { symbolValues.put(symbols[i], i); }

		int dec = 0;
		for (int i = 0; i < number.length(); i++) {
			dec += symbolValues.get(number.charAt(i)) * Math.pow(base, number.length() - (1 + i));
		}
		return dec;
	}
}
