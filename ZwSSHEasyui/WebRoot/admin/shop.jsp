<%@ page language="java" pageEncoding="utf-8"%>
<script>
	var url;
	function newShop() {
		$('#dlg_shop').dialog('open').dialog('setTitle', '添加商家');
		$('#fm_shop').form('clear');
		url = 'add.action';
	}
	function editShop() {
		var row = $('#dg_shop').datagrid('getSelected');
		if (row) {
			$('#dlg_shop').dialog('open').dialog('setTitle', '信息编辑');
			$('#fm_shop').form('load', row);
			url = 'update.action?shopid=' + row.shopid;
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
					$.post('delete.action', {
						shopid : row.shopid
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

</script>
<table id="dg_shop" title="商家管理" class="easyui-datagrid"
	style="overflow:auto"
	data-options="toolbar:'#toolbar_shop',pagination:true,singleSelect:true,collapsible:true,url:'list.action',pageSize:10,pageList:[ 5, 10, 15, 20 ]">
	<thead>
		<tr>
			<th data-options="field:'shopid',width:200">商店ID</th>
			<th data-options="field:'shopname',width:200">商店名称</th>
			<th data-options="field:'shoplocation',width:200">商店位置</th>
			<th data-options="field:'shopimage',width:200">商店图片</th>
		</tr>
	</thead>
</table>
<div id="toolbar_shop">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="newShop()">添加商家</a> <a href="#" class="easyui-linkbutton"
		iconCls="icon-edit" plain="true" onclick="editShop()">信息编辑</a> <a
		href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="destroyShop()">删除商家</a>
</div>
<div id="dlg_shop" class="easyui-dialog"
	style="width:400px;height:280px;padding:10px 20px" closed="true"
	buttons="#dlg_shop-buttons">
	<div class="ftitle">商家信息</div>
	<form id="fm_shop" method="post" novalidate>
		<div class="fitem">
			<label>商家名称:</label> <input name="shopname" id="shopname"
				class="easyui-textbox" style="width:60%; height:25px;"
				required="true">
		</div>
		<div class="fitem">
			<label>商家位置:</label> <input name="shoplocation" id="shoplocation"
				class="easyui-textbox" style="width:60%; height:25px;"
				required="true">
		</div>
		<div class="fitem">
			<label>商家图片:</label> <input name="shopimage" class="easyui-textbox"
				style="width:60%; height:25px;" required="true">
		</div>
	</form>
</div>
<div id="dlg_shop-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveShop()">保存</a> <a href="#" class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:$('#dlg_shop').dialog('close')">取消</a>
</div>