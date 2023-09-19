package ecommerce.src.main.java.ecommerce;

public class Adress {
    private AdressType adressType;
    private String street; // max 255 ch
    private Integer number;
    private String district; // max 50 ch
    private Integer cep;

    public enum AdressType {
        AVENIDA, PRACA, RUA, OUTRO
    }

    public AdressType getAdressType() {
        return adressType;
    }

    public void setAdressType(AdressType adressType) {
        this.adressType = adressType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws Exception {
        if (street.length() > 255) {
            throw new Exception("Maximo de 255 caracteres no logradouro");
        }
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) throws Exception {
        if (street.length() > 50) {
            throw new Exception("Maximo de 255 caracteres no district");
        }
        this.district = district;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Adress(AdressType adressType, String street, Integer number, String district, Integer cep)
            throws Exception {
        setAdressType(adressType);
        setStreet(street);
        setNumber(number);
        setDistrict(district);
        setCep(cep);
    }

    @Override
    public String toString() {
        return street + ", " + number + ", " + district + ", " + cep;
    }
}
