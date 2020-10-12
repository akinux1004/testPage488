<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    


<%@ include file="../includes/header.jsp" %>

     
 <div class="row">
     <div class="col-lg-12">
         <h1 class="page-header">Board Register</h1>
     </div>
     <!-- /.col-lg-12 -->
 </div>
 <!-- /.row -->
 <div class="row">
     <div class="col-lg-12">
         <div class="panel panel-default">
             <div class="panel-heading">
                 Board Register
             </div>
             <!-- /.panel-heading -->
             <div class="panel-body">
                 
<!-- ==================================================================================================================== -->                  
<div class="col-lg-12">
<form action="/board/register" method="post">
<div class="form-group">	
	<label>Title</label>
	<div><c:if test="${errors.title }"><Strong>제목을 입력 하여 주세요.</Strong></c:if></div>
	<input class="form-control" name="title"/>
</div>	
<div class="form-group">
	<label>Content</label>
	<div><c:if test="${errors.title }"><Strong>내용을 입력 하여 주세요.</Strong></c:if></div>
	<textarea class="form-control" name="content"/></textarea>
</div>
<div class="form-group">	
	<label>Writer</label>
	<div><c:if test="${errors.title }"><Strong>작성자를 입력 하여 주세요.</Strong></c:if></div>
	<input class="form-control" name="writer"/>
</div>	

<button data-oper="modify" class="btn btn-default" type="submit">Register</button>
 
</form>

<form action="/board/list" method="get">
<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum }'/>"/>
<input type="hidden" name="amount" value="<c:out value='${cri.amount }'/>"/>
<input type="hidden" name="type" value="<c:out value='${cri.type }'/>"/>
<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }'/>"/>
<button data-oper="list" class="btn btn-info" type="submit">List</button>
</form>
</div>
<!-- ==================================================================================================================== -->                       
     			
             </div>
             <!-- /.panel-body -->
         </div>
         <!-- /.panel -->
     </div>
     <!-- /.col-lg-6 -->
</div>
 <!-- /.row -->
       
<script type="text/javascript">
$(document).ready(function(){
	
	/* var formObj = $("form");
	var group = $(".form-group");
	
	$("button [data-oper='list']").on("click", function(e){
		e.preventDefault();
		
		console.log("Click List !!!");
		
		group.remove();
		formObj.attr("action", "/board/list").attr("method", "get");
		formObj.submit();
		
		
	});
	
	group.on("click", function(){
		console.log("click group!!!")
	}) */
	
});


</script>
       
<%@ include file="../includes/footer.jsp" %>      
       