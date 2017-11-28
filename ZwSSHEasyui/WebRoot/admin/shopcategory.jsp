<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script>
	var url;
	function newCategory() {
		$('#dlg_shopcategory').dialog('open').dialog('setTitle', '添加类别');
		$('#fm_shopcategory').form('clear');
		url = 'addCategory.action';
	}
	function editCategory() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$('#dlg_shopcategory').dialog('open').dialog('setTitle', '类别编辑');
			$('#fm_shopcategory').form('load', row);
			url = 'updateCategory.action?shopid=' + row.shopid;
		}
	}
	function saveCategory() {
		$('#fm_shopcategory').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					$('#dlg_shopcategory').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
				} else {
					$.messager.show({
						title : 'Error',
						msg : result.errorMsg
					});
				}
			}
		});
	}
	function destroyCategory() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$.messager.confirm('温馨提示', '是否删除此行数据?', function(r) {
				if (r) {
					$.post('deleteCategory.action', {
						shopcategoryid : row.shopcategoryid
					}, function(result) {
						if (result.success) {
							$('#dg').datagrid('reload'); // reload the user data
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
<table id="dg" title="商家类别管理" class="easyui-datagrid"
	style="overflow:auto"
	data-options="toolbar:'#toolbar_shopcategory',pagination:true,singleSelect:true,collapsible:true,url:'categoryList.action',pageSize:10,pageList:[ 5, 10, 15, 20 ]">
	<thead>
		<tr>
			<th data-options="field:'shopcategoryid',width:200">类别ID</th>
			<th data-options="field:'shopcategory',width:200">类别名称</th>
			<th data-options="field:'pid',width:200">上级类别ID</th>
		</tr>
	</thead>
</table>
<div id="toolbar_shopcategory">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="newCategory()">添加类别</a> <a href="#" class="easyui-linkbutton"
		iconCls="icon-edit" plain="true" onclick="editCategory()">信息编辑</a> <a
		href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="destroyCategory()">删除类别</a>
</div>
<div id="dlg_shopcategory" class="easyui-dialog"
	style="width:400px;height:280px;padding:10px 20px" closed="true"
	buttons="#dlg_shopcategory-buttons">
	<div class="ftitle">Category Information</div>
	<form id="fm_shopcategory" method="post" novalidate>
		<div class="fitem">
			<label>类别ID:</label> <input name="shopcategoryid" class="easyui-validatebox" required="true">

		</div>
		<div class="fitem">
			<label>类别名称:</label> <input name="shopcategory"
				class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>上级类别ID:</label> <input name="pid"
				class="easyui-validatebox" required="true">
		</div>
	</form>
</div>
<div id="dlg_shopcategory-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveCategory()">Save</a> <a href="#"
		class="easyui-linkbutton" iconCls="icon-cancel"
		onclick="javascript:$('#dlg_shopcategory').dialog('close')">Cancel</a>
</div>