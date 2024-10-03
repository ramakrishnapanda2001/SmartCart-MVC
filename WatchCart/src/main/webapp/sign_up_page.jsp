<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up page</title>
    <link rel="stylesheet" href="style.css">
    <link
     rel="stylesheet"
     href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.19/css/intlTelInput.css"/>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.19/js/intlTelInput.min.js"></script>
</head>
<body>
    <div class="container">
        <form action="RegisterServlet" class="form" method="post">
            <h2>REGISTER HERE</h2>
            <input id="rname" type="text" name="name" class="box" placeholder="Enter Your Name">
            <input id="rmail" type="email" name="email" class="box" placeholder="Enter Your Email">
       		<input id="phone" type="text" name="phone" class="box" placeholder="Enter Your Contact">
            <input id="password" type="password" name="password" class="box" placeholder="Enter Your Password">
           	<textarea rows="4" cols="50" id="addressbox" name="addressbox" placeholder="Enter your address here.."></textarea>
            <input id="signuphandler" type="submit" class="btn" value="REGISTER">
            <%
	            String message = (String)request.getAttribute("message");
	    		if(message!=null){
	    			out.println(message);
	    		}
            %>
        </form>
        <div class="side">
            <img src="assets/ecommerce_login_image.png" alt="ecommerce img">
        </div>
    </div>
   <!--  code for adding country code -->
    <script type="text/javascript">
	    var input = document.querySelector("#phone");
	
	    window.intlTelInput(input,({
	    	 utilsScript:
	    	       "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.19/js/utils.min.js",
	    }));    
    </script>
</body>
</html>