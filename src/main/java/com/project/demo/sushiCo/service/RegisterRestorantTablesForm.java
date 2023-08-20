package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.entity.BasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterRestorantTablesForm extends BasicEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistration;

	@Column(name = "tableName")
	private String tableName;
	@Column(name = "noTables")
	private Integer noTables;
	@Column(name = "tableDescription")
	private String tableDescription;
	@Column(name = "noChairsT")
	private Integer noChairsT;
	private Integer rtb_id;
	private Integer adminRId;
	private Integer tb_id;

	@Override
	public Integer getId() {
		return idRegistration;
	}

	public void setIdRegistration(Integer idR) {
		this.setIdRegistration(idR);
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getNoTables() {
		return noTables;
	}

	public void setNoTables(Integer noTables) {
		this.noTables = noTables;
	}

	public String getTableDescription() {
		return tableDescription;
	}

	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}

	public Integer getNoChairsT() {
		return noChairsT;
	}

	public void setNoChairsT(Integer noChairsT) {
		this.noChairsT = noChairsT;
	}

	public Integer getAdminRId() {
		return adminRId;
	}

	public void setAdminRId(Integer id) {
		this.adminRId = id;
	}

	public Integer getTb_id() {
		return tb_id;
	}

	public void setTb_id(Integer tb_id) {
		this.tb_id = tb_id;
	}

	public Integer getRtb_id() {
		return rtb_id;
	}

	public void setRtb_id(Integer rtb_id) {
		this.rtb_id = rtb_id;
	}

	public String toString() {
		return "RegisterRestorantTablesForm[idRegistration = " + idRegistration + ",tableName = " + tableName
				+ ",noTables = " + noTables + ",noChairsT = " + noChairsT + ",tableDescription = " + tableDescription
				+ ",adminRId = " + adminRId + ",tb_id = " + tb_id + ",rtb_id = " + rtb_id + "]";
	}

}
