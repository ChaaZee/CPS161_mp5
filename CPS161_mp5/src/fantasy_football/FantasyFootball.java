package fantasy_football;

import java.util.*;

public class FantasyFootball {
	 private int numberOfTeams; // Same as teamAverage.length.
	 private int numberOfWeeks; // Same as weekAverage.length.
	 private int[][] scores; //numberOfTeams rows and numberOfWeeks columns.
	 private double[] weekAverage; // contains an entry for each week
	 private double[] teamAverage; // contains an entry for each team
	 private String[] teamNames; // contains an entry for each team
	 
	 public void enterInData() {
		 Scanner input = new Scanner(System.in);
		 
		 System.out.print("Enter number of teams: ");
		 numberOfTeams = input.nextInt();
		 
		 System.out.print("Enter number of weeks: ");
		 numberOfWeeks = input.nextInt();
		 
		 weekAverage = new double[numberOfWeeks];
		 teamAverage = new double[numberOfTeams];
		 scores = new int[numberOfTeams][numberOfWeeks];
		 teamNames = new String[numberOfTeams];
		 
		 for(int team = 0; team < numberOfTeams; team++) {
			 System.out.print("Enter team name: ");
			 input.nextLine();
			 teamNames[team] = input.nextLine();
			 
			 for(int week = 0; week < numberOfWeeks; week++) {
				 System.out.print("Enter score for team " + teamNames[team]);
				 System.out.print(" on week " + (week + 1) + ": ");
				 scores[team][week] = input.nextInt(); 
			 }
		 }
	 }

	 public void fillTeamAverage() {
		 double average = 0;
		 
		 for(int t = 0; t < scores.length; t++) {
			 for(int w = 0; w < scores[t].length; w++) {
				 average += scores[t][w];
			 }
			 average /= scores[t].length;
			 teamAverage[t] = average;
			 average = 0;
		 }
	 }
	 
	 public void fillWeekAverage() {
		 double average = 0;
		 
		 for(int w = 0; w < scores[w].length; w++) {
			 for(int t = 0; t < scores.length; t++) {
				 average += scores[t][w];
			 }
			 average /= scores.length;
			 weekAverage[w] = average;
			 average = 0;
		 }
	 }
	 
	 public void display() {
		 System.out.printf("%-20s", "Team Name");
		 for(int w = 0; w < scores[0].length; w++) {
			 System.out.printf("%-15s", "week " + (w + 1));
		 }
		 System.out.println();
		 
		 for(int t = 0; t < scores.length; t++) {
			 System.out.printf("%-20s", teamNames[t]);
			 for(int w = 0; w < scores[t].length; w++) {
				 System.out.printf("%-15s", scores[t][w]);
			 }
			 System.out.printf("%s%n", "ave: " + (int)(teamAverage[t]));
		 }
		 
		 System.out.printf("%-20s", "Weekly Ave: ");
		 for(int a = 0; a < weekAverage.length; a ++) {
			 System.out.printf("%-15s", (int)(weekAverage[a]));
		 }
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FantasyFootball f= new FantasyFootball();
		 f.enterInData();
		 f.fillTeamAverage();
		 f.fillWeekAverage();

		 f.display();

	}

}
