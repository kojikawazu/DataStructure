package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * Shellソートクラス
 * @author nanai
 *
 */
@Component
public class ShellSort implements SuperSortIF {

	/**
	 * 
	 * [sort前]
	 * [1] [7] [5] [2] [4]
	 * 
	 * ↓
	 * 
	 * 1. gap = 2 temp = 5
	 * [1] [7] [5] [2] [4]
	 * |         |
	 * |---------|
	 * 
	 *    gap = 2 temp = 2
	 * [1] [7] [5] [2] [4] ★ sort
	 *     |         |
	 *     |---------|
	 *
	 *    gap = 2 temp = 4
	 * [1] [2] [5] [7] [4] ★ sort
	 *         |         |
	 *         |---------|
	 *
	 *    gap = 2 temp = 4
	 * [1] [2] [4] [7] [5]
	 * |         |
	 * |---------|
	 *
	 * 2. gap = 1 temp = 2
	 * [1] [2] [4] [7] [5]
	 * |     |
	 * |-----|
	 *
	 *    gap = 1 temp = 4
	 * [1] [2] [4] [7] [5]
	 *     |     |
	 *     |-----|
	 *
	 *    gap = 1 temp = 7
	 * [1] [2] [4] [7] [5]
	 *         |     |
	 *         |-----|
	 *
	 *    gap = 1 temp = 5
	 * [1] [2] [4] [7] [5] ★ sort
	 *             |     |
	 *             |-----|
	 *
	 *    gap = 1 temp = 5
	 * [1] [2] [4] [5] [7]
	 *         |     |
	 *         |-----|
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
		int gap = (int)(len / 2);
		while (gap > 0) {
			for (int idx = gap; idx < len; idx++) {
				int temp = targetArray[idx];
				int idy = idx;
				while (idy >= gap && 
						((isDesc && targetArray[idy - gap] < temp) || 
						(!isDesc && targetArray[idy - gap] > temp))) {
					targetArray[idy] = targetArray[idy - gap];
					idy -= gap;
				}
				targetArray[idy] = temp;
			}
			gap = (int)(gap / 2);
		}

		// success
		return true;
	}
}
