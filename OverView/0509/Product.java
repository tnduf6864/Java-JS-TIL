public class Product  {

    String prodNo;		//��ǰ��ȣ
    private String prodName;		//��ǰ�̸�
    private int prodPrice;		//��ǰ����

    public static void main(String []args)  {
        System.out.println("������Դϴ�");
        System.out.print("KOSTA\t 263��\n");
        System.out.println("�ݰ����ϴ�");

        Product p  = new Product();
        p.prodNo = "C0001";
        p.prodName = "�Ƹ޸�ī��";
        p.prodPrice = 1000;

        Product p1 = new Product();

        System.out.println(p.prodNo + "," + p.prodName + "," + p.prodPrice);
        System.out.println(p1.prodNo + "," + p1.prodName + "," + p1.prodPrice);

        Product pArr[];
        pArr = new Product[5];

        pArr[0] = new Product();
        pArr[0].prodNo = "F0001";
        pArr[0].prodName= "����";
        pArr[0].prodPrice = 10;

        pArr[1] = p;
        pArr[2] = p1;
	
       for (Product prod: pArr) {
           System.out.println(prod.prodNo);
       }

    }

}  