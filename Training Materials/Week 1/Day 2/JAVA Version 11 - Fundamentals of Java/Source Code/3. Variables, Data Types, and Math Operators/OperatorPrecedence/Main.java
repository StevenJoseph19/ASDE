package com.mycompany.operatorprecedence;

public class Main {

	public static void main(String[] args) {

		int valA = 21;
		int valB = 6;
		int valC = 3;
		int valD = 1;

		int result1 = valA - valB / valC;

		int result2 = (valA - valB) / valC;

		System.out.println(result1);
		System.out.println(result2);

//		int result3 = valA / valC * valD + valB;
//
//		int result4 = valA / (valC * (valD + valB));
//
//		System.out.println(result3);
//		System.out.println(result4);

//		byte x = 3;
//		byte y = 4;
//
//		byte z = (byte) (x * y);

//		short x = 3;
//		short y = 4;
//
//		short z = (short) (x * y);
//		
//		long x = 3;
//		long y = 4;
//
//		long z =  (x * y);
//
//		System.out.println(z);

	}

}
