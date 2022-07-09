package lecture05polymorphism.E05Calculator;

import java.util.ArrayDeque;

public class MemoryRecallOperation implements Operation {
    private ArrayDeque<Integer> calculatorMemory;

    public MemoryRecallOperation(ArrayDeque<Integer> calculatorMemory) {
        this.calculatorMemory = calculatorMemory;
    }

    @Override
    public void addOperand(int operand) {
    }

    @Override
    public int getResult() {
        return calculatorMemory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
