<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Lets Explore Admin Managment System</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/form.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div id="wrapper">
        <div id="header">
            <div id="system-identity">
                <h1 class="system-name"><a href="/">LEAMS</a></h1>
                <span class="detailed-name"><a href="/">Lets Explore Admin Managment System</a></span>
            </div>
        </div>
        <div id="login-status">
            <span>Admin</span> |
            <a href="HomeController">Logout</a>
        </div>
        <div id="middle">
            <div id="sidebar-left">
                <div id="orgLinks" class="module-box">
                    <span>Tour Management</span>
                    <ul>
                        <li><a href="tourlocationcontroller">Tour Location</a></li>
                        <li><a href="tourguidecontroller">Tour Guides</a></li>
                        <li><a href="newscontroller">News</a></li>
                    </ul>
                </div>
                <div id="recLinks" class="module-box">
                    <span>User Managment</span>
                    <ul>
                        <li><a href="usercontroller">User Account</a></li>
                    </ul>
                </div>
                <div id="orgLinks" class="module-box">
                    <span>Look Up</span>
                    <ul>
                        <li><a href="tourlocationcontrollerlist">Tour Location List</a></li>
                        <li><a href="tourguidecontrollerlist">Tour Guides List</a></li>
                        <li><a href="newscontrollerlist">News List</a></li>
                    </ul>
                </div>
            </div>
            <div id="content">
                <table>
                	<thead>
                		<tr>
                			<th>#</th>
                			<th>Name</th>
                			<th>Transportation</th>
                			<th>Image</th>
                		</tr>
                	</thead>
                	<tbody>
                		<c:forEach var="tourlocationlist" items="${tourLocations}" varStatus="iteration">
                			<tr>
                				<th scope="row"><c:out value="${iteration.index+1}"></c:out>.</th>
		                        <td><c:out value="${tourlocationlist.name}"></c:out></td>
		                        <td><c:out value="${tourlocationlist.transportation}"></c:out></td>
		                        <td><img src=" <c:out value="${tourlocationlist.imgPath}"></c:out>"  /></td>
                			</tr>
                		</c:forEach>
                	</tbody>
                </table>
            </div>
            <div class="clear">&nbsp;</div>
        </div>
        <div id="footer">
            <span>Copy Right</span>
        </div>
    </div>
</body>

</html>