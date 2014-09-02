

import java.util.Random;
import java.util.Scanner;

public class HeapSort {
	
	static int lengthOfArray = 0;
	static int[] array; 
	static int leftChildIndex = 0;
	static int rightChildIndex = 0;
	static int swapIndex = 0;
	static int temp = 0;
	static int comparisons = 0;
	
	public static void buildHeap(int[] array){
		lengthOfArray = array.length;
		// lengthOfArray/2 for each row of the tree
		    for(int i = (lengthOfArray/2); i >= 0; i--){
		        heapify(array,i);
		    }
	}
	
	public static void heapify(int[] array, int index){
		comparisons++;
		leftChildIndex = 2 * index;
		rightChildIndex = 2 * index + 1;
		swapIndex = index;
		
		// check to see if the left child is larger then the root
        if(leftChildIndex < lengthOfArray && array[leftChildIndex] > array[index]){
            swapIndex=leftChildIndex;
        }
        
        // if the left child was larger then the root but the right child is even larger, swap
        // if the left child was not larger then the root but the right child is, swap
        if(rightChildIndex < lengthOfArray && array[rightChildIndex] > array[swapIndex]){
            swapIndex=rightChildIndex;
        }
        
        // can not swap the root with the root
        if(swapIndex != index){
            temp = array[index];
            array[index] = array[swapIndex];
            array[swapIndex] = temp;
            heapify(array, swapIndex);
        }
		
	}
	
	public static void sort(int[] unSortedArray){
		
		int temp = 0;
		
		for(int i = lengthOfArray -1; i > 0; i--){
			temp = unSortedArray[0];
			unSortedArray[0] = unSortedArray[i];
			unSortedArray[ i] = temp;
			lengthOfArray = lengthOfArray -1;
			heapify(unSortedArray, 0);
			
		}
	}
	
//############################################################################################	
	
	public static void printArray( int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
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
		buildHeap(arr);
		time1 = System.currentTimeMillis();
		sort (arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("");
		comparisons = 0;
		
		arr = randomArray(arrSize);
		buildHeap(arr);
		time1 = System.currentTimeMillis();
		sort (arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("");
		comparisons = 0;
		
		arr = quarterSortedArray(arrSize);
		buildHeap(arr);
		time1 = System.currentTimeMillis();
		sort (arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("");
		comparisons = 0;
		
		arr = poissonArray(arrSize);
		buildHeap(arr);
		time1 = System.currentTimeMillis();
		sort (arr);
		time2 = System.currentTimeMillis();
		printFirstLast(arr);
		System.out.println("time: " + (time2 - time1) + " seconds");
		System.out.println("Compares: " + comparisons);
		System.out.println("free memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
		System.out.println("");
		comparisons = 0;

	}

}
