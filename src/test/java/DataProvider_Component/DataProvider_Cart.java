package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Cart 
{
	@DataProvider(name="dp_AddCart")
	public static Iterator<String[]> getAddCartData() throws IOException
	{
		List<String[]> Obj = flagrowCount("AddCart");
		return Obj.iterator();
	}
	
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<String[]> getDeleteCartData() throws IOException
	{
		List<String[]> Obj = flagrowCount("DeleteCart");
		return Obj.iterator();
	}
	
	
	public static List<String[]> flagrowCount(String Scriptname) throws IOException
	{
		ExcelReadWrite x1=new ExcelReadWrite("E:\\July_BB_Project\\TestData\\Test_Data.xls");
		HSSFSheet Scenario_Cart = x1.Setsheet("Scenario_Cart");
		
		int RowCount = x1.getrowcount(Scenario_Cart);
		
		//Create a list
		List<String[]> List_cart= new ArrayList<String[]>();
		
		for(int x1Row=1; x1Row<=RowCount; x1Row++)
		{
			String Execute_Flag = x1.Readvalue(Scenario_Cart, x1Row, "Execute_Flag");
			
			String Script_name = x1.Readvalue(Scenario_Cart, x1Row, "Script_name");
			
			if((Execute_Flag.equals("Y") && (Script_name.equals(Scriptname))))
			{
				String[] arr_cart=new String[5];
				
				arr_cart[0]= x1.Readvalue(Scenario_Cart, x1Row, "TC_ID");
				arr_cart[1]= x1.Readvalue(Scenario_Cart, x1Row, "Order");
				arr_cart[2]= x1.Readvalue(Scenario_Cart, x1Row, "Search_Item");
				arr_cart[0]= x1.Readvalue(Scenario_Cart, x1Row, "Quantity");
				arr_cart[0]= x1.Readvalue(Scenario_Cart, x1Row, "Exp_Result");
				
				
				List_cart.add(arr_cart);
						
			} //close if stmt
			
		}//close for stmt
		
		
		return List_cart;
	}
	
	

}
