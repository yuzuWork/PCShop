package model;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

/**
 * 店内オペレーションクラス
 * @author Owner
 *
 */
public class Operation {

	public boolean loginProc(String userId, String password, HttpSession session) {
		boolean result = authenticate(userId, password);

		if (result) {
			Store store = makeStore();
			session.setAttribute("store", store);
			Cart cart = new Cart(userId, new ArrayList<Product>());
			session.setAttribute("cart", cart);
		}

		return result;
	}

	/**
	 * 認証する
	 * @param userId
	 * @param password
	 * @return 結果　(true/false)
	 */
	private boolean authenticate(String userId, String password) {
		DB db = new DB("mydb");
		String getPass = db.getPassWord(userId);
		db.Close();
		boolean result = password.equals(getPass);
		return result;
	}

	/**
	 * 店舗情報
	 * @return 店舗情報
	 */
	private Store makeStore() {
		DB db = new DB("mydb");
		//店舗情報作成
		Store store = new Store("PC販売", db.getProductList());
		db.Close();
		return store;
	}

	/**
	 * 商品追加処理
	 * @pram idx
	 * @pram session
	 */
	public void addProd(int idx, HttpSession session) {
		Store store = (Store) session.getAttribute("store");
		Cart cart = (Cart) session.getAttribute("cart");
		if (store != null && cart != null) {
			cart.add(store.getListProd().get(idx));
			session.setAttribute("cart", cart);
		}
	}

	/**
	 * カートから商品を削除
	 * @param idx
	 * @param session
	 */
	public void removeProd(int idx, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			cart.remove(idx);
			session.setAttribute("cart", cart);
		}
	}

	/**
	 * 精算処理
	 * @param session
	 */
	public void pay(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			session.setAttribute("pay", cart);
			Cart newCart = new Cart(cart.getUserId(), new ArrayList<Product>());
			session.setAttribute("cart", newCart);
		}
	}

	/**
	 * ログアウト時の処理
	 * @param session
	 */
	public void logOutProc(HttpSession session) {
		session.invalidate();
	}
}
