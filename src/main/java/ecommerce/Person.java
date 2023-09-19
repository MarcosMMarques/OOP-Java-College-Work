package ecommerce.src.main.java.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Person {
    private String name;
    private LocalDate dateBorn;
    private Byte age;
    private Credential credential;
    private ArrayList<Adress> adresses;
    private ArrayList<Telephone> telephones;
    private ArrayList<Buys> buys;

    public Person() {
        this.adresses = new ArrayList<>();
        this.telephones = new ArrayList<>();
        this.buys = new ArrayList<>();
    }

    public Person(String name, LocalDate dateBorn, Byte age, Credential credential, ArrayList<Adress> adresses,
            ArrayList<Telephone> telephones, ArrayList<Buys> buys) throws Exception {
        setName(name);
        setDateBorn(dateBorn);
        setCredential(credential);
        setAdresses(adresses);
        setTelephones(telephones);
        setBuys(buys);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() > 45) {
            throw new Exception("Maximo de 45 caracteres para nome");
        }
        this.name = name;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(LocalDate dateBorn) {
        this.dateBorn = dateBorn;
        setAge();
    }

    public Byte getAge() {
        return age;
    }

    private void setAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateBorn, today);
        this.age = (byte) period.getYears();
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public ArrayList<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(ArrayList<Adress> adresses) {
        this.adresses = adresses;
    }

    public ArrayList<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(ArrayList<Telephone> telephones) {
        this.telephones = telephones;
    }

    public ArrayList<Buys> getBuys() {
        return buys;
    }

    public void setBuys(ArrayList<Buys> buys) {
        this.buys = buys;
    }

    public void addAdress(Adress adress) {
        this.adresses.add(adress);
    }

    public void addBuys(Buys buys) {
        this.buys.add(buys);
    }

    public void addTelephone(Telephone telephone) {
        this.telephones.add(telephone);
    }

    @Override
    public String toString() {
        String adressesString = "Endereços: [ ";
        for (Adress x : this.adresses) {
            adressesString += x.toString() + "; ";
        }
        adressesString += " ] ";
        String telephonesString = "Telefones: [ ";
        for (Telephone x : this.telephones) {
            telephonesString += x.toString() + "; ";
        }
        telephonesString += " ] ";
        BigDecimal totalValue = new BigDecimal(0.0);
        String buysString = "Compras: [";
        for (Buys x : this.buys) {
            // buysString += x.getInvoice() + ", " + x.totalCalc().toString() + "; ";
            buysString += x.toString() + "; ";
            totalValue = totalValue.add(x.totalCalc());
        }
        buysString += " ] ";

        String formattedDate = this.dateBorn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return (this.name + ", " + formattedDate + ", " + this.age.intValue() + " anos, " + this.credential + ", "
                + adressesString + ", " + telephonesString + ", Gasto total:  " + totalValue.toString() + ", "
                + buysString);
    }

}
