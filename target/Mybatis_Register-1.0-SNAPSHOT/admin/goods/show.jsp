<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: underline;
}
a:active {
	text-decoration: none;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[基础数据管理]-[商品管理]</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="cbox_all" id="cbox_all" />
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><A href="javascript:void(0)">新增</A></div></td>
                  </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/11.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><A href="javascript:void(0)">删除</A></div></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
   <!-- 多条件查询表单 -->
   <td height="50" align="left">
     <form action="${pageContext.request.contextPath}/admin/goods/showgoods.do" method="post">
       搜索 商品名称<input type="text" placeholder="输入商品名称..." name="goods_name"/>
       价格区间<input style="width: 40px"  type="text" name="goods_price_min"/>--<input style="width: 40px" type="text" name="goods_price_max"/>
       <select name="type_name">
         <c:forEach items="${goodsTypes}" var="item">
           <option>${item.type_name}</option>
         </c:forEach>
       </select>
       <input type="submit" value="Find..">
     </form>
   </td>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <!-- 商品显示 -->
        <td><span class="STYLE1">
        <!-- 多条件查询表单 -->
        <!-- 多条件查询表单 end-->
		</span>
		<form action="" name="deletesForm"  method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="3%" height="19" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center">
            </div></td>
            <td width="5%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td width="5%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">商品图片</span></div></td>
            <td width="5%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">商品编号</span></div></td>
            <td width="30%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">商品名称</span></div></td>
            <td width="10%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">商品价格</span></div></td>
            <td width="10%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">库存数量</span></div></td>
            <td width="10%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">商品类型</span></div></td>
            <td width="10%" height="19" background="images/bg.gif" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">基本操作</span></div></td>
          </tr>
          <c:forEach items="${goods}" var="item" varStatus="vst">
            <tr>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center">
                <input type="checkbox" name="goodsIds" id="goodsIds"/>
              </div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center" class="STYLE1">
                <div align="center">${vst.count}</div>
              </div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1"><img width="48px"  src="uploadimg/${item.goods_img}"></span></div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">${item.goods_id}</span></div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">${item.goods_name}</span></div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">${item.goods_price}</span></div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">${item.goods_num}</span></div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE1">${item.type_name}</span></div></td>
              <td height="20" bgcolor="#FFFFFF" nowrap="nowrap"><div align="center"><span class="STYLE4"><img src="images/edt.gif" width="16" height="16" /><A href="${pageContext.request.contextPath }/admin/goods/toupdate.do?goodsId=">编辑</A>&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" /><A href="javascript:void(0)">删除</A></span></div></td>
            </tr>
          </c:forEach>

        </table></form></td><!-- 商品显示 -->
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="images/tab_19.gif">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td>
        <!-- 分页控制 -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有${pageInfo.getTotal()}条记录，当前第${pageInfo.getPageNum()}/${pageInfo.getPages()}页</td>
            <td>
            <table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><A href="${pageContext.request.contextPath}/admin/goods/showgoods.do?currentPage=1"><img src="images/first.gif" width="37" height="15" /></A></td>
                  <td width="45">
                  <A href="${pageContext.request.contextPath}/admin/goods/showgoods.do?currentPage=${pageInfo.getPageNum()-1==0?1:pageInfo.getPageNum()-1}"><img src="images/back.gif" width="43" height="15" /></A>
                  </td>
                  <td width="45">
                  <A href="${pageContext.request.contextPath}/admin/goods/showgoods.do?currentPage=${pageInfo.getPageNum()==pageInfo.getPages()?pageInfo.getPages():pageInfo.getPageNum()+1}"><img src="images/next.gif" width="43" height="15" /></A>
                  </td>
                  <td width="40"><A href="${pageContext.request.contextPath}/admin/goods/showgoods.do?currentPage=${pageInfo.getPages()}"><img src="images/last.gif" width="37" height="15" /></A></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第<input name="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                    	页 </span></div></td>
                  <td width="40"><img src="images/go.gif" width="37" height="15" /></td>
                </tr>
            </table>
            </td>
          </tr>
        </table><!-- 分页控制 end-->
        </td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
  </body>
</html>
