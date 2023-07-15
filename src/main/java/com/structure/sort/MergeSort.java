package com.structure.sort;

import org.springframework.stereotype.Component;

import com.structure.array.NormalArray;
import com.structure.array.SuperArrayIF;

/**
 * マージソートクラス
 * @author nanai
 *
 */
@Component
public class MergeSort implements SuperSortIF {

	/**
	 * 
	 * [sort前]
	 * [1] [7] [5] [2] [4]
	 * 
	 * ↓
	 * 
	 * 1.
	 * [1] [7] | [5] [2] [4]
	 * 
	 * 2.
	 * [1] | [7] | [5] | [2] [4]
	 *
	 * 3.
	 * [1] | [7] | [5] | [2] [4]
	 * 
	 * 4.
	 * [1] | [7] | [5] | [2] | [4]
	 * 	 
	 * 5.
	 * [1] [7] | [5] | [2]  [4]
	 *
	 * 6.
	 * [1] [7] | [2] [4] [5]
	 *
	 * 7.
	 * [1] [2] [4] [5] [7]
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
		
		// 再帰的マージソート
		this.recursive_merge_sort(list, isDesc);
		// 降順の場合は反転する
		if(isDesc) list.reverse();

		// success
		return true;
	}

	/**
	 * 再帰的マージソート
	 * @param list   リスト配列 {@link SuperArrayIF}
	 * @param isDesc true: 降順 false: 昇順
	 * @return true: ソート成功 false: ソート失敗
	 */
	private boolean recursive_merge_sort(SuperArrayIF list, boolean isDesc) {
		// validate
		if (list == null || list.getArray() == null || list.getArray().length == 0) {
			return false;
		}
		int[] targetArray = list.getArray();

		// sort
		int center              = (int)(targetArray.length / 2);
		boolean isOdd           = (targetArray.length >= 3 && targetArray.length % 2 != 0);
		int[] left              = new int[center];
		int[] right             = new int[(isOdd ? center + 1 : center)];
		SuperArrayIF leftArray  = new NormalArray();
		SuperArrayIF rightArray = new NormalArray();

		for (int idx = 0; idx < center; idx++) {
			left[idx]  = targetArray[idx];
			right[idx] = targetArray[idx + center];
		}
		if(isOdd) right[center] = targetArray[targetArray.length - 1];
		leftArray.setArray(left);
		rightArray.setArray(right);

		// 再帰マージソート
		this.recursive_merge_sort(leftArray, isDesc);
		this.recursive_merge_sort(rightArray, isDesc);

		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				targetArray[k] = left[i];
				i++;
			} else {
				targetArray[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			targetArray[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			targetArray[k] = right[j];
			j++;
			k++;
		}

		// success
		return true;
	}
}
