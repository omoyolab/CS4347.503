import java.sql.*;
import java.util.*;

public class Console {

	public static void main(String[] args) throws SQLException {
		String db = "jdbc:mysql://localhost:3306/matchingapp";
		String username = "root";
		String password = "Mreman769";
		
		Connection myConnection = DriverManager.getConnection(db, username, password);
		Statement myStatement = myConnection.createStatement();
		
	
		int userInput;
		Scanner keyboard = new Scanner(System.in);
		
		
		do {
			System.out.println(
                    " MENU – FRIENDS APPLICATION– DATABASE SYSTEMS\n"+
                    " 1. Register Account \n" +
                    " 2. Search All Users\n"+
                    " 3. Find Users by Zodiac \n" +
                    " 4. Change your Interests\n"+
                    " 5. See My Potential Matches\n" +
                    " 0. Exit \n" 
                    );
                    userInput = keyboard.nextInt();
                    keyboard.nextLine();
			switch(userInput){
			case 1:
				//code here
			break;
			
			case 2:
				ResultSet allUsers = myStatement.executeQuery("select * from user");
				while(allUsers.next()) {
					System.out.println(allUsers.getString("name") + " - " + allUsers.getString("email") + " - " + allUsers.getString("sex"));
				}
			break;
			
			case 3:
				//code here
			break;
			
			case 4:
				//code here
			break;
			
			case 5:
				String zodiac = null, interest = null;
				char gender = 0 ;

				System.out.println("What zodiac sign are you interested in?");
				zodiac = keyboard.nextLine();
				System.out.println("Name of activity you are interested in");
				interest = keyboard.nextLine();
				System.out.println("What gender are you interested in?");
				gender = keyboard.nextLine().charAt(0);
				
				String query = " Select user.name, user.college, user.major, match.interest_1, match.interest_2,  match.interest_3, match.zodiac\r\n"
						+ " From user,`match`\r\n"
						+ " where match.match_id = user.user_id AND\r\n"
						+ " match.zodiac = \""+zodiac+"\" AND \r\n"
						+ " \""+interest+"\" in (match.interest_1, match.interest_2, match.interest_3)AND\r\n"
						+ " user.sex = \""+gender+"\" \r\n"
						+ " order by user.name;";
				
				ResultSet myMatches =  myStatement.executeQuery(query);
				
				while(myMatches.next()) {
					System.out.println("----------------Your Matches---------------------");
					System.out.println(myMatches.getString("name")+ " - " + myMatches.getString("college")
					+ " - " + myMatches.getString("interest_1")+ " - " + myMatches.getString("interest_2")
					+ " - " + myMatches.getString("interest_3")+ " - " + myMatches.getString("major"));
					
				}
				System.out.println();
				System.out.println();
				System.out.println();
			break;
			}
			
		}while(userInput != 0);
		    System.out.println("Thank you.. Application Terminated");

	

	}

}
