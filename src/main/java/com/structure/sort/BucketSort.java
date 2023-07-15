package com.structure.sort;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.structure.array.NormalArray;
import com.structure.array.SuperArrayIF;

/**
 * バケットソートクラス
 * @author nanai
 *
 */
@Component
public class BucketSort extends NormalSort {

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
		//int max = Arrays.stream(targetArray).max().getAsInt();
		int size = 10;

		List<List<Integer>> buckets = new ArrayList<List<Integer>>();
		for (int idx = 0; idx < size; idx++) {
			buckets.add(new ArrayList<>());
		}

		for (int idx = 0; idx < len; idx++) {
			int idy = (int)(targetArray[idx] / size);
			if (idy != size) {
				buckets.get((isDesc ? size - 1 - idy : idy)).add(targetArray[idx]);
			} else {
				buckets.get((isDesc ? 0 : size - 1)).add(targetArray[idx]);
			}
		}

		// 挿入ソート
		InsertionSort insertionSort = new InsertionSort();
		for (int idx = 0; idx < size; idx++) {
			insertionSort.sort(buckets.get(idx), isDesc);
		}

		// リストの連結
		List<Integer> resultList = new ArrayList<Integer>();
		for (int idx = 0; idx < size; idx++) {
			resultList.addAll(buckets.get(idx));
		}

		// コピー
		NormalArray normalArray = new NormalArray(resultList);
		System.arraycopy(normalArray.getArray(), 0, list.getArray(), 0, normalArray.getArray().length);

		// success
		return true;
	}

}
