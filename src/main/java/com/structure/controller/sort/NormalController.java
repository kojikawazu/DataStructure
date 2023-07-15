package com.structure.controller.sort;

import org.springframework.ui.Model;

import com.structure.controller.SuperSortControllerIF;
import com.structure.model.NormalListModel;
import com.structure.model.SuperListModelIF;

/**
 * ノーマルモデルクラス
 * <br>
 * implements {@link SuperSortControllerIF}
 * @author nanai
 *
 */
public class NormalController implements SuperSortControllerIF {

	/** リストモデル */
	protected SuperListModelIF  sortModel = null;

	/**
	 * アクションメソッド
	 * @param  model    {@link Model}
	 * @return htmlのURL {@link String}
	 */
	@Override
	public String execute(Model model) {
		this.sort();
		this.setModel(model);
		return "index";
	}

	/**
	 * ソート処理
	 */
	@Override
	public void sort() {
		this.sortModel = new NormalListModel();
	}

	/**
	 * モデルクラス設定
	 * @param model {@link Model}
	 */
	@Override
	public void setModel(Model model) {
		model.addAttribute(BEFORE_LIST_NAME, sortModel.getList().getArray());
		model.addAttribute(AFTER_LIST_NAME,  sortModel.getSortedList().getArray());
	}
}
