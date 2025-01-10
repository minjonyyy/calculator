## 📱계산기 만들기

## 📍필수 기능
### 단계별 요구사항
### 1️⃣LV.1 클래스 없는 연산 수행 계산기
##### App.java
1. 사용자에게
**양의 정수 2개(0포함)**
을 각각 하나씩 입력받는다.
   - Scanner 사용, 적절한 타입으로 변수 선언하여 저장하기
     
3. 사용자에게
**사칙연산 기호 (+, - *, /)***
를 입력받는다. `charAt(0)`
    - Scanner 사용, 적절한 타입으로 변수 선언하여 저장하기
      
6. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력한다.
   - 제어문 사용 `if` `switch`
   - 연산 오류 발생 시에 오류 내용 출력하기
     (ex. 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.)
     
7. 연산 수행을 반복한다.
   - `for` `while`등 반복문을 사용하기
   - 반복의 종료를 알려주는 "exit"문자열을 입력하기 전까지는 무한으로 계산 진행

***
### 2️⃣LV.2 클래스를 적용한 연산 수행 계산기
##### App.java / Calculator.java
1. Calculator 클래스
   
   - 연산 수행 역할을 담당한다.
     - 연산 결과를 저장하는 컬렉션 타입 필드를 가짐
     - 사칙연산을 수행한 후, 결과값을 반환하는 calculate 메서드 구현
       
   - 캡슐화가 된 메서드를 구현한다.
     - App클래스의 main 메서드에서 연산결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 **캡슐화**
     - 간접 접근을 통해 가져오거나 수정할 수 있도록 구현
       `Getter 메서드` `Setter 메서드`

   - 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능 메서드를 구현한다.
     - 컬렉션에서 '값을 넣고 제거하는 방법' 이해하기

2. App 클래스
   
   - 사용자가 사용하는 계산기 (입출력 담당)
   - Calculator 클래스에서 구현한 메서드들을 App클래스의 main 메서드에서 활용한다.
***
## 📍도전 기능

### 3️⃣ Enum, 제네릭, 람다&스트림을 이해한 계산기 만들기
1. Enum 타입 활용하기
   - 4가지 연산자를 Enum타입을 활용하여 연산자 타입에 대한 정보를 관리하고 ArithmeticCalculator 클래스에 활용
     
2. `제네릭`을 사용하여 피연산자를 여러 타입으로 받을 수 있도록 기능 확장하기

3. 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값들을 출력하기
   - 위의 요구사항을 만족하는 조회 메서드 구현 : `Lambda & Stream`활용하기
***
## 🪄 주요 코드 구현 설명

##### * LV.3의 2단계(제네릭)까지 구현 완료
##### * 상위 코드인 LV.3에 대해서만 설명


### ✅App.java
#### 사용자가 계산기를 사용하는 메인 메서드가 구현되어있다. (입출력 기능)
* 사용자로부터 계산기에 사용할 타입을 입력받고,<br>
  ConvertType 클래스의 createCalculatorByType 메서드를 통해 타입에 맞는 계산기를 생성한다.
```
// 계산기에 사용할 타입 입력 받기
        System.out.print("계산기에 사용할 타입을 입력하세요 (Integer, Float, Double): ");
        String typeInput = sc.nextLine().toLowerCase(); //대소문자 상관없이 입력받음
        ArithmeticCalculator<?> arithmeticCalculator = ConvertType.createCalculatorByType(typeInput);
```

* 사용자가 지정했던 타입에 맞게 계산 결과를 출력
* do-while 문을 사용하여 사용자가 exit을 입력하기 전까지 무한반복
  
### ✅ArithmeticCalculator.java
#### 실질적인 계산이 진행되는 클래스이다. (연산 기능)
* `제네릭`을 사용하여 구현
   * `T extends Number` : 제네릭을 Number 클래스와 그 하위 타입(Integer, Douoble ...)로만 받을 수 있도록 제한.
   * 결과 리스트 `results` 또한 제네릭으로 구현
   * 연산은 기본적으로 double형식으로 진행 (구체적 설명 블로그 참고)
* 연산 후, 결과를 T 타입으로 변환해주는 converToT메서드
  ```
  T typedResult = converter.convertToT(result);
        if (typedResult != null) {
            results.add(typedResult);
        }
        return typedResult;
  ```
* getter와 setter메서드
  * setter메서드는 구현만 해두고 사용하진 않았다.
    ```
    // getter 메서드
    public List<T> getResults() {
        return results;
    }

    // setter 메서드
    public void setResults(List<T> results) {
        this.results = results;
    }
    ```
* 결과 리스트에서 가장 먼저 저장된 데이터를 삭제하는 removeResult메서드

### ✅Operator.java
#### 4개의 연산자를 enum 타입으로 저장하고 관리하는 클래스이다.

### ✅ConvertType.java
#### 사용자가 입력한 정보에 따라 타입을 맞춰주는 클래스이다.
* `createCalculatorByType` 메서드
   * App.java에서 사용자가 입력한 typeinput을 매개변수로 받아서 지정된 타입에 맞는 계산기를 생성한다.
     ```
     public static ArithmeticCalculator<?> createCalculatorByType(String typeInput) {
        return switch (typeInput) {
            case "integer" -> new ArithmeticCalculator<>(Integer.class);
            case "float" -> new ArithmeticCalculator<>(Float.class);
            case "double" -> new ArithmeticCalculator<>(Double.class);
            default -> {
                System.out.println("지원하지 않는 타입입니다. 3가지 중 하나만 입력해주세요.");
                yield null;
            }
        };
    }
     ```
* `convertToT` 메서드
   * 기본적으로 double타입으로 연산되는 결과를 사용자가 지정한 타입에 맞게 변환해준다.
     ```
     public T convertToT(double value) {
        if (type == Integer.class) {
            return type.cast((int) value);
        } else if (type == Double.class) {
            return type.cast(value);
        } else if (type == Float.class) {
            return type.cast((float) value);
        } else {
            System.out.println("지원하지 않는 타입입니다.");
            return null;
        }
    }
     ```
* double로 연산하는 이유에 대해서는 블로그 참고<br>
  [[JAVA] 계산기 과제 트러블 슈팅](https://velog.io/@minjonyyy/JAVA-%EA%B3%84%EC%82%B0%EA%B8%B0-%EA%B3%BC%EC%A0%9C-%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85)
  
