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
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12" id="content">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					 <textarea rows="5" id="message"></textarea>
					<button type="button" class="btn btn-primary" id="send">
						提交
					</button>
					<script type="text/javascript">
						
						$(document).ready(function(){
							var socket = new WebSocket('ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket');
				            // 处理服务器端发送的数据
				            socket.onmessage = function(event) {
				                addMessage(event.data);
				            };
				            $("#send").click(function(){
					            var mes=$("#message").val();
				            	socket.send(JSON.stringify({
			                        content : mes
			                    }));
							});
							function addMessage(message){
								mess = JSON.parse(message);
								var str="<p>"+mess.data+"</p>"+"<p>"+mess.message+"</p>";
								$(str).appendTo("#content");
								}
							});
					</script>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>