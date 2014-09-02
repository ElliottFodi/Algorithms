import java.util.Random;
import java.util.Scanner;


public class MySort {
	
	static long comparisons = 0;
	static long partitions =0;
	
	public static void quicksort(int[] data){
		// array first element, last element
		quicksortHelper(data, 0, data.length -1);
		
	}

	private static void quicksortHelper(int[] data, int bottom, int top) {
		// if the array is bigger then 1 element
		if(bottom < top){
			
			// recursive call here
			int midpoint = partition(data, bottom, top);
			quicksortHelper(data, bottom, midpoint - 1);
			quicksortHelper(data, midpoint + 1, top);
		}
		
	}

	private static int partition(int[] data, int bottom, int top) {
		partitions++;
		//generate random index 
		Random random = new Random();
		int randomIndex = random.nextInt(top - bottom) + bottom;
		swap(data, randomIndex, top);
		
		int pivot = data[top];
		int firstAfterSmall = bottom;
		
		// find any number smaller then the pivot
		for(int i = bottom; i < top; i++){
			comparisons++;
			if(data[i] <= pivot){
				swap(data, firstAfterSmall, i);

				firstAfterSmall++;
			}
		}
		
		swap(data, firstAfterSmall, top);
		
		return firstAfterSmall;
		//return randomIndex;
	}

	private static void swap(int[] data, int firstAfterSmall, int i) {
		int temp = data[i];
		data[i] = data[firstAfterSmall];
		data[firstAfterSmall] = temp;
		
	}
	
//##########################################################################################	
	public static void printArray(int[] arr){
		for(int i : arr){
			System.out.print( i + " ");
		}
		System.out.println("");
	}
	
	public static void printFirstLast(int[] arr){
		for(int i = 0; i < 10; i++ ){
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		for(int i = arr.length - 10; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		
		
	}
	
	public static int poisson(int numberOfDataElements){
		double lambda = (numberOfDataElements/2) * -1;
		double L = Math.pow(Math.E, lambda);;
		double p = 1;
		int k = 0;
		
		do{
			k += 1;
			p = Math.random() * p;
		}while(p > L);
		return k -1;
	}
	
	public static int[] poissonArray(int arraySize){
		int[] arr = new int[arraySize];
		for( int i = 0 ; i < arraySize; i++){
			arr[i] = poisson(arraySize);
		}
		return arr;
	}
	
	public static int[] inOrderArray(int arraySize){
		int[] arr = new int[arraySize];
		for(int i = 0; i < arraySize; i++){
			arr[i] = i;
		}
		return arr;
	}
	
	public static int[] quarterSortedArray(int arraySize){
		
		int[] arr = new int[arraySize];
		int quarter = arraySize/4;
		Random random = new Random();
		for(int i =0; i < quarter;i++){
			arr[i] = i;
		}
		for(int i = quarter; i < arraySize; i++){
			arr[i] = random.nextInt();
		}
		return arr;
	}
	
	public static int[] randomArray(int arraySize){
		int[] arr = new int[arraySize];
		
		Random random = new Random();
		
		for(int i = 0; i < arraySize; i++){
			arr[i] = random.nextInt();
		}
		return arr;
	}
	
//##########################################################################################

	public static void main(String[] args) {

		
		
		double time1 = 0;
		double time2 = 0;
		int arrSize = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array size you would like to test");
		arrSize = scan.nextInt();
		scan.close();
		
		int[] arr = new int[arrSize];
		
		
		arr = inOrderArray(arrSize);
		time1 = System.currentTimeMillis();
		quicksort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");		
		System.out.println("Compares: " + comparisons);
		System.out.println("Partitions: " + partitions);
		System.out.println("");
		comparisons = 0;
		partitions = 0;
		
		arr = randomArray(arrSize);
		time1 = System.currentTimeMillis();
		quicksort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");		
		System.out.println("Compares: " + comparisons);
		System.out.println("Partitions: " + partitions);
		System.out.println("");
		comparisons = 0;
		partitions = 0;
		
		arr = quarterSortedArray(arrSize);
		time1 = System.currentTimeMillis();
		quicksort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");		
		System.out.println("Compares: " + comparisons);
		System.out.println("Partitions: " + partitions);
		System.out.println("");
		comparisons = 0;
		partitions = 0;
		
		arr = poissonArray(arrSize);
		time1 = System.currentTimeMillis();
		quicksort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("Partitions: " + partitions);
		System.out.println("free memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
		System.out.println("");
		comparisons = 0;
		partitions = 0;
	}

}


