$(() => {
  const formObj = $('form.login');

  formObj.submit((e) => {
    $(e.target)
      .attr('action', 'http://localhost:8888/back/login')
      .attr('method', 'post');

    $.ajax({
      url: $(e.target).attr('action'),
      method: $(e.target).attr('method'),
      data: formObj.serialize(),
      success: (responseObj) => {
        if (responseObj.status == 0) alert(responseObj.msg);
        else alert('성공~');
      },
      error: (jqXhr, status) => {
        alert(`네트워크오류: ${status}\n오류명:${jqXhr.statusCode}`);
      },
    });

    return false;
  });
});
