package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public enum OperatorType{
        PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

        private final char operator;
        OperatorType(char operator) {this.operator = operator;}

        public char getOperator() {
            return operator;
        }

    }

}
