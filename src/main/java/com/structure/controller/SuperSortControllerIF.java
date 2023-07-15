package com.structure.controller;

import org.springframework.ui.Model;

/**
 * スーパーコントローラーIF
 * @author nanai
 *
 */
public interface SuperSortControllerIF {

	public static final String TITLE_NAME       = "sortTitle";
	public static final String BEFORE_LIST_NAME = "beforeList";
	public static final String AFTER_LIST_NAME  = "afterList";

	/**
	 * アクションメソッド
	 * @param  model    {@link Model}
	 * @return htmlのURL {@link String}
	 */
	String execute(Model model);

	/**
	 * ソート処理
	 */
	public void sort();

	/**
	 * モデルクラス設定
	 * @param model {@link Model}
	 */
	void setModel(Model model);
}
