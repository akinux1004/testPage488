<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ include file="../includes/header.jsp" %>

     
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><a href="/board/list">Tables</a></h1>
	</div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a href="/board/list"><button id='register' type="button" class="btn btn-primary btn-sm float-right">Board List Page</button></a>
                <button id='regBtn' type="button" class="btn btn-primary btn-sm float-right"><a href="/board/register">Register New Board</a></button>
            </div>
            
            <!-- /.panel-heading -->
            <div class="panel-body">


<!-- LIST -->                                    	
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">#BNO</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">등록일자</th>
      <th scope="col">수정일자</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${list }" var="list">
      <tr>
 		<td><c:out value="${list.bno }"/></td>
 		<td><a class="move" href="<c:out value='${list.bno }'/>"><c:out value="${list.title }"/></a><small>   [<c:out value="${list.replyCnt}"/>]  </small></td>
 		<td><c:out value="${list.writer }"/></td>
 		<td><fmt:formatDate value="${list.regdate }" pattern="yyyy-MM-dd hh:mm"/>
 		<td><fmt:formatDate value="${list.updateDate }" pattern="yyyy-MM-dd hh:mm"/>	    
      </tr>	
    </c:forEach>
 </tbody>
</table>

<!-- pagination -->
<div class="row">
<div class="col-lg-12">
  <ul class="pagination pull-right">
    
    <c:if test="${pageMaker.prev }">
	    <li class="page-item">
	      <a class="page-link" href="${pageMaker.startPage -1 }" tabindex="-1">Previous</a>
	    </li>
    </c:if>
    
    <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
    	<li class="page-item ${pageMaker.cri.pageNum == num ? 'active' : '' }">
	      <a  href=${num }>${num }</a>
	    </li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
	    <li class="page-item">
	      <a class="page-link" href="${pageMaker.endPage + 1 }">Next</a>
	    </li>
    </c:if>
    
  </ul>
  
  

<form id="actionForm" action="/board/list" method="get">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }"/>
	<input type="hidden" name="amount" value="${pageMaker.cri.amount }"/>
	<input type="hidden" name="type" value="${pageMaker.cri.type }"/>
	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }"/>
</form>

<!-- search bar -->

	<div class="col-lg-4">
		<form id="searchForm" action="/board/list" method="get">
			<select name="type">
				<option value="" <c:out value="${pageMaker.cri.type == null ? 'selected' : ''}"/>>--</option>
				<option value="T" <c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : ''}"/>>제목</option>
				<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : ''}"/>>내용</option>
				<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected' : ''}"/>>작성자</option>
				<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected' : ''}"/>>제목 or 작성자</option>
				<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : ''}"/>>제목 or 내용</option>
				<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW' ? 'selected' : ''}"/>>제목 or 내용 or 작성자</option>
			</select>
			<input type="text" name="keyword" value="<c:out value='${pageMaker.cri.keyword }'/>"/>
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }"/>
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }"/>
			<button class="btn btn-success">Search</button>
		</form>
	</div>
</div>




<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

                                
                			
            </div>
		<!--  end panel-body -->
		</div>
	<!-- end panel -->
	</div>
</div>
<!-- /.row -->
       
<script>
$(document).ready(function(){
	
	var result = "<c:out value='${result}'/>";
	checkModal(result);
	
	history.replaceState({}, null, null);
	
	function checkModal(result){
		
		if (result === '' || history.state) {
			return;
		}
		
		if(parseInt(result) > 0){
			$(".modal-body").html(" 게시물 " + parseInt(result) + " 번이 등록 되었습니다.");
		}
		
		$("#myModal").modal("show");
	};
	
	
	var actionForm = $("#actionForm");
	var searchForm = $("#searchForm");
	var move = $("#move");
	
	$(".page-item a").on("click", function(e){
		e.preventDefault();
		console.log("page-item click!!");
		
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	
	});
	
	$("#searchForm button").on("click", function(e){
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();
		searchForm.submit();
	});
	
	$(".move").on("click", function(e){
		
		e.preventDefault();
		
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'/>");
		actionForm.attr("action", "/board/get");
		actionForm.submit();
		
	});
	
	$("#register").on("click", function(e){
		e.preventDefault();
		
		console.log("click register!!");
		
		actionForm.attr("action", "/board/register");
		actionForm.submit();
	});
	
	
	
});


</script>

<%@ include file="../includes/footer.jsp" %>
   