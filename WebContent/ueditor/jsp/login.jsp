<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>随访系统登录</title>
    <link href="${ctx}/Content/css/jquery-ui-1.10.1.custom.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/Content/Scripts/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${ctx}/Content/Scripts/jquery-ui-1.11.2.js" type="text/javascript"></script>
    <script src="${ctx}/Content/Scripts/Ch-Pinyin.js" type="text/javascript"></script>
    <style type="text/css">
        body
        {
            background-image: url('${ctx}/Content/Images/ycbldydl.png');
            background-repeat: no-repeat;
            font-family: "Trebuchet MS" , "Helvetica" , "Arial" , "Verdana" , "sans-serif";
            font-size: 70%;
        }
        #logindiv
        {
            background-color: White;
            width: 380px;
            height: 300px;
            border: 1px solid #C7C7C7;
            margin-top: 50px;
            margin-left: 550px;
        }
        #logoimg
        {
            margin-top: 120px;
            width: 400px;
            margin-right: 400px;
        }
        #logbottom
        {
            width: 500px;
            margin-top: 40px;
            margin-left: 360px;
        }
        #rbllist
        {
            padding-left: 100px;
        }
        #btnsub
        {
            width:84px;
            height:31px;
            background-image:url(${ctx}/Content/Images/submit.png);
            background-repeat:no-repeat;
            border:0px;
            }
        #erMsg
        {
            color:Red;
            margin:3px;
            font-size:12px;
            }
        select
        {
            width:202px;
            }
            
            
        .custom-combobox
        {
            margin-left:0px;
            position: relative;
            display: inline-block;
        }
        
        .custom-combobox-toggle
        {
            position: absolute;
            top: 0;
            bottom: 0;
            margin-left: -1px;
            padding: 0;
        }
        
        .custom-combobox-input
        {
            margin: 0;
            padding: 3px 10px;
        }
        .ui-state-default
        {
            background: none;
        }
        .ui-menu-item
        {
            line-height: 20px;
        }
        #ui-id-1, #ui-id-2
        {
            width: 300px;
        }
    </style>

    <script  type="text/javascript">
    $(function () {
        $("input").keyup(function (event) {
            if (event.keyCode == 13) {
                $("#user_norLogin").click();
            }
        });
        
        orgselector();
        /*普通登录*/
        $("#user_norLogin").click(function () {
           	check();
        });
    });	
    function check() {
    	 var _userName = $("#userName").val();
         var _userPwd = $("#userPwd").val();
         if (_userName == undefined || _userName == null || _userName.length == 0) {
             alert("请输入用户名！");
             return false;
         }
         if (_userPwd == undefined || _userPwd == null ||_userPwd.length == 0) {
             alert("请输入密码！");
             return false;
         }
        return true;
    }
    </script>
    <script type="text/javascript">
        function SetErrorMsg(msg) {
            $("#erMsg").text(msg);
        }
    </script>
</head>
<body>
    <form id="formmain" method="post" action="dologin" onsubmit="return check()">
    <center>
        <div id="logbg">
            <div id="logoimg"  >
                <img alt="" src="${ctx}/Content/imgs/browser_model/logo_login.png" />
            </div>
            <div id="logindiv">
                <br />
                <img alt="" src="${ctx}/Content/Images/login.png" />
                <br />
                <br />
                <img alt="" src="${ctx}/Content/Images/line.png" />
                <br />
                <table style="font-size: 12px; line-height: 35px; margin: 8px 0 0;" cellpadding="0"
                    cellspacing="0">
                    <tr>
                        <td style="text-align: right; padding-right: 8px;">
                            用户名：
                        </td>
                        <td>
                            <input id="userName" class="new_user_name" name="userName" type="text" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right; padding-right: 8px;">
                            密 码：
                        </td>
                        <td>
                           <!--  <input type="password" id="txtpwd" name="password" style="border-width: 1px; border-color: #D1E3ED; width: 200px; height: 20px"/> -->
                        	<input id="userPwd" class="new_user_password" name="password" type="password" value=""/>
                        </td>
                    </tr>
                    <c:if test="${errMsg != null}">
                    <tr>
                       	<span style="font-size:12px;color:red">${errMsg}</span>
                    </tr>
                    </c:if>
                </table>
                <p id="erMsg"></p>              
                	<input type="submit" id="btnsub" value="" style="margin-left: 130px;margin-top: 10px" />
                
                <br />
                <br />
                <img alt="" src="${ctx}/Content/Images/line.png" />
              
            </div>
            <div id="logbottom">
                <div id="errDiv" style="float: left; color: Red;">
                </div>
                <div style="float: right; color: #626262; font-size: 12px;">
                    曼 荼 罗 软 件 有 限 公 司 
                </div>
            </div>
        </div>
    </center>
    </form>
        
</body>
</html>