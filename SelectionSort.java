public class SelectionSort {
  /** selection sort method */
  public static void selectionSort(int[] list) {
    for (int i = list.length - 1; i > 0; i--) {
      // find the maximum in the list[i..0], and swap it with list[i]
      int currentMaxValue = list[i];
      int currentMaxIndex = i;

      for (int j = i - 1; j >= 0; j--) {
        if (currentMaxValue < list[j]) { // Is list[j] a new candidate for max value ?
          currentMaxValue = list[j];     // if yes, record down the new candidate's info
          currentMaxIndex = j;
        }
      }

      // Swap list[i] with list[currentMaxIndex] if necessary;
      if (currentMaxIndex != i) { 
        list[currentMaxIndex] = list[i];
        list[i] = currentMaxValue;
      }
    }
  } // end of sorting method
  
  /** A test method */
  public static void main(String[] args) {
    int[] numbers = {-3, 16, 12, 29, -16, 8, 12, 16, 17, 19};
	
	System.out.print("before sorting: ");
	outputArray(numbers);
    
	selectionSort(numbers);
	
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
