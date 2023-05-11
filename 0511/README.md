<JDBC>
  1. JDCB 드라이버 로드
  2. DB연결
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

  <ojdbc주소 추가>
  javac -d d:\overview\myjava -cp d:overview\myjava d:\overview\myjava\Product*.java
  java -cp d:\lib\ojdbc6.jar;d:\overview\myjava\ ProductUser
    
  2. DB연결    
  try{
      String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe";
      String user = "kosta44";
      String password = "kosta44";

      java.sql.DriverManager.getConnection(url, user, password);
  }catch(Exception e){
      System.out.println("DB연결실패");
      return;
  }
    
    stmt.executeQuery() - 조회할 때 만
    stmt.executeUpdate() - 조회를 제외한 추가, 삭제, 수정에서
    
    차이: 
