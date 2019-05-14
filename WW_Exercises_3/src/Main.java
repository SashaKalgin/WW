import java.util.Arrays;

public class Main {

	static int rndNumber;
	static int number = 500;
	static int[] intArray = new int[number];
	public static void main(String[] args) {

		for(int i = 0 ; i<500 ; i++){
			intArray[i] = genarateRandomNumber(number);
			//System.out.println(intArray[i]);
		}
		System.out.println("The smaller is : " + getSmallest(intArray,number));

	}

	public static int genarateRandomNumber(int number){
		int random = (int)(Math.random() * number + 1);
		return random;
	}


	public static int getSmallest(int[] a, int total){  
		Arrays.sort(a);  
		return a[0];  
	}  

}
