<html>

<head>
    <title>E Guru</title>
    <link rel="stylesheet" href="/css/desktop7.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            if (window.location.href.indexOf("wrongcredential") > -1) {
                alert("Incorrect OTP");
                clearInterval(x);
                document.getElementById("clock").innerHTML = "0:00";
                var a = document.getElementById("link");
                a.style.pointerEvents = 'auto';
                a.style.opacity = '100%';
            } else {
                var countDownDate = new Date().getTime() + 60000;
                var x = setInterval(function () {
                    var now = new Date().getTime();
                    var distance = countDownDate - now;
                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                    document.getElementById("clock").innerHTML = "0:" + seconds;
                    if (distance < 0) {
                        clearInterval(x);
                        document.getElementById("clock").innerHTML = "0:00";
                        var a = document.getElementById("link");
                        a.style.pointerEvents = 'auto';
                        a.style.opacity = '100%';
                    }
                }, 1000);
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
        <h2 id="loghead">${heading}</h2>
        <form action="/guruprofile" method="post" style="text-align: center;">
            <label id="otp">Enter OTP</label><br>
            <input type="text" id="box1" name="otp" />
            <p id="clock"></p>
            <a id="link" href="/guruverifymail?email=${email}" style="pointer-events: none;color:blue;opacity: 50%;">yet not received?
                resend otp</a><br><br>
            <input type="submit" style="cursor:pointer" id="submit" value="Verify OTP" />
        </form>
    </div>
</body>

</html>