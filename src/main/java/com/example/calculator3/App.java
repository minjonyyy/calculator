package com.example.calculator3;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

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

            ArithmeticCalculator.OperatorType operator = getOperatorType(op);
            if (operator == null) {
                System.out.println("잘못된 연산 기호입니다.");
                continue;  // 잘못된 기호일 경우 다시 입력 받기
            }

            int result = arithmeticCalculator.calculate(num1, num2, operator);

            if (result != -1) {
                System.out.println("결과: " + num1 + " " + op + " " + num2 + " = " + result); // 여기까지 출력 잘 됨
//                arithmeticCalculator.saveResult(result);
                System.out.println("계산된 결과들: " + arithmeticCalculator.getResults().toString());

            }

            if (!arithmeticCalculator.getResults().isEmpty()) {
                // 삭제 여부 확인
                System.out.println("가장 먼저 저장된 데이터 삭제? ('네' 입력 시 삭제)");
                yesorno = sc.nextLine();

                if (Objects.equals(yesorno, "네")) {
                    arithmeticCalculator.removeResult();
                    System.out.println("삭제 후 계산된 결과들: " + arithmeticCalculator.getResults().toString());
                } else {
                    System.out.println("결과들 그대로: " + arithmeticCalculator.getResults().toString());
                }
            } else {
                System.out.println("계산된 결과가 없습니다.");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)"); //입력 안받아짐
            stop= sc.nextLine();

        } while(!stop.equals("exit"));

    }

    // char를 OperatorType으로 변환
    private static ArithmeticCalculator.OperatorType getOperatorType(char op) {
        for (ArithmeticCalculator.OperatorType operatorType : ArithmeticCalculator.OperatorType.values()) {
            if (operatorType.getOperator() == op) {
                return operatorType;
            }
        }
        return null;
    }
}