<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <title>Lets Explore Admin Managment System</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div id="wrapper">
        <div id="header">
            <div id="system-identity">
                <h1 class="system-name"><a href="/">LEAMS</a></h1>
                <span class="detailed-name"><a href="/">Lets Explore Admin Managment System</a></span>
            </div>
        </div>
        <div id="middle">
            <form action="HomeController" method="POST">
                <div id="login">
                    <div id="login-box-header">
                        <img id="Img1" src="images/users.gif" alt="login" />
                        <span>Please Login</span>
                    </div>
                    <div id="login-form">
                        <form action="HomeController" method="post">
                            <p>
                                <label>Username:</label>
                                <input type="text" id="name" name="username" required>
                            </p>
                            <p>
                                <label>Password:</label>
                                <input type="password" id="password" name="password" required>
                            </p>
                            <p id="login-button">
                                <input type="submit" name="btnLogin" value="Login">
                            </p>
                        </form>
                    </div>
                </div>
            </form>
        </div>
        <div id="footer">
            <span>Copy Right</span>
        </div>
    </div>
</body>

</html>