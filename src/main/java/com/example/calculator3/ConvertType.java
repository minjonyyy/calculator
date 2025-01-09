package com.example.calculator3;

// 사용자가 입력한 정보에 따라 타입을 맞춰주는 ConvertType 클래스

public class ConvertType <T extends Number> {

    private final Class<T> type;

    // 생성자를 통해 타입 정보를 전달받음
    public ConvertType(Class<T> type) {
        this.type = type;
    }

    // 지정된 타입에 맞는 계산기 생성
    public static ArithmeticCalculator<?> createCalculatorByType(String typeInput) {
        return switch (typeInput) {
            case "integer" -> new ArithmeticCalculator<>(Integer.class);
            case "float" -> new ArithmeticCalculator<>(Float.class);
            case "double" -> new ArithmeticCalculator<>(Double.class);
            default -> {
                System.out.println("지원하지 않는 타입입니다. 3가지 중 하나만 입력해주세요.");
                yield null;
            }
        };
    }

    //기본적으로 double타입으로 연산되었지만, 값을 사용자가 처음 지정했던 타입으로 변환
    public T convertToT(double value) {
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

}
