package com.evaluation.debugging;

public class DebuggingTest {
	
	public int testMethod(int count) {
		
		int [] ar = new int[count];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int)(Math.random() * 900) + 100;
		}
		
		int result = 0;
		for (int n : ar) {
			result += n;
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		DebuggingTest test = new DebuggingTest();
		
		int result = test.testMethod(10);
		
		System.out.println(result);
		
	}

}
