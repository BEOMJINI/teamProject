let sum = 0;


$("#check-all").click(function() {
	if ($("#check-all").is(":checked")) {
		$("input[name=check]").prop("checked", true);
	} else {
		$("input[name=check]").prop("checked", false);
	}
	
});

$("input[name=check]").click(function() {
	let max = $("input[name=check]").length;
	let count = $("input[name=check]:checked").length;

	if (max == count) {
		$("#check-all").prop("checked", true);
	} else {
		$("#check-all").prop("checked", false);
	}
	
});

$(document).ready(function() {
	$("#check-all").prop("checked", true);
	$("input[name=check]").prop("checked", true);
	let arr = $("input[name=check]").filter(":checked").val();
	console.log("arr ==  " + arr);
	let arr2 = [];

	$("input[name=check]").each(function() {
		if ($(this).is(":checked")) {
			console.log($(this).val());
			arr2.push($(this).val());
			sum += $(this).val() * 1;

		}
	});
	console.log("arr2 == " + arr2);
	console.log(sum);
	$("#sum").html(sum);
	
	

});
/*
function price() {



	sum = 0;
	let disco = 0;
	let cqtycqty = 0;
	$("input[name=check]").each(function() {
		if ($(this).is(":checked")) {
			$("input[name=cqtyTest]").oninput = alert($("input[name=cqtyTest]").val());


		}
	});
	
};

*/

