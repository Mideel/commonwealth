package com.example.demo;

public class PrintStairApplication {
	
	public static void main(String[] args) {
	 
		printStair(10);
	}
	
	private static void printStair(int n) {
		for(int i= 1; i <= n; i++) {
			for(int j=1 ; j <= n - i; j++ ) {
				System.out.print(" ");
			}
			for(int j=n-i+1; j <= n; j++) {
				System.out.print("#");
			}
			if(i != n)
				System.out.print("\n");
		}
	}

}
