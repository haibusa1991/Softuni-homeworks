package lecture05polymorphism.E05Calculator;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;
    private ArrayDeque<Integer> calculatorMemory;

    public InputInterpreter(CalculationEngine engine, ArrayDeque<Integer> calculatorMemory) {
        this.engine = engine;
        this.calculatorMemory = calculatorMemory;

    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            return new MemoryStoreOperation(calculatorMemory);
        } else if (operation.equals("mr")) {
            return new MemoryRecallOperation(calculatorMemory);
        }

        return null;
    }
}
