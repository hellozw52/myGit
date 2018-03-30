<%@ page language="java" pageEncoding="utf-8"%>
<script>
	
	var url; // 后台请求url
	
	/* 增 */
	function add() {
		$('#dlg_shop').dialog('open').dialog('setTitle', '添加');
		$('#fm_shop').form('clear');
		url = '../book/add';
	}
	
	/* 删 */
	function destroy() {
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
	
	/* 改 */
	function edit() {
		var row = $('#dg_shop').datagrid('getSelected');
		if (row) {
			$('#dlg_shop').dialog('open').dialog('setTitle', '信息编辑');
			$('#fm_shop').form('load', row);
			url = '../book/update?id=' + row.id;
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
			$('#dg_shop').datagrid('options').url = '../book/search';
			$('#dg_shop').datagrid('load', {
				id : id,
				isbn : isbn,
				title : title
			});
			/* 所有参数均为空，默认查询第1页结果 */
		} else {
			$('#dg_shop').datagrid('options').url = '../book/list';
			$('#dg_shop').datagrid('load');
		}
	}
	
	/* 保存 */
	function save() {
		$('#fm_shop').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					$('#dlg_shop').dialog('close'); // close the dialog
					$('#dg_shop').datagrid('reload'); // reload the data
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

<div id="toolbar_shop">
	<!-- 此页面为通用页面，元素id不需要修改，只修改js即可实现easyui的CRUD功能！！！ -->
	<div id="tb" style="padding:3px">
		
		<span>自增ID:</span> <input id="id"
			style="line-height:20px;border:1px solid #ccc"
			onkeypress="if(event.keyCode==13) {btn_search.click();return false;}">
			
		<span>图书编号:</span> <input id="isbn"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search.click();return false;}">
			
		<span>图书名称:</span> <input id="title"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search.click();return false;}">
		
		<a href="#" id="btn_search" class="easyui-linkbutton"
			iconCls="icon-search" plain="true" onclick="doSearch()">Search</a>
		
	</div>
	
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="add()">添加</a> 
		<a href="#" class="easyui-linkbutton"
		iconCls="icon-edit" plain="true" onclick="edit()">编辑</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="destroy()">删除</a>
		
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
				<label>图书编号:</label> <input name="isbn" id="isbn"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
			<div class="fitem">
				<label>图书名称:</label> <input name="title" id="title"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
			<div class="fitem">
				<label>出版机构:</label> <input name="publisher" id="publisher"
					class="easyui-textbox" style="width:60%; height:25px;"
					required="true">
			</div>
			<div class="fitem">
				<label>图书作者:</label> <input name="author" id="author" 
					class="easyui-textbox" style="width:60%; height:25px;" 
					required="true">
			</div>
		</form>
	</div>
	
	<div id="dlg_shop-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="save()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_shop').dialog('close')">取消</a>
	</div>
</div>

<table id="dg_shop" title="" class="easyui-datagrid"
	style="overflow:auto;"
	data-options="toolbar:'#toolbar_shop',pagination:true,singleSelect:true,collapsible:true,url:'../book/list',pageSize:15,pageList:[ 5, 10, 15, 20 ]">
	<thead>
		<tr>
			<th data-options="field:'id',width:80">自增ID</th>
			<th data-options="field:'isbn',width:200">图书编号</th>
			<th data-options="field:'title',width:300">图书名称</th>
			<th data-options="field:'publisher',width:200">出版机构</th>
			<th data-options="field:'author',width:200">图书作者</th>
			
		</tr>
	</thead>
</table>


