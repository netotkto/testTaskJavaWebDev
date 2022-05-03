package Weight;

public class Pound {
    private final long value;

    public Pound(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public long transformIntoKg(){
        return (long) (value * 0.4536);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
