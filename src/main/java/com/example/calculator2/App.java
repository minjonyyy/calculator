package com.example.calculator2;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); //Calculator 인스턴스 생성

        String stop="";
        String yesorno="";

        do {
            System.out.println("-----------------------");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);
            sc.nextLine();

            int result = calculator.calculate(num1, num2, op);

            if (result != -1) {
                System.out.println("결과: " + num1 + " " + op + " " + num2 + " = " + result);

                System.out.println("계산된 결과들:" + calculator.getResults().toString());

            }

            if (!calculator.getResults().isEmpty()){
                System.out.println("가장 먼저 저장된 데이터 삭제? ('네' 입력 시 삭제)");
                yesorno = sc.nextLine();

                if (Objects.equals(yesorno, "네")){
                    calculator.removeResult();
                    System.out.println("삭제 후 계산된 결과들: "+ calculator.getResults().toString());
                } else {
                    System.out.println("결과들 그대로" + calculator.getResults().toString());
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            stop= sc.nextLine();

        } while(!stop.equals("exit"));


    }
}
