# 자바플랫폼 
자바App이 실행될 수 있는 환경

- 종류
JAVA SE - UI+network
     EE - 기업형 자바App
     ME - 안씀

- 자바플랫폼의 구조
     * JDK = JRE(JVM + API) + 여러 응용프로그램(javac, java, ...)
     * JVM: 재해석기 + 메모리관리

- 객체지향
     * 객체를 기반으로 클래스의 재사용성을 높히는 프로그램



# 변수와 타입
- module-info ver11이상에서 나오는 거 <~ 호환성을 고려하면 없는 게 좋아. 생성할 때 꺼주자
- JAVA에선 1과 0은 true/false와 다르다
- 정수타입연산시 int로 연산 수행, (실수형 -> double)
- 형변환은 큰 범위에서 작은범위로 반대상황에선 강제형변환
- BOOLEAN타입은 형변환 불가

# 연산자
논리연산자 &와 &&의 차이점
& <~ 흐름대로 다 읽음 (b++같은 거 다 읽으면서 실행)
&& <~ 거짓이 나오면 더 안읽음, 성능 향상을 위해서 쓰면 효율적임

+ 숫자입력받는 법

      int month = Integer.parseInt(sc.nextLine());

- 난수
      
      rand = (int)(Math.random() * 3) + 1;
    
