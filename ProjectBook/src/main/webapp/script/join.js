// 약관보기 
const dialog = document.querySelector('dialog');
const cancel = document.querySelector('#cancelBtn');

$("#specialty").click(function () {

    dialog.showModal();
});

$("#cancelBtn").click(function () {
    dialog.close();
});

// 체크박스 선택 개수 제한
let max = 3;
let count = 0;

function checkCount(c) {
    if (c.checked) {
        count += 1;
    } else {
		count -= 1;
	}

    if (count > max) {
        c.checked = false;
        count -= 1;
        alert("최대 3개 까지만 가능합니다.");
    }
};