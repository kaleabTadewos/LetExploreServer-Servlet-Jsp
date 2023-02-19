<html>

<head>
    <title>Lets Explore Admin Managment System</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/form.css" rel="stylesheet" type="text/css" />
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
                <form action="newscontroller" method="POST" enctype="multipart/form-data">
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" placeholder="Enter news title" required>

                    <label for="img">Select Image of News</label><br>
                    <!-- onchange="displaySelectImage(this)" -->
                    <input type="file" id="img" name="img" accept="image/*" style="padding-top: 0.5em;"><br><br>

                    <label for="description">Description</label><br>
                    <textarea id="description" name="description" cols="75" rows="5" placeholder="Enter description of news" required></textarea>

                    <input type="submit" value="Submit">
                </form>
            </div>
            <div class="clear">&nbsp;</div>
        </div>
        <div id="footer">
            <span>Copy Right</span>
        </div>
    </div>
</body>

</html>