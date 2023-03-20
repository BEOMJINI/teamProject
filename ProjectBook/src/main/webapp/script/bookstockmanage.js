let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
let status = true;

const dialog = document.querySelector('dialog');
function showModal(isbn){
	
	$.ajax({
		type: "post",
		url:"selectStoreInsertBookStock.do",
		data: { isbn : isbn},
		success: function(){
			alert("ㅇㅇ");
			
		}
	})
	dialog.showModal();
	const num=isbn;
	
}
function closeModal(){
	dialog.close();
}