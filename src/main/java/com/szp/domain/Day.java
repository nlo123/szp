package com.szp.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.szp.config.JsonDateDeserializer;
import com.szp.config.JsonDateSerializer;

public class Day {
	private Date date;
	private int worked;
	private int planned;
	private boolean present;
	private boolean reported;
	
	
	public Day() {};
	public Day(@JsonDeserialize(using=JsonDateDeserializer.class) Date date, int worked, int planned, boolean present, boolean reported) {
		this.date = date;
		this.worked = worked;
		this.planned = planned;
		this.present = present;
		this.reported = reported;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}


	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getWorked() {
		return worked;
	}
	
	public void setWorked(int worked) {
		this.worked = worked;
	}
	
	public int getPlanned() {
		return planned;
	}
	
	public void setPlanned(int planned) {
		this.planned = planned;
	}
	
	public boolean isPresent() {
		return present;
	}
	
	public void setPresent(boolean present) {
		this.present = present;
	}
	
	public boolean isReported() {
		return reported;
	}
	
	public void setReported(boolean reported) {
		this.reported = reported;
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}