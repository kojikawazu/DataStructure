package com.structure.array;

import com.structure.array.IF.AsArrayIF;
import com.structure.array.IF.ControlArrayIF;
import com.structure.array.IF.SetterExpansionArrayIF;

/**
 * スーパー配列IF
 * @author nanai
 *
 */
public interface SuperArrayIF extends ControlArrayIF, SetterExpansionArrayIF, AsArrayIF {

	/**
	 * setter
	 * @param list int[]
	 */
	void setArray(int[] list);

	/**
	 * getter
	 * @return int[]
	 */
	int[] getArray();
}
