package com.interveiw.assignments.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsTest2 {
	
	public static void main(String[] args) {
		flatmapEx();
		flatMapex2();
	}

	private static void flatMapex2() {
		
		List<List<Integer>> a1 = new ArrayList();
		a1.add(Arrays.asList(32,432,533,355,254,534));
		a1.add(Arrays.asList(32,432,533,678,534));
		a1.add(Arrays.asList(32,432,434,254,745));
		a1.add(Arrays.asList(45,432,875,254,534));
		a1.add(Arrays.asList(465,432,434,656,745));
		
		
		Map<Integer, Long> a2= a1.stream().flatMap(List::stream).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(a1.stream().distinct().collect(Collectors.toList()));
		
		findMissingNumber();
		findSmallestInArray();
		
	}

	private static void flatmapEx() {
		
		List<List<Integer>> a1 = new ArrayList();
		
		a1.add(Arrays.asList(32,432,533,355,254,534));
		a1.add(Arrays.asList(32,432,533,678,534));
		a1.add(Arrays.asList(32,432,434,254,745));
		a1.add(Arrays.asList(45,432,875,254,534));
		a1.add(Arrays.asList(465,432,434,656,745));
		
		Map<Integer, Long> a2= (a1.stream().flatMap(List::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(a2);
		
		
		
	}
	
	public static void findMissingNumber(){
		
		int[] arr1={7,5,6,1,4,2};
		//Missing numner : 3
		int[] arr2={5,3,1,2};
		//Missing numner : 4
		
        System.out.println("Missing number from array arr1: "+missingNumber(arr1));
        System.out.println("Missing number from array arr2: "+missingNumber(arr2));
 
    }
 
    public static int missingNumber(int[] arr)
    {
        int n=arr.length+1;
        int sum=n*(n+1)/2;
        int restSum=0;
        for (int i = 0; i < arr.length; i++) {
            restSum+=arr[i];
        }
        int missingNumber=sum-restSum;
        return missingNumber;
    }

    public static void findSmallestInArray() {
        int arr[]={16,19,21,25,3,5,8,10};
        System.out.println("Index of element 5 : "+findElementRotatedSortedArray(arr,0,arr.length-1,5));
    }
    public  static  int findElementRotatedSortedArray(int[] arr,int low,int high,int number)
    {
        int mid;
        while(low<=high)
        {
            mid=low + ((high - low) / 2);;
 
            if(arr[mid]==number)
            {
                return mid;
            }
            if(arr[mid]<=arr[high])
            {
                // Right part is sorted
                if(number > arr[mid] && number <=arr[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            else
            {
                // Left part is sorted
                if(arr[low]<=number && number < arr[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
        }
        return -1;
    }
}
