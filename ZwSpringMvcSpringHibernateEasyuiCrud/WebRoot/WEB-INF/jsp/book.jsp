<%@ page language="java" pageEncoding="utf-8"%>
<script>
	
	var url;
	
	function newShop() {
		$('#dlg_shop').dialog('open').dialog('setTitle', '添加商家');
		$('#fm_shop').form('clear');
		url = '../book/add';
	}
	function editShop() {
		var row = $('#dg_shop').datagrid('getSelected');
		if (row) {
			$('#dlg_shop').dialog('open').dialog('setTitle', '信息编辑');
			$('#fm_shop').form('load', row);
			url = '../book/update?id=' + row.id;
		}
	}
	function saveShop() {
		$('#fm_shop').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					$('#dlg_shop').dialog('close'); // close the dialog
					$('#dg_shop').datagrid('reload'); // reload the user data
				} else {
					$.messager.show({
						title : 'Error',
						msg : result.errorMsg
					});
				}
			}
		});
	}
	function destroyShop() {
		var row = $('#dg_shop').datagrid('getSelected');
		if (row) {
			$.messager.confirm('温馨提示', '是否删除此行数据?', function(r) {
				if (r) {
					$.post('../book/delete', {
						id : row.id
					}, function(result) {
						if (result.success) {
							$('#dg_shop').datagrid('reload'); // reload the user data
						} else {
							$.messager.show({ // show error message
								title : 'Error',
								msg : result.errorMsg
							});
						}
					}, 'json');
				}
			});
		}
	}


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

	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="newShop()">添加</a> 
	<a href="#" class="easyui-linkbutton"
		iconCls="icon-edit" plain="true" onclick="editShop()">编辑</a> 
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="destroyShop()">删除</a>
		
	<div id="dlg_shop" class="easyui-dialog"
	style="width:400px;height:280px;padding:10px 20px" closed="true"
	buttons="#dlg_shop-buttons">
	
		<form id="fm_shop" method="post" novalidate>
			<!-- <div class="fitem">
				<label>id:</label> <input name="id" id="id"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div> -->
		
			<div class="fitem">
				<label>isbn:</label> <input name="isbn" id="isbn"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
			<div class="fitem">
				<label>title:</label> <input name="title" id="title"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
			<div class="fitem">
				<label>publisher:</label> <input name="publisher" id="publisher"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
			<div class="fitem">
				<label>author:</label> <input name="author" id="author" 
					class="easyui-textbox" style="width:60%; height:25px;" 
					required="true">
			</div>
		</form>
	</div>
	
	<div id="dlg_shop-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveShop()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_shop').dialog('close')">取消</a>
	</div>

	<!-- <div id="tb" style="padding:3px">
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
	</div> -->
	
</div>

<table id="dg_shop" title="" class="easyui-datagrid"
	style="overflow:auto;"
	data-options="toolbar:'#toolbar_shop',pagination:true,singleSelect:true,collapsible:true,url:'../book/list',pageSize:15,pageList:[ 5, 10, 15, 20 ]">
	<thead>
		<tr>
			<th data-options="field:'id',width:40">id</th>
			<th data-options="field:'isbn',width:100">isbn</th>
			<th data-options="field:'title',width:200">title</th>
			<th data-options="field:'intro',width:450">intro</th>
			<th data-options="field:'author',width:100">author</th>
			<th data-options="field:'publisher',width:200">publisher</th>
		</tr>
	</thead>
</table>


