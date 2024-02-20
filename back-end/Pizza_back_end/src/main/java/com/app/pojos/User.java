package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

	@Column(length = 50,nullable = false)
	private String name;
	
//	@Column(columnDefinition = "default='Customer'")
	
	private String Role;
	
	@Column(length = 12)
	private String mobileNo;
	
	@Column(length = 50,nullable = false)
	private String email;
	
	@Column(length = 10,nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user",orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Payment> payment=new ArrayList<>();
	
	@OneToMany(mappedBy = "user",orphanRemoval = true,cascade = CascadeType.ALL)
	private List<Order> order=new ArrayList<>();
	
	
	public User() {
		// TODO Auto-generated constructor stub
		this.Role="Customer";
	}
	
	
	
//	Helper methods
	
	public void addPayment(Payment payment) {
		this.payment.add(payment);
		payment.setUser(this);
	}
	
	public void removePayment(Payment payment) {
		this.payment.remove(payment);
		payment.setUser(null);
	}
	
	public void addOrder(Order order) {
		this.order.add(order);
		order.setUser(this);
	}
	
	public void removeOrder(Order order) {
		this.order.remove(order);
		order.setUser(null);
	}
	
//	Overrided methods
	
	@Override
	public String toString() {
		return "Users [name=" + name + ", mobileNo=" + mobileNo + ", Role=" + Role + ", email=" + email + "]";
	}
}
