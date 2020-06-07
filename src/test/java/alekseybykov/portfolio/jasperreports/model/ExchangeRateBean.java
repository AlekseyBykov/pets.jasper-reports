package alekseybykov.portfolio.jasperreports.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author Aleksey Bykov
 * @since 06.06.2020
 */
public class ExchangeRateBean {
	private Date date;
	private Integer usd;
	private BigDecimal eur;
	private BigDecimal gbp;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getUsd() {
		return usd;
	}

	public void setUsd(Integer usd) {
		this.usd = usd;
	}

	public BigDecimal getEur() {
		return eur;
	}

	public void setEur(BigDecimal eur) {
		this.eur = eur;
	}

	public BigDecimal getGbp() {
		return gbp;
	}

	public void setGbp(BigDecimal gbp) {
		this.gbp = gbp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExchangeRateBean that = (ExchangeRateBean) o;
		return date.equals(that.date) &&
		       usd.equals(that.usd) &&
		       eur.equals(that.eur) &&
		       gbp.equals(that.gbp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, usd, eur, gbp);
	}
}
