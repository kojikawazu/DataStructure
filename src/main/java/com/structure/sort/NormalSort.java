package com.structure.sort;

import java.util.List;

import com.structure.array.NormalArray;
import com.structure.array.SuperArrayIF;

/**
 * ノーマルソートクラス
 * @author nanai
 *
 */
public class NormalSort implements SuperSortIF {

	/**
	 * 並び替え
	 * @param list   リスト配列 {@link SuperArrayIF}
	 * @param isDesc true: 降順 false: 昇順
	 * @return true: ソート成功 false: ソート失敗
	 */
	@Override
	public boolean sort(SuperArrayIF list, boolean isDesc) {
		return true;
	}

	/**
	 * 並び替え
	 * @param list   リスト配列
	 * @param isDesc true: 降順 false: 昇順
	 * @return true: ソート成功 false: ソート失敗
	 */
	public boolean sort(List<Integer> list, boolean isDesc) {
		NormalArray normalArray = new NormalArray(list);

		// 本来のsort
		boolean result = this.sort(normalArray, isDesc);

		// コピー
		List<Integer> sortedList = normalArray.asList();
		for (int idx = 0, len = sortedList.size(); idx < len; idx++) {
			list.set(idx, sortedList.get(idx));
		}

		return result;
	}
}
