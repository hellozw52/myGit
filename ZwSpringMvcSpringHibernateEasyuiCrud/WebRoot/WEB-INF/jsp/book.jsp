<%@ page language="java" pageEncoding="utf-8"%>

<!-- 增删改查jquery脚本 -->
<script>
	
	var url; // 后台请求url
	
	/* 增 */
	//打开一个对话框并清空表单数据。
	function add() {
		$('#dlg_book').dialog('open').dialog('setTitle', '添加');
		$('#fm_book').form('clear');
		url = '../book/add';//服务器controller处理地址
	}
	
	/* 删 */
	//移除一行之前,我们将显示一个确认对话框让用户决定是否真的移除该行数据。当移除数据成功之后，调用 'reload'方法来刷新 datagrid数据。
	//用户可以在与消息框交互后使用回调函数function(r)来完成一些动作。
	/* 
	function destroy() {
		var row = $('#dg_book').datagrid('getSelected');
		if (row) {
			$.messager.confirm('温馨提示', '是否删除此行数据?', function(r) {
				if (r) {
					$.post('../book/delete', {id:row.id}, function(result) {
						if (result.success) {
							$('#dg_book').datagrid('reload'); // reload the user data
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
	*/
	
	/* 删除--可批量 */
	function deletemany() {
		//获取选中行的数据,如果是多行返回的是数组。
		var selectRows = $('#dg_book').datagrid('getSelections');
		//所选条数
		var selectNum = selectRows.length;
		//alert(selectNum);
		//如果没有选中行的话，提示信息
	    if (selectNum < 1) {
	        $.messager.alert("提示消息", "请选择要删除的记录！", 'info');
	        return;
	    }
	    //如果选中行了，则要进行判断
	    $.messager.confirm("确认消息", "确定要删除所选 <span style='color: red;'>"+selectNum+"</span> 条记录吗？", function (isDelete) {
	 
	        //如果为真的话
	        if (isDelete) {
	            //定义变量值
	            var strIds = "";
	            //拼接字符串，这里也可以使用数组，作用一样
	            for (var i = 0; i < selectNum; i++) {
	                strIds += selectRows[i].id + ",";
	            }
	            //删除最后一个字符","
				strIds = strIds.substr(0, strIds.length - 1);
				//alert(strIds);
	            $.post('../book/deletemany',{ids:strIds} ,function (result) {
	                if (result.success) {
	                    $.messager.alert("提示", "删除 <span style='color: red;'>"+selectNum+"</span> 条数据，成功！！！");
	                    $('#dg_book').datagrid('reload'); //删除成功后 刷新页面
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
	
	/* 改 */
	//打开一个对话框并从 datagrid 选择的行中加载表单数据。
	function edit() {
		var row = $('#dg_book').datagrid('getSelected');
		if (row) {
			$('#dlg_book').dialog('open').dialog('setTitle', '编辑');
			$('#fm_book').form('load', row);
			url = '../book/update?id=' + row.id;
		}
	}
	
	/* 保存 */
	function save() {
		$('#fm_book').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					$('#dlg_book').dialog('close'); // close the dialog
					$('#dg_book').datagrid('reload'); // reload the data
				} else {
					$.messager.show({
						title : 'Error',
						msg : result.errorMsg
					});
				}
			}
		});
	}
	
	/* 查 */
	function doSearch() {

		/* 获取参数值 */
		var id = $('#id').val();
		var isbn = $('#isbn').val();
		var title = $('#title').val();

		/* 三个参数只要有一个不为空，就查询结果 */
		if (id||isbn||title) {
			$('#dg_book').datagrid('options').url = '../book/search';
			$('#dg_book').datagrid('load', {
				id : id,
				isbn : isbn,
				title : title
			});
			/* 所有参数均为空，默认查询第1页结果 */
		} else {
			$('#dg_book').datagrid('options').url = '../book/list';
			$('#dg_book').datagrid('load');
		}
	}
	
	/* 设置datagride属性 */
	$('#dg_book').datagrid({
	    title:'图书列表',
	    url:'../book/list',
	    overflow:'auto',
	    toolbar:'#toolbar_book',
	    pagination:true,
	    rownumbers:true,
	    singleSelect:true,
	    collapsible:true,
	    pageSize:15,
	    pageList:[ 5, 10, 15, 20, 100 ]
	});
	
</script>

<!-- 数据展示表格 -->
<table id="dg_book">
	<!-- 表头 -->
	<thead>
		<tr>
			<!-- 表头字段  设置第一列为复选框  图书编号列可排序-->
			<th field="ck" checkbox="true"></th>
			<th field="id" width="80">id</th>
			<th field="isbn" width="200">图书编号</th>
			<th field="title" width="300">图书名称</th>
			<th field="publisher" width="200">出版机构</th>
			<th field="author" width="200">图书作者</th>
		</tr>
	</thead>
</table>

<!--工具框 -->
<div id="toolbar_book">
	
	<div id="tb" style="padding:3px">
		
		<!-- 增删改工具栏 -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="add()">添加</a> 
		<a href="#" class="easyui-linkbutton"
		iconCls="icon-edit" plain="true" onclick="edit()">编辑</a> 
		<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="destroy()">删除</a> -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="deletemany()">删除(可批量删除)</a>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- 选择模式 -->
		<span>选择模式: </span>
		<select onchange="$('#dg_book').datagrid({singleSelect:(this.value==0)})">
			<option value="0">单选</option>
			<option value="1">多选</option>
		</select>
		<br>
		
		<!-- 联合查询工具栏 -->
		<span>自增ID:</span> <input id="id"
			style="line-height:20px;border:1px solid #ccc"
			onkeypress="if(event.keyCode==13) {btn_search_book.click();return false;}">
			
		<span>图书编号:</span> <input id="isbn"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search_book.click();return false;}">
			
		<span>图书名称:</span> <input id="title"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search_book.click();return false;}">
		
		<a href="#" id="btn_search_book" class="easyui-linkbutton"
			iconCls="icon-search" plain="true" onclick="doSearch()">Search</a>
		
	</div>
		
	<!--dlg对话框 -->
	<div id="dlg_book" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg_book-buttons">
	
		<form id="fm_book" method="post" novalidate>
		
			<div class="fitem">
				<label>图书编号:</label>
				<input name="isbn" id="isbn" class="easyui-textbox" style="width:60%; height:25px;" required="true">
			</div>
			
			<div class="fitem">
				<label>图书名称:</label> 
				<input name="title" id="title" class="easyui-textbox" style="width:60%; height:25px;" required="true">
			</div>
			
			<div class="fitem">
				<label>出版机构:</label> 
				<input name="publisher" id="publisher" class="easyui-textbox" style="width:60%; height:25px;" required="true">
			</div>
			
			<div class="fitem">
				<label>图书作者:</label>
				<input name="author" id="author" class="easyui-textbox" style="width:60%; height:25px;" required="true">
			</div>
			
		</form>
	</div>
	
	<!--dlg对话框按钮 -->
	<div id="dlg_book-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">保存</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_book').dialog('close')">取消</a>
	</div>
</div>




