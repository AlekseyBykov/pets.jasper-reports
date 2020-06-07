package alekseybykov.portfolio.jasperreports.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Aleksey Bykov
 * @since 06.06.2020
 */
public class ExchangeRateBeanBuilder implements Builder {

	private ExchangeRateBean bean = new ExchangeRateBean();

	@Override
	public Builder setDate(Date date) {
		bean.setDate(date);
		return this;
	}

	@Override
	public Builder setUsd(Integer usd) {
		bean.setUsd(usd);
		return this;
	}

	@Override
	public Builder setEur(BigDecimal eur) {
		bean.setEur(eur);
		return this;
	}

	@Override
	public Builder setGbp(BigDecimal gbp) {
		bean.setGbp(gbp);
		return this;
	}

	@Override
	public ExchangeRateBean build() {
		return bean;
	}
}
