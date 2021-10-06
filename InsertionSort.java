public class InsertionSort {
  /** insertion sort method */
  public static void insertionSort(int[] list) {
    for (int i = 1; i < list.length; i++) {
      /** insert list[i] into a suitable position of the sorted sublist list[0..i-1], 
        such that list[0..i] is sorted. */
      int currentElement = list[i];
      int j;
      for (j = i - 1; j >= 0 && list[j] > currentElement; j--) {
        list[j + 1] = list[j];
      }
	  
      if(j+1 != i){  // there is a need to insert the current element list[i] into list[j+1]
        list[j + 1] = currentElement;
	  }
    }
  }
  
  /** A test method */
  public static void main(String[] args) {
    int[] numbers = {27, 33, -12, 15, 7, 11, -12, 30, 33, 7};
	
	System.out.print("before sorting: ");
	outputArray(numbers);
    
	insertionSort(numbers);
	
	System.out.print("after  sorting: ");
	outputArray(numbers);
  }
  
  public static void outputArray(int[] list){
    for (int i = 0; i < list.length; i++){
      System.out.printf("%4d", list[i]);
	}
	System.out.println();
  }   
}
