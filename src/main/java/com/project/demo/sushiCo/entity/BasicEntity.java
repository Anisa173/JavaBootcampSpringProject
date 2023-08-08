package com.project.demo.sushiCo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BasicEntity<K extends Serializable> {
	public abstract K getId();

	@CreatedBy
	@Column(columnDefinition = "bigint default 1", updatable = false)
	protected Long createdBy;

	@CreatedDate
	@Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'", updatable = false)
	protected LocalDateTime createdDate;

	@LastModifiedBy
	@Column(columnDefinition = "bigint default 1")
	protected Long lastModifiedBy;

	@LastModifiedDate
	@Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'")
	protected LocalDateTime lastModifiedDate;
	private boolean deleted;

	public BasicEntity() {

	}

	public BasicEntity(Long createdBy, LocalDateTime createdDate, Long lastModifiedBy, LocalDateTime lastModifiedDate,
			boolean deleted) {
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
		this.setDeleted(deleted);
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String toString() {
		return "BasicEntity[createdBy = " + createdBy + ",createdDate = " + createdDate + ",lastModifiedBy = "
				+ lastModifiedBy + ",lastModifiedDate = " + lastModifiedDate + ",deleted = " + deleted + "]";
	}

}
