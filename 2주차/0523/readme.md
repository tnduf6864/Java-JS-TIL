+ static: 프로그램 시작부터 끝까지 메모리에 남아있어서 메모리 효율성이 떨어짐 (활용도가 높을 때만 사용)
          객체와 무관한 것을 사용 할 때 

+ 접근 제한자
  없을 때(default): 같은 패키지 내에서 접근, 변경 가능
  
+ 싱글톤, 객체 생성 메서드화
  Single getInstance() {
    return new Single();
  }
  
+ 자바 빈
![image](https://github.com/tnduf6864/TIL/assets/66365553/49fb013c-c341-49c8-a461-63a369a2564b)

  요약하자면, 자바 빈은 자바 언어를 사용하여 재사용 가능한 소프트웨어 구성 요소를 개발하기 위한 모델로, 속성과 getter/setter 메서드를 통해 데이터를 저장하고 접근합니다. 이를 통해 캡슐화와 정보 은닉을 구현할 수 있습니다. 또한 자바 빈은 자바   의 다양한 프레임워크에서 활용되며, GUI 개발에 많이 사용됩니다.

+ boolean의 getter메서드 -> is머시기() (국룰임)
