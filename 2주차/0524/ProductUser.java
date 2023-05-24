
import java.util.Scanner;

import com.my.product.dao.ProductRepository;
import com.my.product.dto.Product;

public class ProductUser {

    static Scanner sc = new Scanner(System.in);

    public static void main(String []args) {

    	ProductRepository repository = new ProductRepository(10); 
        String opt;

        do {
            System.out.println("작업을 선택하세요");
            System.out.println("1: 상품 전체 검색, 2: 상품번호로 검색, 3: 상품 추가, 4: 상품이름으로 검색, 9: 종료");

            opt = sc.nextLine();
            if (opt.equals("1")) {
                System.out.println(">>전체상품검색<<");

                Product resultArr[] = repository.selectAll();

                for (int i = 0; i < resultArr.length; i++)                
                {
                	resultArr[i].print();
                	System.out.println();
                }
                
            }
            else if (opt.equals("2")) {
                System.out.println(">>상품검색<<");                
                System.out.print("상품 번호를 입력하세요: ");

                String noArg1 = sc.nextLine();        
        
                System.out.println(noArg1);
                
                Product repo =  repository.selectByProdNo(noArg1);
                if (repo != null)                
                	repo.print();                                 
                
            }
            else if (opt.equals("3")) {
            	
                System.out.println(">>상품추가<<");
                
                System.out.print("상품 번호를 입력하세요: ");
                String prodNo = sc.nextLine();
                
                System.out.print("상품 이름을 입력하세요: ");
                String prodName = sc.nextLine();
                
                System.out.print("상품 가격을 입력하세요: ");
                int prodPrice = Integer.parseInt(sc.nextLine());
                
                Product pArg = new Product(prodNo, prodName, prodPrice);
                //repository.insert2(pArg);                              
                repository.insert(pArg);
            }
            
            else if (opt.equals("4")) {
                System.out.println(">>상품이름으로 검색<<");                
                System.out.print("단어를 입력하세요. 단어를 포함한 상품명으로 검색합니다. ");

                String nameArg1 = sc.nextLine();                             
                Product[] pArr = repository.selectByProdName(nameArg1);
                
                //for (int i = 0; i < pArr.length; i++)
                for (Product p: pArr)
                	p.print();                
            }
            
            else if (opt.equals("9")) {

            }
            else {
                System.out.println("잘못입력하였습니다.");
            }
        } while(!opt.equals("9"));

/*
        System.out.println(">>상품추가<<");
        Product pArg = new Product();
        pArg.prodNo = "G0001";
        insert(pArg);

        System.out.println(">>상품추가<<");
        Product pArg1 = new Product();
        pArg1.prodNo = "G0002";
        insert(pArg1);

        System.out.println(">>상품검색<<");
        String noArg1 = "G0002";
        Product result1 = selectByProdNo(noArg1);
        System.out.println(noArg1);
        System.out.println(result1 == null? "상품이 없습니다" : "상품이 있습니다.");

        System.out.println(">>상품검색<<");
        String noArg2 = "X";
        System.out.println(selectByProdNo(noArg2) == null? "상품이 없습니다" : "상품이 있습니다.");

        System.out.println(">>전체상품검색<<");
        Product resultArr[] = selectAll();
        for (int i = 0; i < resultArr.length; i++) 
            System.out.println("상품번호: " + resultArr[i].prodNo);               
        */

    }

}