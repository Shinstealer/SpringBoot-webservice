package com.shinstealer.blog.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class DeliverDayCalender {

	private static final int CYCLE_DAY = 3;

	private final List<DeliveryDay> candidates;

	public DeliverDayCalender(List<DeliveryDay> candidates) {
		this.candidates = candidates;
	}

	public DeliveryDay getExpectedDeliveryDate(LocalDate orderDate) {

		List<DeliveryDay> businessDay = candidates.stream().filter(d -> d.isAfter(orderDate))
				.filter(DeliveryDay::isBusinessDay).collect(Collectors.toList());
		return businessDay.get(CYCLE_DAY - 1);

	}

}
