import java.sql.*;
import java.util.*;


public class Console {

	public static void main(String[] args) throws SQLException {
		String db = "jdbc:mysql://localhost:3306/matchingapp";
		String username = "root";
		String password = "axoxweb";
		
		Connection myConnection = DriverManager.getConnection(db, username, password);
		Statement myStatement = myConnection.createStatement();
		
	
		int userInput;
		String zodiac = null, interest = null, query = null;
		String interest_1 = null,interest_2 = null, interest_3 = null;
		String name = null, email = null, pw = null,college = null, major = null;
		String matchId = null;
		int age = 0, match_id = 0;
		char gender = 0 ;  
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ResultSet myMatches, allUsers, newUser, grabLastMatchId, executeOldUser, executeUpdatedUser;
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
				// Collect User Input for Match Table
				System.out.println("What Zodiac Sign");
				zodiac = keyboard.nextLine();
				System.out.println("What Zodiac Enter your First Interest");
				interest_1 = keyboard.nextLine();
				System.out.println("What Zodiac Enter your Second Interest");
				interest_2 = keyboard.nextLine();
				System.out.println("What Zodiac Enter your Third Interest");
				interest_3 = keyboard.nextLine();
				
				// Query to insert User Input
				String createMatchQuery = "INSERT INTO `match`\r\n"
						+ "	(zodiac, interest_1, interest_2, interest_3)\r\n"
						+ "	VALUES ('"+zodiac+"','"+interest_1+"','"+interest_2+"','"+interest_3+"'); ";
				//Execute Query
				myStatement.executeUpdate(createMatchQuery);
				
				//Query to Collect the newest match ID in from the match table
				String getlastIdQuery =" SELECT * FROM `match` ORDER BY `match`.`match_id` DESC LIMIT 1";
				//Execute Query
				grabLastMatchId = myStatement.executeQuery(getlastIdQuery);
				//Loop through Query Result and collect the match ID
				while(grabLastMatchId.next()) {
					matchId = (grabLastMatchId.getString("match_id"));
				}
					//Save the match ID as an integer
					int matchID = Integer.parseInt(matchId);
				
				// Collect user Input for User Table
				System.out.println("What is your Name");
				name = keyboard.nextLine();
				System.out.println("What is your Email");
				email = keyboard.nextLine();
				System.out.println("Choose a Password");
				pw = keyboard.nextLine();
				System.out.println("What is your Major");
				major = keyboard.nextLine();
				System.out.println("What College do you attend?");
				college = keyboard.nextLine();
				System.out.println("What is your Gender (Enter one Character)");
				gender = keyboard.nextLine().charAt(0);
				System.out.println("How Old are you?");
				age = keyboard.nextInt();
				
				// Query to Insert User Input
				String createUserQuery = "INSERT INTO user \r\n"
						+ "	(name, email, password, major, college, sex, registered_date, match_id, age)\r\n"
						+ "	VALUES ('"+name+"', '"+email+"','"+pw+"','"+major+"','"+college+"','"+gender+"','"+date+"','"+matchID+"','"+age+"');";
				//Execute Query
				myStatement.executeUpdate(createUserQuery);
				
				// Execute Query to print User info
				newUser = myStatement.executeQuery(" SELECT * FROM user ORDER BY user.user_id DESC LIMIT 1");
				//Loop through result and print user info
				System.out.println("----------------YOUR INFORMATION---------------------");
				while(newUser.next()) {
					System.out.println(newUser.getString("name")+ " - " + newUser.getString("college")+ " - "
					+ newUser.getString("age")+ " - " + newUser.getString("email"));
					
				}
				System.out.println();
				System.out.println();
				System.out.println();
			break;
			
			case 2:
				allUsers = myStatement.executeQuery("select * from user");
				while(allUsers.next()) {
					System.out.println(allUsers.getString("name") + " - " + allUsers.getString("email") + " - " + allUsers.getString("sex"));
				}
			
			break;
			
			case 3:	
				System.out.println("What Zodiac Sign are you interested in?");
				zodiac = keyboard.nextLine();
				System.out.println("What gender are you interested in?");
				gender = keyboard.nextLine().charAt(0);
				
				query = "Select user.name, match.zodiac, user.age, user.major, user.email \n" +
						" from user, `match` \n" +
						" Where match.match_id = user.user_id AND \n" +
						" match.zodiac = \""+zodiac+"\" AND \r\n" +
						 " user.sex = \""+gender+"\" \r\n" +
						" Order by user.name; ";
				
				 myMatches =  myStatement.executeQuery(query);
					System.out.println("----------------Your Matches---------------------");
					while(myMatches.next()) {
						System.out.println(myMatches.getString("name")+ " - " + myMatches.getString("zodiac")
						+ " - " + myMatches.getString("email")+ " - " + myMatches.getString("major")
						+ " - " + myMatches.getString("age"));
						
					}
					System.out.println();
					System.out.println();
					System.out.println();
		
			break;
			
			case 4:
				System.out.println("Enter your New First Interest");
				interest_1 = keyboard.nextLine();
				System.out.println("Enter your New Second Interest");
				interest_2 = keyboard.nextLine();
				System.out.println(" Enter your New Third Interest");
				interest_3 = keyboard.nextLine();
				System.out.println("Enter your Match ID");
				match_id = keyboard.nextInt();
				
				String getOldUser =" Select name, user.match_id, interest_1, interest_2, interest_3\r\n"
						+ " from\r\n"
						+ " user,`match`\r\n"
						+ " where user.match_id = match.match_id AND\r\n"
						+ " user.match_id = "+match_id+";";
				executeOldUser = myStatement.executeQuery(getOldUser);
				
				System.out.println("----------------Your Old Interests---------------------");
				while(executeOldUser.next()) {
					System.out.println(executeOldUser.getString("name")+ " - " + executeOldUser.getString("match_id")
					+ " - " + executeOldUser.getString("interest_1")
					+ " - " + executeOldUser.getString("interest_2")+ " - " + executeOldUser.getString("interest_3"));		
				}
				
				System.out.println();
				
				query = " Update `match`\r\n"
						+ "set interest_1 = '"+interest_1+"', interest_2 = '"+interest_2+"', interest_3 = '"+interest_3+"'\r\n"
						+ "where match_id =  \""+match_id+"\"";
				
				myStatement.executeUpdate(query);
				
				String getUpdatedUser =" Select name, user.match_id, interest_1, interest_2, interest_3\r\n"
						+ " from\r\n"
						+ " user,`match`\r\n"
						+ " where user.match_id = match.match_id AND\r\n"
						+ " user.match_id = "+match_id+";";
				executeUpdatedUser = myStatement.executeQuery(getUpdatedUser);
				
				System.out.println("----------------Your New Interests---------------------");
				while(executeUpdatedUser.next()) {
					System.out.println(executeUpdatedUser.getString("name")+ " - " + executeUpdatedUser.getString("match_id")
					+ " - " + executeUpdatedUser.getString("interest_1")
					+ " - " + executeUpdatedUser.getString("interest_2")+ " - " + executeUpdatedUser.getString("interest_3"));
					
				}
				System.out.println();
				System.out.println();
				System.out.println();
			break;
			
			case 5:			
				System.out.println("What zodiac sign are you interested in?");
				zodiac = keyboard.nextLine();
				System.out.println("Name of activity you are interested in");
				interest = keyboard.nextLine();
				System.out.println("What gender are you interested in?");
				gender = keyboard.nextLine().charAt(0);
				
				query = " Select user.name, user.college, user.age, user.email, match.interest_1, match.interest_2,  match.interest_3, match.zodiac\r\n"
						+ " From user,`match`\r\n"
						+ " where match.match_id = user.user_id AND\r\n"
						+ " match.zodiac = \""+zodiac+"\" AND \r\n"
						+ " \""+interest+"\" in (match.interest_1, match.interest_2, match.interest_3)AND\r\n"
						+ " user.sex = \""+gender+"\" \r\n"
						+ " order by user.name;";
				
				 myMatches =  myStatement.executeQuery(query);
				System.out.println("----------------Your Matches---------------------");
				while(myMatches.next()) {
					System.out.println(myMatches.getString("name")+ " - " + myMatches.getString("college")
					+ " - " + myMatches.getString("interest_1")+ " - " + myMatches.getString("interest_2")
					+ " - " + myMatches.getString("interest_3")+ " - " + myMatches.getString("age")+ " - " + myMatches.getString("email"));
					
				}
				System.out.println();
				System.out.println();
				System.out.println();
			break;
			}
			
		}while(userInput != 0);
		    System.out.println("Thank you.. Application Terminated");
		    keyboard.close();
	

	}

}
