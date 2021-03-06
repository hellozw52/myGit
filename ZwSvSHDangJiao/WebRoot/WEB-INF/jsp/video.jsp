<%@ page language="java" pageEncoding="utf-8"%>
<script>
	/* 查询 */
	function doSearch() {

		/* 获取参数值 */
		var videoId = $('#videoId').val();
		var assetId = $('#assetId').val();
		var assetName = $('#assetName').val();

		/* 三个参数只要有一个不为空，就查询结果 */
		if (videoId||assetId||assetName) {
			$('#dg_video').datagrid('options').url = '../videolist/getVideoInfoManyPara';
			$('#dg_video').datagrid('load', {
				videoId : videoId,
				assetId : assetId,
				assetName : assetName
			});
			/* 所有参数均为空，默认查询第1页结果 */
		} else {
			$('#dg_video').datagrid('options').url = '../videolist/getVideoInfoList';
			$('#dg_video').datagrid('load');
		}
	}
</script>

<div id="toolbar_shop">

	<div id="tb" style="padding:3px">
		<span>videoId:</span> <input id="videoId"
			style="line-height:20px;border:1px solid #ccc"
			onkeypress="if(event.keyCode==13) {btn_search.click();return false;}">
			
		<span>assetId:</span> <input id="assetId"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search.click();return false;}">
			
		<span>assetName:</span> <input id="assetName"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search.click();return false;}">
		
		<a href="#" id="btn_search" class="easyui-linkbutton"
			iconCls="icon-search" plain="true" onclick="doSearch()">Search</a>
	</div>
</div>

<table id="dg_video" title="" class="easyui-datagrid"
	style="overflow:auto;"
	data-options="toolbar:'#toolbar_shop',pagination:true,singleSelect:true,collapsible:true,url:'../videolist/getVideoInfoList',pageSize:15,pageList:[ 5, 10, 15, 20 ]">
	<thead>
		<tr>
			<th data-options="field:'videoId',width:200">videoId</th>
			<th data-options="field:'assetId',width:200">assetId</th>
			<th data-options="field:'assetName',width:200">assetName</th>
			<th data-options="field:'providerName',width:200">providerName</th>
			<th data-options="field:'providerCode',width:200">providerCode</th>
		</tr>
	</thead>
</table>


