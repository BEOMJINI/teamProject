function addComma(value) {
	value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return value;
}


function removeComma(value) {
	value = value.replace(/[^\d]+/g, '');
	return value;
}

function itemTotal() {
	let list = document.querySelectorAll("input[name=check]");
	let totalList = document.querySelectorAll("input[name=cart_discount]");
	let qtyList = document.querySelectorAll("input[name=cart_qty]");
	
	let total = 0;
	for (let i = 0; i < list.length; i++) {
		if (list[i].checked) {
			total += ( totalList[i].value * qtyList[i].value ) * 1;
		}
	}
	
	if(total != 0){
		
		total = addComma(total+"");
	}
	$("#sumsumsum").html(total);
}

function addEvent() {


	let list = document.querySelectorAll("input[name=check]");
	for (let i = 0; i < list.length; i++) {
		list[i].addEventListener("click", checkBox);
	}
	
	list = document.querySelectorAll("input[name=cart_qty]");
	for (let i = 0; i < list.length; i++) {
		list[i].addEventListener("click", qtyControll);
	}

	let allCheck = document.querySelector("input[name=check-all]");
	if (allCheck != null) {
		allCheck.addEventListener("click", checkAll);
	}
	
	let delivery = document.querySelector("input[name=deliveryBtn]");
	if (delivery != null) {
		delivery.addEventListener("click",()=>{
			if($("input[name=check]:checked").length == 0){
				Swal.fire(
  '선택된 책이 없습니다',
  '책을 선택한 후 진행해주세요',
  'question'
)
				
			} else {
			let cartform = document.querySelector("#cart_form");
			cartform.action="payMain.do";
			cartform.submit();
			}
		});
	}
}


function qtyControll() {
	let index = $("input[name=cart_qty]").index(this);
	let buyCount = $("input[name=cart_qty]").eq(index).val();
	
	let cost = $("input[name=cart_discount]").eq(index).val();				
	

	let price = buyCount * 1 * cost * 1;						
	price = price + "";
	price = addComma(price);
	$(".cost").eq(index).html(price + ' 원');

	itemTotal();
}

function checkBox() {
	let total = $("input[name=check]").length;
	let checked = $("input[name=check]:checked").length;
	
	if (total != checked) {
		$("input[name=check-all]").prop("checked", false);
	} else {
		$("input[name=check-all]").prop("checked", true);
	}
	itemTotal();
}

function checkAll() {
	let list = document.querySelectorAll("input[name=check]");
	for (let i = 0; i < list.length; i++) {
		list[i].checked = this.checked;
	}
	itemTotal();
}

function statusControll(idx) {

	let list = document.querySelectorAll("input[name=check]");
	let statusList = document.querySelectorAll("input[name=status]");

	if(list[idx].checked){
		statusList[idx].value = 1;
	} else {
		statusList[idx].value = 2;
	}
}


$(document).ready(function() {
	let allCheck = document.querySelector("input[name=check-all]");
	allCheck.checked = true;
	let list = document.querySelectorAll("input[name=check]");
	for (let i = 0; i < list.length; i++) {
		list[i].checked = true;
	}
	itemTotal();
	
	addEvent();
	

});
