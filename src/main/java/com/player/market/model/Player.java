package com.player.market.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAYER")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_Sequence")
	@SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "START_DATE")
	private Date startDate;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "teamId", referencedColumnName = "id") private Team team;
	 */

	public double getTransferFee() {
		return (getPlayerExperience() * 100000) / getPlayerAge();
	}

	private long getPlayerExperience() {
		return ChronoUnit.MONTHS.between(YearMonth.from(this.startDate.toLocalDate()), YearMonth.from(LocalDate.now()));
	}

	private long getPlayerAge() {
		return ChronoUnit.YEARS.between(YearMonth.from(this.dob.toLocalDate()), YearMonth.from(LocalDate.now()));
	}

}
