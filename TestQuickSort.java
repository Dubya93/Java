//Test the time complexity of quick sort

public class TestQuickSort{
	public static void main(String[] args){
		int size = 400000;
		int[] myNumbers = new int[size];
		long startTimeTag,stopTimeTag;

		//fill array with random numbers between 0 and 1 million
   	    for(int i=0; i<myNumbers.length; i++){
			myNumbers[i] = (int) (Math.random() * 1000000);
		}
		
		startTimeTag = System.currentTimeMillis();
		QuickSort.quickSort(myNumbers);
		stopTimeTag = System.currentTimeMillis();

		System.out.println();
		System.out.printf("Time for quick sorting %d numbers is %d ms\n",  
			myNumbers.length, stopTimeTag-startTimeTag);
	} //end of main() method
} //end of class






