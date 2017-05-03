<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<script type="text/javascript">
	var $curs = {};
	$(function(){
	    var param={};
		query(param);
	});
	function clickQuery(){
		query({});
	}
	function query(params){
		$curs = params;
		$('#myPage').html('');
		$.ajax({
			   type: "POST",
			   url: '${path}/project/list',
			   data:params,
			   dataType:'json',
			   success: function(data){
				   $('#myData').empty();
				   var template = Handlebars.compile($("#roleTemplate").html());
				   var $tr = template(data);
				   $('#myData').append($tr);
				   pagePlugin('myPage',data.totalPages,data.number,data.totalElements,jumpPage);
			   }
		});
	}
	function jumpPage(page){
		$curs.pageNo = page;
		query($curs);
	}
	function startQuery(){
		var pArray = $('#searchForm').serializeArray();
		var params = {};
		for(var i = 0;i < pArray.length;i++){
			if($.trim(pArray[i].value) != ''){
				params[pArray[i].name] = pArray[i].value;
			}
		}
		query(params);
	}
</script>
</head>
        <!-- page heading start-->
        <div class="page-heading">
            <ul class="breadcrumb">
                <li>
                    <a href="#">我的项目</a>
                </li>
                <li>
                    <a href="#">项目列表</a>
                </li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
        <div class="row">
        <div class="col-sm-12">
        <section class="panel">
        <header class="panel-heading">
                                            项目
              <span class="tools pull-right">
             </span>
        </header>
        <div class="panel-body">
					<div class="adv-table">
						<table class="display table table-bordered table-striped"
							id="dynamict">
							<thead>
								<tr>
									<th>序号</th>
									<th>名称</th>
									<th>类型</th>
									<th>用户</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="myData">
							</tbody>
							<tfoot>
							</tfoot>
						</table>
						<div align="right">
							<ul id="myPage" class="pagination">
							</ul>
						</div>
					</div>
				</div>
        </section>
        </div>
        </div>
        </div>
<script id="roleTemplate" type="text/x-handlebars-template">
	{{#each content}}
		<tr>
			<td>{{id}}</td>
			<td>{{name}}</td>
			<td>{{type}}</td>
			<td>{{userId}}</td>
			<td>删除，修改</td>
		</tr>
	{{/each}}
</script>     
        
   