import com.mysql.cj.protocol.x.ReusableOutputStream;

import java.awt.desktop.SystemEventListener;
import java.sql.*;
import java.util.*;

public class Console {
	static String[] zsigns = {"Capricorn","Aquarius","Pisces",
			"Aries","Taurus", "Gemini",
			"Cancer","leo","Virgo",
			"Libra","Scorpio","Sagitarius"};

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
				System.out.println("Please enter a Zodiac Sign from the following:\n");
				for(int i =0; i< zsigns.length;i++){
					int pos= i +1;
					String sign = zsigns[i];
					System.out.println("  "+pos+" | "+ sign);
				}
				userInput= keyboard.nextInt();
				String zquery= getZodiac(userInput,keyboard);
				// Unlock comment to print query before querying System.out.println(zquery);

				ResultSet zodiacList= myStatement.executeQuery(zquery);
				while(zodiacList.next()){
					System.out.println(zodiacList.getString("name")+ " - " + zodiacList.getString("zodiac")+" - "+ zodiacList.getString("sex"));
				}
				System.out.println("\n\n\n\n"); // adds space for asthetics


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



	public static String getZodiac(int ui, Scanner k) {
		int c= ui-1;// since index starts at 0 and not 1 but options are 1 through 12
		String queryout = null;
		if (!(ui < 1 || ui > 12)) {
			System.out.println("Did you want to specify sex?  Y/N ");
			String response = k.next().toLowerCase();
			//int respint = response - 0;
			char rchar=response.charAt(0);
			int r = rchar-0; //turn response into numerical value with simple char to in conversion.
			if (r==110){
				//This means not gender specific query all for this sign
				queryout = "SELECT user.name,matchingapp.match.zodiac, user.sex "
						+"FROM user,matchingapp.match "
						+ "WHERE matchingapp.match.match_id = user.user_id AND "
						+ "matchingapp.match.zodiac = \""+ zsigns[c] +"\" ;";
				return queryout;
			}else if (r==121){
				// This is means it is gender specific ask for male or female?
				System.out.println("Male or Female?");//male 77, female 70
				String gen = k.next().toUpperCase();
				char gChar=gen.charAt(0);
				if (!(gChar==77||gChar==70)) {
					System.out.println("Please choose Male or Female");
					//getZodiac(ui, k);
				}else{

				queryout = "SELECT user.name,matchingapp.match.zodiac, user.sex "
						+"FROM user,matchingapp.match "
						+ "WHERE matchingapp.match.match_id = user.user_id AND "
						+ "matchingapp.match.zodiac = \""+ zsigns[c] +"\" and user.sex= \""+gChar+"\";";
				return queryout;}
			}else{
				System.out.println("You did not specify a sex please try again");
				//getZodiac(ui,k);
			}

		} else {
			System.out.println("Please enter valid input\n");
			int nui = k.nextInt();
			getZodiac(nui, k);

		}
		return queryout;
	}

}
