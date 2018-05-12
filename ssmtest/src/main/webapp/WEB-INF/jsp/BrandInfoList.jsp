<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="${pageContext.request.contextPath}/">
<link href="static/css/mycss.css" rel="stylesheet">
<link href="static/js/boostrap/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
 <script src="static/js/ie-emulation-modes-warning.js"></script>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript" src="static/js/boostrap/js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(function() {
	/*添加  弹窗*/
	$("#add-btn").click(function(){
		$('#myModal').modal({
			//backdrop:static
		})
	})
	
	/* 用按钮提交 表单,实现添加 */
	$("#add_confirm").click(function() {
		save("add");
	})

	/*修改前到后台拿到数据，进行回显  */
	$(".btn-update").click(function() {
		var id = $(this).attr("btn-id");
		$.getJSON("/brandInfo/toUpdate",{'id' : id},
				function(brandInfo) {
					$("#update_id").val(brandInfo.id);
					$("#update_brandName").val(brandInfo.brandName);
					$("#update_company").val(brandInfo.company);
					$("#update_contact").val(brandInfo.contact);
					$("#update_email").val(brandInfo.email);
					$("#update_tel").val(brandInfo.tel);
					$("#update_remark").val(brandInfo.remark);
				})
		})
		//提交到后台修改
		$("#update_confirm").click(function() {
			save("update");
		})
		
	/* 用按钮提交 表单,实现修改或添加 */
	function save(type){
		var pageNum = $("#add-btn").attr("pageNum");
		var pages = $("#update_confirm").attr("pages");
		$.ajax({
				type : 'POST',
				dataType : 'text',
				url : "/brandInfo/"+type+"BrandInfo",
				data : $("#"+type+"_form").serialize(),
				success : function(result) {
					alert(result);
					if (result == "ok") {
						if(type=="update"){
							alert("修改成功");
							location.href = "/brandInfo/getBrandInfoList/"+pageNum;
						}else if(type=="add"){
							alert("添加成功");
							location.href = "/brandInfo/getBrandInfoList/"+(pages+1);
						}
					} else if (type="update") {
						alert("修改失败");
					}else if (type="add") {
						alert("添加失败");
					}
				}
			})
	}
	//全选/全不选
	$("#selectAll").click(function(){
		$(".selectOne").prop("checked",$("#selectAll").prop("checked"))
	})
	//全选和单个的绑定
	$(".selectOne").click(function(){
		$("#selectAll").prop("checked",$(".selectOne").length==$(".selectOne:checked").length)
	})
		/*  删除单个 */
	$(".btn-del").click(function() {
		var pageNum=$(this).attr("pageNum");
		if(confirm("是否确认删除？？？？")){
			$.ajax({type : "POST",
				dataType : "text",
				url : "/brandInfo/deleteOne",
				data : {
					'id' : $(this).attr("btn-id")
				},
				success : function(result) {
					if (result=="ok") {
						alert("删除成功");
						location = "/brandInfo/getBrandInfoList/"+pageNum;
					}else{
						alert("删除失败");
						location = "/brandInfo/getBrandInfoList/"+pageNum;
					}
				}
			})
		}
	})
	/*删除多个  */
	$("#del-many").click(function() {
		var pageNum = $(this).attr("pageNum");
						/* 向后台传送数组  */
						var text = [];
						$('.selectOne:checked').each(function() {
							text.push($(this).val());
						});
						if ($("#total").val() == 0) {
							return;
						} else if (text.length == 0) {
							alert("请选择要删除的供应商");
							return;
						}
						
						if(confirm("是否确认删除？")){
							$.ajax({
								url : "/brandInfo/deleteMany",
								data : {
									"ids" : text
								},
								traditional : true,
								dataType : "text",
								type : "POST",
								success : function(result) {
									if (result == "ok") {
										alert("删除成功");
										location = "/brandInfo/getBrandInfoList/"+pageNum;
									} else {
										alert("删除失败");
									}
								}
							})
						}
						
					})
})
</script>

