package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Practice
{
	@DataProvider(name="dp_DataSearch")
	public static Iterator<String[]> getInvalidData() throws IOException 
	{
		List<String[]> Obj = flagRowCount("Invalid-Search");
		return Obj.iterator();
	}
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<String[]> getValidSearchdata() throws IOException
	{
		List<String[]> Obj = flagRowCount("Valid_Search");
		return Obj.iterator();
	}
	
	//common method
	public static List<String[]> flagRowCount(String Scriptname) throws IOException
	{
		ExcelReadWrite x1=new ExcelReadWrite("E:\\July_BB_Project\\TestData\\Test_Data.xls");
		HSSFSheet Scenario_Search = x1.Setsheet("Scenario_Search");
		int Rowcount = x1.getrowcount(Scenario_Search);
		
		//create a list
		List<String[]> List_Search= new ArrayList<String[]>();
		
		for(int x1row=1;x1row<=Rowcount;x1row++)
		{
			String Execute_Flag = x1.Readvalue(Scenario_Search, x1row, "Execute_Flag");
			String Script_name = x1.Readvalue(Scenario_Search, x1row, "Script_name");
			
			if((Execute_Flag.equals("Y")) && (Script_name.equals(Scriptname)))
			{
				String[] arr_Search=new String[4];
				
				 arr_Search[0] = x1.Readvalue(Scenario_Search, x1row, "TC_ID");
				 arr_Search[1] = x1.Readvalue(Scenario_Search, x1row, "Order");
				 arr_Search[2] = x1.Readvalue(Scenario_Search, x1row, "Search_Item");
				 arr_Search[3] = x1.Readvalue(Scenario_Search, x1row, "Exp_Result");
				 
				 arr_Search[3]= arr_Search[3].replace(".0", "");
				 
				 List_Search.add(arr_Search);
				 
				 
			}//end of if condiation
			
			
		}//end of for loop
		
		return List_Search;
		
		
	}

}
