import java.util.Scanner;

/**
 * 
 * Tufayl Dhalla
 * 101003562
 *
 */
public class TestHeapSort {

	//Method to take a semiheap and reconstruct it to become a heap 
	public static void heapRebuild (int[] arr, int root, int size) {
		int child = 0;
		//If the root is not a leaf 
		if ((2*root+1) <= size || (2*root+2) <= size) {
			//Index for left child
			child = root*2 + 1;
			if ((2*root+2) <= size) {
				//Index for right child 
				int rightChild = child +1;
				//Make larger value out of the two equal to child 
				if (arr[rightChild] > arr[child])
					child = rightChild;
			}
			//If the root value is less than the child value 
			if (arr[root] < arr[child]) {
				//Swap root and child value
				int temp = arr[root];
				arr[root] = arr[child];
				arr[child] = temp;
				//Recursion in case the child has children so we can continue the process over, now the 
				//child being the root 
				heapRebuild(arr, child, size);
			}
		}
	}
	
	//Method to sort array and put in ascending order 
	public static void heapSort (int[] arr, int n) {
		//Initialize heap
		for (int i = n-1; i >= 0; i--)
			heapRebuild(arr,i,n-1);
		//Set variable to save index of last index in the heap, the ones past last (last+1...) are part of 
		//the sorted array
		int last = n-1;
		//While loop to expand the sorted region and decrease the heap, then call heapBuild to recontruct
		//semiheap to heap
		for (int i = 1; i <= n; i++) {
			int temp = arr[0];
			arr[0] = arr[last];
			arr[last] = temp;
			last--;
			heapRebuild(arr,0,last);
		}
		
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " "); 
		
	}
	//Main method to call functions
	public static void main(String[] args) {
		Scanner var1 = new Scanner(System.in);
		System.out.print("How many numbers would you like to sort: "); 
		int arrLength = var1.nextInt();
		//Input string array - collection of names
		int[] arr = new int[arrLength];
		for (int i = 1; i <= arrLength; i++) {
			Scanner var2 = new Scanner(System.in);
			System.out.print(i + ". Enter number: "); 
			arr[i-1] = var2.nextInt();
		}
		//int[] arr = new int[] {10,9,6,3,2,5};
		/*System.out.print("Original Array: "); 
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " "); 
		System.out.println();*/
		System.out.print("Ascending Order: "); 
		heapSort(arr, arrLength);
	}

}
