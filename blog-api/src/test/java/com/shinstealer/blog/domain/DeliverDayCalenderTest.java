package com.shinstealer.blog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliverDayCalenderTest {


	@Test
	public void delieveryLoalDateOf() {

		LocalDate date = LocalDate.of(2019,5,7);

		List<DeliveryDay> days = Arrays.asList(new DeliveryDay(date.plusDays(1), false),
				new DeliveryDay(date.plusDays(2), false), new DeliveryDay(date.plusDays(3), false));

		DeliverDayCalender calendar = new DeliverDayCalender(days);

		// when
		DeliveryDay expectedArriveDate = calendar.getExpectedDeliveryDate(date);

		// then
		assertThat(expectedArriveDate.getDate()).isEqualTo(date.plusDays(3));
	}
}
