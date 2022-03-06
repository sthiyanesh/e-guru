<html>
    <head>
        <title>E Guru</title>
        <link rel="stylesheet" href="css/desktop3.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body style="background-color: #D9FAFFBF;">
        <div class="header">
            <img id="logo" src="logo.jpg" alt="Logo Not Found" />
            <h2 id="cname">E Guru</h2>
        </div>
        <div class="mainbox">
            <h2 id="loghead">${heading}</h2>
            <form action="/studverifymail" method="post" style="text-align: center;">
                <label id="email">Enter Email ID</label><br>
                <input type="email" id="box1" name="email" /><br><br>
                <input type="submit" style="cursor: pointer;" id="submit" value="Send OTP" />
            </form>
        </div>
    </body>
</html>