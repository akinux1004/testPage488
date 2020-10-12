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
                <a href="/board/list"><button id='' type="button" class="btn btn-primary btn-sm float-right">Board Read Page</button></a>
            </div>
            
            <!-- /.panel-heading -->
            <div class="panel-body">

     
<div class="form-group">
	<label>Bno</label>
	<input class="form-control" name="bno" readonly="readonly" value="<c:out value='${board.bno }'/>"/>
</div>
<div class="form-group">	
	<label>Title</label>
	<input class="form-control" name="title"  readonly="readonly" value="<c:out value='${board.title }'/>"/>
</div>	
<div class="form-group">
	<label>Content</label>
	<textarea class="form-control" name="content" readonly="readonly"><c:out value="${board.content }"/></textarea>
</div>	
<div class="form-group">
	<label>RegDate</label>
	<input class="form-control" name="regdate" readonly="readonly" value="<fmt:formatDate value='${board.regdate }' pattern='yyyy-MM-dd hh:mm'/>"/>
</div>
<div class="form-group">	
	<label>updateDate</label>
	<input class="form-control" name="updateDate" readonly="readonly" value="<fmt:formatDate value='${board.updateDate }' pattern='yyyy-MM-dd hh:mm'/>"/>
</div>	
	
	<button data-oper="modify" class="btn btn-default" type="submit">Modify</button>
	<button data-oper="list" class="btn btn-info" type="submit">List</button> 
             
         
   <form id="operForm" action="/board/modify" method="get">
   		<input type="hidden" id="bno" name="bno" value="<c:out value='${board.bno }'/>"/>
   		<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum }'/>"/>
   		<input type="hidden" name="amount" value="<c:out value='${cri.amount }'/>"/>
   		<input type="hidden" name="type" value="<c:out value='${cri.type }'/>"/>
   		<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }'/>"/>
   </form>     
   


<div class="container">
    <div class="row">
        <div class="col-md-10">
          <div class="page-header">
            <h1><small class="pull-right">${replyCnt } comments</small> Comments </h1>
            	<textarea id="replyText" name="reply"></textarea>
            	<button id="addReply" type="submit">New Reply</button>
            </from>
          </div> 
           
           <!-- start comment list -->
<ul class="chat">
	<li class="replyLI">
		<div class="comments-list">
			<div class="media">
			              
				<p class="pull-right"><small>5 days ago</small></p>
				<a class="media-left" href="#">
				  <img src="http://lorempixel.com/40/40/people/1/">
				</a>
				<div class="media-body">
				    
					<h4 class="media-heading user_name">Baltej Singh</h4>
					Wow! this is really great.   
					 
					<div>
						<small><a href="">Like</a> - <a href="">Share</a></small>
						  
						<button type="button" class="btn btn-primary btn-xs" title="Edit">
						    <span class="glyphicon glyphicon-pencil"></span>
						</button>
						<button type="button" class="btn btn-success btn-xs" title="Approved">
						    <span class="glyphicon glyphicon-ok"></span>
						</button>
						<button type="button" class="btn btn-danger btn-xs" title="Delete">
						    <span class="glyphicon glyphicon-trash"></span>
						</button>
					</div>
				</div>
			                   
			</div>
		</div>
	</li>
</ul>
<!-- end comment list -->
           
        
        </div>
    </div>
</div>
   
<div class="plusList">
	<a href="#" class="btn btn-primary btn-sm btn-block" role="button"><span class="glyphicon glyphicon-refresh"></span> More</a>    
</div>			



                                
                			
            </div>
		<!--  end panel-body -->
		</div>
	<!-- end panel -->
	</div>
</div>
<!-- /.row -->





