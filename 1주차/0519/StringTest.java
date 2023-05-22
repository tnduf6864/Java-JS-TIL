public class StringTest {
	
	static void parseURL(String url)
	{		
		//프로토콜://호스트명/패스?쿼리
		String components[] = { "프로토콜", "호스트", "패스", "쿼리" };
		String split[] = { "://", "/", "?", ""};
		String data[] = new String[components.length];
		
		int start, end;
		start = 0; 
		end = 0; 
		
		for (int i = 0; i < components.length; i++)
		{
			if (i == components.length - 1) //마지막 문자열(쿼리) 처리
				data[i] = url.substring(start);
			else
			{
				end = url.indexOf(split[i], start);
				if (end == -1)
				{
					System.out.println("구분자 입력 오류");
					break;
				}			
				data[i] = url.substring(start, end);
			}
			
			System.out.println(components[i] + ": " + data[i]);
			start = end + (split[i].length());
		}				
	}
	
	public static void main(String[] args) {

		String urlStr = "https://n.news.naver.com/article/032/0003224574?cds=news_media_pc";
		parseURL(urlStr);	
		
	}
	
}