</head>
<body >
	<div class=".container-fluid" id="chenkun">
		<!-- 2、添加，删除按钮 -->
		<div class="row">
			<div class="col-sm-3 col-md-7 sidebar">
				<div class="col-md-6  col-md-offset-6">
					<form class="form-inline" action="brandInfo/getByName/1">
					  <div class="form-group">
					    <div class="input-group">
					      <input type="text" class="form-control" id="brandName" placeholder="供应商名字" name="brandName">
					    </div>
					  </div>
					  <button type="submit" class=" btn btn-primary ">查询</button>
					</form>
				</div>
			</div>
			<div class="col-md-2  col-md-offset-10">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#add_myModal" id="add-btn" pageNum = "${pageInfo.pageNum }">添加</button>
				<button type="button" class="btn btn-danger" id="del-many" pageNum="${pageInfo.pageNum}">删除</button>
			</div>
		</div>
		<!-- 3、列表详情 -->
		<div class="row" scrolling="auto">
			<div class="col-md-12 ">
				<table class="nth-child table table-hover  table-condensed  table-bordered ">
					<tr>
						<th >全选<input type="checkbox" id="selectAll" /></th>
						<th >品牌</th>
						<th >联系人</th>
						<th >邮箱</th>
						<th >电话</th>
						<th class="col-md-2">备注</th>
						<th >操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="info">
						<input type="hidden" name="id" value="${info.id }">
						<tr>
							<td><input type="checkbox" value="${info.id}" class="selectOne" name="id"></td>
							<td>${info.brandName}</td>
							<td>${info.contact}</td>
							<td>${info.email}</td>
							<td>${info.tel}</td>
							<td >${info.remark}</td>
							<td >
								<button type="button" class="btn btn-info btn-sm btn-update"
									data-toggle="modal" data-target="#myModal-update"
									btn-id="${info.id }">修改</button>
								<button type="button" class="btn btn-danger btn-sm btn-del"
									btn-id="${info.id }" pageNum="${pageInfo.pageNum}">删除</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
			<!-- 4、分页 -->
			 <div class="row">
				<div class="col-md-4">当前是第${pageInfo.pageNum}页，一共有${pageInfo.total}条记录</div>
				<div class="col-md-4 col-md-offset-4">
					<nav aria-label="Page navigation">
					<!-- 根据不同结果显示没同分页 -->
					<!-- 按名字查询的分页 -->
					<c:choose>
						<c:when test="${pageType eq 'queryByName' }">
							<ul class="pagination">
							<li><a href="/brandInfo/getByName/1?brandName=${brandName}">首页</a></li>
							<li><a href="/brandInfo/getByName/${pageInfo.prePage}/?brandName=${brandName}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
								<c:choose>
									<c:when test="${pageInfo.pageNum==pageNum }">
										<li class="active"><a
											href="/brandInfo/getByName/${pageNum}?brandName=${brandName}">${pageNum}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/brandInfo/getByName/${pageNum}?brandName=${brandName}">${pageNum}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
	
							<li><a href="/brandInfo/getByName/${pageInfo.nextPage}?brandName=${brandName}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
							<li><a
								href="/brandInfo/getByName/${pageInfo.total/pageInfo.pageSize+1}?brandName=${brandName}">尾页</a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<!-- 所有结果分页 -->
							<ul class="pagination">
								<li><a href="/brandInfo/getBrandInfoList/1">首页</a></li>
								<li><a href="/brandInfo/getBrandInfoList/${pageInfo.prePage}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
									<c:choose>
										<c:when test="${pageInfo.pageNum==pageNum }">
											<li class="active"><a
												href="/brandInfo/getBrandInfoList/${pageNum}">${pageNum}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="/brandInfo/getBrandInfoList/${pageNum}">${pageNum}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
		
								<li><a href="/brandInfo/getBrandInfoList/${pageInfo.nextPage}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
								<li><a
									href="/brandInfo/getBrandInfoList/${pageInfo.total/pageInfo.pageSize+1}">尾页</a></li>
							</ul>
						</c:otherwise>
					</c:choose>
					
					</nav>
				</div>
			</div>
	</div>

	<!-- Modal 添加窗口-->
	<div class="modal fade" id="add_myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加供应商</h4>
				</div>
				<div class="modal-body">

					<!-- 弹窗内部表单 -->
					<form id="add_form" class="form-horizontal" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label"
								placeholder="">品牌</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="brandName">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">公司</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="company">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">联系人</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="contact" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="email" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="tel" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
								<textarea rows="6" cols="30" id="remark" name="remark"></textarea>
							</div>
						</div>
						<input type="hidden" id="add_categoryName" name="categoryName">
						<input type="hidden" id="add_imgUrl" name="images"> <input
							type="hidden" id="total" value="${pageInfo.total }">
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="add_confirm">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 修改窗口-->
	<div class="modal fade" id="myModal-update" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改供应商信息</h4>
				</div>
				<div class="modal-body">

					<!-- 弹窗内部表单 -->
					<form id="update_form" class="form-horizontal" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
						
						<input type="hidden" id="update_id" name="id"> 
						<input type="hidden" id="total" value="${pageInfo.total }">
						
							<label for="inputEmail3" class="col-sm-2 control-label">品牌</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" name="brandName"
									id="update_brandName" >
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">公司</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="company"
									id="update_company">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">联系人</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="contact"
									id="update_contact" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="email"
									id="update_email" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="tel"
									id="update_tel" />
							</div>
						</div>

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
								<textarea rows="6" cols="30" id="update_remark" name="remark"
									id="update_remark"></textarea>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update_confirm" pages="${pageInfo.pages}">确定</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>