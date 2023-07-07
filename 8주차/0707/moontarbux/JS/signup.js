$(() => {
  const formObj = $('form.login');
  const inputIdObj = $('form div > input.inputID');
  const dupleBtn = $('form > button.dupleBtn');

  /* ID중복확인 버튼 '클릭' */
  dupleBtn.click((e) => {
    chkIdDuple();
  });

  inputIdObj.focus(() => {
    dupleBtn.css('backgroundColor', 'red');
  });

  inputIdObj.focusout(() => {
    dupleBtn.css('backgroundColor', 'blue');
  });

  formObj.submit((e) => {
    if (chkNameEmpty(e) && chkPwdMatch(e)) requestAJAX(e);
    else return false;
  });
});

function chkIdDuple() {
  var inputID = document.querySelector('.inputID');
  var btn = document.querySelector('.joinBtn');

  if (inputID.value == '') alert('아이디를 입력하세요!');
  else if (inputID.value == 'id1') alert('이미 사용중인 아이디 입니다~~~');
  else btn.style.display = 'block';
}

function chkNameEmpty(e) {
  var username = document.getElementById('username').value;
  if (username == '') {
    alert('이름을 입력하세요!');
    return false;
  }
  return true;
}

function chkPwdMatch(e) {
  var pwd1 = document.getElementById('pwd1').value;
  var pwd2 = document.getElementById('pwd2').value;

  if (pwd1 == '' || pwd2 == '') {
    alert('비밀번호를 입력하세요!');
  } else if (pwd1 != pwd2) {
    alert('비밀번호가 다릅니다!');
  } else {
    alert('가입을 환영합니다~~~!');
    return true;
  }
  return false;
}

function requestAJAX(e) {
  const formObj = $('form.login');

  $(e.target)
    .attr('action', 'http://localhost:8888/back/signup')
    .attr('method', 'post');

  // alert($(e.target).serialize());
  $.ajax({
    url: $(e.target).attr('action'),
    method: $(e.target).attr('method'),
    data: formObj.serialize(),
    success: (responseObj) => {
      if (responseObj.status == 0) alert('실패~~~~' + responseObj.msg);
      else alert('안녕');
      //const responseObj = JSON.parse(responseData); //서버에서 setContentType을 app/json으로 하면 설정 할 필요 없음.
    },
    error: (jqXhr, status) => {
      alert(`실패: ${status}\n오류명:${jqXhr.statusCode}`);
    }
  });
}
