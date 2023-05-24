package com.my.product.dao;
import com.my.product.dto.Product;

public class ProductRepository  {
	
	private Product[] pArr;	
	private int totalCnt = 0;
	
	public ProductRepository() {
		pArr = new Product[5];
	}
	
	public ProductRepository(int cnt) {
		if (1 <= cnt)
			pArr = new Product[cnt];			
		else
		{
			System.out.println("저장소의 크기는 1이상이어야합니다.");
			pArr = new Product[5];
		}			
	}
	
    public void insert (Product p) {
    	
    	if (pArr.length <= totalCnt)
    	{
    		System.out.print  ("저장소가 꽉찼습니다");
    		System.out.println("현재상품수는: " + totalCnt);
    		return ;
    	}
    	// (1) totalCnt 검사
    	
    	
    	Boolean flag = false;
    	for (int i = 0; i < totalCnt; i++)	{
    		String originalStr = pArr[i].getProdName();
    		String newStr = p.getProdName(); 
    		
    		if ( originalStr.equals(newStr) ) {    		
    			flag = true;
    			break;
    		}
    	}
    	
    	if (flag == true)
    	{
    		System.out.println("이미 존재하는 상품입니다.");
    		return ;
    	}
    	// (2) 상품명 중복 검사    	
    	
    	pArr[totalCnt++] = p;
    }



    public  Product[] selectByProdName (String name) {

    	int resultSize = 0;
    	
    	 for(int i = 0; i < totalCnt; i++) {         	
             Product p = pArr[i];
             
             if (p.getProdName().contains(name))          
             	resultSize++;                        
         }
    	 // (1) 결과값의 개수를 구한다.
    	
     	Product returnArr[] = new Product[resultSize];
     	// (2) 결과값의 개수만큼 Product형 배열 생성
    	 
     	int index = 0;
        for(int i = 0; i < totalCnt; i++) {        	
            Product p = pArr[i];
            
            if (p.getProdName().contains(name)) 
            {
            	returnArr[index] = p;
            	index++;
            }
                         
        }
        // (3) 결과값을 배열:returnArr에 저장
        
        return returnArr; 
        // (4) 배열 return
    }
    
    public Product selectByProdNo(String no){
        //상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다
    	for (int i = 0; i < totalCnt; i++){
            Product p = pArr[i];
            
            if(p.getProdNo().equals(no))
               return p;
        }   
        return null; //상품이 없는 경우 null을 반환한다
    }
    
    public Product[] selectAll(){
        Product[] all = new Product[totalCnt];
        for(int i=0; i<totalCnt; i++){
            all[i] = pArr[i];
        }
        return all;
     }

    

}