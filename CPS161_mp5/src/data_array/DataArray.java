package data_array;

public class DataArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate date1 = new MyDate("May", 16, 1984);
		MyDate date2 = new MyDate("November", 14, 1978);
		MyDate date3 = new MyDate("September", 21, 1980);
		MyDate date4 = new MyDate("July", 3, 1987);
		
		MyDate[] dateArray = {date1, date2, date3, date4};
		
		for(int i = dateArray.length - 1; i >= 0; i--) {
			System.out.println(dateArray[i]);
		}
	}

}
