public class ProductUser {

    static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String []args) {

        String opt;

        do {
            System.out.println("�۾��� �����ϼ���");
            System.out.println("1: ��ǰ ��ü �˻�, 2: ��ǰ��ȣ�� �˻�, 3: ��ǰ �߰�, 9: ����");

            opt = sc.nextLine();
            if (opt.equals("1")) {
                System.out.println(">>��ü��ǰ�˻�<<");

                Product resultArr[] = ProductRepository.selectAll();

                for (int i = 0; i < resultArr.length; i++) 
                    System.out.println("��ǰ��ȣ: " + resultArr[i].prodNo);                   	    
            }
            else if (opt.equals("2")) {
                System.out.println(">>��ǰ�˻�<<");                
                System.out.print("��ǰ ��ȣ�� �Է��ϼ���: ");

                String noArg1 = sc.nextLine();        
        
                System.out.println(noArg1);
                System.out.println(ProductRepository.selectByProdNo(noArg1)== null? "��ǰ�� �����ϴ�" : "��ǰ�� �ֽ��ϴ�.");
            }
            else if (opt.equals("3")) {
                System.out.println(">>��ǰ�߰�<<");
                System.out.print("��ǰ ��ȣ�� �Է��ϼ���: ");

                Product pArg = new Product();
                pArg.prodNo = sc.nextLine();
                ProductRepository.insert(pArg);
            }
            else if (opt.equals("9")) {

            }
            else {
                System.out.println("�߸��Է��Ͽ����ϴ�.");
            }
        } while(!opt.equals("9"));

/*
        System.out.println(">>��ǰ�߰�<<");
        Product pArg = new Product();
        pArg.prodNo = "G0001";
        insert(pArg);

        System.out.println(">>��ǰ�߰�<<");
        Product pArg1 = new Product();
        pArg1.prodNo = "G0002";
        insert(pArg1);

        System.out.println(">>��ǰ�˻�<<");
        String noArg1 = "G0002";
        Product result1 = selectByProdNo(noArg1);
        System.out.println(noArg1);
        System.out.println(result1 == null? "��ǰ�� �����ϴ�" : "��ǰ�� �ֽ��ϴ�.");

        System.out.println(">>��ǰ�˻�<<");
        String noArg2 = "X";
        System.out.println(selectByProdNo(noArg2) == null? "��ǰ�� �����ϴ�" : "��ǰ�� �ֽ��ϴ�.");

        System.out.println(">>��ü��ǰ�˻�<<");
        Product resultArr[] = selectAll();
        for (int i = 0; i < resultArr.length; i++) 
            System.out.println("��ǰ��ȣ: " + resultArr[i].prodNo);               
        */

    }

}