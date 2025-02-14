package com.example.calculator3;

import java.util.Objects;
import java.util.Scanner;

// 사용자가 값을 입력하고, 계산된 결과가 출력되는 App

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String stop = "";
        String yesOrNo;

        // 계산기에 사용할 타입 입력 받기
        System.out.print("계산기에 사용할 타입을 입력하세요 (Integer, Float, Double): ");
        String typeInput = sc.nextLine().toLowerCase(); //대소문자 상관없이 입력받음

        ArithmeticCalculator<?> arithmeticCalculator = ConvertType.createCalculatorByType(typeInput);

        do {
            System.out.println("---------"+typeInput+"형 계산기----------");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();
            sc.nextLine(); //입력 버퍼 지우기

            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);
            sc.nextLine();

            Operator.OperatorType operator = Operator.OperatorType.getOperatorType(op);
            if (operator == null) {
                System.out.println("잘못된 연산 기호입니다.");
                continue;
            }

            Number result = arithmeticCalculator.calculate(num1, num2, operator);

            if (result != null) {
                //연산 중 num1과 num2가 double 형식으로 계산되었기 때문에 지정된 타입으로 변경해주는 과정
                String formattedNum1 = formatNumber(num1, typeInput);
                String formattedNum2 = formatNumber(num2, typeInput);

                System.out.println("계산 결과: " + formattedNum1 + " " + op + " " + formattedNum2 + " = " + result);
            }

            if (!arithmeticCalculator.getResults().isEmpty()) {
                System.out.println("계산 결과 리스트 : " + arithmeticCalculator.getResults().toString());
                System.out.println("가장 먼저 저장된 데이터 삭제? ('네' 입력 시 삭제)");
                yesOrNo = sc.nextLine();

                if (Objects.equals(yesOrNo, "네")) {
                    arithmeticCalculator.removeResult();
                    System.out.println("삭제 후 계산 결과 리스트 : " + arithmeticCalculator.getResults().toString());
                } else {
                    System.out.println("계산 결과 리스트 : " + arithmeticCalculator.getResults().toString());
                }
            }

            System.out.println("더 계산하시겠습니까? (EXIT 입력 시 종료)");
            stop = sc.nextLine().toLowerCase();

        } while (!stop.equals("exit"));
    }

    // 계산 결과 출력 시에도 지정된 타입으로 출력하기 위한 형변환 메서드
    public static String formatNumber(double number, String type) {
        switch (type) {
            case "integer":
                return String.format("%d", (int) number);
            case "float":
                return String.format("%f", (float) number);
            default:
                return String.format("%f", number);
        }
    }




}
