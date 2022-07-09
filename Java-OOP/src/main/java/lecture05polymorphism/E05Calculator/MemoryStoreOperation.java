package lecture05polymorphism.E05Calculator;

import java.util.ArrayDeque;

public class MemoryStoreOperation implements Operation {
    private ArrayDeque<Integer> calculatorMemory;

    public MemoryStoreOperation(ArrayDeque<Integer> calculatorMemory) {
        this.calculatorMemory = calculatorMemory;
    }

    @Override
    public void addOperand(int operand) {
        this.calculatorMemory.push(operand);
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
