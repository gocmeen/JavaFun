
public class Answers {

	public static int forbiddenInterval(int a,int b)
	{
		// No 1
		if( a+b < 10 || a+b > 19 )
			return a+b;
		else
			return 20;
	}
	
	public static int biggerNumber(int a,int b)
	{
		// No 2
		if( a < b)
			return b;
		else
			return a;
	}
	
	public static boolean isInRange(int a)
	{
		// No 3
		if( a < 1 || a > 10 )
			return false;
		else
			return true;
	}
	
	public static String charAtString( String s,int n )
	{
		// No 4
		if(s.equals("")==false && n>=0 && n<s.length())
			return s.charAt(n)+"";
		else
			return "Unexpected value!";
	}
	
	public static int sum(int a,int b)
	{
		// No 5
		if(a!= b)
			return a+b;
		else
			return a*4;
	}
	
	public static int nearestValue(int a,int b)
	{
		// No 6
		if(Math.abs(10-a)< Math.abs(10-b))
			return b;
		else if(Math.abs(10-a)> Math.abs(10-b))
			return a;
		else
			return 0;
	}
	
	public static int sumOrDoubleSum(int a,int b)
	{
		// No 7
		if( a%2 == 0 && b%2 == 0)
			return 2*(a+b);
		else
			return a+b;
	}
	
	public static int howManyInString(String s,char ch)
	{
		// No 8
		int count = 0;
		
		if( s.equals("") || (ch + "").length() == 0 )
			return -27;
		else
		{
			for(int i = 0; i< s.length(); i++)
			{
				if((s.charAt(i)+"").equals(ch + ""))
					count++;
			}
				
		}
		return count;
	}
	
	public static boolean modFive(int a)
	{
		// No 9
		if(a<=0)
			return false;
		else
		{
			if(a%5==0)
				return true;
		}
		return false;
	}
	
	public static boolean multipleOf(int a)
	{
		// No 10
		if(a<=0)
			return false;
		else
		{
			if(a%2==0 && a%3!=0)
				return true;
		}
		return false;
	}
	
	public static int[] evenButNotDivisibleByThree()
	{
		// No 11
		// IMPORTANT: I assumed that we will return an array
		int[] array = new int[15];
		int count = 0;
		int number = 0;
		
		while(count<15)
		{
			number++;
			
			if(number%2==0 && number%3!=0)
			{
				array[count]=number;
				count++;
			}
		}
		return array;	
	}
	
	public static void swap(int[] a)
	{
		// No 12
		if(a.length>=2)
		{
			int tmp = 0;
		
			tmp = a[0];
			a[0]= a[a.length -1];
			a[a.length-1]=tmp;
		}
		else
			System.out.println("Unexpected value!");
	}
	
	public static boolean sameTwoElements(int[] a)
	{
		// No 13
		if(a.length>=2)
		{
			if(a[0]==a[1])
				return true;
			else
				return false;
		}
		return false;
	}
	
	public static String reverseString(String s)
	{
		// No 14
		if(s.length()>=2)
		{
			String reverse = new StringBuffer(s).reverse().toString();
			return reverse;
		}
		else
			return "Unexpected value!";
	}
	  
    public static boolean isConsecutive(int[] givenArray)
    {
        // No 15
        if( givenArray.length <= 1)
            return true;
        else
            for( int i = 0; i < givenArray.length-1; i++)
        {
            if((givenArray[i] +1) !=  givenArray[i+1])
                return false;
        }
        return true;
    }
	
	public static String deleteSubstring(String s)
	{
		// No 16
		if(s.length()>=2)
		{
			String str=s.replaceAll("hi","");
			return str;
		}
		else
			return "Unexpected value!";
	}
	
	public static String recursiveRemover(String given)
    {
        // No 17
        if (given.length() == 0)
        {
            return given;
        }
        
        if (given.charAt(0) == 'y')
        {
            return "" + recursiveRemover(given.substring(1));
        }
        return given.charAt(0) + recursiveRemover(given.substring(1));
    }
}
