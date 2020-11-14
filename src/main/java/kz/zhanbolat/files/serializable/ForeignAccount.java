package kz.zhanbolat.files.serializable;

import java.util.Objects;

public class ForeignAccount extends Account {
    private String bankName;
    private String country;

    public ForeignAccount(Long id, String name, Balance balance, String bankName, String country) {
        super(id, name, balance);
        this.bankName = bankName;
        this.country = country;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ForeignAccount that = (ForeignAccount) o;
        return Objects.equals(bankName, that.bankName) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bankName, country);
    }

    @Override
    public String toString() {
        return "ForeignAccount{" +
                "bankName='" + bankName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
