package com.structure.sort;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * Radixソートクラス
 * @author nanai
 *
 */
@Component
public class RadixSort implements SuperSortIF {

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

		// sort
		int[] targetArray = list.getArray();
		int   max         = Arrays.stream(targetArray).max().getAsInt();
		int   place       = 1;

		// Countingソート
		CountingSort countingSort = new CountingSort();
		while (max > place) {
			countingSort.sort(list, false, place);
			// 次の位へ
			place *= 10;
		}

		// 降順の場合は反転する
		if(isDesc) list.reverse();

		return true;
	}

}
