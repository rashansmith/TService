
/**
 * 
 * @author rashansmith
 * This class provides a definition and 
 * implementation of the various levels
 *
 */
public class Level {
	int Name;
	int Price;
	int Rows;
	int Seats_In_Row;
	int TotalSeats;
	
	
	public Level(int some_Name, int some_Price, int some_Rows, int some_Seats_In_Row) {
		this.Name = some_Name;
		this.Price = some_Price;
		this.Rows = some_Rows;
		this.Seats_In_Row = some_Seats_In_Row;
		this.TotalSeats = this.Rows * this.Seats_In_Row;
	}
	
	public int getName() {
		return this.Name;
	}
	
	public int getPrice() {
		return this.Price;
	}
	
	public int getRows() {
		return this.Rows;
	}
	
	public int getSeatsInRows() {
		return this.Seats_In_Row;
	}
	
	public void setName(int someName) {
		this.Name = someName;
	}
	
	public void setPrice(int somePrice) {
		this.Price = somePrice;
	}
	
	public void setRows(int someRows) {
		this.Rows = someRows;
	}
	
	public void setSeatsInRows(int someSeatsInRows) {
		this.Seats_In_Row = someSeatsInRows;
	} 
	public int getTotalSeats() {
		return this.TotalSeats;
	}
	
	public void setTotalSeats(int seatsRemoved) {
		this.TotalSeats = this.getTotalSeats() - seatsRemoved;
	}
}
	
	
