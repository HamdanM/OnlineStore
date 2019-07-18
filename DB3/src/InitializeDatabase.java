
/////////////////////////////////////////
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/////////////////////////////


////////

@WebServlet("/InitializeDatabase")

public class InitializeDatabase extends HttpServlet { 
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static Connection connect = null;
  private static Statement statement = null;
  private static PreparedStatement preparedStatement = null;
  
  
  protected void connect_func() throws SQLException {
      if (connect == null || connect.isClosed()) {
          try {
              Class.forName("com.mysql.jdbc.Driver");
          } catch (ClassNotFoundException e) {
              throw new SQLException(e);
          }
	     // Setup the connection with the DB
	    	 connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useSSL=FALSE&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
System.out.println(connect);
	    	
      }
  }
  protected void disconnect() throws SQLException {
      if (connect != null && !connect.isClosed()) {
      	connect.close();
      }
  }
  
  
  
  public void build() throws SQLException {

    
	  connect_func();
      // Statements allow to issue SQL queries to the database  
      ///////////////////////////////////////////////////////////////////////Create Friends table
      statement = connect.createStatement();
      statement.executeUpdate("DROP TABLE IF EXISTS Friends");

      String sqlstmt = "CREATE TABLE IF NOT EXISTS Friends " +
                   "(User_UserID INT(6) UNSIGNED, " +
                   " FriendUserID INT(6) UNSIGNED, " +
                   " Favorite BOOLEAN NOT NULL)"; 
      statement.executeUpdate(sqlstmt);

      ////////////////////////////////////////////////////////////////////////Insert 12 tubles to Friends table
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "1");
      preparedStatement.setString(2, "2");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "2");
      preparedStatement.setString(2, "3");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "3");
      preparedStatement.setString(2, "4");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "4");
      preparedStatement.setString(2, "5");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "5");
      preparedStatement.setString(2, "6");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "6");
      preparedStatement.setString(2, "7");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "7");
      preparedStatement.setString(2, "8");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "8");
      preparedStatement.setString(2, "9");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "9");
      preparedStatement.setString(2, "10");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Friends(User_UserID, FriendUserID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "10");
      preparedStatement.setString(2, "1");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      
      //////////////////////////////////////////////////////////////////////ItemList table
      statement = connect.createStatement();
      statement.executeUpdate("DROP TABLE IF EXISTS itemList");

      sqlstmt = "CREATE TABLE IF NOT EXISTS itemList " +
                   "(User_UserID INT(6) UNSIGNED, " +
                   " Item_ItemID INT(6) UNSIGNED, " +
                   " Favorite BOOLEAN NOT NULL)"; 
      statement.executeUpdate(sqlstmt);
      /////////////////////////////////////////////////////////////////////////Insert 10 tubles to reviewList table
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "1");
      preparedStatement.setString(2, "1");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "2");
      preparedStatement.setString(2, "2");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "3");
      preparedStatement.setString(2, "3");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "4");
      preparedStatement.setString(2, "4");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "5");
      preparedStatement.setString(2, "5");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "6");
      preparedStatement.setString(2, "6");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "7");
      preparedStatement.setString(2, "7");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "8");
      preparedStatement.setString(2, "8");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "9");
      preparedStatement.setString(2, "9");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  itemList(User_UserID, Item_ItemID, Favorite) values (?, ?, ?)");
      preparedStatement.setString(1, "10");
      preparedStatement.setString(2, "10");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      //////////////////////////////////////////////////////////////////////////Blacklist table
      statement = connect.createStatement();
      statement.executeUpdate("DROP TABLE IF EXISTS Blacklist");

      sqlstmt = "CREATE TABLE IF NOT EXISTS Blacklist " +
                   "(User_UserID INT(6) UNSIGNED, " +
                   " Description TEXT NOT NULL, " +
                   " UnBaned BOOLEAN NOT NULL, " +
                   " Date TIMESTAMP)"; 
      statement.executeUpdate(sqlstmt);
      ////////////////////////////////////////////////////////////////Insert 10 tubles to Blacklist table
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "1");
      preparedStatement.setString(2, "Rude");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "2");
      preparedStatement.setString(2, "Harmful");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "3");
      preparedStatement.setString(2, "Racism");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "4");
      preparedStatement.setString(2, "Harmful sexual content.");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "5");
      preparedStatement.setString(2, "Bad behavior.");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "6");
      preparedStatement.setString(2, "Repeating same review.");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "7");
      preparedStatement.setString(2, "Copying other review.");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "8");
      preparedStatement.setString(2, "Making fun of other users.");
      preparedStatement.setString(3, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "9");
      preparedStatement.setString(2, "Hamrful metrial.");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Blacklist(User_UserID, Description, UnBaned) values (?, ?, ?)");
      preparedStatement.setString(1, "10");
      preparedStatement.setString(2, "Insulting review.");
      preparedStatement.setString(3, "1");
      preparedStatement.executeUpdate();
      /////////////////////////////////////////////////////////////////////////Reviews table
      statement = connect.createStatement();
      statement.executeUpdate("DROP TABLE IF EXISTS Reviews");

      sqlstmt = "CREATE TABLE IF NOT EXISTS Reviews " +
                   "(ReviewsID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, " +
                   " Item_ItemID INT(6) UNSIGNED, " + 
                   " User_UserID INT(6) UNSIGNED, " +
                   " Score VARCHAR(9) NOT NULL, " +
                   " ShortRemark TEXT NOT NULL, " +
                   " Date TIMESTAMP)"; 
      statement.executeUpdate(sqlstmt);
      ///////////////////////////////////////////////Insert 10 tubles to Reviews table
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "1");
      preparedStatement.setString(2, "1");
      preparedStatement.setString(3, "Excellent");
      preparedStatement.setString(4, "amazing review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "2");
      preparedStatement.setString(2, "2");
      preparedStatement.setString(3, "Good");
      preparedStatement.setString(4, "good review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "3");
      preparedStatement.setString(2, "3");
      preparedStatement.setString(3, "fair");
      preparedStatement.setString(4, "fair review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "4");
      preparedStatement.setString(2, "4");
      preparedStatement.setString(3, "Excellent");
      preparedStatement.setString(4, "amazing review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "5");
      preparedStatement.setString(2, "5");
      preparedStatement.setString(3, "Good");
      preparedStatement.setString(4, "good review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "6");
      preparedStatement.setString(2, "6");
      preparedStatement.setString(3, "fair");
      preparedStatement.setString(4, "fair review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "7");
      preparedStatement.setString(2, "7");
      preparedStatement.setString(3, "Excellent");
      preparedStatement.setString(4, "amazing review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "8");
      preparedStatement.setString(2, "8");
      preparedStatement.setString(3, "Good");
      preparedStatement.setString(4, "good review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "9");
      preparedStatement.setString(2, "9");
      preparedStatement.setString(3, "fair");
      preparedStatement.setString(4, "fair review");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
      preparedStatement.setString(1, "10");
      preparedStatement.setString(2, "10");
      preparedStatement.setString(3, "good");
      preparedStatement.setString(4, "good review");
      preparedStatement.executeUpdate();

      //////////////////////////////////////////////////////////////////item table
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      statement.executeUpdate("DROP TABLE IF EXISTS Item");

      sqlstmt = "CREATE TABLE IF NOT EXISTS Item " +
                   "(ItemID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, " +
                   " User_UserID INT(6) UNSIGNED, " + 
                   " Title TEXT NOT NULL, " +
                   " Description TEXT NOT NULL, " +
                   " Date TIMESTAMP, " +
                   " Tags VARCHAR(50))"; 
      statement.executeUpdate(sqlstmt);
      /////////////////////////////////////////////////////////////////////////Insert 10 tubles to review table
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "1");
      preparedStatement.setString(2, "Why did the chicked cross the road?");
      preparedStatement.setString(3, "Because she was hungry.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "2");
      preparedStatement.setString(2, "Why did the cow cross the road?");
      preparedStatement.setString(3, "Because she was thirsty.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "3");
      preparedStatement.setString(2, "Why did the professor get angry?");
      preparedStatement.setString(3, "Because I didn't do the homework.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "4");
      preparedStatement.setString(2, "Why the TA is happy?");
      preparedStatement.setString(3, "Because I didn't go to his office hours.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "5");
      preparedStatement.setString(2, "Why the university is expensive?");
      preparedStatement.setString(3, "Because they hire doctors.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "6");
      preparedStatement.setString(2, "Why shorter people shouldnt get muslcer?");
      preparedStatement.setString(3, "Because they will look shoter.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "7");
      preparedStatement.setString(2, "Why the student didn't come to class?");
      preparedStatement.setString(3, "Because the lecture is boring.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "8");
      preparedStatement.setString(2, "Why the fox cross the road?");
      preparedStatement.setString(3, "To catch the chicken.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "9");
      preparedStatement.setString(2, "Why the wolf cross the road?");
      preparedStatement.setString(3, "To catch the fox.");      
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
          .prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
      preparedStatement.setString(1, "10");
      preparedStatement.setString(2, "Why the bear cross the road?");
      preparedStatement.setString(3, "To catch the wolf.");      
      preparedStatement.executeUpdate();
      ////////////////////////////////////////////////////////////////User table
      statement = connect.createStatement();
      statement.executeUpdate("DROP TABLE IF EXISTS User");

      sqlstmt = "CREATE TABLE IF NOT EXISTS User " +
                   "(UserID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, " +
                   " Username VARCHAR(50) NOT NULL, " + 
                   " Password VARCHAR(50) NOT NULL, " + 
                   " FirstName VARCHAR(50) NOT NULL, " +
                   " LastName VARCHAR(50) NOT NULL, " +
                   " Email VARCHAR(50) NOT NULL, " +
                   " Gender VARCHAR(10) NOT NULL, " +
                   " Age INT(6) NOT NULL, " +
                   " Level BOOLEAN NOT NULL)"; 
      statement.executeUpdate(sqlstmt);
      
      /////////////////////////////////////////////////////////////////////////Insert 10 tubles to User table
      preparedStatement = connect
          .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Amanda John");
      preparedStatement.setString(2, "AmandaJohn");
      preparedStatement.setString(3, "Amanda");
      preparedStatement.setString(4, "John");
      preparedStatement.setString(5, "AmandaJohn@gmail.com");
      preparedStatement.setString(6, "female");
      preparedStatement.setString(7, "22");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Jessica Smith");
      preparedStatement.setString(2, "Jessica Smith");
      preparedStatement.setString(3, "Jessica");
      preparedStatement.setString(4, "Smith");
      preparedStatement.setString(5, "JessicaSmith@gmail.com");
      preparedStatement.setString(6, "female");
      preparedStatement.setString(7, "21");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "karim fares");
      preparedStatement.setString(2, "Karimfaress");
      preparedStatement.setString(3, "Karim");
      preparedStatement.setString(4, "Fares");
      preparedStatement.setString(5, "KarimFares@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "10");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "adelmohamed");
      preparedStatement.setString(2, "adel1999");
      preparedStatement.setString(3, "adel");
      preparedStatement.setString(4, "mohamed");
      preparedStatement.setString(5, "adelmohamed@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "19");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Mohammad Hamdan");
      preparedStatement.setString(2, "mohammadhamdan1");
      preparedStatement.setString(3, "Mohammad");
      preparedStatement.setString(4, "Hamdan");
      preparedStatement.setString(5, "mohammadhamdan@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "23");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Omar Amjad");
      preparedStatement.setString(2, "OmarAmjad13");
      preparedStatement.setString(3, "Omar");
      preparedStatement.setString(4, "Amjad");
      preparedStatement.setString(5, "OmarAmjad1995@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "20");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Hasan Ansari");
      preparedStatement.setString(2, "Hasan1999");
      preparedStatement.setString(3, "Hasan");
      preparedStatement.setString(4, "Ansari");
      preparedStatement.setString(5, "Hasanansari@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "29");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Monowar Omar");
      preparedStatement.setString(2, "MonowarOmar");
      preparedStatement.setString(3, "Monowar");
      preparedStatement.setString(4, "Omar");
      preparedStatement.setString(5, "monowaromar@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "19");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Khalid Smith");
      preparedStatement.setString(2, "khalid1990");
      preparedStatement.setString(3, "Khalid");
      preparedStatement.setString(4, "Smith");
      preparedStatement.setString(5, "KhalidSmith@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "30");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();
      
      preparedStatement = connect
    		  .prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, "Bob Smith");
      preparedStatement.setString(2, "bob1999");
      preparedStatement.setString(3, "bob");
      preparedStatement.setString(4, "Smith");
      preparedStatement.setString(5, "BobSmith@gmail.com");
      preparedStatement.setString(6, "male");
      preparedStatement.setString(7, "14");
      preparedStatement.setString(8, "0");
      preparedStatement.executeUpdate();



     


  }
} 
