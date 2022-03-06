<html>

<head>
    <title>E Guru</title>
    <link rel="stylesheet" href="css/desktop5.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            if (window.location.href.indexOf("wrongcredential") > -1) {
                alert("Username or password is incorrect");
            }
        });
    </script>
</head>

<body style="background-color: #D9FAFFBF;">
    <div class="header">
        <img id="logo" src="logo.jpg" alt="Logo Not Found" />
        <h2 id="cname">E Guru</h2>
    </div>
    <div class="mainbox">
        <h2 id="loghead">Guru Login</h2>
        <form action="/guruhome" method="post" style="text-align: center;">
            <label id="uname">Username</label><br>
            <input type="text" id="box1" name="uname" /><br><br>
            <label id="pass">Password</label><br>
            <input type="password" id="box2" name="pass" /><br><br>
            <input type="submit" style="cursor:pointer;" id="submit" value="Login Here" />
        </form>
        <a id="forgot" href="/guruforgotpassword">Forgot Password?</a><br><br>
    </div>
</body>

</html>