<script type="text/javascript" src="/resources/js/reply.js?ver=11"></script> 
<script>
$(document).ready(function(){

	var bnoValue = "<c:out value='${board.bno}'/>";
	var replyUL = $(".chat");
	var listAmount = 1; 
	
	
	showList(listAmount);
	
	
	$(".replyList").on("click", function(e){
		e.preventDefault();
		console.log("click!!");
	});
	
	
	function showList(page){
		console.log(bnoValue);
		console.log(page);
		
		replyService.getList({bno : bnoValue, page : page || 1 }, function(list){
			
			console.log(list);
			
			var str = "";
			
			for(var i = 0, len = list.length || 0; i < len ; i++){
				str += '     	<li class="replyList">';
				str += '     		<div class="comments-list">';
				str += '     			<div class="media">';
				str += '     					<p class="pull-right"><small>'+'  ['+(i+1)+']  '+replyService.displayTime(list[i].replyDate)+'</small></p>';
				str += '     					<a class="media-left" href="#">';
				str += '     				  		<img src="http://lorempixel.com/40/40/people/1/">';
				str += '     					</a>';
				str += '     				<div class="media-body">';
				str += '     				    ';
				str += '     					<h4 class="media-heading user_name">'+list[i].replyer+'</h4>';
				str += '     					<p>'+list[i].reply+'</p>';
				str += '     					 ';
				str += '     					<div>';
				str += '     						<small><a href="">Like</a> - <a href="">Share</a></small>';
				str += '     						  ';
				str += '     						<button type="button" class="btn btn-primary btn-xs" title="Edit">';
				str += '     						    <span class="glyphicon glyphicon-pencil"></span>';
				str += '     						</button>';
				str += '     						<button type="button" class="btn btn-success btn-xs" title="Approved">';
				str += '     						    <span class="glyphicon glyphicon-ok"></span>';
				str += '     						</button>';
				str += '     						<button type="button" class="btn btn-danger btn-xs" title="Delete">';
				str += '     						    <span class="glyphicon glyphicon-trash"></span>';
				str += '     						</button>';
				str += '     						<input type="text" name="rno" value="'+list[i].rno+'"/>';
				str += '     					</div>';
				str += '     				</div>';
				str += '     			                   ';
				str += '     			</div>';
				str += '     		</div>';
				str += '     	</li>';

			}//for 문
			
			
			
			replyUL.html(str); // end  댓글 리스트 구현 
			
			$("button[title='Approved']").hide();
			
			
			// replyUL.html(str); 이 밖에서 호출이 안된다. 아마 인스턴스가 사라지기에 그런것 같다. 그리고 이밑에 기능도 구현을 하려니 밖에서 호출 또는 실행이 되지 않아  callback 함수 부분에서 구현 해본다.
			$("button").on("click", function(){
				
				var title = $(this).attr("title");
				var replyTag = $(this).parent().parent().find("p");
				var reply = replyTag.html();
				
				
				console.log(title);
				
				// this 의 Edit 버튼을 클릭시 해당 본문의 내용을 인풋 텍스트 태그로 변환  (수정을 위한 용도)
				if(title === "Edit"){
					//수정하기 버튼에서 전송 버튼으로 바꾸기		
					$(this).attr("title", "Approved").attr("class", "btn btn-success btn-xs").children().first().attr("class", "glyphicon glyphicon-ok");
					
					//list[i].reply 가 있는  p 태그를 input 태그로 변경하기
					replyTag.contents().unwrap().wrap( "<input id='replyINPUT' type='text' value='"+reply+"'/>" );
					
				}
				
				// modify
				if(title === 'Approved'){
					
					console.log("Approved Click!!!");
					
					// 이렇게 접근 해서 값을 가져오지 않으면 리스트의 다른 값들을 가져온다 ... 꼭 $(this) 가 필요하여  this 에서 상위 노드로 이동후 자식노드를 찾아 값을 가져온다.
					var replyTag = $(this).parent().parent().find("input");
					var rnoTag = $(this).parent().find("input");
					
					//ajax 자원
					var reply = replyTag.val();	
					var rno = rnoTag.attr("value");
					console.log(reply);
					console.log(rno)
					
					//update 할 JSON 객체
					var replyJSON = {rno : rno, reply : reply};
					
					// 수정완료 버튼 클릭 처리
					replyService.update(replyJSON, function(result){
						alert(result);
						//location.reload();
						
						showList(listAmount);
					});
					
				}
				
				
				//remove
				if(title === 'Delete'){
					
					var rnoTag = $(this).parent().find("input");
					var rno = rnoTag.attr("value");
					
					console.log(rno);
					
					replyService.remove(rno, function(result){
						alert(result);
						
						showList(listAmount);
					});
					
				}
				
				
				
			});
			
			
			
		}); //end replyService.getList
	
	} // end showList()
	
	
	
	// 댓글 더보기 기능 : more 버튼 클릭시 리스트  showList 인자를 증감하여 호출
	$(".plusList").on("click", function(e){
		e.preventDefault();
		
		listAmount++;
		
		showList(listAmount);
		
	});
	
	
	// 댓글 등록 기능 : replyer 를 default 인 AKI 로 하였으니 , 차후 로그인 구현 시 수정 하도록 하자 
	$("#addReply").on("click", function(e){
		
		var replyText = $("#replyText");
		
		var reply = {
				reply : replyText.val(),
				replyer : "AKI",
				bno : bnoValue
		} 
		
		replyService.add(reply, function(result){
			
			alert(result);
			replyText.val("");
			
			showList(1);
			//showList(listAmount); 댓글 등록시 리스트를 1페이지만 보여 줄것인지 아니면 이전에 열람 했던 댓글 리스트를 고대로 보여줄 것인지 선택 사항으로 이것을 주석 처리함.  
		});
		
	});
	
	$(".replyList").on("click", function(){
		console.log("AAA");
	})
	
	
	
	
	
});
</script>


<script>
$(document).ready(function(){
	
	var operForm = $("#operForm");
	var modifyButton = $("button[data-oper='modify']");
	var listButton = $("button[data-oper='list']");
	
	
	modifyButton.on("click", function(e){
		operForm.submit();
		
	});
	
	listButton.on("click", function(e){
		operForm.find("#bno").remove();
		operForm.attr("action", "/board/list");
		operForm.submit();
	});
	
	
});


</script>

<%@ include file="../includes/footer.jsp" %>
   