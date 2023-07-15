package com.structure.controller.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.structure.common.CommonFunctions;
import com.structure.sort.InsertionSort;

/**
 * 挿入ソートコントローラー
 * <br>
 * extends {@link NormalController}
 * @author nanai
 */
@Controller
@RequestMapping("/sort")
public class InsertionSortController extends NormalController {

	/** ソート名 */
	private final static String SORT_NAME = "Insertion Sort";

	@Autowired
	CommonFunctions cmnFunc;
	@Autowired
	InsertionSort   insertionSort;

	/**
	 * アクションメソッド
	 * @param  model    {@link Model}
	 * @return htmlのURL {@link String}
	 */
	@GetMapping("/insertionSort")
	@Override
	public String execute(Model model) {
		return super.execute(model);
	}

	/**
	 * ソート処理
	 */
	@Override
	public void sort() {
		super.sort();
		insertionSort.sort(sortModel.getSortedList(), false);

		System.out.println("[" + SORT_NAME + "]");
		this.sortModel.println();
	}

	/**
	 * モデルクラス設定
	 * @param model {@link Model}
	 */
	@Override
	public void setModel(Model model) {
		model.addAttribute(TITLE_NAME, SORT_NAME);
		super.setModel(model);
	}
}
