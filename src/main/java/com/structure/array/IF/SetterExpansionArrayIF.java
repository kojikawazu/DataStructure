package com.structure.array.IF;

import java.util.List;

/**
 * setter拡張配列IF
 * @author nanai
 *
 */
public interface SetterExpansionArrayIF {

	/**
	 * setter
	 * @param list {@link Integer}[]
	 */
	void setArray(Integer[] list);

	/**
	 * setter
	 * @param list {@link List}<{@link Integer}>
	 */
	void setArray(List<Integer> list);
}
