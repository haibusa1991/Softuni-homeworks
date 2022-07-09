package lecture05polymorphism.E05Calculator;

import java.util.ArrayDeque;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine, ArrayDeque<Integer> calculatorMemory) {
        return new InputInterpreter(engine, calculatorMemory);
    }


}
