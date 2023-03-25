$(document).ready(function() {
	

		let sum = 0;
		let mileage = 0;
		for(let i=0; i<100; i++){
			sum += $("#total"+i).text() * 1;
			
		}
		
		if(sum < 50000){
			$("#deli").text("3,000");
			$("#totalSum").text(sum *1 + 3000);
		} else{
			$("#deli").text("0");
			$("#totalSum").text(sum);
		}
	
		mileage = (sum / 10)+"";
		$("#saveMileage").text(addComma(mileage));
		
		$("input[name=saveMileage]").val(mileage);
		$("input[name=totalSum]").val($("#totalSum").text());
	
});	

function addComma(value) {
	value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return value;
}


function removeComma(value) {
	value = value.replace(/[^\d]+/g, '');
	return value;
}

$("#payBtn").click(function(){
	let useMileage = $("input[name=useMileage]").val();
	let totalSum = $("input[name=totalSum]").val();
	console.log
	if(useMileage > totalSum){
		Swal.fire("결제 오류", "사용하려는 마일리지가 구매 금액 보다 큽니다.", "error")
	} else {
		let payMainForm = document.querySelector("#payMain_form");
		payMainForm.action="payResult.do";
		payMainForm.submit();
	}
});
	