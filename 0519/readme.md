# 자바 실행 과정

1. LottoUser.class, String.class, Lotto.class 찾기:
  자바 파일(.java)을 컴파일하면 바이트 코드(.class)로 변환됩니다. 이때 LottoUser 클래스, String 클래스, Lotto 클래스의 바이트 코드 파일(.class)을 찾습니다.
  파일을 JVM에 로드:
2. JVM(Java Virtual Machine)은 자바 프로그램을 실행하는 가상 머신입니다. JVM은 LottoUser.class, String.class, Lotto.class 파일을 로드하여 실행 준비를 합니다.

3. 바이트 코드 검증:
   JVM은 로드한 바이트 코드를 검증합니다. 바이트 코드의 구문 및 유효성을 확인하여 실행 중에 오류가 발생하지 않도록 합니다.
  
4. 인터프리트(바이트 코드 -> 바이너리):
  검증된 바이트 코드는 JVM에 의해 인터프리트되어 기계어에 가까운 중간 형식으로 변환됩니다. 이 과정에서 바이트 코드가 하나씩 읽혀지며 실행됩니다.
  인터프리트된 파일 내용은 Method에 기억됨:

5. 인터프리트된 바이트 코드의 내용은 JVM의 메소드 영역에 기억됩니다. 클래스, 메소드, 변수 등의 정보가 저장되어 실행 중에 필요한 정보에 접근할 수 있습니다.
   static 변수들 자동 초기화: 

6. JVM은 static 변수들을 자동으로 초기화합니다. static 변수는 클래스 수준에서 한 번만 초기화되며, 인스턴스 생성과는 관계없이 사용됩니다.

7. main() 자동 호출됨:
   main() 메소드는 자바 프로그램의 진입점입니다. JVM은 main() 메소드를 자동으로 호출하여 프로그램의 실행을 시작합니다.

# 스택과 힙
- 스택(Stack):

스택은 메소드 호출과 관련된 정보를 저장하는 영역입니다.
메소드가 호출될 때마다 해당 메소드의 지역 변수, 매개 변수, 리턴 값, 메소드 호출 시점 등의 정보가 스택 프레임(Stack Frame)에 저장됩니다.
스택은 후입선출(Last-In-First-Out, LIFO) 구조로 동작합니다. 가장 최근에 호출된 메소드의 스택 프레임이 가장 상위에 위치하며, 메소드 실행이 완료되면 해당 프레임이 제거됩니다.
스택의 크기는 일반적으로 제한되어 있으며, 스택 오버플로우(Stack Overflow)가 발생할 수 있습니다.
- 힙(Heap):

힙은 동적으로 생성된 객체의 인스턴스가 저장되는 영역입니다.
객체는 힙에 할당되고, 참조 변수를 통해 접근됩니다.
힙의 크기는 시스템의 가용 메모리 크기에 따라 동적으로 조정됩니다.
Garbage Collection(GC)에 의해 사용되지 않는 객체는 자동으로 해제되어 메모리 공간을 회수합니다.

# lottoUser.java의 데이터 구조
![image](https://github.com/tnduf6864/TIL/assets/66365553/27105a35-cf0b-42b1-b3c4-dda8f2e385f2)

# 변수
![image](https://github.com/tnduf6864/TIL/assets/66365553/58e7352f-50c1-4b4b-bc6a-abf4da00915b)

# null
null선언과 길이를 0 또는 데이터를 입력하지 않는것은 다름
- 후자는 객체는 만들었기 떄문에 heap 영역에 데이터 존재
  int[] var = null;은 배열 자체가 할당되지 않은 상태이며, int[] var = new int[0];은 비어있는 배열이 할당된 상태

# String
- new 생략 가능 하지만
  str = "Hello"와 str = new String("Hello")는 다름
  (... = "Hello)"와 같은 방식으로 만든 다른 변수끼리는 같은 메모리를 참조함 
  
- 문자열 잘라내기
  substring(int beginindex)
  
- 문자열 찾기
  변수명.indexof("찾을문자열"); (없으면 -1)
  
- 문자열 분리
  + Split 
  String[] arr = string변수명.split("구분문자");
  형변환을 통해 int[]에 저장 불가 두 번에 걸쳐 해야해
  
  50::30 (:로 구분) 과 같이 구분자 사이에 공백도 가능
  
  + String Tokenizer
    토큰이란 분리가능한 데이터조각 (\t, \n 같은 것들은 미포함) - Split은 count함
    st.hasMoreTokens()로 존재하는지 판별 가능
    String s = st.nextToken(); 이런식으로 데이터 가져옴
      
- 
  
  
  
# 배열
  
