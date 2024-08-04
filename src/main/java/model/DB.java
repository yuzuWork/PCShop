package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	Connection connection;
	Statement statement;

	public DB(String dbName) {
		//String url = "jdbc:postgresql://dpg-cqm9ma1u0jms73fo9jk0-a.singapore-postgres.render.com:5432/mydb_mb29";
		String url = "jdbc:postgresql://dpg-cqm9ma1u0jms73fo9jk0-a:5432/mydb_mb29";
		String user = "mydb_mb29_user";
		String password = "kF71i5sudVRIC3UiGkHqPbvRVAhfGUgT";
		try {
			connection = DriverManager.getConnection(url, user, password);
			// ステートメントの作成
			statement = connection.createStatement();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getPassWord(String userID) {
		String sql = "SELECT * FROM user WHERE ID = '" + userID + "';";
		String passWord = "";
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				passWord = resultSet.getString("PW");
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return passWord;
	}

	public ArrayList<Product> getProductList() {
		String sql = "SELECT * FROM productlist WHERE STOCK > 0;";
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString("ID");
				String name = resultSet.getString("NAME");
				int price = resultSet.getInt("PRICE");
				productList.add(new Product(id, name, price));
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return productList;
	}

	public void Close() {
		try {
			if (connection != null)
				connection.close();
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
