- innerhtml, innerText는 모든 자식의 특정값들을 가져와

      <div id="id">
      <p>123</p>
      <div>
        <p>
          123
        </p>
      </div>
      <a href="#">a</a>
          </div>
      
          <script>
            var v1 = document.querySelector('#id').innerText;
            document.write(v1);
          </script>
      
          결과:
          123
      
          123
          
          a
          123 123 a

- e.preventDefault(); = return false;

- jquery AJAX

              $.ajax({url: '',
                    method: '',
                    data: '',
                    success: '',
                    error: '' })


- ajax 설명

           success: (responseData) => {
            alert(responseData);
          },
          error: (jqXhr, status) => {
            alert(`실패: ${status}\n오류명:${jqXhr.statusCode}`);
          },

  -error: 네트워크 오류 -> 다른 오류들이 발생해도 success로 갈 수도 있어!
