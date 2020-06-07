package alekseybykov.portfolio.jasperreports.fixtures;

import alekseybykov.portfolio.jasperreports.helpers.CustomDateHelper;
import alekseybykov.portfolio.jasperreports.model.ExchangeRateBean;
import alekseybykov.portfolio.jasperreports.model.ExchangeRateBeanBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Aleksey Bykov
 * @since 07.06.2020
 */
public class ExchangeRateFixture {
	public static List<ExchangeRateBean> getFixture() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = simpleDateFormat.parse("01.05.2020");
		List<ExchangeRateBean> beans = new ArrayList<>();
		final int recordsNumber = 28;
		final int baseCurrency = 1;
		for (int i = 1; i <= recordsNumber; i ++) {
			beans.add(new ExchangeRateBeanBuilder()
					.setDate(date)
					.setUsd(baseCurrency)
					.setEur(new BigDecimal(BigInteger.valueOf(new Random().nextInt(10000)), 4))
					.setGbp(new BigDecimal(BigInteger.valueOf(new Random().nextInt(10000)), 4))
					.build());
			date = CustomDateHelper.plusDay(date);
		}
		return beans;
	}
}
