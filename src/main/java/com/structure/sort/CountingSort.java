package com.structure.sort;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.structure.array.SuperArrayIF;

/**
 * Countingソートクラス
 * @author nanai
 *
 */
@Component
public class CountingSort implements SuperSortIF {

	/**
	 * 
	 * [sort前]
	 * [1] [7] [5] [2] [4]
	 * 
	 * ↓
	 * 
	 *  0   1   2   3   4   5   6   7
	 * [0] [0] [0] [0] [0] [0] [0] [0]
	 *
	 *  0   1   2   3   4   5   6   7
	 * [0] [1] [1] [0] [1] [1] [0] [1]
	 *
	 *  0   1   2   3   4   5   6   7
	 * [0] [1] [2] [3] [3] [4] [4] [5]
	 * 
	 * ↓
	 * 
	 * [1] [7] [5] [2] [4]
	 * 
	 * 1.
	 *  0   1   2   3   4   5   6   7
	 * [0] [1] [2] [3] [2] [4] [4] [5]
	 *  0   1   2   3   4
	 * [ ] [ ] [4] [ ] [ ]
	 * 
	 * 2.
	 *  0   1   2   3   4   5   6   7
	 * [0] [1] [1] [3] [2] [4] [4] [5]
	 *  0   1   2   3   4
	 * [ ] [2] [4] [ ] [ ]
	 *
	 * 3.
	 *  0   1   2   3   4   5   6   7
	 * [0] [1] [1] [3] [2] [3] [4] [5]
	 *  0   1   2   3   4
	 * [ ] [2] [4] [5] [ ]
	 * 
	 * 4.
	 *  0   1   2   3   4   5   6   7
	 * [0] [1] [1] [3] [2] [3] [4] [4]
	 *  0   1   2   3   4
	 * [ ] [2] [4] [5] [7]
	 *  
	 * 5.
	 *  0   1   2   3   4   5   6   7
	 * [0] [0] [1] [3] [2] [3] [4] [4]
	 *  0   1   2   3   4
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
		this.sort(list, isDesc, -1);
		return true;
	}

	/**
	 * 並び替え
	 * @param list   リスト配列 {@link SuperArrayIF}
	 * @param isDesc true: 降順 false: 昇順
	 * @param place  Radixソート用 -1の場合: CountingSort それ以外: RadixSort
	 * @return true: ソート成功 false: ソート失敗
	 */
	public boolean sort(SuperArrayIF list, boolean isDesc, int place) {
		// validate
		if (list == null || list.getArray() == null || list.getArray().length == 0) {
			return false;
		}

		int[] targetArray = list.getArray();
		int   len         = targetArray.length;
		int   max         = Arrays.stream(targetArray).max().getAsInt();
		int[] countArray  = new int[(place == -1 ? max + 1 : 10)];
		int[] resultArray = new int[len];

		// sort
		for (int idx = 0; idx < len; idx++) {
			int plusIndex = (place == -1 ? targetArray[idx] : (int)(targetArray[idx] / place) % 10);
			countArray[plusIndex]++;
		}

		for (int idx = 1, countArrayLen = countArray.length; idx < countArrayLen; idx++) {
			countArray[idx] += countArray[idx - 1];
		}

		int idy = len - 1;
		while (idy >= 0) {
			int index = (place == -1 ? targetArray[idy] : (int)(targetArray[idy] / place) % 10);
			resultArray[countArray[index] - 1] = targetArray[idy];
			countArray[index]--;
			idy--;
		}

		// 降順の場合は反転する
		if(isDesc) {
			for (int idx = 0, idz = resultArray.length - 1; idx < idz; idx++, idz--) {
				int temp         = resultArray[idx];
				resultArray[idx] = resultArray[idz];
				resultArray[idz] = temp;
			}
		}

		// ソート内容を反映
		list.duplication(resultArray);
		return true;
	}
}
