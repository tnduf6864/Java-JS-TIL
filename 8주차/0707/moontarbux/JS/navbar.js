const frontURL = 'http://127.0.0.1:5500/html';

$(() => {
  var nav_var = $('header > nav > ul');

  nav_var.click((e) => {
    var url;
    var 탭주소 = $(e.target).attr('href');

    if (탭주소 == './login.html') {
      url = 'login.html';
      load_xhttp(url);
    } else if (탭주소 == './signup.html') {
      url = 'signup.html';
      load_xhttp(url);
    } else if (탭주소 == './productlist.html') {
      url = 'productlist.html';
      location.href = `${frontURL}/productlist.html`;
    }
    return false;
    //탭 추가시 여기에 작성 else if(탭이름 == '') url = '.html';
  });

  function load_xhttp(url) {
    $.ajax({
      url: url,
      method: 'GET',
      // data: 'id=tnduf&pwd=1234&username=bomi',
      success: (responseData) => {
        $('section > div').html(responseData);
      },
      error: (jqXhr, status) => {
        alert(`실패: ${status}\n오류명:${jqXhr.statusCode}`);
      },
    });
  }

  function 함수() {
    location.href = `${frontURL}/productlist.html`;
  }

  // function load_xhttp(url) {
  //   let xhttp = new XMLHttpRequest();
  //   // xhttp

  //   xhttp.addEventListener('load', (e) => {
  //     $('section > div').html(e.target.responseText);
  //   });

  //   xhttp.open('GET', url);
  //   xhttp.send();
  // }
});
