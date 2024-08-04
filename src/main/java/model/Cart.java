package model;

import java.util.List;

public class Cart {
	/**
	 * ユーザーID 
	 */
	private String userId;

	/**
	 * カート内の商品リスト
	 */
	private List<Product> listProd;

	/**
	 * @param userId
	 * @param listProd
	 */
	public Cart(String userId, List<Product> listProd) {
		this.userId = userId;
		this.listProd = listProd;
	}

	/**
	 * @retirn userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return listItem
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

	/**
	 * カート内の商品の合計金額を取得する
	 * @return 合計金額
	 */
	public int getTotalPrice() {
		int total = 0;
		for (Product prod : listProd) {
			total += prod.getPrice();
		}
		return total;
	}

	/**
	 * カート内の商品の合計金額を文字列にして返す
	 */
	public String getTotalPriceString() {
		return String.format("%,d", getTotalPrice()) + "円";
	}
}
