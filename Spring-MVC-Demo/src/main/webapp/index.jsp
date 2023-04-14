<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index of the Spring MVC Demo</title>
    <meta charset="UTF-8">
    <%--<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.6.0.min.js"></script>--%>
    <script src="resources/js/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="resources/css/index.css">
    <%
        String curPageUrl = request.getRequestURI();
//        curPageUrl = curPageUrl.substring(curPageUrl.lastIndexOf("/") + 1);

        String path = request.getContextPath();
        String basePath = path + "/";
        String serverName = request.getServerName();
        String serverPort = request.getServerPort() + "";
        String schema = request.getScheme();
    %>
</head>
<body>
<h2 style="text-align: center;">Hello World!</h2>
<div class="index-center" style="height: 120px;text-align: center;">
    <button onclick="getMessage()">click and get a message</button>
    <%--border-style: solid;border-width: 2px;border-color: gray;--%>
    <p id="message"
       style="border: solid 2px gray;border-radius: 5px;visibility: hidden;white-space: pre-line;"></p>
</div>
<div class="index-center" id="demo-indexes"
     style="height: 200px;/*border: solid 2px gray;border-radius: 10px;*/">
    <button id="demo-btn1" onclick="gotoNewPage('demo')">go to demo page</button>
</div>
</body>
<script type="text/javascript">
    let basePath = "";

    $(document).ready(function () {
        // console.log(window.location.href);
        // basePath = window.location.protocol + "//" + window.location.host + window.location.pathname;
        // basePath = window.location.origin + window.location.pathname;
        basePath = "<%=basePath%>";
        console.log("index", basePath);
    });

    /**
     * AJAX请求获取信息
     */
    function getMessage() {
        let date = new Date();
        $.ajax(
            //url
            "<%=basePath%>" + "index/getMessage",
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

    /**
     * 页面跳转
     * @param path
     */
    function gotoNewPage(path) {
        window.location.assign("<%=basePath%>" + path);
    }
</script>
</html>
