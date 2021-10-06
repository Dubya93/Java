public class QuickSort {
	
  public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);  // call the overloaded method below
  }

  private static void quickSort(int list[], int first, int last) {
    int index = partition(list, first, last);
    if (first < index - 1){
      quickSort(list, first, index - 1);  // recursive calling itself
	}
    if (index < last){
      quickSort(list, index, last);  // recursive calling itself 
    }
  }  

  /** Partition the array list[first..last] */
  private static int partition(int list[], int first, int last)
  {
    int i = first, j = last;
    int tmp;

    int pivot = list[(first + last) / 2];

    while (i <= j) {
	  while (list[i] < pivot){
        i++;
      }
      
	  while (list[j] > pivot){
	    j--;
	  }

      if (i <= j) {
        tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
        i++;
        j--;
      }
    }  // end of while loop.
    return i;
  } // end of method partition
} // end of class
