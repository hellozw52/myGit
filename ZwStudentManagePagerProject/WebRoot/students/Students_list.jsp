<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.5.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.5.2/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.5.2/demo/demo.css">
	<script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		var url;
		function deleteStudent(){
			var row=$('#dg').datagrid('getSelected');
			if(row){
				$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
					if(r){
						$.post('deleteStudents.action',{delId:row.sid},function(result){
							if(result.success){
								$.messager.alert("系统提示","已成功删除这条记录!");
								$("#dg").datagrid("reload");
							}else{
								$.messager.alert("系统提示",result.errorMsg);
							}
						},'json');
					}
				});
			}
		}
		
		function newStudent(){
			$("#dlg").dialog('open').dialog('setTitle','添加学生');
			$('#fm').form('clear');
			url='addStudents.action';
		}
		
		
		function editStudent(){
			var row=$('#dg').datagrid('getSelected');
			if(row){
				$("#dlg").dialog('open').dialog('setTitle','编辑学生');
				$('#fm').form('load',row);
				url='updateStudents.action?sid='+row.sid;
			}
		}
		
		function saveStudent(){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					$.messager.alert("提示信息", "操作成功");
					$('#dlg').dialog('close');		// close the dialog
					$('#dg').datagrid('reload');	// reload the user data
				}
			});
		}
		
		/* function saveStudent2(){
			$("#fm").form("submit", {
                url: url,
                onsubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                	//将result转为json
                	//var result = eval('('+result+')');
                    if (result.success) {
                        $.messager.alert("提示信息", "操作成功");
                        $("#dlg").dialog('close');
                        $("#dg").datagrid('load');
                    }
                    else {
                        $.messager.alert("提示信息", "操作失败");
                        $("#dlg").dialog('close');
                        $("#dg").datagrid('load');
                    }
                }
            });
		} */
		
	   	/* function doSearch(){
	    	$.post('getStudentsBySid.action',$('#sid').val(),function(result){
				if(result.rows){
					$.messager.alert("查询成功！");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示",result.errorMsg);
				}
			},'json');
	    } */


		
	</script>
	
	<script type="text/javascript">
		function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		}
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		}
	</script>
	
</head>
<body>
	<table id="dg" title="学生管理" class="easyui-datagrid" style="width:700px;height:365px"
            url="./queryStudents.action"
            fit="true"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
	    
        <thead>
            <tr>
            	<th field="sid" width="50">编号</th>
                <th field="sname" width="50">姓名</th>
                <th field="gender" width="50">性别</th>
                <th field="birthday" width="50">生日</th>
                <th field="address" width="50">地址</th>
            </tr>
        </thead>
        
    </table>
    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newStudent()">添加学生</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editStudent()">编辑学生</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteStudent()">删除学生</a>
        
        <!-- <div id="tb" style="padding:3px">
	    	<span>编号:</span>
	    	<input id="sid" style="line-height:13px;border:1px solid #ccc">
	    	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
	    </div> -->
        
    </div>
    
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
        	<table cellspacing="10px;">
        		<tr>
        			<td>姓名：</td>
        			<td><input name="sname" style="width: 200px;"></td>
        		</tr>
        		<tr>
        			<td>性别：</td>
        			<td><input name="gender" style="width: 200px;"></td>
        		</tr>
        		<tr>
        			<td>生日：</td>
        			<td><input name="birthday" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width: 200px;"></td>
        		</tr>
        		<tr>
        			<td>地址：</td>
        			<td><input name="address" style="width: 200px;"></td>
        		</tr>
        	</table>
        </form>
	</div>
    
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveStudent()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
	</div>
</body>
</html>