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
<title>游戏聊天室</title>
</head>
<body>
<script type="text/javascript">
		var websocket;
		if('WebSocket' in window){
			websocket=new WebSocket("ws://localhost:8080/online_chart/ws");
			}
		websocket.onopen = function(event) {
			console.log("WebSocket:已连接");
			console.log(event);
		};
		websocket.onmessage = function(event) {
			var data=JSON.parse(event.data);
			console.log("WebSocket:收到一条消息",data);
			$("#content").append("<p>"+data.username+"</p><p>"+data.msg+"</p>");
		};
		websocket.onerror = function(event) {
			console.log("WebSocket:发生错误 ");
			console.log(event);
		};
		websocket.onclose = function(event) {
			console.log("WebSocket:已关闭");
			console.log(event);
		}
		function send(){
			var messsage=$("#message").val();
			var data={};
			data["username"]="${username}";
			data["msg"]=message;
			websocket.send(JSON.stringify(data));
			$("#content").append("<p>"+'${username}'+"</p>"+"<p>"+data.msg+"</p>");
			}
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<h2>${username},游戏聊天室欢迎你</h2>
					<!-- 这里显示聊天室的内容 -->
					<div class="row" id="content"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
						<input type="text" name="message" class="form-control" id="message"/>
						<button type="button" class="btn btn-primary" onclick="send()">提交</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>