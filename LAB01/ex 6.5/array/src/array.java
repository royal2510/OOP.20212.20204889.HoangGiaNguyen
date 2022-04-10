public class array {
	public static void main(String[] args)   
	{    
	int sum = 0;
	int arr[] = new int[] {8, 9, 1, 3, 2, 5, 6, 7, 10, 68, 29, 100};  
	System.out.println("Array elements after sorting:");  
	for (int i = 0; i < arr.length; i++)   
	{  
	for (int j = i + 1; j < arr.length; j++)   
	{  
	int tmp = 0;  
	if (arr[i] > arr[j])   
	{  
	tmp = arr[i];  
	arr[i] = arr[j];  
	arr[j] = tmp;  
	}  
	}
	System.out.print(arr[i] + " "); 
	} 
	for (int h = 0; h < arr.length;h++)
	{
		sum = arr[h] + sum;
	}
	float average = sum/arr.length;
	System.out.println();
	System.out.println("sum = " + sum);
	System.out.println("average = " + average);
	}  
	}  