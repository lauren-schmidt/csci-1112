public class SimpleStats {
 private static int count = 0;
 private static double sum = 0.0;
 private static double min = 0.0;
 private static double max = 0.0;

 public static void main(String[] args) { 
addValue(1.012468); 
addValue(12.0912);
 addValue(551.9871);
 addValue(78.12489);
 addValue(83.33333);
 addValue(112.55123);
 getCount();
 getMin();
 getMax();
 getAverage(); } public static void addValue(double newValue)  { sum += newValue; count += 1; if (count == 1) { min = newValue; max = newValue; } else { if(newValue < min) { min = newValue; } else if(newValue > max) { max = newValue; } } } public static int getCount()  { return count; } public static double getMin() { return min; } public static double getMax() { return max; } public static double getAverage()  { if (count == 0)  { return 0.0; } return sum / count; } }
