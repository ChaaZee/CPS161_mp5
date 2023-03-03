package string_array;

public class StringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] firstnames = {"George", "Fred", "Sam", "Mary", "Sarah", "Bella", "Joy", "Rita", "Marta", "Sue", "Nancy" };
		for(int i = firstnames.length - 1; i >= 0; i--) {
			System.out.print(firstnames[i] + " ");
		}
	}

}
