package DataStructorPractice;

public class Heap {
	public static int[] arr;
	public static void main(String[] args) {
		
	}
	public static void MaxTheHeap(int[] arr,int index){
		int left = index*2+1;
		int right = index*2+2;
		int length = arr.length;
		if(length-1<left)
			return;
		if(length-1 == left){
			if(arr[left]>arr[index]){
				int temp = arr[left];
				arr[left] = arr[index];
				arr[index] = temp;
			}
			return;
		}
		int maxIndex = -1;
		if(arr[left]>arr[index])
			maxIndex = left;
		if(arr[right]>arr[left])
			maxIndex = right;
		if(maxIndex != index){
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[index];
			arr[index] = temp;
		}
		return;
		
	}
}
