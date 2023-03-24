let sum = 0;


$("#check-all").click(function() {
	if ($("#check-all").is(":checked")) {
		$("input[name=check]").prop("checked", true);
	} else {
		$("input[name=check]").prop("checked", false);
	}
	
});

let checks = document.querySelectorAll("input[name=check]");

checks.forEach((tag)=>{
	tag.addEventListener("change",()=>{
		
	}) 
})

$("input[name=check]").click(function() {
	let max = $("input[name=check]").length;
	let count = $("input[name=check]:checked").length;

	if (max == count) {
		$("#check-all").prop("checked", true);
	} else {
		$("#check-all").prop("checked", false);
	}
	
});


list = document.querySelectorAll("input[name=cart_qty]");
for (let i = 0; i < list.length; i++) {
	list[i].addEventListener("click", changeQty);
}


function changeQty() {
	let checklist = document.querySelectorAll("input[name=check]");
	for (let i = 0; i < checklist.length; i++) {
		if (checklist[i].checked) {
			
			console.log(list);
			let index = $("input[name=cart_qty]").index(this);
			//var index = $(".qty_div").index(this);
			console.log("index = ", index);
			let buyCount = $(".cart_qtyBtn").eq(index).val();

			let cost = $(".cart_discount").eq(index).val();				// 원가

			let price = buyCount * cost;						// 총금액
			price = price + "";

			console.log(buyCount, cost, price);
			$(".cost").eq(index).html(price);
		} else {
			console.log(list);
			let index = $("input[name=cart_qty]").index(this);
			//var index = $(".qty_div").index(this);
			console.log("index = ", index);
			let buyCount = $(".cart_qtyBtn").eq(index).val();

			let cost = $(".cart_discount").eq(index).val();				// 원가

			let price = buyCount * cost;						// 총금액
			price = price + "";

			console.log(buyCount, cost, price);
			$(".cost").eq(index).html("");
		}
	}
	
	
	
	
}