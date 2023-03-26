let radio = document.querySelectorAll("input[name=store]");

for (let i = 0; i < radio.length; i++) {
	radio[i].addEventListener("click", () => {
		alert('tets');
	})
}

function radioEvent(){
	let store = $('input:radio[name=store]:checked').val();
	
}
	


