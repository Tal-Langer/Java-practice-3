package bank;

import java.util.Arrays;

public class ProAccount extends Account{
int[] history = new int[100];
int transactions=0;	
	public ProAccount(String name) {
		super(name);
	}
	@Override
	public void add(int amount)
	{
		super.add(amount);
		history[transactions]=super.getShekels();
		transactions++;
	}
	@Override
	public String toString()
	{
		/*make history tostring*/
		String temp_str = "[";
		for(int i=0;i<transactions;i++)
		{
			temp_str+=history[i];
			if(i<transactions-1)
				temp_str+=",";
		}
		temp_str+="]";
		return (super.toString() +" "+ temp_str);
	}
		
	
	
	public static void transfer(ProAccount from, ProAccount to, int amount)
	{
		from.add(-amount);
		to.add(amount);
	}
	
	

}
