package fractions;

import java.util.*;

public class Fractions {
	//Scanner input = new Scanner(System.in);
	private int n;
	private int d;
	
	public Fractions(int n, int d){
		this.n = n;
		this.d = d;
		reduce();
	}
	
	public void setFraction(int n, int d) {
		this.n = n;
		this.d = d;
		reduce();
	}
	
	private void reduce() {
		int divisor = 1;
		
		if(d > n) {
			for(int i = d; i > 0; i--) {
				if(d % i == 0 && n % i == 0) {
					divisor = i;
					break;
				}
			}
		} else {
			for(int j = n; j > 0; j--) {
				if(d % j == 0 && n % j == 0) {
					divisor = j;
					break;
				}
			}
		}
		
		n /= divisor;
		d /= divisor;		
	}
	
	public boolean equals(Fractions f) {
		//this.reduce();
		//f.reduce();
		
		if(this.n == f.n && this.d == f.d) {
			return true;
		} else {
			return false;
		}
	}
	
	public Fractions add(Fractions f) {
		//this.reduce();
		//f.reduce();
		
		int den = this.d * f.d;
		int num = (this.n * f.d) + (f.n * this.d);
		
		Fractions frac = new Fractions(num, den);
		frac.reduce();
		
		return frac;
	}
	
	public Fractions subtract(Fractions f) {
		//this.reduce();
		//f.reduce();
		
		int den = this.d * f.d;
		int num = (this.n * f.d) - (f.n * this.d);
		
		Fractions frac = new Fractions(num, den);
		frac.reduce();
		
		return frac;
	}
	
	public Fractions multiply(Fractions f) {
		//this.reduce();
		//f.reduce();
		
		int den = this.d * f.d;
		int num = this.n * f.n;
		
		Fractions frac = new Fractions(num, den);
		frac.reduce();
		
		return frac;
	}
	
	public Fractions divide(Fractions f) {
		//this.reduce();
		//f.reduce();
		
		int den = this.d * f.n;
		int num = this.n * f.d;
		
		Fractions frac = new Fractions(num, den);
		frac.reduce();
		
		return frac;
	}
	
	public static int getNum(String f) {
		int index = f.indexOf("/");
		int num1 = 1;
		
		while(true) {
			if(index != -1) {
				String num = f.substring(0, index);
				num1 = Integer.parseInt(num);
				break;
			} else {
				continue;
			}
		}
		return num1;
	}
	
	public static int getDen(String f) {
		int index = f.indexOf("/");
		int den1 = 1;
		
		while(true) {
			if(index != -1) {
				String den = f.substring(index + 1, f.length());
				den1 = Integer.parseInt(den);
				break;
			} else {
				continue;
			}
		}
		return den1;
	}
	
	public String toString() {
		return n + "/" + d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			System.out.print("Enter operation(+, -, *, /, q = quit): ");
			Scanner input = new Scanner(System.in);
			char operator = input.nextLine().charAt(0);
			
			if(operator == 'q') {
				System.out.println("Have a nice day!");
				break;
			} else if(operator != '+' && operator != '-' && operator != '*' && operator != '/') {
				System.out.println("Try again.");
				System.out.println();
				continue;
			}

			System.out.print("Enter fraction 1: ");
			Scanner input1 = new Scanner(System.in);
			String f1 = input1.nextLine();
			int frac1_num = getNum(f1);
			int frac1_den = getDen(f1);
			
			System.out.print("Enter fraction 2: ");
			Scanner input2 = new Scanner(System.in);
			String f2 = input2.nextLine();
			int frac2_num = getNum(f2);
			int frac2_den = getDen(f2);
			
			Fractions frac1 = new Fractions(frac1_num, frac1_den);
			Fractions frac2 = new Fractions(frac2_num, frac2_den);
			
			if(frac1.equals(frac2)) {
				System.out.println("fraction 1 and 2 are equal");
			} else {
				System.out.println("fraction 1 and 2 are not equal");
			}
			
			if(operator == '+') {
				System.out.println(frac1 + " " + operator + " " + frac2 + " = " + frac1.add(frac2));
				System.out.println();
			} else if(operator == '-') {
				System.out.println(frac1 + " " + operator + " " + frac2 + " = " + frac1.subtract(frac2));
				System.out.println();
			} else if(operator == '*') {
				System.out.println(frac1 + " " + operator + " " + frac2 + " = " + frac1.multiply(frac2));
				System.out.println();
			} else if(operator == '/') {
				System.out.println(frac1 + " " + operator + " " + frac2 + " = " + frac1.divide(frac2));
				System.out.println();
			}
		}
	}
}
