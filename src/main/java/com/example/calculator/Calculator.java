package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        sc.nextLine(); // 입력 버퍼 비우기

        System.out.print("사칙연산 기호를 입력하세요: ");
        String op = sc.nextLine();


        int result = 0;
        /* 제어문을 활용하여 위 요구사항을 만족할 수 있게 구현합니다.*/
        switch (op) {
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                if (num2==0){
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return;
                }
                else {
                    result = num1 / num2;
                }
                break;
        }

        System.out.println("결과: " + num1 + op + num2 + "=" + result);


//        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
//        /* exit을 입력 받으면 반복 종료 */


    }
}
