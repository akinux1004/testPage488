


var replyService = (function(){
	
	
	function getList(param, callback, error){
		
		var bno = param.bno;
		var page = param.page;
		
		$.getJSON("/replies/pages/" + bno + "/" + page+".json", function(data){
			if(callback)
				callback(data);
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
		
	}
	
	function displayTime(timeValue){
		var today = new Date();
	
		var gap = today.getTime() - timeValue;
		
		var dateObj = new Date(timeValue);
		
		var str = "";
		
		if(gap < 1000 * 60 * 60 * 24){
			
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [(hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join('');
		} else {
			
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			
			return [yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd ].join(''); 
		}
	};
	
	function add(reply, callback, error){
	
		console.log("add reply ........... ");
		
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
		
	}
	
	function update(replyJSON, callback, error){
		console.log("update reply ......");
		
		$.ajax({
			type : 'post',
			url : '/replies/modify',
			data : JSON.stringify(replyJSON),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error)
					error(er);
			}
		});
	}
	
	//와 무슨 함수 이름에 delete 로 하니깐 syntax 에러 라고 뜨길래 개 염병 했네 와진짜 자스 하기 존나 싫다. 	
	function remove(rno, callback, error){
		console.log("delete reply .....");
		
		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error)
					error(er);
			}
		});
		
	}
	

	
	return {
		
		getList : getList,
		displayTime : displayTime,
		add : add,
		update : update,
		remove : remove
		
	};
	
})();