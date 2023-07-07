$(() => {
  const prodNo = sessionStorage.getItem('prodNo');
  $('div.product_view_pic > img').attr('src', `../images/${prodNo}.jpg`);

  $.ajax({
    url: 'http://localhost:8888/back/product',
    method: 'GET',
    data: `prodNo=${prodNo}`,
    success: (responseObj) => {
      const prodName = responseObj.prodName;
      const prodPrice = responseObj.prodPrice;

      $('span.ko').html($('span.ko').html() + ' ' + prodName);
      $('span.en').html($('span.en').html() + ' ' + prodPrice);
      $('span.name').html(prodName);
    },
    error: (jqXhr, status) => {
      alert(`네트워크 연결 실패!: ${status}\n오류명:${jqXhr.statusCode}`);
    },
  });
});
