package ecommerce.src.main.java.ecommerce;

public class Telephone {
    private Byte ddd;
    private Integer number;

    @Override
    public String toString() {
        String numberStr = Integer.toString(number);
        if (numberStr.length() == 9) {
            String aux = "(" + ddd + ") " + String.format("%,d", number);
            return aux.replace(",", "-");
        }
        return "(" + ddd + ") " + numberStr.substring(0, 4) + "-" + numberStr.substring(4);
    }

    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Telephone(Byte ddd, Integer number) {
        setDdd(ddd);
        setNumber(number);
    }
}
