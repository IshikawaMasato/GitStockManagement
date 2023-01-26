package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.StockManagement;

public class StockManagementDao {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}
	public static int registerStockProduct(StockManagement product) {
		String sql = "INSERT INTO Stock VALUES(default, ?, ?, ?, ?, ?, current_timestamp)";
		int result = 0;

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, product.getStockId());
			pstmt.setString(2, product.getStockName());
			pstmt.setString(3, product.getStockCategory());
			pstmt.setInt(4, product.getStockPrice());
			pstmt.setString(5, product.getStockNote());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件登録しました。");
		}
		return result;
	}
	public static void deletestockManagement(String StockId) {
		String sql = "DELETE FROM Stock WHERE StockId = ?";
		int result = 0;

		try (
				Connection con =getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){

			pstmt.setString(1, StockId);

			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
		} finally {
			System.out.println(result + "件削除しました。");
		}
	}
	public static List<StockManagement> SelectAllList(){

		// 実行するSQL
		String sql = "SELECT * FROM Stock";

		// 返却用のListインスタンス
		List<StockManagement> result = new ArrayList<>();

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){

				while(rs.next()) {
					int id = rs.getInt("id");
					String StockId = rs.getString("StockId");
					String StockName = rs.getString("StockName");
					String StockCategory = rs.getString("StockCategory");
					int StockPrice=rs.getInt("StockPrice");
					String StockNote = rs.getString("StockNote");
					String created_at = rs.getString("created_at");

					StockManagement product = new StockManagement(id, StockId, StockName, StockCategory, StockPrice, StockNote, created_at);
					result.add(product);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	public static StockManagement searchProductById(String keyword){

		// 実行するSQL
		String sql = "SELECT * FROM ECsiteProduct WHERE productId LIKE ?";

		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){

			// %や_はここで文字列結合する。そうすると'%keyword%'となる。
			pstmt.setString(1, keyword);

			// SQL実行！
			// ResultSetもcloseする必要があるのでtry-with-resources文を使う
			try (ResultSet rs = pstmt.executeQuery()){

				// next()がfalseを返すまでループ
				while(rs.next()) {

					// n行目のデータを取得
					int id = rs.getInt("id");
					String productId = rs.getString("productId");
					String productName = rs.getString("productName");
					String productCategory = rs.getString("productCategory");
					int productPrice=rs.getInt("productPrice");
					String productNote = rs.getString("productNote");
					String created_at = rs.getString("created_at");

					StockManagement product = new StockManagement(id, productId, productName, productCategory, productPrice, productNote, created_at);
					return product;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// Listを返却する。0件の場合は空のListが返却される。
		return null;
	}
	public static int updateECsiteProduct(StockManagement product,String Id) {
		String sql = "UPDATE ECsiteProduct SET (productId,productName,productCategory,productPrice,productNote) = (?,?,?,?,?) where productid = ?;";
		int result = 0;

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, product.getStockId());
			pstmt.setString(2, product.getStockName());
			pstmt.setString(3, product.getStockCategory());
			pstmt.setInt(4, product.getStockPrice());
			pstmt.setString(5, product.getStockNote());
			
			pstmt.setString(6, Id);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
}
