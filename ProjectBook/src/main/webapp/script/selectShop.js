let radio = document.querySelectorAll("input[name=store]");

for (let i = 0; i < radio.length; i++) {
	radio[i].addEventListener("change", radioEvent);
}

function radioEvent(){
	let store = $('input:radio[name=store]:checked').val();
	
	let sto0 = document.querySelector("#sto0");
	let sto1 = document.querySelector("#sto1");
	let sto2 = document.querySelector("#sto2");
	let sto3 = document.querySelector("#sto3");
	
	if(store == '0'){
		sto0.style.display = "block";
		sto1.style.display = "none";
		sto2.style.display = "none";
		sto3.style.display = "none";		
	} else if (store == '1'){
		sto0.style.display = "none";
		sto1.style.display = "block";
		sto2.style.display = "none";
		sto3.style.display = "none";	
	} else if (store == '2'){
		sto0.style.display = "none";
		sto1.style.display = "none";
		sto2.style.display = "block";
		sto3.style.display = "none";	
	} else if (store == '3'){
		sto0.style.display = "none";
		sto1.style.display = "none";
		sto2.style.display = "none";
		sto3.style.display = "block";	
	}
	
}

$(document).ready(function() {
	let selectShopForm = document.querySelector("#selectShop_Form");
	let pay = document.querySelectorAll("input[name=payBtn]");
	for(let i=0; i<pay.length; i++){
		pay[i].addEventListener("click",()=>{
			selectShopForm.action="payMain.do";
			selectShopForm.submit();
		});
	}	
});	