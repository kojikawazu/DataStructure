package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * 挿入ソートクラス
 * @author nanai
 *
 */
@Component
public class InsertionSort extends NormalSort {

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
	 * 2. temp = 5
	 * [1] [7] [5] [2] [4] ★ sort
	 *     |-----|
	 *
	 * 3. temp = 2
	 * [1] [5] [7] [2] [4] ★ sort
	 *         |-----|
	 * 
	 * 4. temp = 2
	 * [1] [5] [2] [7] [4] ★ sort
	 *     |-----|
	 *  
	 * 5.
	 * [1] [2] [5] [7] [4]
	 *         |-----|
	 *
	 * 6. temp = 4
	 * [1] [2] [5] [7] [4] ★ sort
	 *             |-----|
	 *
	 *    temp = 4
	 * [1] [2] [5] [4] [7] ★ sort
	 *         |-----|
	 *
	 *    temp = 4
	 * [1] [2] [4] [5] [7]
	 *     |-----|
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
		for (int idx = 1; idx < len; idx++) {
			int tmp = targetArray[idx];
			int idy = idx- 1;
			while (idy >= 0 && 
					((isDesc && targetArray[idy] < tmp) ||
					(!isDesc && targetArray[idy] > tmp))) {
				targetArray[idy + 1] = targetArray[idy];
				idy--;
			}
			targetArray[idy + 1] = tmp;
		}

		// success
		return true;
	}
}
