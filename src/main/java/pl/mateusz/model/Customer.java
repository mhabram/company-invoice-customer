package pl.mateusz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Pole wymagane")
    @Column(name = "pesel_id")
    private Long peselId;

    @NotNull(message = "Pole wymagane")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Pole wymagane")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Pole wymagane")
    @Column(name = "full_address")
    private String fullAdderss;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Invoice> invoices;

    public Customer() {
    }

    public Customer(long peselId, String name, String lastName, String fullAdderss, List<Invoice> invoices) {
        this.peselId = peselId;
        this.name = name;
        this.lastName = lastName;
        this.fullAdderss = fullAdderss;
        this.invoices = invoices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPeselId() {
        return peselId;
    }

    public void setPeselId(Long peselId) {
        this.peselId = peselId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "Customer{" +
                "id=" + id +
                ", peselId=" + peselId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullAdderss='" + fullAdderss + '\'' +
                '}';
    }
}
