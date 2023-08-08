package com.project.demo.sushiCo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


	@Entity
	public class AddInBasket extends BasicEntity<Integer>{
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "custId", referencedColumnName = "id")
		private User user;

		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "IDdish", referencedColumnName = "dId")
		private Dish dish;


		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer addId;
		@Column(name = "addId")
		private Integer addItemsDish;
//private Double valueAmount;

		
		public AddInBasket() {
			super();
		}

		public AddInBasket(Integer addItemsDish, User user, Dish dish) {
			super();
			this.addItemsDish = addItemsDish;
			this.user = user;
			this.dish = dish;
			
		}

		@Override
		public Integer getId() {
			return addId;
		}

		public void setAddId(Integer id) {
			this.addId = id;
		}

		public Integer getAddItemsDish() {
			return addItemsDish;
		}

		public void setAddItemsDish(Integer addItemsDish) {
			this.addItemsDish = addItemsDish;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Dish getDish() {
			return dish;
		}

		public void setDish(Dish dish) {
			this.dish = dish;
		}

		public String toString() {
			return "AddInBasket[addId = " + addId + ", addItemDish = " + addItemsDish + ",user = " + user + ",dish = "
					+ dish + "]";
		}
	}
