package com.project.demo.sushiCo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shedlock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	@Column(name = "lock_until")
	private LocalDateTime lock_until;
	@Column(name = "lock_at")
	private LocalDateTime locked_at;
	@Column(name = "locked_by")
	private String locked_by;

	public LocalDateTime getLock_until() {
		return lock_until;
	}

	public void setLock_until(LocalDateTime lock_until) {
		this.lock_until = lock_until;
	}

	public LocalDateTime getLocked_at() {
		return locked_at;
	}

	public void setLocked_at(LocalDateTime locked_at) {
		this.locked_at = locked_at;
	}

	public String getLocked_by() {
		return locked_by;
	}

	public void setLocked_by(String locked_by) {
		this.locked_by = locked_by;
	}

	public String toString() {
		return "Shedlock[name = " + name + ",lock_until = " + lock_until + ",locked_at = " + locked_at + ",locked_by = "
				+ locked_by + "]";
	}
}
