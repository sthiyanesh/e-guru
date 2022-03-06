<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <html>

    <head>
        <title>E Guru</title>
        <link rel="stylesheet" href="/css/desktop15i.css" type="text/css" />
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
                function openNav() {
                    document.getElementById("mySidenav").style.width = "250px";
                }

                function closeNav() {
                    document.getElementById("mySidenav").style.width = "0";
                }

                function load(s) {
                    console.log(jsonObject);
                }
            </script>
    </head>

    <body style="background-color: #D9FAFFBF;">
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
        <div id="mySidenav" class="sidenav">
            <a id="close" href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <c:forEach items="${a}" var="k">
                <form id="${k}" action="/coursecontent" method="post">
                    <input type="hidden" name="courseid" value="${cr.courseid}" />
                    <input type="hidden" name="topic" value="${k}" />
                    <h2 id="submitter"><a id="submitting" href="javascript:{}" onclick="document.getElementById('${k}').submit();">${k}</a></h2>
                </form>
            </c:forEach>
        </div>
        <h2 id="mainhead">${cr.name}</h2>
        <div style="display:flex;">
            <div class="part1">
                <c:forEach items="${a}" var="k">
                    <form id="${k}" action="/coursecontent" method="post">
                        <input type="hidden" name="courseid" value="${cr.courseid}" />
                        <input type="hidden" name="topic" value="${k}" />
                        <h2 id="submitter"><a id="submittng" href="javascript:{}" onclick="document.getElementById('${k}').submit();">${k}</a></h2>
                    </form>
                </c:forEach>
            </div>
            <div class="part2">
                <span id="hammenu" onclick="openNav()">&#9776; Video List</span>
                <h4>${d}</h4>
                <div><iframe id="video" src="${e}"></iframe></div>
                <p id="intro">${f}</p>
            </div>
        </div>
    </body>

    </html>