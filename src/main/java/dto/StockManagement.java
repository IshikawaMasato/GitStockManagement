package dto;

public class StockManagement {
	int id;
	String StockId;
	String StockName;
	String StockCategory;
	int StockPrice;
	String StockNote;
	String created_at;
	public StockManagement(int id, String stockId, String stockName, String stockCategory, int stockPrice,
			String stockNote, String created_at) {
		super();
		this.id = id;
		StockId = stockId;
		StockName = stockName;
		StockCategory = stockCategory;
		StockPrice = stockPrice;
		StockNote = stockNote;
		this.created_at = created_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockId() {
		return StockId;
	}
	public void setStockId(String stockId) {
		StockId = stockId;
	}
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
	public String getStockCategory() {
		return StockCategory;
	}
	public void setStockCategory(String stockCategory) {
		StockCategory = stockCategory;
	}
	public int getStockPrice() {
		return StockPrice;
	}
	public void setStockPrice(int stockPrice) {
		StockPrice = stockPrice;
	}
	public String getStockNote() {
		return StockNote;
	}
	public void setStockNote(String stockNote) {
		StockNote = stockNote;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
}
