/*
 * Christopher Schweninger
 */
public class WordHelper {
	
	public static String[] sortByVowels(String[] stringArray)
	{
		int temp = stringArray.length;
		String[] workingArray = new String[temp];
		for(int i=0;i<stringArray.length;i++)
			workingArray[i] = stringArray[i];
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			
			for(int i=0; i<workingArray.length-1; i++)
			{
				int workNum1 = WordHelper.findNumOfVowels(workingArray[i]);
				int workNum2 = WordHelper.findNumOfVowels(workingArray[i+1]);
				if(workNum1 > workNum2)
				{
					//Swap
					String tempStr = workingArray[i];
					workingArray[i] = workingArray[i+1];
					workingArray[i+1] = tempStr;
					hasSwapped = true;
				}
			}
		}
		return workingArray;
	}
	public static String[] sortByConsonants(String[] stringArray)
	{
		int temp = stringArray.length;
		String[] workingArray = new String[temp];
		for(int i=0;i<stringArray.length;i++)
			workingArray[i] = stringArray[i];
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			
			for(int i=0; i<workingArray.length-1; i++)
			{
				int workNum1 = WordHelper.findNumOfConsonants(workingArray[i]);
				int workNum2 = WordHelper.findNumOfConsonants(workingArray[i+1]);
				if(workNum1 > workNum2)
				{
					//Swap
					String tempStr = workingArray[i];
					workingArray[i] = workingArray[i+1];
					workingArray[i+1] = tempStr;
					hasSwapped = true;
				}
			}
		}
		return workingArray;
	}
	public static String[] sortByLength(String[] stringArray)
	{
		int temp = stringArray.length;
		String[] workingArray = new String[temp];
		for(int i=0;i<stringArray.length;i++)
			workingArray[i] = stringArray[i];
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			
			for(int i=0; i<workingArray.length-1; i++)
			{
				
				if(workingArray[i].length() > workingArray[i+1].length())
				{
					//Swap
					String tempStr = workingArray[i];
					workingArray[i] = workingArray[i+1];
					workingArray[i+1] = tempStr;
					hasSwapped = true;
				}
			}
		}
		return workingArray;
	}
	public static int findNumOfVowels(String aStr)
	{
		int strNumber = 0;
		for(int i=0;i<aStr.length();i++)
		{
			char letter = aStr.charAt(i);
			if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y')
				strNumber++;
		}
		return strNumber;
	}
	public static int findNumOfConsonants(String aStr)
	{
		int strNumber = 0;
		for(int i=0;i<aStr.length();i++)
		{
			char letter = aStr.charAt(i);
			if(letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u' && letter != 'y')
				strNumber++;
		}
		return strNumber;
	}
}
