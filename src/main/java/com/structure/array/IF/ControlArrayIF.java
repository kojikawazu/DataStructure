package com.structure.array.IF;

/**
 * 制御配列IF
 * @author nanai
 *
 */
public interface ControlArrayIF {

	/**
	 * 生成
	 * @param 配列の長さ
	 */
	void create(int length);

	/**
	 * 長さ取得
	 * @return length
	 */
	int length();

	/**
	 * 出力
	 */
	void println();

	/**
	 * 複製
	 * @param list int[]
	 */
	void duplication(int[] list);

	/**
	 * 反転
	 */
	void reverse();
}
