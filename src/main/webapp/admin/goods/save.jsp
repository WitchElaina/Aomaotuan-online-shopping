<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'show.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	text-align: left;
}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>


  </head>
  
  <body>
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[基础数据管理]-[<a href="${pageContext.request.contextPath }/admin/goods/findbypage.do">商品管理</a>]-[保存新商品]</td>
              </tr>
            </table></td>
            <td width="54%">&nbsp;</td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td><!-- 新增商品表单 -->
        <form action="${pageContext.request.contextPath }/admin/goods/save.do" 
         method="post" name="savegoodsform" id="savegoodsform">
          <table width="400" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" >
            <tr>
              <td width="100%" colspan="2" height="19" align="right"  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1" style="color:red;">${requestScope.error }</span></div></td>
            </tr>
            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">商品名称：</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
                <input type="text" name="goodsName" id="goodsName">
              </span></div></td>
            </tr>
            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">商品价格：</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
                <input type="text" name="goodsPrice" id="goodsPrice">
              </span></div></td>
            </tr>
            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">商品数量：</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
                <input type="text" name="goodsNum" id="goodsNum">
              </span></div></td>
            </tr>
            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">商品类型：</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
                <select name="goodsType" id="goodsType">
                	<option value="类型编号">类型名称</option>
                </select>
              </span></div></td>
            </tr>
            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">商品图片：</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF">
                <div align="left">
                  <span class="STYLE1">
                    <%--文件上传需要文件域 type="file" --%>
                    <input type="file" id="file" name="file">
                    <%--需要一个文件上传的按钮   点击后调用文件上传的函数--%>
                    <input type="button" value="上传" onclick="ajaxFileUpload();">
                    <%--保存文件的名称到数据库  最好隐藏 type="hidden"--%>
                    <input type="hidden" id="goods_img" name="goods_img">
                    <%--上传成功后预览--%>
                    <div id="imgDiv">

                    </div>
                  </span>
                </div>
              </td>
            </tr>


            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">&nbsp;</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
                <input type="submit" value="保存" >
                </span>
                <input type="reset" name="button" id="button" value="重置">
              </div></td>
            </tr>
          </table>
        </form><!-- 新增商品表单 end--></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
  <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
  <script type="application/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
  <script>
    $(function () {
      $.ajax({
        url: "${pageContext.request.contextPath}/admin/goods/ajax.do",
        dataType: "json",
        success: function (result) {
          let msg = "";
          for(let goodsType in result) {
            // msg = msg + goodsType + " ";
            $("#goodsType").append("<option>"+result[goodsType]["type_name"]+"</option>>")
          }
          // alert(msg);
        }
      })
    })

    function ajaxFileUpload() {
      $.ajaxFileUpload({
        url : '${pageContext.request.contextPath}/upload.do',//用于文件上传的服务器端请求地址
        secureuri : false,//一般设置为false
        fileElementId : 'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
        dataType : 'json',//返回值类型 一般设置为json
        success : function(data, status){//服务器成功响应处理函数 status 如果成功为200   data为返回的json数据 文件的路径和文件的名称
          // create img object
          let imgObj = $("<img>");
          imgObj.attr("src", data.imgurl);
          $("#imgDiv").append(imgObj);
          $("#goods_img").val(data.imgname);
        },
        error: function (data, status, e){//服务器响应失败处理函数
          alert(status);
          alert(e);
        }
      });
    }

  </script>
</html>
