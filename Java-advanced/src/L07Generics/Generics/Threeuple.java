package L07Generics.Generics;

public class Threeuple<T1, T2, T3> extends Tuple<T1, T2> {
    private final T3 t3;

    public Threeuple(T1 t1, T2 t2, T3 t3) {
        super(t1, t2);
        this.t3 = t3;
    }

    public T3 getT3() {
        return t3;
    }

    public String print() {
        return getT1() + " -> " + getT2() + " -> " + t3;
    }
}
