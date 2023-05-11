public class ProductRepository  {

    public static void insert (Product p) {

        //1. JDBC드라이버 로드
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
             System.out.println("JDBC드라이버가 없습니다");
             return;
        }

        //2. DB연결
        java.sql.Connection conn = null;

        try{
            String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe";
            String user = "kosta44";
            String password = "kosta44";

            conn =  java.sql.DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("DB연결실패");
            return;
        }

        //3. SQL문 전송
   
        String insertSQL = 
            "INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('" + p.prodNo  +"', '냉장고', 10000)";
             //세미콜론이 문자열안에 있으면 안됨
        java.sql.Statement stmt = null;
        try{
            stmt = conn.createStatement();
            //4. 전송 결과 수신용 변수 cnt
            int cnt = stmt.executeUpdate(insertSQL);
            //5. 수신내용활용
            System.out.println("추가건수: " + cnt);
        }catch(Exception e){
            System.out.println("추가 실패");
            return;
        }
        
        //6. DB연결 닫기
        try { stmt.close(); }catch(Exception e) {}
        try { conn.close(); }catch(Exception e) {}
    }

    public static Product selectByProdNo (String no) {

        //1. JDBC드라이버 로드
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
             System.out.println("JDBC드라이버가 없습니다");
             return null;
        }

        //2. DB연결
        java.sql.Connection conn = null;

        try{
            String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe";
            String user = "kosta44";
            String password = "kosta44";

            conn =  java.sql.DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("DB연결실패");
            return null;
        }

        //3. SQL문 전송
        
        java.sql.Statement stmt = null;
        java.sql.ResultSet rs = null; 	//질의 결과

        try{
            stmt = conn.createStatement();

            String selectByNoSQL = "SELECT * FROM PRODUCT WHERE Prod_no = '" + no + "'";

            //4. 전송결과 수신용 변수 rs
            rs = stmt.executeQuery(selectByNoSQL);
            //rs.next() - 반환 값: 이동 된 곳의 행 여부(true/false);
            boolean result = rs.next();

            //5. 수신내용 활용
            if (result = true) {
                String prodNo    =  rs.getString("prod_no");
                String prodName = rs.getString("prod_name");
                int     prodPrice  = rs.getInt("prod_price");

                Product p = new Product();
                p.prodNo = prodNo;
                //p.prodName = prodName;
                //p.prodPrice = prodPrice;

                return p;
            }            
            else {
                System.out.println("검색 내용 X");
                return null;
            }
        }catch(Exception e){
            System.out.println("DB 오류");
            return null;
        }finally{
            //6. DB연결 닫기
            try { stmt.close(); }catch(Exception e) {}
            try { conn.close(); }catch(Exception e) {}
        }

    }

    public static Product[] selectAll () {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
             System.out.println("JDBC드라이버가 없습니다");
             return null;
        }

        java.sql.Connection conn = null;

        try{
            String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe";
            String user = "kosta44";
            String password = "kosta44";

            conn =  java.sql.DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("DB연결실패");
            return null;
        }
        
        java.sql.Statement stmt = null;  
        java.sql.Statement stmt2 = null;  
        java.sql.ResultSet rs = null;
        java.sql.ResultSet rs2 = null;



        try{
            stmt   = conn.createStatement();
            stmt2 = conn.createStatement();
            String selectAllSQL     = "SELECT * FROM PRODUCT";
            String selectCountSQL = "SELECT COUNT(*) FROM PRODUCT";
            rs   = stmt.executeQuery(selectAllSQL);
            rs2 = stmt2.executeQuery(selectCountSQL); // count(*)문

            rs2.next();
            int cnt = rs2.getInt(1);

            Product pArr[] = new Product[cnt];
            if (cnt == 0) return pArr;

            boolean result = rs.next();
            int index = 0;

            while (result) {

                String prodNo    =  rs.getString("prod_no");
                String prodName = rs.getString("prod_name");
                int     prodPrice  = rs.getInt("prod_price");

                pArr[index] = new Product();
                pArr[index].prodNo     = prodNo;
                pArr[index].prodName = prodName;
                pArr[index].prodPrice  = prodPrice;

                index++;
                result = rs.next();
            }

            return pArr;

        }catch(Exception e){
            System.out.println("DB 오류");
            return (new Product[0]);
        }finally{
            try { stmt.close(); }  catch(Exception e) {}
            try { stmt2.close(); } catch(Exception e) {}
            try { conn.close(); }  catch(Exception e) {}
        }
    }

}