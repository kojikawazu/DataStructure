package com.structure.sort;

import com.structure.array.SuperArrayIF;

/**
 * ソートインターフェースIF
 * @author nanai
 *
 */
public interface SuperSortIF {

	/**
	 * 並び替え
	 * @param list   リスト配列 {@link SuperArrayIF}
	 * @param isDesc true: 降順 false: 昇順
	 * @return true: ソート成功 false: ソート失敗
	 */
	public boolean sort(SuperArrayIF list, boolean isDesc);
}
