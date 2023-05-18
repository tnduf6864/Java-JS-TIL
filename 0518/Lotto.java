/**
 * 
 * @author 김수열
 * @version 1.0
 *
 */
public class Lotto {

	int lotto[] = new int[6];
	
	/**
	 * 로또 숫자 계산
	 */
	public void make () 
	{
		for (int i = 0; i < lotto.length; i++)	
		{
			lotto[i] = (int)(Math.random() * 45 ) + 1;
			
			for (int j = 0; j < i; j++) 
			{
				if (lotto[i] == lotto[j])	
				{
					i--;
					break;
				}
			}
		}//for
	}//make()
	
	/**
	 * index에 해당하는 로또숫자를 반환한다.
	 * index가 0이하이거나 index가 6이상인 경우는 -1을 반환한다.
	 * @param index 로또숫자위치
	 * @return 로또숫자값
	 */
	public int get(int index) {
		if(0<= index && index <= 6)
			return lotto[index];
		System.out.println("index값 오류!");
		return (-1);
	}
	
	/**
	 * 모든 로또숫자들을 반환한다.
	 * @return 모든 로또숫자값들
	 */
	public int[] get() {
		return lotto;
	}
	
	public void print() {
		for (int i = 0; i < lotto.length; i++)
			System.out.print( lotto[i] + "\t");	
	}
			

}
