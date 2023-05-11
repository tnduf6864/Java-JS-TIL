public class ProductRepository  {

    public static void insert (Product p) {

        //1. JDBC����̹� �ε�
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
             System.out.println("JDBC����̹��� �����ϴ�");
             return;
        }

        //2. DB����
        java.sql.Connection conn = null;

        try{
            String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe";
            String user = "kosta44";
            String password = "kosta44";

            conn =  java.sql.DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("DB�������");
            return;
        }

        //3. SQL�� ����
   
        String insertSQL = 
            "INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('" + p.prodNo  +"', '�����', 10000)";
             //�����ݷ��� ���ڿ��ȿ� ������ �ȵ�
        java.sql.Statement stmt = null;
        try{
            stmt = conn.createStatement();
            //4. ���� ��� ���ſ� ���� cnt
            int cnt = stmt.executeUpdate(insertSQL);
            //5. ���ų���Ȱ��
            System.out.println("�߰��Ǽ�: " + cnt);
        }catch(Exception e){
            System.out.println("�߰� ����");
            return;
        }
        
        //6. DB���� �ݱ�
        try { stmt.close(); }catch(Exception e) {}
        try { conn.close(); }catch(Exception e) {}
    }

    public static Product selectByProdNo (String no) {

        //1. JDBC����̹� �ε�
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
             System.out.println("JDBC����̹��� �����ϴ�");
             return null;
        }

        //2. DB����
        java.sql.Connection conn = null;

        try{
            String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe";
            String user = "kosta44";
            String password = "kosta44";

            conn =  java.sql.DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("DB�������");
            return null;
        }

        //3. SQL�� ����
        
        java.sql.Statement stmt = null;
        java.sql.ResultSet rs = null; 	//���� ���

        try{
            stmt = conn.createStatement();

            String selectByNoSQL = "SELECT * FROM PRODUCT WHERE Prod_no = '" + no + "'";

            //4. ���۰�� ���ſ� ���� rs
            rs = stmt.executeQuery(selectByNoSQL);
            //rs.next() - ��ȯ ��: �̵� �� ���� �� ����(true/false);
            boolean result = rs.next();

            //5. ���ų��� Ȱ��
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
                System.out.println("�˻� ���� X");
                return null;
            }
        }catch(Exception e){
            System.out.println("DB ����");
            return null;
        }finally{
            //6. DB���� �ݱ�
            try { stmt.close(); }catch(Exception e) {}
            try { conn.close(); }catch(Exception e) {}
        }

    }

    public static Product[] selectAll () {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
             System.out.println("JDBC����̹��� �����ϴ�");
             return null;
        }

        java.sql.Connection conn = null;

        try{
            String url = "jdbc:oracle:thin:@192.168.0.116:1521:xe";
            String user = "kosta44";
            String password = "kosta44";

            conn =  java.sql.DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("DB�������");
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
            rs2 = stmt2.executeQuery(selectCountSQL); // count(*)��

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
            System.out.println("DB ����");
            return (new Product[0]);
        }finally{
            try { stmt.close(); }  catch(Exception e) {}
            try { stmt2.close(); } catch(Exception e) {}
            try { conn.close(); }  catch(Exception e) {}
        }
    }

}