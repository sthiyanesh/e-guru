<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <html>

    <head>
        <title>E Guru</title>
        <link rel="stylesheet" href="/css/desktop11.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <script>
                var a = false;
                function fun() {
                    if (a == true) {
                        a = false;
                        var x = document.getElementById("menu");
                        x.style.display = 'none';
                    } else {
                        a = true;
                        var x = document.getElementById("menu");
                        x.style.display = 'block';
                    }
                }
            </script>
    </head>

    <body style="background-color: #D9FAFFBF;align-items: center;">
        <div class="header">
            <img id="logo" src="logo.jpg" alt="Logo Not Found" />
            <img id="profile" onclick="fun()" src="https://drive.google.com/uc?export=view&id=${sir.profileimg}" alt="Profile Not Found" />
            <h2 id="cname">E Guru</h2>
        </div>
        <div class="menu" id="menu">
            <h2><a href="/createcourse">Create New Course</a></h2>
            <h2><a href="/createdcourses">Edit Created Courses</a></h2>
            <h2><a href="/editguruprofile">Edit Profile</a></h2>
            <h2><a href="/gurulogout">Logout</a></h2>
        </div>
        <h2 id="wel">Welcome ${sir.name}</h2>
        <h4 id="head1">Create Course</h4>
        <div class="box1">
            <a href="/createcourse">
                <div class="card1">
                    <img src="plus.png" id="plus" alt="img not found">
                </div>
            </a>
        </div>
        <h4 id="head1">Edit Your Courses...</h4>
        <div class="box1">
            <c:forEach items="${crs}" var="cr">
                <div class="card">
                    <img id="crimg" src="cr pro.jpg" alt="img not found" />
                    <h2>${cr.name}</h2>
                    <h3>${cr.guruname}</h3><br>
                    <form action="/editcourse" method="post">
                        <input type="hidden" name="courseid" value="${cr.courseid}" />
                        <input id="submitting" style="cursor:pointer" type="submit" value="Edit Course" />
                    </form>
                </div>
            </c:forEach>
        </div>
    </body>

    </html>