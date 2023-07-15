package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * Gnomeソートクラス
 * @author nanai
 *
 */
@Component
public class GnomeSort implements SuperSortIF {

	/**
	 * 
	 * [sort前]
	 * [1] [7] [5] [2] [4]
	 * 
	 * ↓
	 * 
	 * 1.
	 * [1] [7] [5] [2] [4]
	 * |-----| 
	 * 
	 * 2.
	 * [1] [7] [5] [2] [4] ★ sort
	 *     |-----|
	 *
	 * 3.
	 * [1] [5] [7] [2] [4]
	 * |-----|
	 * 
	 * 4.
	 * [1] [5] [7] [2] [4]
	 *     |-----|
	 * 
	 * 5.
	 * [1] [5] [7] [2] [4] ★ sort
	 *         |-----|
	 *
	 * 6.
	 * [1] [5] [2] [7] [4] ★ sort
	 *     |-----|
	 * 
	 * 7.
	 * [1] [2] [5] [7] [4]
	 * |-----|
	 * 
	 * 8.
	 * [1] [2] [5] [7] [4]
	 *     |-----|
	 * 
	 * 9.
	 * [1] [2] [5] [7] [4]
	 *         |-----|
	 * 
	 * 10.
	 * [1] [2] [5] [7] [4] ★ sort
	 *             |-----|
	 * 
	 * 11.
	 * [1] [2] [5] [4] [7] ★ sort
	 *         |-----|
	 *
	 * 12.
	 * [1] [2] [4] [5] [7]
	 *     |-----|
	 *
	 * 13.
	 * [1] [2] [4] [5] [7]
	 *         |-----|
	 * 
	 * 14.
	 * [1] [2] [4] [5] [7]
	 *             |-----|
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
		int len           = targetArray.length;
		int idx          = 0;
		while (idx < len) {
			if (idx == 0) {
				idx++;
			}
			if ((isDesc && targetArray[idx] <= targetArray[idx - 1]) || 
				(!isDesc && targetArray[idx] >= targetArray[idx - 1])) {
				idx++;
			} else {
				int temp             = targetArray[idx];
				targetArray[idx]     = targetArray[idx - 1];
				targetArray[idx - 1] = temp;
				idx--;
			}
		}

		// success
		return true;
	}

}
