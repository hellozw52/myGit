<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script>
	var url;
	function newUser() {
		$('#dlg_user').dialog('open').dialog('setTitle', '添加用户');
		$('#fm_user_user').form('clear');
		url = 'addUser.action';
	}
	function editUser() {
		var row = $('#dg_user').datagrid('getSelected');
		if (row) {
			$('#dlg_user').dialog('open').dialog('setTitle', '用户编辑');
			$('#fm_user').form('load', row);
			url = 'updateUser.action?userid=' + row.userid;
		}
	}
	function saveUser() {
		$('#fm_user_user').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					$('#dlg_user').dialog('close'); // close the dialog
					$('#dg_user').datagrid('reload'); // reload the user data
				} else {
					$.messager.show({
						title : 'Error',
						msg : result.errorMsg
					});
				}
			}
		});
	}
	function destroyUser() {
		var row = $('#dg_user').datagrid('getSelected');
		if (row) {
			$.messager.confirm('温馨提示', '是否删除此行数据?', function(r) {
				if (r) {
					$.post('deleteUser.action', {
						userid : row.userid
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

</script>
<table id="dg_user" title="用户管理" class="easyui-datagrid"
	style="overflow:auto"
	data-options="toolbar:'#toolbar_user',pagination:true,singleSelect:true,collapsible:true,url:'userList.action',pageSize:10,pageList:[ 5, 10, 15, 20 ]">
	<thead>
		<tr>
			<th data-options="field:'userid',width:200">UserId</th>
			<th data-options="field:'username',width:200">UserName</th>
			<th data-options="field:'userpass',width:200">UserPass</th>
			<th data-options="field:'useremail',width:200">UserEmail</th>
			<th data-options="field:'usergender',width:200">UserGender</th>
			<th data-options="field:'userphone',width:200">UserPhone</th>
		</tr>
	</thead>
</table>
<div id="toolbar_user">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="newUser()">添加用户</a> <a href="#" class="easyui-linkbutton"
		iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a> <a
		href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="destroyUser()">删除用户</a>
</div>
<div id="dlg_user" class="easyui-dialog"
	style="width:400px;height:400px;padding:10px 20px" closed="true"
	buttons="#dlg_user-buttons">
	<div class="ftitle" style="margin-bottom:5px;">用户信息</div>
	<form id="fm_user" method="post" novalidate>
		<div class="fitem" style="margin-bottom:5px;">
			<label>用户名:</label> <input name="username" class="easyui-textbox"
				required="true" style="width:60%; height:25px;">
		</div>
		<div class="fitem" style="margin-bottom:5px;">
			<label>邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</label> <input name="useremail"
				class="easyui-textbox" required="true"
				style="width:60%; height:25px;">
		</div>
		<div class="fitem" style="margin-bottom:5px;">
			<label>性&nbsp;&nbsp;&nbsp;&nbsp;别:</label> <input name="usergender"
				class="easyui-radiobox" type="radio" value="1" check="checked"
				required="true">男 <input name="usergender"
				class="easyui-radiobox" type="radio" value="0" required="true">女
		</div>
		<div class="fitem" style="margin-bottom:5px;">
			<label>电&nbsp;&nbsp;&nbsp;&nbsp;话:</label> <input name="userphone"
				class="easyui-textbox" required="true"
				style="width:60%; height:25px;">
		</div>

	</form>
</div>
<div id="dlg_user-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
		onclick="saveUser()">保存</a> <a href="#" class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:$('#dlg_user').dialog('close')">重置</a>
</div>