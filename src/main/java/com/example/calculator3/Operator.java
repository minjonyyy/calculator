package com.example.calculator3;

// 연산자를 enum 타입으로 구현한 Operator 클래스

public class Operator {

    public enum OperatorType {
        PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

        private final char operator;

        OperatorType(char operator) {
            this.operator = operator;
        }

        public char getOperator() {
            return operator;
        }

        public static OperatorType getOperatorType(char op) {
            for (OperatorType operatorType : Operator.OperatorType.values()) {
                if (operatorType.getOperator() == op) {
                    return operatorType;
                }
            }
            return null;
        }
    }


}
