package com.structure.model;

import com.structure.array.SuperArrayIF;

/**
 * スーパーリストモデルIF
 * @author nanai
 *
 */
public interface SuperListModelIF {

	/**
	 * リストのgetter
	 * @return {@link SuperArrayIF}
	 */
	public SuperArrayIF getList();
	
	/**
	 * ソート用リストのgetter
	 * @return {@link SuperArrayIF}
	 */
	public SuperArrayIF getSortedList();

	/**
	 * コンソール出力
	 */
	public void println();

	/**
	 * ランダムリストの作成
	 * @param randomNum ランダム最大値
	 * @param length    配列の長さ
	 */
	public void makeListRandom(int randomNum, int length);

	/**
	 * ソート用リストに複製
	 */
	public void duplication();
}
