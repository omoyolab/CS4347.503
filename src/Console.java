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
				String query= getZodiac(userInput,keyboard);


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



	private static String getZodiac(int ui, Scanner k) {
		int c= ui-1;// since index starts at 0 and not 1 but options are 1 through 12
		if (!(ui < 1 || ui > 12)) {
			System.out.println("Did you want to specify gender?  Y/N ");
			String response = k.next();
			//int respint = response - 0;
			System.out.println("response " + response);
			char rchar=response.toLowerCase(Locale.ROOT).charAt(0);
			int r = rchar-0;
			System.out.println("response char" + r);
			if (r==110){
				//This means not gender specific query all for this sign
				String q= "SELECT user.name,match.zodiac\n"
						+"FROM user, 'match' \n"
						+ "WHERE match.match_id = user.user_id AND \n"
						+ "match.zodiac = \""+ zsigns[c] +"\"";
				System.out.println(q);
			}else{
				// This is means it is gender specific ask for male or female?
				System.out.println("Male or Female?");//male 77, female 70
				String gen = k.next();
				//int respint = response - 0;
				System.out.println("response: " + gen);
				char gChar=gen.toUpperCase(Locale.ROOT).charAt(0);
				int g = gChar-0;
				System.out.println(g);

				String q1= "SELECT user.name,match.zodiac \n"
						+"FROM user, 'match' \n"
						+ "WHERE match.match_id = user.user_id AND \n"
						+ "match.zodiac = \""+ zsigns[c] +"\" and user.sex= \""+gChar+"\"";
				System.out.println(q1);
			}

		} else {
			System.out.println("Please enter valid input\n");
			int nui = k.nextInt();
			getZodiac(nui, k);

		}
		return "hey";
	}

}
