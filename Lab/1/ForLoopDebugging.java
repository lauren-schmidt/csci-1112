import java.util.Arrays;

public class ForLoopDebugging{
	public static void main (String[] args){
		int[] totalNums = new int[50];
		for(int i = 0; i < totalNums.length; i++)
		{
			totalNums[i] = i/2;
		}
		System.out.println(Arrays.toString(totalNums));
	}
}
