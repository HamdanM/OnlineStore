import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Connection connect = null;
	  private static PreparedStatement preparedStatement = null;
	
	private Users user;
    private Reviews review;
    private Items item;
    private InitializeDatabase initDB;
	private Register register;

    /**
     * @see HttpServlet#HttpServlet()
     */
   
   public void init() {
	   user = new Users();
	   item = new Items();
	   initDB = new InitializeDatabase();
	   register = new Register();
	   review = new Reviews();
   }
   
   protected void connect_func() throws SQLException, ClassNotFoundException {
       if (connect == null || connect.isClosed()) {
           try {
               Class.forName("com.mysql.jdbc.Driver");
           } catch (ClassNotFoundException e) {
               throw new SQLException(e);
           }
           // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.jdbc.Driver");
	        // Setup the connection with the DB
	     // Setup the connection with the DB
	    	 connect = (Connection) DriverManager
   			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useSSL=FALSE&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
 System.out.println(connect);
	    	
       }
   }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.err.close();
	        System.setErr(System.out);
		String action = request.getServletPath();
		System.out.println(action);
		String name = request.getParameter("username");
		System.out.println(name);
		System.out.println("we are linked");
		try {
			switch (action) {
			case "/build":
				System.out.println("we are inside build");
				buildDatabase(request, response);
				break;
			case "/login":
				System.out.println("we are inside login");
				loginUser(request, response);
				break;
			case "/register":
				System.out.println("we are inside register");
				registerUser(request, response);
				break;
			case "/search":
				System.out.println("we are inside search ");
				searchItem(request, response);
				break;
			case "/insertitem":
				System.out.println("we are inside insertItem");
				insertItem(request, response);
				break;
			case "/insertreview":
				System.out.println("we are inside insertReview");
				insertReview(request, response);
				break;
			case "/sellers":
				System.out.println("we are inside sellers");
				sellers(request, response);
				break;
			case "/list":
				System.out.println("we are inside list");
				listItems(request, response);
				break;
				
			default:
				System.out.println("Error 404");
				break;
			}
		}
		catch (SQLException ex) { 
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	protected void buildDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		initDB.build();
		
		System.out.println("We are linked");
		RequestDispatcher dispatcher = request.getRequestDispatcher("initializeDatabase.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}
	
	protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		boolean found = false;
		Login login = new Login();
		System.out.println("We are linked");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		found = login.login(username, password);
		System.out.println(found);
		response.sendRedirect("login.jsp");
		request.setAttribute("found", found);

		RequestDispatcher dispatcher = request.getRequestDispatcher("jfunny.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());		
	}

	protected void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		System.out.println("We are linked");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String firstname = request.getParameter("FirstName");
		String lastname = request.getParameter("LastName");
		String email = request.getParameter("Email");
		String gender = request.getParameter("Gender");
		String age = request.getParameter("Age");
		register.register(username, password, firstname, lastname, email, gender, age);
		request.setAttribute("register", register);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}
	
	
	protected void searchItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
	
		String username = request.getParameter("Username");
		String title = request.getParameter("Title");
		String description = request.getParameter("Description");
		
		item.insertItem(username, title, description);
		
		request.setAttribute("item", item );
		RequestDispatcher dispatcher = request.getRequestDispatcher("itemList.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void insertItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		

		String searchitem = request.getParameter("item");
		
		item.searchItem(searchitem);
		
		request.setAttribute("item", item );
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}
	
protected void insertReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
	String itemID = request.getParameter("ItemID");
	String userid = request.getParameter("User_UserID");
	String score = request.getParameter("Score");
	String shortremark = request.getParameter("ShortRemark");
		
    connect_func();

	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
	preparedStatement = connect
			.prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
	preparedStatement.setString(1, itemID);
	preparedStatement.setString(2, userid);
	preparedStatement.setString(3, score);
	preparedStatement.setString(4, shortremark);
	preparedStatement.executeUpdate();
	
	request.setAttribute("review", review );
	RequestDispatcher dispatcher = request.getRequestDispatcher("addReview.jsp");
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
protected void sellers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	List<User> usersList = user.listUsers();
    request.setAttribute("usersList", usersList);       
	RequestDispatcher dispatcher = request.getRequestDispatcher("seller.jsp");
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	
}
protected void listItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
	
	
	List<Item> itemsList=item.listItem();
	request.setAttribute("itemsList", itemsList);
	RequestDispatcher dispatcher = request.getRequestDispatcher("itemList.jsp");
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		InitializeDatabase build = new InitializeDatabase();
		
	}

}