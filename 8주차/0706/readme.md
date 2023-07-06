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
