public class ProductRepository  {

    static Product pArr[] = new Product[5];

    public static void main(String []args)  {
	
        for (int i = 0; i < 5; i++) {
            pArr[i] = new Product();
            pArr[i].prodNo = "G000" + (i + 1);
        }

        for(Product p: pArr)
            System.out.println(p.prodNo);
    }

}