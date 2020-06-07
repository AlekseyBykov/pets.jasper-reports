package alekseybykov.portfolio.jasperreports.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Aleksey Bykov
 * @since 06.06.2020
 */
public interface Builder {

	Builder setDate(Date date);

	Builder setUsd(Integer usd);

	Builder setEur(BigDecimal eur);

	Builder setGbp(BigDecimal gbp);

	ExchangeRateBean build();
}
