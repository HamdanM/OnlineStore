<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
</head>
<body>
<div id="Login" class="tab">
    <h1>Log In</h1>
</div>
    <form action="login"
          method="post">
        <input type="hidden" name="action" value="addToMailingList" >
        <p style="color:green"><label>Username: <input
                    type="text" name="username"
                    size="70" maxlength="70" />
            </label></p>
        <p style="color:red"><label>Password: <input
                    type="password" name="password"
                    size="70" maxlength="70" />
            </label></p>

        <p style="color:orange"><input style="height:120px;width:225px" type=
        "submit" name="submit" value=
        "Submit" /></p>			
    </form>
      <form action="register.jsp"
          method="post" class="tab">
        <p style="color:orange"><input style="height:120px;width:225px" type=
        "submit" name="submit" value=
        "Register" /></p>
</form>

</body>
</html>
