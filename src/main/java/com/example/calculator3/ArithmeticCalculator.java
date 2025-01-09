package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

    private List<T> results;
    private final Class<T> type;

    // 생성자를 통해 타입 정보를 전달받음
    public ArithmeticCalculator(Class<T> type) {
        this.results = new ArrayList<>();
        this.type = type;
    }

    public enum OperatorType {
        PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

        private final char operator;

        OperatorType(char operator) {
            this.operator = operator;
        }

        public char getOperator() {
            return operator;
        }
    }

    public T calculate(double num1, double num2, OperatorType operator) {
        double result;

        // 음수인지 체크
        if (num1 < 0 || num2 < 0) {
            System.out.println("0 이상의 숫자를 입력해주세요");
            return null; // 에러 처리
        }

        switch (operator) {
            case PLUS:
                result = num1 + num2;
                break;
            case MINUS:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0.0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 숫자)에 0이 입력될 수 없습니다.");
                    return null;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 연산 기호입니다. (+, -, *, / 중 하나를 입력하세요)");
                return null;
        }

        // 결과를 T 타입으로 변환
        T typedResult = convertToT(result);
        if (typedResult != null) {
            results.add(typedResult);
        }
        return typedResult;
    }

    private T convertToT(double value) {
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

    // getter 메서드
    public List<T> getResults() {
        return results;
    }

    // setter 메서드
    public void setResults(List<T> results) {
        this.results = results;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}
