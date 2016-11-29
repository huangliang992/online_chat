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
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/angular.js"></script> 
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
							<a type="button" class="btn btn-block btn-default" id="c_enter" href="#">
								娱乐聊天室
							</a>
						</div>
						<!-- toggle菜单控制显示 -->
						<script type="text/javascript">
							$(document).ready(function(){
								$("#education").show();
								$("#game").hide();
								$("#technic").hide();
								$("#entertainment").hide();
								});
							$("#c_game").click(function(){
								$("#education").hide();
								$("#game").show();
								$("#technic").hide();
								$("#entertainment").hide();
								});
							$("#c_education").click(function(){
								$("#education").show();
								$("#game").hide();
								$("#technic").hide();
								$("#entertainment").hide();
								});
							$("#c_technic").click(function(){
								$("#education").hide();
								$("#game").hide();
								$("#technic").show();
								$("#entertainment").hide();
								});
							$("#c_enter").click(function(){
								$("#education").hide();
								$("#game").hide();
								$("#technic").hide();
								$("#entertainment").show();
								});
						</script>
						<!-- 右边的聊天室 -->
						<div class="col-md-9">
							<!-- 游戏聊天室 -->
							<div class="row" id="game">
								<h2>游戏聊天室</h2>
								<div class="row" id="cgame">
								
								</div>
								<script type="text/javascript">
									$(document).ready(function(){
										var game=${grecord};
										var content="";
										for(var i in game){
											content=content+"<p style=\"color:red\">"+game[i].username+" "+
											game[i].time+"</p>"+"<p>"+game[i].content+"</p>";
											}
										$("#cgame").html(content);

										});
								</script>
								<div class="row">
										<textarea rows="5" name="gmessage" id="gmessage" class="form-control"></textarea>
										<button id="gbutton" class="btn btn-default">提交</button>
								</div>
							</div>
							<!-- 教育聊天室 -->
							<div class="row" id="education" >
								<h2>教育聊天室</h2>
								<div class="row" id="ceducation">
									
								</div>
								<script type="text/javascript">
									$(document).ready(function(){
										var education=${erecord};
										var content="";
										for(var i in education){
											content=content+"<p style=\"color:red\">"+education[i].username+" "+
											education[i].time+"</p>"+"<p>"+education[i].content+"</p>"
											;
											}
										$("#ceducation").html(content);
										});
								</script>
									<div class="row">
											<textarea rows="5" name="emessage" id="emessage" class="form-control"></textarea>
											<button id="ebutton" class="btn btn-default">提交</button>
									</div>
							</div>
							
							<!-- 科技聊天室 -->
							<div class="row" id="technic">
								<h2>科技聊天室</h2>
								<div class="row" id="ctech">
								
								</div>
								<script type="text/javascript">
									$(document).ready(function(){
										var tech=${trecord};
										var content="";
										for(var i in tech){
											content=content+"<p style=\"color:red\">"+tech[i].userneame+" "+
											tech[i].time+"</p>"+"<p>"+tech[i].content+"</p>"
											;
											}
										$("#ctech").html(content);
										});
								</script>
									<div class="row">
											<textarea rows="5" name="tmessage" id="tmessage" class="form-control"></textarea>
											<button id="tbutton" class="btn btn-default">提交</button>
									</div>
							</div>
							<!-- 娱乐聊天室 -->
							<div class="row" id="entertainment">
								<h2>娱乐聊天室</h2>
								<div class="row" id="center">
								
								</div>
								<script type="text/javascript">
									$(document).ready(function(){
										var en=${enrecord};
										var content="";
										for(var i in en){
											content=content+"<p style=\"color:red\">"+en[i].userneame+" "+
											en[i].time+"</p>"+"<p>"+en[i].content+"</p>"
											;
											}
										$("#center").html(content);
										});
								</script>
									<div class="row">
											<textarea rows="5" name="enmessage" id="enmessage" class="form-control"></textarea>
											<button id="enbutton" class="btn btn-default">提交</button>
									</div>
							</div>
						</div>
						</div>
						
						<script type="text/javascript" charset="UTF-8">
							$("#ebutton").click(function(){
								$.ajax({
									data:"message="+$("#emessage").val(),
									dataType:'json',
									type:"POST",
									url:"${pageContext.request.contextPath}/chat/echat",
									success:function(data){
										$("#ceducation").html("成功！");
										},
									error:function(data){
										alert("错误");
										}
									});
								});
							$("#enbutton").click(function(){
								$.ajax({
									data:"message="+$("#enmessage").val(),
									dataType:'json',
									url:"${pageContext.request.contextPath}/chat/enchat",
									type:"POST",
									success:function(data){
										$("#center").html("成功！");
										},
									error:function(data){
										alert("错误");
										}
									});
								});
							$("#gbutton").click(function(){
								$.ajax({
									data:"message="+$("#gmessage").val(),
									dataType:'json',
									url:"${pageContext.request.contextPath}/chat/gchat",
									type:"POST",
									success:function(data){
										$("#cgame").html("成功！");
										},
									error:function(data){
										alert("错误");
										}
									});
							});
							$("#tbutton").click(function(){
								$.ajax({
									data:"message="+$("#tmessage").val(),
									dataType:'json',
									url:"${pageContext.request.contextPath}/chat/tchat",
									type:"POST",
									success:function(data){
										$("#ctech").html("成功！");
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
</body>
</html>