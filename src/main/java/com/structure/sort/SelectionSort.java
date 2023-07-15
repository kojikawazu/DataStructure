package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * 選択ソートクラス
 * @author nanai
 *
 */
@Component
public class SelectionSort implements SuperSortIF {

	/**
	 * 
	 * [sort前]
	 * [1] [7] [5] [2] [4]
	 * 
	 * ↓
	 * 
	 * 1.
	 * [1] [7] [5] [2] [4]
	 * |-----------------|
	 *  → → → → → → → → →
	 * 
	 * 2.
	 * [1] [7] [5] [2] [4]
	 *     |-------------|
	 *      → → → → → → →
	 *
	 * 3.
	 * [1] [2] [5] [7] [4]
	 *         |---------|
	 *          → → → → →
	 * 
	 * 4.
	 * [1] [2] [4] [7] [5]
	 *             |-----|
	 *              → → →
	 * 	 
	 * 5.
	 * [1] [2] [4] [5] [7]
	 *                 |-|
	 *                  →
	 *  
	 *  ↓
	 *  
	 *  [ソート後]
	 *  [1] [2] [4] [5] [7]
	 *  
	 */

	/**
	 * 並び替え
	 * @param list   リスト配列 {@link SuperArrayIF}
	 * @param isDesc true: 降順 false: 昇順
	 * @return true: ソート成功 false: ソート失敗
	 */
	@Override
	public boolean sort(SuperArrayIF list, boolean isDesc) {
		// validate
		if (list == null || list.getArray() == null || list.getArray().length == 0) {
			return false;
		}
		int[] targetArray = list.getArray();

		// sort
		int len = targetArray.length;
		for (int idx = 0; idx < len; idx++) {
			int min_idx = idx;
			for (int idy = idx + 1; idy < len; idy++) {
				if ((isDesc && targetArray[min_idx] < targetArray[idy]) || 
					(!isDesc && targetArray[min_idx] > targetArray[idy])) {
					min_idx = idy;
				}
			}

			int temp             = targetArray[idx];
			targetArray[idx]     = targetArray[min_idx];
			targetArray[min_idx] = temp;
		}

		// success
		return true;
	}
}
