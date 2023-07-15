package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * Combソートクラス
 * @author nanai
 *
 */
@Component
public class CombSort implements SuperSortIF {

	/**
	 * 
	 * [sort前]
	 * [1] [7] [5] [2] [4]
	 * 
	 * ↓
	 * 
	 * 1. gap = 3
	 * [1] [7] [5] [2] [4]
	 * |             |
	 * |-------------|
	 * 
	 * [1] [7] [5] [2] [4] ★ sort
	 *     |             |
	 *     |-------------|
 	 *
	 * 2. gap = 2
	 * [1] [4] [5] [2] [7]
	 * |         |
	 * |---------|
	 *
	 * [1] [4] [5] [2] [7] ★ sort
	 *     |         |
	 *     |---------|
	 * 
	 * [1] [2] [5] [4] [7]
	 *         |         |
	 *         |---------|
	 *
	 * 3. gap = 1
	 * [1] [2] [5] [4] [7]
	 * |     |
	 * |-----|
	 * 
	 * [1] [2] [5] [4] [7]
	 *     |     |
	 *     |-----|
	 *
	 * [1] [2] [5] [4] [7] ★ sort
	 *         |     |
	 *         |-----|
	 *
	 * [1] [2] [4] [5] [7]
	 *             |     |
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
		int gap           = len;
		boolean isSwapp   = true;
		while (gap != 1 || isSwapp) {
			gap = (int)(gap / 1.3);
			if (gap < 1) gap = 1;
			isSwapp = false;

			for (int idx = 0; idx < len - gap; idx++) {
				if((isDesc && targetArray[idx] < targetArray[idx + gap]) || 
					(!isDesc && targetArray[idx] > targetArray[idx + gap])) {
					int temp               = targetArray[idx];
					targetArray[idx]       = targetArray[idx + gap];
					targetArray[idx + gap] = temp;
					isSwapp = true;
				}
			}
		}

		// success
		return true;
	}
}
