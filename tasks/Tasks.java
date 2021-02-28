package tasks;

import java.util.Arrays;

public class Tasks {
	private int tasks;
	protected int[][] matrix;
	protected int dependence_Cnt;
	protected final int BEFORE = 0, AFTER = 1; // col of matrix sign

	public Tasks(int num) {
		tasks = num;
		this.matrix = new int[num][2];
		dependence_Cnt = 0;
	}

	public boolean dependsOn(int task1, int task2) {
		/* matrix of dependence , row = Constraint , col[0]=before , col[1]=after */
		/* task2 must be before task 1 */
		if ((task1 < 0 || task1 > tasks - 1) || (task2 < 0 || task2 > tasks - 1))
			return false;
		/* add dependence to matrix */
		matrix[dependence_Cnt][BEFORE] = task2;// before
		matrix[dependence_Cnt][AFTER] = task1;// after
		dependence_Cnt++;
		return true;
	}

	public int[] order() {
		int cnt_result = 0;// counter of tasks added to result array
		int[] result_arr = new int[tasks];

		while (cnt_result < tasks)// while result array is not full
		{
			int[] cnt_arr = new int[tasks]; // Counter array
			/* update cnt_arr with -1 for tasks that already in result array */
			for (int i = 0; i < cnt_result; i++)
				cnt_arr[result_arr[i]] = -1;
			/* add dependences to cnt_arr (if not in result and not deleted from matrix) */
			for (int i = 0; i < dependence_Cnt; i++) {
				if (matrix[i][AFTER] != -1)// dependence not deleted //האם אפטר שונה ממינוס 1
					if (!(cnt_arr[matrix[i][AFTER]] == -1))// dependence not in result arr
						cnt_arr[matrix[i][AFTER]]++;// add dependence to cnt_arr
			}
			/* find task without dependence */
			for (int i = 0; i < tasks; i++) {
				if (cnt_arr[i] == 0)// task without dependence
				{
					/* add task to result array */
					result_arr[cnt_result] = i;
					cnt_result++;// task added to result array
					/* delete from matrix */
					for (int j = 0; j < dependence_Cnt; j++) {
						if (matrix[j][BEFORE] == result_arr[cnt_result - 1])
							/* delete Shared constraints on task added to result array */
							matrix[j][AFTER] = -1;// (-1) is delete mark
					} // for

				}

				else if (i == tasks - 1 && cnt_arr[i] != -1)
					return null; // there is circle
			} // for
		} // while
		return result_arr;
	}// order()

}
