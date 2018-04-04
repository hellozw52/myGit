<%@ page language="java" pageEncoding="utf-8"%>
<script>
	
	var url; // 后台请求url
	
	/* 增 */
	function add() {
		$('#dlg_user').dialog('open').dialog('setTitle', '添加');
		$('#fm_user').form('clear');
		url = '../user/add';
	}
	
	/* 删 */
	function destroy() {
		var row = $('#dg_user').datagrid('getSelected');
		if (row) {
			$.messager.confirm('温馨提示', '是否删除此行数据?', function(r) {
				if (r) {
					$.post('../user/delete', {
						id : row.id
					}, function(result) {
						if (result.success) {
							$('#dg_user').datagrid('reload'); // reload the user data
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
	
	/* 改 */
	function edit() {
		var row = $('#dg_user').datagrid('getSelected');
		if (row) {
			$('#dlg_user').dialog('open').dialog('setTitle', '信息编辑');
			$('#fm_user').form('load', row);
			url = '../user/update?id=' + row.id;
		}
	}
	
	/* 查 */
	function doSearch() {

		/* 获取参数值 */
		var id = $('#id').val();
		var isbn = $('#isbn').val();
		var title = $('#title').val();

		/* 三个参数只要有一个不为空，就查询结果 */
		if (id||isbn||title) {
			$('#dg_user').datagrid('options').url = '../user/search';
			$('#dg_user').datagrid('load', {
				id : id,
				isbn : isbn,
				title : title
			});
			/* 所有参数均为空，默认查询第1页结果 */
		} else {
			$('#dg_user').datagrid('options').url = '../user/list';
			$('#dg_user').datagrid('load');
		}
	}
	
	/* 保存 */
	function save() {
		$('#fm_user').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					$('#dlg_user').dialog('close'); // close the dialog
					$('#dg_user').datagrid('reload'); // reload the data
				} else {
					$.messager.show({
						title : 'Error',
						msg : result.errorMsg
					});
				}
			}
		});
	}
	
</script>

<div id="toolbar_user">
	<!-- <div id="tb" style="padding:3px">
		
		<span>自增ID:</span> <input id="id"
			style="line-height:20px;border:1px solid #ccc"
			onkeypress="if(event.keyCode==13) {btn_search_user.click();return false;}">
			
		<span>图书编号:</span> <input id="isbn"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search_user.click();return false;}">
			
		<span>图书名称:</span> <input id="title"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search_user.click();return false;}">
		
		<a href="#" id="btn_search_user" class="easyui-linkbutton"
			iconCls="icon-search" plain="true" onclick="doSearch()">Search</a>
		
	</div> -->
	
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="add()">添加</a> 
		<a href="#" class="easyui-linkbutton"
		iconCls="icon-edit" plain="true" onclick="edit()">编辑</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="destroy()">删除</a>
		
	<div id="dlg_user" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg_user-buttons">
		<form id="fm_user" method="post" novalidate>
			<div class="fitem">
				<label>用户名：</label> <input name="userName" id="userName"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
			<div class="fitem">
				<label>用户密码:</label> <input name="password" id="password" 
					class="easyui-textbox" style="width:60%; height:25px;" 
					required="true">
			</div>
			<div class="fitem">
				<label>用户角色：</label> <input name="roleName" id="roleName"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
		</form>
	</div>
	
	<div id="dlg_user-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="save()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_user').dialog('close')">取消</a>
	</div>
</div>

<table id="dg_user" title="" class="easyui-datagrid"
	style="overflow:auto;"
	data-options="toolbar:'#toolbar_user',pagination:true,singleSelect:true,collapsible:true,url:'../user/list',pageSize:15,pageList:[ 5, 10, 15, 20 ]">
	<thead>
		<tr>
			<th data-options="field:'id',width:80">ID</th>
			<th data-options="field:'userName',width:200">用户名称</th>
			<th data-options="field:'password',width:300">用户密码</th>
			<th data-options="field:'roleName',width:200">用户角色</th>
			
		</tr>
	</thead>
</table>


