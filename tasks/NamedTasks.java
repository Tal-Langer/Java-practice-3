package tasks;

import java.util.Arrays;

public class NamedTasks extends Tasks {
	//private String[][] matrix;
	private String[] names;
	//private String[] result_arr;
	
	public NamedTasks(String[] names) {
		super(names.length);// num of tasks
		this.names = names;// save tasks names
	}

	public boolean dependsOn(String task1, String task2) {
		int index1=-1 , index2=-1;
		String temp = Arrays.deepToString(names);
		/*check if task1 and task2 is in names array*/
		if (!(temp.contains(task1) && temp.contains(task2)))
			return false;
		/*find index of task1 and task2*/
		for(int i=0;i<names.length;i++)
		{
			if(names[i].equals(task1))
				index1=i;
			else if (names[i].equals(task2))
				index2=i;
		}
		return(dependsOn(index1,index2));
		
		
	}

	public String[] nameOrder() {
		{
			int[] index_order = order();//order by index
			if (index_order == null)
				return null;//no order possible (circle)
			String[] names_order = new String[names.length];
			for (int i = 0; i < names.length; i++) 
				/*add names to names_order by index , using index_order */  
			{
				names_order[i] = names[index_order[i]];
			}
			return names_order;
		}
	}
	
	
}
