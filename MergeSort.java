import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args)
	{
		int[] start = new int[100];
		for(int i = 0; i < start.length; i++)
		{
			start[i] = (int)(Math.random()*20 + 1);
		}
		int[] sorted = Arrays.copyOf(start,start.length);
		Arrays.sort(sorted);
		mergesort(start);
		if(Arrays.equals(start, sorted))
			System.out.print("correctly sorted");
		else
			System.out.print("not properly sorted");
	}
	
	/*
	 * implement the mergesort method.  It should be a recursive
	 * implementation of the mergesort algorithm we spoke about
	 * in class.  If you run this main method it will tell you 
	 * if your algorithm properly sorted the array.  You do not 
	 * need to add any code to the main method.
	 */
	
	public static void mergesort(int[] arr)
	{
		if(arr.length <= 1)
		{
			return;
		}
		
		int midpoint = arr.length/2;
		int[] left = new int[midpoint];
		int[] right = new int[arr.length-midpoint];
		
		//Populating Left Array
		for(int i = 0; i < midpoint ; i++)
		{
			left[i] = arr[i];
		}
		
		//Populating Right Array
		for(int i = midpoint; i < arr.length; i++)
		{
			right[i-midpoint] = arr[i];
		}
		
		
		mergesort(left);
		mergesort(right);
		
		
		merge(arr, left, right, midpoint, arr.length-midpoint);
	}
	public static void merge(int[] arr, int[] left, int[] right, int l, int r)
	{
		int i = 0; 
		int j = 0;
		int k = 0;
		
		while (i < l && j < r) 
		{
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                k++;
                i++;
            }
            else
            {
                arr[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < l)
        {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < r)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
	}

}
