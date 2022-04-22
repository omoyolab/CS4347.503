import com.mysql.cj.protocol.x.ReusableOutputStream;

import java.sql.*;
import java.util.*;

public class Console {

	public static void main(String[] args) throws SQLException {
		String db = "jdbc:mysql://localhost:3306/matchingapp";
		String username = "magusc";
		String password = "password";
		
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
				System.out.println("Please enter a Zodiac Sign from the following:\n" +
						"");
				ResultSet zodreq= myStatement.executeQuery("SELECT *");
				break;
			
			case 4:
				//code here
			break;
			
			case 5:
				//code here
			break;
			}
			
		}while(userInput != 0);
		    System.out.println("Thank you.. Application Terminated");

	

	}

}
