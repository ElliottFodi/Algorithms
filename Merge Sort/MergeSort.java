

import java.util.Random;
import java.util.Scanner;

public class MergeSort {
	static int comparisons = 0;
	
	public static int[] mergeSort(int[] data){
		return mergeSortHelper(data, 0, data.length -1);
	}
	
	

	private static int[] mergeSortHelper(int[] data, int bottom, int top) {
		if(bottom == top){
			return new int[] {data[bottom]};
		}else{
			int midpoint = (top + bottom)/2;
			return merge(mergeSortHelper(data, bottom, midpoint), mergeSortHelper(data, midpoint + 1, top));
		}
	}


	// this will receive 2 sorted arrays
	private static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		for(int k = 0; k < result.length; k++){
			comparisons++;
			if( (j == b.length) || ((i < a.length)&& (a[i] <= b[j])) ){
				result[k] = a[i];
				i++;
			}else{
				result[k] = b[j];
				j++;
			}
		}
		return result;
	}
	
//####################################################################################
	public static void printArray(int[] array){
		for(int i : array){
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
//#################################################################################

	/**
	 * @param args
	 */
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
		arr = mergeSort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("");
		comparisons = 0;
		
		arr = randomArray(arrSize);
		time1 = System.currentTimeMillis();
		arr = mergeSort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("");
		comparisons = 0;
		
		arr = quarterSortedArray(arrSize);
		time1 = System.currentTimeMillis();
		arr = mergeSort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("");
		comparisons = 0;
		
		arr = poissonArray(arrSize);
		time1 = System.currentTimeMillis();
		arr = mergeSort(arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("free memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
		System.out.println("");
		comparisons = 0;
		

	}

}

