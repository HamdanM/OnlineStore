
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Items")
public class Items extends HttpServlet {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connect = null;
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
	  
	  public void insertItem(String username, String title, String description) throws SQLException {
	   
		  connect_func();
	   
	    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
	    	preparedStatement = connect
	    			.prepareStatement("insert into  Items(ItemID, Title, Description) values (?, ?, ?)");
	    	preparedStatement.setString(1, username);
	    	preparedStatement.setString(2, title);
	    	preparedStatement.setString(3, description);
	    	preparedStatement.executeUpdate();

	      
	  
	    ///////////////////////////////////////////////////////////////////////////////////////////////////
	  }
	  public Item searchItem(String title) throws ClassNotFoundException, SQLException {
		        Item item = null;
	  
		        connect_func();
			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    	preparedStatement = connect
			    			.prepareStatement("select User_userID, Title, Description, Date, Tags from Items where Title="+title+"");
			    	preparedStatement.setString(1, title);
			    	
			    	ResultSet resultSet = preparedStatement.executeQuery();
			    	
			    	  if (resultSet.next()) {
			              int itemid1 = resultSet.getInt("ItemID");
			              String Username = resultSet.getString("User_UserID");
			              String Title = resultSet.getString("Title");
			              String Description = resultSet.getString("Description");
			              String date= resultSet.getString("Date");
			              String tags =resultSet.getString("Tags");
			               
			              item = new Item(itemid1, Username, Title, Description, date, tags);
			          }

			      
			  
				return item;
			  }
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
		  
	  public List<Item> listItem() throws SQLException {
	        List<Item> itemsList = new ArrayList<Item>();
  
	
	        connect_func();
		    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
		    	preparedStatement = connect
		    			.prepareStatement("select * from Items");
		    
		    	ResultSet resultSet = preparedStatement.executeQuery();
		    	
		    	  while (resultSet.next()) {
		    		  int itemid1 = resultSet.getInt("Item");
		              String Username = "madeup";
		              String Title = resultSet.getString("Title");
		              String Description = resultSet.getString("Description");
		              String date= resultSet.getString("Date");
		              String tags =resultSet.getString("Tags");
		              
		              Item item =  new Item(itemid1, Username, Title, Description, date, tags);
		              itemsList.add(item); 
		          }

		    System.out.println(itemsList);
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
			return itemsList;
		  }

	  public boolean deleteItem(int itemid) throws ClassNotFoundException, SQLException {
		  String sql = "DELETE FROM Items WHERE Itemid = ?";        

		  connect_func();
	    
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setInt(1, itemid);
	         
	        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
//	        disconnect();
	        return rowDeleted;  
	  }
	  public boolean update(Item item) throws SQLException {
	        String sql = "update Items set User_UserID = ?, Title = ?, Description = ?, Date = ?, Tags = ? where ItemID="+item.ItemID+"";
			  connect_func();

	     
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setString(1, item.User_UserID);
	        preparedStatement.setString(2, item.Title);
	        preparedStatement.setString(3, item.Description);
	        preparedStatement.setString(4, item.Date);
	        preparedStatement.setString(5, item.Tags);
	         
	        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
//	        disconnect();
	        return rowUpdated;     
	    }
	  
}

