<JDBC>
  1. JDCB 드라이버 로드
  2. DB 연결
  3. SQL문 전송
  4. 전송 결과 수신
  5. 수신 내용 활용
  6. DB연결닫기
  
  1. 드라이버 로드
  try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
  }catch(Exception e){
       System.out.println("JDBC드라이버가 없습니다");
       return;
  }
