<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>视频管理系统</title>
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="../easyui/themes/gray/easyui.css" ></link>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/portal.css">
<link rel="stylesheet" type="text/css" href="../css/common.css">
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery.portal.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/jeasyui.common.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"
	charset="utf-8"></script>
<script>
	/* 查询 */
	function logoutFun() {
		window.location.href="../index.jsp";
	}
</script>
</head>
<body class="easyui-layout">
	<noscript>
		<div
			style="position:absolute; z-index:100000; height:246px;top:0px;left:0px; width:100%; background:white; text-align:center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div data-options="region:'north',border:false"
		style="height:60px;background:#fff;padding:0px">
		<div class="site_title">电视门户视频管理系统</div>
		<div id="sessionInfoDiv"
			style="position: absolute;right: 5px;top:10px;">
			尊敬的 [<strong>${sessionScope.username}</strong>]，欢迎您使用本系统！
		</div>
		<div style="position: absolute; right: 0px; bottom: 0px; ">
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_zxMenu',iconCls:'icon-back'">注销</a>
		</div>
		<div id="layout_north_pfMenu" style="width: 120px; display: none;">
			<div onclick="changeTheme('default');">default</div>
			<div onclick="changeTheme('gray');">gray</div>
			<div onclick="changeTheme('metro');">metro</div>
			<div onclick="changeTheme('cupertino');">cupertino</div>
			<div onclick="changeTheme('dark-hive');">dark-hive</div>
			<div onclick="changeTheme('pepper-grinder');">pepper-grinder</div>
			<div onclick="changeTheme('sunny');">sunny</div>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="userInfoFun();">个人信息</div>
			<div onclick="userInfoFun();">退出登录</div>
		</div>
		<div id="layout_north_zxMenu" style="width: 100px; display: none;">
			<div onclick="logoutFun();">重新登录</div>
			<div onclick="logoutFun();">退出系统</div>
		</div>


	</div>
	<div data-options="region:'west',split:true,title:'导航菜单'"
		style="width:200px;height:500px;" split="true">
		<div class="easyui-accordion sider"
			data-options="fit:true,border:false">
			<!--//左侧菜单导航-->
			<!--waiceng-->
			<div title="视频管理模块" data-options="iconCls:'icon-mini-add'"
				style="padding:10px;">
				<ul class="easyui-tree" data-options="animate:true">
					<li data-options="state:'closed'"><span>已注入视频</span>
						<ul>
							<li><a href="javascript:viod(0);" cmshref="../videolist/goToVideoTab"
								type="member_perinfo" rel="">视频列表</a></li>
						</ul></li>
			</div>
			<!--waiceng-->
			<!--
			<div title="商家中心" data-options="iconCls:'icon-mini-add'"
				style="padding:10px;">
				<ul class="easyui-tree" data-options="animate:true">
					<li data-options="state:'closed'"><span>商家管理</span>
						<ul>
							<li><a href="javascript:viod(0);" cmshref="shop/shop.action"
								type="member_perinfo" rel="">商家管理</a></li>
							<li><a href="javascript:viod(0);"
								cmshref="shop/shopCategory.action" type="member_perinfo" rel="">类别管理</a></li>
						</ul></li>
			</div>
			-->
			<!--//左侧菜单导航-->
		</div>
		<!--accordion-->

	</div>
	<!--west-->
	<div data-options="region:'south',border:false"
		style="height:50px;background:#fff;padding:10px;">
		<div id="footer">
			Copyright &copy; 2018 by hellozw.<br> All Rights Reserved<br>
		</div>
	</div>
	<!--//主体内容部分-->
	<div data-options="region:'center'" class="indexcenter"
		title="视频管理模块">
		<div id="tabs_index" class="easyui-tabs" fit="true" border="false">
			<div title="首页" style="overflow:hidden; "></div>
		</div>
	</div>
	<!--center-->
	<!--//主体内容部分-->
	<div id="dialog_cms" data-options="iconCls:'icon-save'"></div>
</body>
</html>