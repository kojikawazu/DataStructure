package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * クイックソートクラス
 * @author nanai
 *
 */
@Component
public class QuickSort implements SuperSortIF {

	/**
	 * 
	 * [sort前]
	 * [1] [7] [5] [2] [4]
	 * 
	 * ↓
	 * 
	 * 1.
	 * [1] [7] [5] [2] [4]
	 *  ↑               |- pivot (i =  0, j = 0, sort = true)
	 * [1] [7] [5] [2] [4]
	 *      ↑           |- pivot (i =  0, j = 1, sort = false)
	 * [1] [7] [5] [2] [4]
	 *          ↑       |- pivot (i =  0, j = 2, sort = false)
	 * [1] [2] [5] [7] [4]
	 *              ↑   |- pivot (i =  1, j = 3, sort = true)
	 * [1] [2] [4] [7] [5]
	 *                  |- pivot (i =  2, j = 4, sort = true)
	 *
	 * [1] [2] [4] [7] [5]
	 *          |- pivot
	 *    left -|- right
	 *  
	 *  [1] [2] [4] | [5] [7]
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
		this.recursive_quick_sort(list, 0, targetArray.length - 1);

		// 降順の場合は反転する
		if(isDesc) list.reverse();

		// success
		return true;
	}

	/**
	 * 再帰クイックソート
	 * @param list {@link SuperArrayIF}
	 * @param low  左番号
	 * @param high 右番号
	 */
	private void recursive_quick_sort(SuperArrayIF list, int low, int high) {
		if (low < high) {
			int partition_index = this.partition(list, low, high);
			this.recursive_quick_sort(list, low,                 partition_index - 1);
			this.recursive_quick_sort(list, partition_index + 1, high);
		}
	}

	/**
	 * パーティション処理
	 * @param list {@link SuperArrayIF}
	 * @param low  左番号
	 * @param high 右番号
	 * @return     境界値
	 */
	private int partition(SuperArrayIF list, int low, int high) {
		int[] targetArray = list.getArray();
		int idx           = low - 1;
		int pivot         = targetArray[high];

		for (int idy = low; idy < high; idy++ ) {
			if (targetArray[idy] <= pivot) {
				idx++;
				int temp         = targetArray[idx];
				targetArray[idx] = targetArray[idy];
				targetArray[idy] = temp;
			}
		}

		int temp = targetArray[idx + 1];
		targetArray[idx + 1] = targetArray[high];
		targetArray[high] = temp;
		return idx + 1;
	}
}
