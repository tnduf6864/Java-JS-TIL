public class ProductUser {

    static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String []args) {

        String opt;

        do {
            System.out.println("작업을 선택하세요");
            System.out.println("1: 상품 전체 검색, 2: 상품번호로 검색, 3: 상품 추가, 9: 종료");

            opt = sc.nextLine();
            if (opt.equals("1")) {
                System.out.println(">>전체상품검색<<");

                Product resultArr[] = ProductRepository.selectAll();

                for (int i = 0; i < resultArr.length; i++) 
                    System.out.println("상품번호: " + resultArr[i].prodNo);                   	    
            }
            else if (opt.equals("2")) {
                System.out.println(">>상품검색<<");                
                System.out.print("상품 번호를 입력하세요: ");

                String noArg1 = sc.nextLine();        
        
                System.out.println(noArg1);
                System.out.println(ProductRepository.selectByProdNo(noArg1)== null? "상품이 없습니다" : "상품이 있습니다.");
            }
            else if (opt.equals("3")) {
                System.out.println(">>상품추가<<");
                System.out.print("상품 번호를 입력하세요: ");

                Product pArg = new Product();
                pArg.prodNo = sc.nextLine();
                ProductRepository.insert(pArg);
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