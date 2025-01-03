package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public int calculate(int num1, int num2, char op) {
        int result = 0;

        if (num1 <0 || num2<0){
            System.out.println("양의 정수(0포함)를 입력해주세요");
            return -1;
        }

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return -1;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("잘못된 연산 기호입니다. (+, -, *, / 중 하나를 입력하세요)");
                return -1;
        }
        results.add(result);
        return result;
    }
    
    //getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    //setter 메서드
    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public void removeResult() {
        results.remove(0);
    }


}
