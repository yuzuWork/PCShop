package model;

import java.util.List;

public class Store {
	/**
	 * 店舗名
	 */
	private String name;

	/**
	 * 商品リスト
	 */
	private List<Product> listProd;

	/**
	 * @param name
	 * @param listProd
	 */
	public Store(String name, List<Product> listProd) {
		this.name = name;
		this.listProd = listProd;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/***
	 * @return listProd
	 */
	public List<Product> getListProd() {
		return listProd;
	}

	/**
	 * 商品を追加する
	 * @param prod
	 */
	public void add(Product prod) {
		listProd.add(prod);
	}

	/**
	 * 特定の商品を除去する
	 * @param index
	 */
	public void remove(int index) {
		listProd.remove(index);
	}

	/**
	 * すべての商品を除去する
	 */
	public void clear() {
		listProd.clear();
	}
}
