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

<form action="/board/modify" method="post">

<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
<input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'> 


<div class="form-group">
	<label>Bno</label>
	<input class="form-control" name="bno" readonly="readonly" value="<c:out value='${board.bno }'/>"/>
</div>
<div class="form-group">	
	<label>Title</label>
	<input class="form-control" name="title" value="<c:out value='${board.title }'/>"/>
</div>	
<div class="form-group">
	<label>Content</label>
	<textarea class="form-control" name="content"><c:out value="${board.content }"/></textarea>
</div>
<div class="form-group">
	<label>Writer</label>
	<textarea class="form-control" name="writer"><c:out value="${board.writer }"/></textarea>
</div>		
<div class="form-group">
	<label>RegDate</label>
	<input class="form-control" disabled="disabled" name="regdate" readonly="readonly" value="<fmt:formatDate value='${board.regdate }' pattern='yyyy-MM-dd hh:mm'/>"/>
</div>
<div class="form-group">	
	<label>updateDate</label>
	<input class="form-control" disabled="disabled" name="updateDate" readonly="readonly" value="<fmt:formatDate value='${board.updateDate }' pattern='yyyy-MM-dd hh:mm'/>"/>
</div>
	
	<button data-oper="modify" class="btn btn-default" type="submit">Modify</button>
	<button data-oper="remove" class="btn btn-danger" type="submit">Remove</button> 
	<button data-oper="list" class="btn btn-info" type="submit">List</button> 
</form>
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
	var formObj = $("form");
	
	$("button").on("click", function(e){
		
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === "remove"){
			formObj.attr("action", "/board/remove");
		} else if(operation === "list"){
			formObj.attr("action", "/board/list");
			formObj.attr("method", "get");
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			var typeTag = $("input[name='type']").clone();
			var keyword = $("input[name='keyword']").clone();
			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(typeTag);
			formObj.append(keyword);
		}
		
		formObj.submit();
	});
	
	
});
</script>
       
<%@ include file="../includes/footer.jsp" %>       
       