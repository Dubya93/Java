import java.util.Scanner;

public class LinearSearch {
  /** linear search is basically a sequential search from the beginning to the end of the array */
  public static int linearSearch(int[] list, int key) {
    for (int i = 0; i < list.length; i++) {  
      if (key == list[i]){
		return i; // the first matched index i is found, return this index and stop the loop, no need to continue.
	  }
    }
    return -1; // finished the loop but no match is found, thus return value -1 that cannot be a valid array index.
  }
  
  /** A test method */
  public static void main(String[] args) {
    int[] numbers = {20, 35, 12, -15, 20, 31, -2, 23, 14, 12};
	int keepSearching = 1;
	
	Scanner input = new Scanner(System.in);
	
    do{
      System.out.print("please input the number you want to search: ");
	  int searchedItem = input.nextInt();
      int result = linearSearch(numbers, searchedItem);
	  if(result != -1){
	    System.out.println("your search item " + searchedItem + " is in array index " + result);
	  }
	  else{
	    System.out.println("your search item " + searchedItem + " is not in this array" );
	  }
	  System.out.print("search for another number ? (1 for yes, 0 for no)");
	  keepSearching = input.nextInt();
    }while(keepSearching == 1);
	
	System.out.print("\njust for verification, the array content is:\n");
	outputArray(numbers);
  }  
  
  public static void outputArray(int[] list){
    for (int i = 0; i < list.length; i++){
      System.out.printf("%4d", list[i]);
	}
	// below is a for-each loop, which can be used to replace the regular for loop above.
	/**
	for (int eachElement: list){
      System.out.printf("%4d", eachElement);
	}
	*/
	System.out.println();
  }     
}
