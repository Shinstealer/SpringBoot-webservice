package com.shinstealer.blog.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class DeliveryDay {

	@Id
	@GeneratedValue
	private Long id;

	private LocalDate date;

	private boolean isHoliday;

	@Builder
	public DeliveryDay(LocalDate date, Boolean isHoliday) {
		this.date = date;
		this.isHoliday = isWeeckend(date) || isHoliday;
	}

	private boolean isWeeckend(LocalDate date) {

		return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	public boolean isBusinessDay() {
		return !isHoliday;
	}

	public boolean isAfter(LocalDate compare) {
		return this.date.isAfter(compare);
	}
}
