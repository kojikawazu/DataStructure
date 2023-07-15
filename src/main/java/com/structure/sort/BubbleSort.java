package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * バブルソートクラス
 * @author nanai
 *
 */
@Component
public class BubbleSort implements SuperSortIF {

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
	 * [1] [5] [2] [4] [7]
	 * |-------------|
	 *  → → → → → → →
	 *
	 * 3.
	 * [1] [2] [4] [5] [7]
	 * |---------|
	 *  → → → → →
	 * 
	 * 4.
	 * [1] [2] [4] [5] [7]
	 * |-----|
	 *  → → →
	 * 	 
	 * 5.
	 * [1] [2] [4] [5] [7]
	 * |-|
	 *  →
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
			for (int idy = 0; idy < len - 1 - idx; idy++) {
				if ((isDesc && targetArray[idy] < targetArray[idy + 1]) || 
					(!isDesc && targetArray[idy] > targetArray[idy + 1])) {
					int temp            = targetArray[idy];
					targetArray[idy]     = targetArray[idy + 1];
					targetArray[idy + 1] = temp;
				}
			}
		}

		// success
		return true;
	}
}
