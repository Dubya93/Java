import java.util.Scanner;

public class BinarySearch {
  /** Use binary search to find out whether there is a match key in the array */
  public static int binarySearch(int[] list, int key) {
    int lowIndex = 0;
    int highIndex = list.length - 1;

    while (highIndex >= lowIndex) {
      int midIndex = (lowIndex + highIndex) / 2; // calculate the middle element's index
      if (key < list[midIndex]){  // key is smaller than the middle element,
		highIndex = midIndex - 1; // eliminate the higher half of the array
      }
      else if (key > list[midIndex]){  // key is bigger than the middle element,
		lowIndex = midIndex + 1;       // eliminate the lower half of the array
      }
      else if (key == list[midIndex]){ // find the match element to the key,
		return midIndex;               // return the matched index 
      }
    } // end of while loop

    return - 1; // now the loop terminates, and highIndex < lowIndex, so there is no match.
  }  // end of binary search method
  
  /** A test method */
  public static void main(String[] args) {
    int[] numbers = {20, 34, 23, 15, 7, 18, -22, 39, 14, 12};
	int keepSearching = 1;
	
	Scanner input = new Scanner(System.in);
	
	BubbleSort.bubbleSort(numbers); // have to sort the array before applying binary search.
    do{
      System.out.print("please input the number you want to search: ");
	  int searchedItem = input.nextInt();
      int result = binarySearch(numbers, searchedItem);
	  if(result != -1){
	    System.out.println("your search item " + searchedItem + " is in array index " + result);
	  }
	  else{
	    System.out.println("your search item " + searchedItem + " is not in this array" );
	  }
	  System.out.print("search for another number ? (1 for yes, 0 for no)");
	  keepSearching = input.nextInt();
    }while(keepSearching == 1);
	
	System.out.print("\njust for verification, the sorted array is:\n");
	outputArray(numbers);
  }  
  
  public static void outputArray(int[] list){
    for (int i = 0; i < list.length; i++){
      System.out.printf("%4d", list[i]);
	}
	System.out.println();
  }       
}
