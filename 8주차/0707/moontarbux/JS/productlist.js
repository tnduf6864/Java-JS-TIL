$(() => {
  //1. 상품목록 서버에서 가져와서 화면에 출력
  getProdlistFromServer();

  //2. 이미지가 클릭되었을 때 product.html section에 표시
  //상품목록이 서버에서 로드가 된 후 해야함. (동기화처리)
  //상품의 정보를 넘겨줘야함.

  const 상품목록리스트 = $('div.productlist');

  상품목록리스트.on('click', 'div.product', (e) => {
    const prodNo = $(e.currentTarget).attr('class').split(' ')[1];

    alert(prodNo);

    if ($(e.target).attr('src') != null) {
      sessionStorage.setItem('prodNo', prodNo);
      $('section').load(`./product.html`);
    }
  });

  //--상품목록 얻기 END--
});

function getProdlistFromServer() {
  $.ajax({
    url: 'http://localhost:8888/back/productlist',
    method: 'GET',
    success: (responseObj) => {
      //네트워크 연결 성공시 화면에 상품정보 Show
      show_productlist(responseObj);
    },
    error: (jqXhr, status) => {
      alert(`네트워크 연결 실패!: ${status}\n오류명:${jqXhr.statusCode}`);
    },
  });
}

function show_productlist(responseObj) {
  const 상품추가위치 = $('div.productlist > div.product');
  const 상품원본 = 상품추가위치.first(); //원본

  responseObj.forEach((pObj) => {
    let 상품복제본 = 상품원본.clone(); //복제본
    상품복제본.addClass(pObj.prodNo); //복제본 클래스추가
    상품복제본
      .find('ul > li > img')
      .attr('src', `../images/${pObj.prodNo}.jpg`)
      .attr('alt', `${pObj.prodNo}`);
    상품복제본.find('ul > li > span').html(pObj.prodName);
    상품원본.parent().append(상품복제본);
  });

  상품원본.hide();
}
