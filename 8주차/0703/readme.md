- 배열의 값을 한번에 여러 변수에 할당해 주는 방법 (Destructuring)
  

      var [num1, num2, num3] = arr;
  
      var [,,,,, num6, num7, num8] = arr;
  
      //push()
      newArr.push(oldArr[i]);
  
      //spread
      var arr3 = [...arr, ...arr2]

      arr4.forEach((value, index, arr)=> {
          //어쩌구
      })

      var f1 = function() {
        console.log('안녕');
      }
      
      f2 = f1;
      f2();
      
      var f3 =  function(a) {
          console.log(a)
      }
      
      f3(2);
      f3(true);
      f3(f1);
      
      var f4 = function(a) {
          a();
      }
      f4(function() {
          console.log('콜백함수');
      });
  
![image](https://github.com/tnduf6864/TIL/assets/66365553/d4882dc6-662b-45d6-952b-a521b4fb5c08)



