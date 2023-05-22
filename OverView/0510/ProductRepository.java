public class ProductRepository  {

    static Product pArr[] = new Product[5];
    static int totalCnt = 0;

    public static void insert (Product p) {
        pArr[totalCnt++] = p;
    }

    public static Product selectByProdNo (String no) {

        for (int i = 0; i < totalCnt; i++) {
            Product p = pArr[i];
            if (p.prodNo.equals(no))
                return p;
        }

        return (null);
    }

    public static Product[] selectAll () {
        Product[] all = new Product[totalCnt];
        for (int i = 0; i < totalCnt; i++) {
            all[i] = pArr[i];
        }
        return all;
    }

}