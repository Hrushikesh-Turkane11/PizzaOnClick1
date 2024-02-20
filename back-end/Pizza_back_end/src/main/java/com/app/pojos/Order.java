package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity{

	
	//how to display date and time differently eg= :date=2023-01-01 time:12:00
	private LocalDate orderDate;
		
	private double orderprice;
	
	@Enumerated(EnumType.STRING)
	private Status orderStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
//	@OneToMany(mappedBy = "order",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER )
//	List<Pizza> pizza=new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;


//	Helper Methods

//	public void addPizza(Pizza pizza) {
//		this.pizza.add(pizza);
//		pizza.setOrder(this);
//	}
//	
//	public void removePizza(Pizza pizza) {
//		this.pizza.remove(pizza);
//		pizza.setOrder(null);
//	}
	
//	Overrided methods	
	
	@Override
	public String toString() {
		return "Order [orderDate=" + orderDate +   ", orderStatus=" + orderStatus
				+ ", orderprice=" + orderprice + "]";
	}
		
}
