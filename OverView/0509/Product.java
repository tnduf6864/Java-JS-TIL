public class Product  {

    String prodNo;		//상품번호
    private String prodName;		//상품이름
    private int prodPrice;		//상품가격

    public static void main(String []args)  {
        System.out.println("김수열입니다");
        System.out.print("KOSTA\t 263기\n");
        System.out.println("반갑습니다");

        Product p  = new Product();
        p.prodNo = "C0001";
        p.prodName = "아메리카노";
        p.prodPrice = 1000;

        Product p1 = new Product();

        System.out.println(p.prodNo + "," + p.prodName + "," + p.prodPrice);
        System.out.println(p1.prodNo + "," + p1.prodName + "," + p1.prodPrice);

        Product pArr[];
        pArr = new Product[5];

        pArr[0] = new Product();
        pArr[0].prodNo = "F0001";
        pArr[0].prodName= "스콘";
        pArr[0].prodPrice = 10;

        pArr[1] = p;
        pArr[2] = p1;
	
       for (Product prod: pArr) {
           System.out.println(prod.prodNo);
       }

    }

}  