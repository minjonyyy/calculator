package com.example.calculator3;

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
