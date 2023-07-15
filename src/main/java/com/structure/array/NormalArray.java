package com.structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ノーマル配列クラス
 * @author nanai
 *
 */
public class NormalArray implements SuperArrayIF {

	/**
	 * Field
	 */
	private int[] list;

	/**
	 * コンストラクタ
	 */
	public NormalArray() {
		this.list = null;
	}

	/**
	 * コンストラクタ
	 */
	public NormalArray(int[] list) {
		this();
		this.setArray(list);
	}

	/**
	 * コンストラクタ
	 */
	public NormalArray(List<Integer> list) {
		this();
		this.setArray(list);
	}

	/**
	 * setter
	 * @param list int[]
	 */
	public void setArray(int[] list) {
		if (list == null)	return;
		this.list = list;
	}

	/**
	 * setter
	 * @param list {@link Integer}[]
	 */
	@Override
	public void setArray(Integer[] list) {
		if (list == null)	return;
		// Integer[] -> int[]
		this.list = Arrays.stream(list).mapToInt(Integer::intValue).toArray();
	}

	/**
	 * setter
	 * @param list {@link List}<{@link Integer}>
	 */
	@Override
	public void setArray(List<Integer> list) {
		if (list == null)	return;
		// List<Integer> -> Integer[]
		Integer[] tempIntegerArray = list.toArray(new Integer[list.size()]);
		// Integer[] -> int[]
		this.setArray(tempIntegerArray);
	}

	/**
	 * getter
	 * @return int[]
	 */
	public int[] getArray() {
		return this.list;
	}

	/**
	 * 変換 int[] -> List
	 * @return {@link List}<{@link Integer}>
	 */
	@Override
	public List<Integer> asList() {
		if (this.list == null) return new ArrayList<>();

		// int[] -> Integer[]
		Integer[] tempIntegerArray = Arrays.stream(this.list).boxed().toArray(Integer[]::new);
		// Integer[] -> List<Integer>
		return Arrays.asList(tempIntegerArray);
	}

	/**
	 * 生成
	 * @param 配列の長さ
	 */
	@Override
	public void create(int length) {
		if (length <= 0) return;
		this.list = new int[length];
	}

	/**
	 * 長さ取得
	 * @return length
	 */
	@Override
	public int length() {
		return (this.list == null ? 0 : this.list.length);
	}

	/**
	 * 出力
	 */
	@Override
	public void println() {
		System.out.println("list: " + Arrays.toString(this.list));
	}

	/**
	 * 複製
	 * @param list int[]
	 */
	@Override
	public void duplication(int[] list) {
		if (list == null || list.length <= 0) return;
		this.list = Arrays.copyOf(list, list.length);
	}

	/**
	 * 反転
	 */
	@Override
	public void reverse() {
		if (list == null || list.length <= 0) return;
		for (int idx = 0, idy = list.length - 1; idx < idy; idx++, idy--) {
			int temp  = list[idx];
			list[idx] = list[idy];
			list[idy] = temp;
		}
	}
}
