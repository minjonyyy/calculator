package com.example.calculator3;


public class ConvertType <T extends Number> {

    private final Class<T> type;

    // 생성자를 통해 타입 정보를 전달받음
    public ConvertType(Class<T> type) {
        this.type = type;
    }

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

    public static ArithmeticCalculator<?> createCalculatorByType(String typeInput) {
        return switch (typeInput) {
            case "integer" -> new ArithmeticCalculator<>(Integer.class);
            case "float" -> new ArithmeticCalculator<>(Float.class);
            case "double" -> new ArithmeticCalculator<>(Double.class);
            default -> {
                System.out.println("지원하지 않는 타입입니다.");
                yield null;
            }
        };
    }


}
