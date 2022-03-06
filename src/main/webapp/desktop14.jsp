<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <html>

    <head>
        <title>E Guru</title>
        <link rel="stylesheet" href="/css/desktop14.css" />
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
            <img id="profile" onclick="fun()" src="https://drive.google.com/uc?export=view&id=${stud.profileimg}"
                alt="Profile Not Found" />
            <h2 id="cname">E Guru</h2>
        </div>
        <div class="menu" id="menu">
            <h2><a href="/viewenrolledcourse">View Enrolled Courses</a></h2>
            <h2><a href="desktop2.html">Explore Courses</a></h2>
            <h2><a href="/editprofile">Edit Profile</a></h2>
            <h2><a href="/logout">Logout</a></h2>
        </div>
        <h2 id="mainhead">${cr.name}</h2>
        <iframe id="video" src="${cr.introvideo}"></iframe><br><br>
        <div style="text-align: center;">
            <form action="/coursereg" method="post">
                <input type="hidden" name="courseid" value="${cr.courseid}" />
                <input id="join" type="submit" value="Join Course" />
            </form>
        </div>
        <h4 id="name">${cr.guruname}</h4>
        <div style="display:flex;flex-wrap: wrap;justify-content:space-around">
            <img src="https://drive.google.com/uc?export=view&id=${sir.profileimg}" id="pro" alt="img not found" />
            <div class="block1">
                <p id="heading">About Guru:</p>
                <p id="intro"></p>${sir.headline}</p>
            </div>
            <div class="block1">
                <p id="heading">Course Intro:</p>
                <p id="intro"></p>${cr.description}</p>
            </div>
        </div>
    </body>

    </html>