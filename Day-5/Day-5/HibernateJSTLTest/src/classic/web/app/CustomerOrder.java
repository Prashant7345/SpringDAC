package classic.web.app;

import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class CustomerOrder {

	@Id
	private int ord_no;
	
	private String cust_id;
	
	@Column(name="pno")
	private int productNo;
	@Column(name="qty")
	private int quantity;
	
	@Column(name="ord_date")
	private Date orderDate;

	public int getOrd_no() {
		return ord_no;
	}

	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/*CustomerOrder(ResultSet rs) throws SQLException {
		productNo = rs.getInt("pno");
		quantity = rs.getInt("qty");
		orderDate = rs.getDate("ord_date");
	}*/

	
	
}

