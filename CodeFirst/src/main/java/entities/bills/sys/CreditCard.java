package entities.bills.sys;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CreditCard extends BillingDetail {
    private String cardType;
    private int expirationMonth;
    private int expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type", nullable = false)
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        if (expirationMonth > 0 && expirationMonth < 13) {
            this.expirationMonth = expirationMonth;
        }
    }

    @Column(name = "expiration_year")
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
