<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<div class="col-md-3">
							<a type="button" class="btn btn-block btn-warning" id="c_game" href="">
								游戏聊天室
							</a> 
							<a type="button" class="btn btn-block btn-primary" id="c_education" href="">
								教育聊天室
							</a> 
							<a type="button" class="btn btn-block btn-success" id="c_technic" href="">
								科技聊天室
							</a>
						</div>
						<div class="col-md-9">
							<div class="row" id="game"></div>
							<div class="row" id="education"></div>
							<div class="row" id="technic"></div>
						</div>
						<!-- 控制显示 -->
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