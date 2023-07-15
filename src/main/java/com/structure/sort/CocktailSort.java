package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * Cocktailソートクラス
 * @author nanai
 *
 */
@Component
public class CocktailSort implements SuperSortIF {

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
	 *  ← ← ← ← ← ← ←
	 *
	 * 3.
	 * [1] [2] [5] [4] [7]
	 *     |---------|
	 *      → → → → →
	 * 
	 * 4.
	 * [1] [2] [4] [5] [7]
	 *     |-----|
	 *      ← ← ←
	 * 	 
	 * 5.
	 * [1] [2] [4] [5] [7]
	 *         |-|
	 *          →
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
		int     length    = targetArray.length;
		boolean isSwap    = true;
		int     start     = 0;
		int     end       = length - 1;

		// sort
		while (isSwap) {
			isSwap = false;

			for (int idx = start; idx < end; idx++) {
				if ((isDesc && targetArray[idx] < targetArray[idx + 1]) || 
					(!isDesc && targetArray[idx] > targetArray[idx + 1])) {
					int temp             = targetArray[idx];
					targetArray[idx]     = targetArray[idx + 1];
					targetArray[idx + 1] = temp;
					isSwap = true;
				}
			}

			// ソートなしで終了
			if (!isSwap) break;

			isSwap = false;
			end = end - 1;
			for (int idx = end; idx >= start; idx--) {
				if ((isDesc && targetArray[idx] < targetArray[idx + 1]) || 
					(!isDesc && targetArray[idx] > targetArray[idx + 1])) {
					int temp             = targetArray[idx];
					targetArray[idx]     = targetArray[idx + 1];
					targetArray[idx + 1] = temp;
					isSwap = true;
				}
			}

			start = start + 1;
		}

		// success
		return true;
	}
}
