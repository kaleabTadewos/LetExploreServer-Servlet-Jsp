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
                <form action="tourguidecontroller" method="POST" enctype="multipart/form-data">
                    <label for="fname">Tour Guide Name</label>
                    <input type="text" id="tourGuideName" name="tourGuideName" placeholder="Enter tour guide name" required>

                    <label for="lname">Address</label><br>
                    <div class="form-group"> 
                        <label for="street">Street</label>
                        <input type="text" id="street" name="street" placeholder="Enter street name" required>
                        <label for="fname">State</label>
                            <select id="state" name="state" required>
                                <option value="">Select...</option>
                                <option value="Iowa">Iowa</option>
                                <option value="Colorado">Colorado</option>
                                <option value="NewJersey">New Jersey</option>
                            </select>
                        <label for="city">City</label>
                            <select id="city" name="city" required>
                                <option value="">Select...</option>
                                <option value="FairField">FairField</option>
                                <option value="Chicago">Chicago</option>
                                <option value="NewYork">New York</option>
                            </select>
                        <label for="fname">ZIP</label>
                        <input type="text" id="zip" name="zip" placeholder="Enter zip code" required pattern="[0-9]{5}">
                    </div>

                    <label for="phoneNo">Phone #</label>
                    <input type="text" id="phoneNo" name="phoneNo" placeholder="e.g. +x-xxx-xxx-xxxx" required pattern="+?[0-9]{1}\-[0-9]{3}\-[0-9]{3}\-[0-9]{4}">
                    
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email" placeholder="e.g. useremail.gmail.com" required pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$">

                    <label for="email">Website</label>
                    <input type="text" id="website" name="website" placeholder="Enter tour guide website" required pattern="https?://.+" title="Include http:// or https:// ">

                    <label for="img">Select Logo Image</label><br>
                    <!-- onchange="displaySelectImage(this)" -->
                    <input type="file" id="img" name="img" accept="image/*" style="padding-top: 0.5em;">

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