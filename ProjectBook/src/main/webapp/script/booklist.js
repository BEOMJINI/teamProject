let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
let status = true;


function category(ths,category){
	
	var keyword = $(ths).text();
		let query={
			category : category,
			keyword : keyword
		};
	
		$.ajax({
			type : "POST",
			url : ctx + "/bookCategory.do",
			data : query,
			success(data){ 
				console.log(data);
				location.href=ctx + "/bookList.do?cate=" + category +"&key="+keyword
				
			}
     
		})
	
}