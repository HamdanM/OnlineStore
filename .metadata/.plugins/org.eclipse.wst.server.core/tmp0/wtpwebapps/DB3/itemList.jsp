<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>People Management Application</title>
</head>
<body>
<a href="addITem.jsp">Add Item</a>
<a href="addReview.jsp">Add Review</a>
<a href="favlist.jsp">Favorite List</a>
<a href="itemReview.jsp">Item Review</a>
<a href="search.jsp">Search</a>
<a href="seller.jsp">Look at Sellers</a>

    <center>
        <h1>Item Management</h1>
        <h2>
            <a href="insert">Add New item</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All item</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>user ID</th>
                <th>Title</th>
                <th>Description</th>
          
            </tr>
            <c:forEach var="it" items="${itemsList}">
                <tr>
                    <td><c:out value="${it.title}" /></td>
                    <td><c:out value="${it.description}" /></td>
                    <td>
                                     <td>
                        <a href="edit?id=<c:out value='${it.itemid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${it.itemid}' />">Delete</a>                     
                    </td>        
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>