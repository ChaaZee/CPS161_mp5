package data_array;

public class MyDate {
	String month;
	int day;
	int year;
	
	MyDate(String month, int day, int year){
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public String toString() {
		return month + " " + day + ", " + year;
	}

}
