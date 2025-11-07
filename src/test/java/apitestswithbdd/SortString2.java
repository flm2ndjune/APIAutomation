package apitestswithbdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortString2 {
	
	public static void main(String[] args) {
		
		
		String[] str= {"cat","bat","rat","mat","hat"};
		
		bubbleSort(str);
		
	}

private static void bubbleSort(String[] arr) {
		
		int pass=1;
		
		for(int i=0;i<arr.length-1;i++)
		{
			
			for(int j=0;j<arr.length-1;j++)
			{
				//a    b 
				if(arr[j].charAt(0)>arr[j+1].charAt(0))
				{
					String temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			//System.out.println(arr[arr.length-pass]);
			pass++;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		
}


}
