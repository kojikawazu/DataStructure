package com.structure.model;

import java.util.Arrays;
import java.util.Random;

import com.structure.array.NormalArray;
import com.structure.array.SuperArrayIF;

/**
 * ノーマルリストモデルクラス
 * @author nanai
 *
 */
public class NormalListModel implements SuperListModelIF {

	/**
	 * Field
	 */
	private SuperArrayIF list;
	private SuperArrayIF sortedList;

	/**
	 * コンストラクタ
	 */
	public NormalListModel() {
		this.list       = new NormalArray();
		this.sortedList = new NormalArray();

		// ランダムリストの作成
		this.makeListRandom(100, 10);
	}

	/**
	 * リストのgetter
	 * @return {@link SuperArrayIF}
	 */
	@Override
	public SuperArrayIF getList() {
		return this.list;
	}

	/**
	 * ソート用リストのgetter
	 * @return {@link SuperArrayIF}
	 */
	@Override
	public SuperArrayIF getSortedList() {
		return this.sortedList;
	}

	/**
	 * コンソール出力
	 */
	@Override
	public void println() {
		this.list.println();
		this.sortedList.println();
	}

	/**
	 * ランダムリストの作成
	 * @param randomNum ランダム最大値
	 * @param length    配列の長さ
	 */
	@Override
	public void makeListRandom(int randomNum, int length) {
		if (length <= 0 || randomNum <= 0)	return;

		// リストの初期化
		this.list.create(length);

		// ランダム値設定
		Random random = new Random();
		int[]  randomList = this.list.getArray();
		for (int idx = 0, len=this.list.length(); idx < len; idx++) {
			randomList[idx] = random.nextInt(randomNum);
		}

		// ソート用リストに複製
		this.duplication();
	}

	/**
	 * ソート用リストに複製
	 */
	@Override
	public void duplication() {
		// ソート用リストに複製
		this.sortedList.duplication(this.list.getArray());
	}
}
