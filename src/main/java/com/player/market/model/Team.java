package com.player.market.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TEAM")
public class Team implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_Sequence")
	@SequenceGenerator(name = "team_Sequence", sequenceName = "TEAM_SEQ")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name="COMMISSION")
	private float commission;

}
