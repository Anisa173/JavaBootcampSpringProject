package com.project.demo.sushiCo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Restorant_tables extends BasicEntity<Integer> {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservationId", referencedColumnName = "cR_id")
	@JsonManagedReference
	private CustomerReservation reservation;

	@OneToOne(mappedBy = "restorant_tables", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private AppRestorant aRest;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rtb_id;
	@Column(name = "tb_id")
	private Integer tb_id;
	@Column(name = "tableName")
	private String tableName;
	@Column(name = "noChairTable")
	private Integer noChairTable;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private boolean status;
	@Column(name = "locked")
	private static boolean locked = true;
	@Column(name = "unlocked")
	private static boolean unlocked = false;

	public Restorant_tables() {
		super();
	}

	public Restorant_tables(Integer tb_id, String tableName, Integer noChairTable, String description, boolean status,
			boolean locked, boolean unlocked, CustomerReservation reservation, AppRestorant aRest) {
		super();
		this.tb_id = tb_id;
		this.tableName = tableName;
		this.noChairTable = noChairTable;
		this.status = status;
		this.description = description;
		Restorant_tables.locked = locked;
		Restorant_tables.unlocked = unlocked;
		this.reservation = reservation;
		this.aRest = aRest;
	}

	@Override
	public Integer getId() {
		return rtb_id;
	}

	public void setRtb_id(Integer rtb_id) {
		this.rtb_id = rtb_id;
	}

	public Integer getTb_id() {
		return tb_id;
	}

	public void setTb_id(Integer tb_id) {
		this.tb_id = tb_id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getNoChairTable() {
		return noChairTable;
	}

	public void setNoChairTable(Integer noChairTable) {
		this.noChairTable = noChairTable;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static boolean isLocked() {
		return locked;
	}

	public static void setLocked(boolean locked) {
		Restorant_tables.locked = locked;
	}

	public static boolean isUnlocked() {
		return unlocked;
	}

	public static void setUnlocked(boolean unlocked) {
		Restorant_tables.unlocked = unlocked;
	}

	public CustomerReservation getReservation() {
		return reservation;
	}

	public void setReservation(CustomerReservation reservation) {
		this.reservation = reservation;
	}

	public AppRestorant getARest() {
		return aRest;
	}

	public void setReservation(AppRestorant aRest) {
		this.aRest = aRest;
	}

	public String toString() {
		return "Restorant_tables[tb_id = " + tb_id + ",tableName = " + tableName + ",noChairTable = " + noChairTable
				+ ",status = " + status + ",description = " + description + ",locked = " + locked + ",unlocked = "
				+ unlocked + ",reservation = " + reservation + ",aRest = " + aRest + "]";
	}


}



