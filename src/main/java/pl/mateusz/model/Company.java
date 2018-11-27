package pl.mateusz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Pole wymagane")
    @Column(name = "vat_id")
    private Long vatID;

    @NotNull(message = "Pole Wymagane")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Pole wymagane")
    @Column(name = "account_number")
    private String accountNumber;

    @NotNull(message = "Pole Wymagane" )
    @Column(name = "full_address")
    private String fullAdderss;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Invoice> invoices;

    public Company() {
    }

    public Company(long vatID, String name, String accountNumber, String fullAdderss, List<Invoice> invoices) {
        this.vatID = vatID;
        this.name = name;
        this.accountNumber = accountNumber;
        this.fullAdderss = fullAdderss;
        this.invoices = invoices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVatID() {
        return vatID;
    }

    public void setVatID(Long vatID) {
        this.vatID = vatID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFullAdderss() {
        return fullAdderss;
    }

    public void setFullAdderss(String fullAdderss) {
        this.fullAdderss = fullAdderss;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", vatID=" + vatID +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", fullAdderss='" + fullAdderss + '\'' +
                '}';
    }
}
