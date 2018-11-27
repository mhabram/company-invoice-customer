package pl.mateusz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Pole wymagane")
    @Pattern(regexp = "[0-9]{2}+-+[0-9]{2}+-+[0-9]{4}", message = "Zła data!")
    @Column(name = "issue_date")
    private String issueDate;

    @NotNull(message = "Pole wymagane")
    @Pattern(regexp = "[0-9]{2}+-+[0-9]{2}+-+[0-9]{4}", message = "Zła data!")
    @Column(name = "due_date")
    private String dueDate;

    @NotNull(message = "Pole wymagane")
    @Pattern(regexp = "[0-9]{2}+-+[0-9]{2}+-+[0-9]{4}", message = "Zła data!")
    @Column(name = "end_date")
    private String endDate;

    @NotNull(message = "Pole wymagane")
    @Column(name = "comments")
    private String comments;

    @NotNull(message = "Pole wymagane")
    @Column(name = "subject")
    private String subject;

    @NotNull(message = "Pole wymagane")
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull(message = "Pole wymagane")
    @Column(name = "net_value")
    private Float netValue;

    @NotNull(message = "Pole wymagane")
    @Column(name = "tax_rate")
    private Integer taxRate;

    @NotNull(message = "Pole wymagane")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull(message = "Pole wymagane")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;

    public Invoice() {
    }

    public Invoice(String issueDate, String dueDate, String endDate, String comments, String subject, int quantity, float netValue, int taxRate, Customer customer, Company company) {
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.endDate = endDate;
        this.comments = comments;
        this.subject = subject;
        this.quantity = quantity;
        this.netValue = netValue;
        this.taxRate = taxRate;
        this.customer = customer;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getNetValue() {
        return netValue;
    }

    public void setNetValue(Float netValue) {
        this.netValue = netValue;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", issueDate='" + issueDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", comments='" + comments + '\'' +
                ", subject='" + subject + '\'' +
                ", quantity=" + quantity +
                ", netValue=" + netValue +
                ", taxRate=" + taxRate +
                '}';
    }
}
