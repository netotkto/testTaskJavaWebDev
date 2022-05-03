package Weight;

public class Kilogram {
    private final long value;

    public Kilogram(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public long transformIntoLb(){
        return (long) (value  * 2.20462262);
    };

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
