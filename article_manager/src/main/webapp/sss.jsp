<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/18
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
    <head>
        <title>Title</title>
    </head>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/layui/layui.all.js"></script>
    <body>

        <input type="text" onblur="return checkName()">


        <script>
            function checkName(){
                var a_name2 = $("#a_name").val();

                if(a_name2 != ''){
                    alert(a_name2);return;
                    $.ajax({

                        url: '/admin/findByName.do',
                        type: 'post',
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify({"a_name": a_name2 }),
                        dataType: 'json',
                        success: function(data){
                            ${data}
                            if(data == null){
                                $("#info").text("可以注册").css({'color':'green','font-size':'1px'});
                                return true;
                            }
                            if(data != null){
                                $("#info").text("该用户名已注册").css({'color':'red','font-size':'1px'});
                                return false;
                            }
                        },
                        // error: function(){
                        //     alert("错误");
                        //     return false;
                        // }
                    });
                }
                if(a_name == ''){
                    $("#info").text("");
                }
            }
        </script>
    </body>
</html>
