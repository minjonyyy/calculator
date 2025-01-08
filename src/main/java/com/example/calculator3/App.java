package com.example.calculator3;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String stop = "";
        String yesOrNo = "";

        // 계산기에 사용할 타입 입력 받기
        System.out.print("계산기에 사용할 타입을 입력하세요 (Integer, Float, Double): ");
        String typeInput = sc.nextLine().toLowerCase();

        ArithmeticCalculator<?> arithmeticCalculator = null;
        if (typeInput.equals("integer")) {
            arithmeticCalculator = createCalculator(Integer.class);
        } else if (typeInput.equals("float")) {
            arithmeticCalculator = createCalculator(Float.class);
        } else if (typeInput.equals("double")) {
            arithmeticCalculator = createCalculator(Double.class);
        } else {
            System.out.println("지원하지 않는 타입입니다.");
            return;
        }

        do {
            System.out.println("-----------------------");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();
            sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);
            sc.nextLine();

            ArithmeticCalculator.OperatorType operator = getOperatorType(op);
            if (operator == null) {
                System.out.println("잘못된 연산 기호입니다.");
                continue;
            }


            Number result = arithmeticCalculator.calculate(num1, num2, operator);

            if (result != null) {
                System.out.println("결과: " + num1 + " " + op + " " + num2 + " = " + result);

            }

            if (!arithmeticCalculator.getResults().isEmpty()) {
                System.out.println("계산된 결과들: " + arithmeticCalculator.getResults());
                System.out.println("가장 먼저 저장된 데이터 삭제? ('네' 입력 시 삭제)");
                yesOrNo = sc.nextLine();

                if (Objects.equals(yesOrNo, "네")) {
                    arithmeticCalculator.removeResult();
                    System.out.println("삭제 후 계산된 결과들: " + arithmeticCalculator.getResults());
                } else {
                    System.out.println("결과들 그대로: " + arithmeticCalculator.getResults());
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            stop = sc.nextLine();

        } while (!stop.equals("exit"));
    }

    private static ArithmeticCalculator.OperatorType getOperatorType(char op) {
        for (ArithmeticCalculator.OperatorType operatorType : ArithmeticCalculator.OperatorType.values()) {
            if (operatorType.getOperator() == op) {
                return operatorType;
            }
        }
        return null;
    }

    // 입력받은 타입에 대해 계산기 분류
    private static <T extends Number> ArithmeticCalculator<T> createCalculator(Class<T> type) {
        return new ArithmeticCalculator<>(type);
    }
}
