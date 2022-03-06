<html>

<head>
    <title>E Guru</title>
    <link rel="stylesheet" href="/css/desktop8.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>
        function fun() {
            let x = document.getElementById("pass").value;
            let y = document.getElementById("cpass").value;
            if (x == y) {
                return true;
            } else {
                alert("Password and Confirm password doesn't match");
                return false;
            }
        }
    </script>
</head>

<body style="background-color: #D9FAFFBF;align-items: center;">
    <div class="header">
        <img id="logo" src="logo.jpg" alt="Logo Not Found" />
        <h2 id="cname">E Guru</h2>
    </div>
    <h2 id="mainhead">Student Profile</h2>
    <form name="1" action="/studsaveprofile" method="post" onsubmit="return fun()">
        <div class="box">
            <div class="set1">
                <Label>Name:</Label>
                <input id="name" type="text" name="name" value="${stud.name}" /><br><br>
                <label>Username:</label>
                <input id="uname" type="text" name="uname" value="${stud.username}" /><br><br>
                <label>Email ID:</label>
                <input id="email" type="email" name="email" value="${stud.emailid}" readonly="readonly" /><br><br>
                <label>Password:</label>
                <input id="pass" type="password" name="pass" value="${stud.password}" /><br><br>
                <label>Confirm Password:</label>
                <input id="cpass" type="password" name="cpass" value="${stud.password}" /><br><br>
            </div>
            <div class="set2">
                <Label>Headline:</Label>
                <input id="hline" type="text" name="hline" value="${stud.headline}" /><br><br>
                <label>Profile Image(url):</label>
                <input id="imgurl" type="text" name="imgurl" value="${stud.profileimg}" /><br><br>
                <label>LinkedIn(url):</label>
                <input id="linkedin" type="url" name="linkedin" value="${stud.linkedin}" /><br><br>
                <label>Github(url):</label>
                <input id="github" type="url" name="github" value="${stud.github}" /><br><br>
            </div>
        </div>
        <div style="text-align: center;">
            <input id="save" type="submit" value="save profile" />
        </div>
    </form>
</body>

</html>