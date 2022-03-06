<html>

<head>
    <script type="text/javascript">

        $(document).ready(function () {
            var countDownDate = new Date().getTime() + 6000;
            var x = setInterval(function () {
                    var now = new Date().getTime();
                    var distance = countDownDate - now;
                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                    if (distance < 0) {
                        clearInterval(x);
                    }
                }, 1000);
            document.getElementById("myRedirectForm").submit();
        });

    </script>
</head>

<body>
    <form id="myRedirectForm" action="/studhome" method="post">
        <input name="uname" type="hidden" value="${stud.username}" />
        <input name="pass" type="hidden" value="${stud.password}" />
        <noscript>
            <input type="submit" value="Click here to continue" />
        </noscript>
    </form>
    <h2>Profile Updated Successfully.</h2>
    <h3>Redirecting to Home Page...</h3>
    <h4>Please Wait....</h4>
</body>

</html>