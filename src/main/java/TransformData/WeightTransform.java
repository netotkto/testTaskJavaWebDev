package TransformData;

public class WeightTransform {
    public static long transformKgIntoLb(long weightInKg){
        float weightInLb = (float) ((float)weightInKg * 2.20462262);
        return (long) weightInLb;
    }
    public static long transformLbIntoKg(long weightInLb){
        float weightInKg = (float) ((float)weightInLb * 0.4536);
        return (long) weightInKg;
    }
}
