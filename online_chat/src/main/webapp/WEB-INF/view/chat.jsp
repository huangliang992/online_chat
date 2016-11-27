<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/layoutit/src/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/layoutit/src/css/style.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/bootstrap.min.js"></script>
<title>聊天室</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-12">
							<h3 class="text-primary text-center">
								${username } 欢迎来到聊天室！
							</h3>
						</div>
					</div>
					<div class="row">
						<!-- 左边的控制菜单 -->
						<div class="col-md-3">
							<a type="button" class="btn btn-block btn-warning" id="c_game" href="#">
								游戏聊天室
							</a> 
							<a type="button" class="btn btn-block btn-primary" id="c_education" href="#">
								教育聊天室
							</a> 
							<a type="button" class="btn btn-block btn-success" id="c_technic" href="#">
								科技聊天室
							</a>
						</div>
						<!-- toggle菜单控制显示 -->
						<script type="text/javascript">
							$(document).ready(function(){
								$("#education").show();
								$("#game").hide();
								$("#technic").hide();
								});
							$("#c_game").click(function(){
								$("#education").hide();
								$("#game").show();
								$("#technic").hide();
								});
							$("#c_education").click(function(){
								$("#education").show();
								$("#game").hide();
								$("#technic").hide();
								});
							$("#c_technic").click(function(){
								$("#education").hide();
								$("#game").hide();
								$("#technic").show();
								});
						</script>
						<!-- 右边的聊天室 -->
						<div class="col-md-9">
							<!-- 游戏聊天室 -->
							<div class="row" id="game">游戏
								<div class="row">${rgame }</div>
								<div class="row">
										<textarea rows="5" name="gmessage" id="gmessage"></textarea>
										<button id="gbutton" class="btn btn-default">提交</button>
								</div>
							</div>
							<!-- 教育聊天室 -->
							<div class="row" id="education">教育
								<div class="row" id="ceducation">${reducation }</div>
									<div class="row">
											<textarea rows="5" name="emessage" id="emessage" class="form-control"></textarea>
											<button id="ebutton" class="btn btn-default">提交</button>
									</div>
							</div>
							<!-- 科技聊天室 -->
							<div class="row" id="technic">科技
								<div class="row">${rtechnic }</div>
									<div class="row">
											<textarea rows="5" name="tmessage" id="tmessage" class="form-control"></textarea>
											<button id="tbutton" class="btn btn-default">提交</button>
									</div>
							</div>
						</div>
						<script type="text/javascript">
							$("#ebutton").click(function(){
								$.ajax({
									data:"message="+$("#emessage").val(),
									dataType:'json',
									type:"GET",
									url:"${pageContext.request.contextPath}/chat/echat",
									success:function(data){
										$("#ceducation").html("成功！");
										},
									error:function(data){
										alert("错误");
										}
									});
								});
						</script>
					</div>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>