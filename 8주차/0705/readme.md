DOM nodeType
    1. Element Node 
    2. Attribute Node 
    3. Text Node

- tomcat이용 servlet 과정

    ![image](https://github.com/tnduf6864/TIL/assets/66365553/9b2aede3-764a-403e-aa09-407817192717)

- 자바스크립트 도움을 받아야 렌더링을 초기화하지않고 추가 수정 할 수 있다
    - XMLHttpRequest(사용)
    - 예) 100km/s의 자동차 -> 렌더링을 초기화하고 추가하는 거 보다 수정하는 것이 더 자원상 좋음
    - 

- xhttp는 비동기라 데이터를 가져오는 규격?을 정해두고 open으로 가져와

- CORS ERROR
    - 동일출처원칙(Soruce Origin Policy)  어쩌구... (front, back 포트번호 달라서?) 
    - 해결 방법:
        - 1. 하나의 포트번호에 프론트 백 다 넣어 (비추)
          2. 서버에서 허용처리

- xhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
- form의 버튼을 눌러서 페이지를 요청하는 것이 아니기 때문에 그것처럼 만들어주기위해서 헤더를 설정해줌
