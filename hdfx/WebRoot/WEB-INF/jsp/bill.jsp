<%@ page language="java" pageEncoding="utf-8"%>

<!-- 增删改查jquery脚本 -->
<script>
	
	var url; // 后台请求url
	
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
	    title:'话单列表',
	    url:'../bill/list',
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
			<!-- 表头字段  设置第一列为复选框  -->
			<th field="ck" checkbox="true"></th>
			<th field="id" width="80">id</th>
			<th field="dfhm" width="80">dfhm</th>
			<th field="thsj" width="80">thsj</th>
			<th field="bfhm" width="80">bfhm</th>
			<th field="bfgsd" width="80">bfgsd</th>
			<th field="dfgsd" width="80">dfgsd</th>
			<th field="thsc" width="80">thsc</th>
			<th field="jh" width="80">jh</th>
			<th field="lac" width="80">lac</th>
			<th field="ci" width="80">ci</th>
			<th field="zbjbz" width="80">zbjbz</th>
			<th field="sjfsd" width="80">sjfsd</th>
			<th field="jh" width="80">yys</th>
		</tr>
	</thead>
</table>

<!--工具框 -->
<div id="toolbar_book">
	
	<div id="tb" style="padding:3px">
		
		<!-- 联合查询工具栏 -->
		<span>id:</span> <input id="id"
			style="line-height:20px;border:1px solid #ccc"
			onkeypress="if(event.keyCode==13) {btn_search_book.click();return false;}">
			
		<span>对方号码:</span> <input id="title"
			style="line-height:20px;border:1px solid #ccc" 
			onkeypress="if(event.keyCode==13) {btn_search_book.click();return false;}">
		
		<a href="#" id="btn_search_book" class="easyui-linkbutton"
			iconCls="icon-search" plain="true" onclick="doSearch()">Search</a>
		
	</div>
		
	
</div>




