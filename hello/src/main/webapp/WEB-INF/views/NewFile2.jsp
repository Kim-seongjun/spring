<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="write_notices">
		<div class="modal-header" id="write_modal_header">
			<!-- <h1 class="modal-title"></h1> -->
			<label for="title">제목:</label> <input type="text"
				class="form-control" id="title" placeholder="제목" name="title">
			<button type="button" class="close" data-dismiss="modal">×</button>
		</div>
		<div class="modal-body" id="write_modal_body">
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
		<!-- Modal footer -->
		<div class="modal-footer">
			<button type="button" id="write_modal_button" class="btn btn-info"
				data-dismiss="modal">등록</button>
		</div>
	</form>



	<script type="text/javascript">
		
	</script>
</body>
</html>