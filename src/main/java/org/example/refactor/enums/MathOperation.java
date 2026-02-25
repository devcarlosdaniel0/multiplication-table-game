package org.example.refactor.enums;

import java.util.Random;

public enum MathOperation {
    ADD("+") {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("x") {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    RANDOM("?") {
        private final Random random = new Random();
        private MathOperation randomOpGenerated;

        @Override
        public int apply(int a, int b) {
            MathOperation[] ops = new MathOperation[]{ADD, MULTIPLY, SUBTRACT};
            randomOpGenerated = ops[random.nextInt(ops.length)];
            return randomOpGenerated.apply(a, b);
        }

        @Override
        public String getSymbol() {
            return randomOpGenerated.getSymbol();
        }
    };

    private final String symbol;

    MathOperation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract int apply(int a, int b);
}
