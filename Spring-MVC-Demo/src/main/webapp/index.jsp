<html>
<head>
    <title>index of the Spring MVC Demo</title>
    <meta charset="UTF-8">
    <%--<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.6.0.min.js"></script>--%>
    <script src="resources/js/jquery-3.6.4.min.js"></script>
</head>
<body>
<h2 style="text-align: center;">Hello World!</h2>
<div style="width:60%;height: 100px;margin: auto;text-align: center;">
    <button onclick="getMessage()">click and get a message</button>
    <p id="message" style="border: solid 2px gray;border-radius: 5px;visibility: hidden;white-space: pre-line;"></p><%--border-style: solid;border-width: 2px;border-color: gray;--%>
</div>
</body>
<script type="text/javascript">
    /**
     * AJAX请求获取信息
     */
    function getMessage() {
        let date = new Date();
        $.ajax(
            //url
            "index/getMessage",
            //settings
            {
                type: "POST",
                data: {"time": date.toString()},
                success: function (data) {
                    $("#message").text(data.data.msg).css("visibility", "visible");
                },
                error: function (data) {

                }
            }
        );
    }
</script>
</html>
