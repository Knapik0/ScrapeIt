package com.example.scrapeit.model;

import com.example.scrapeit.exception.FileParserException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.regex.Pattern;

@Entity
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    private long id;

    private String licenseNumber;

    private String lastName;

    private String firstName;

    private String middleName;

    private String city;

    private String state;

    private String status;

    private String issueDate;

    private String expirationDate;

    private String boardAction;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    private File file;

    public License(String row) {
        String[] split = row.split(Pattern.quote("|"));
        if (split.length != 10) {
            throw new FileParserException("Row has corrupted input");
        }
        this.licenseNumber = split[0];
        this.lastName = split[1];
        this.firstName = split[2];
        this.middleName = split[3];
        this.city = split[4];
        this.state = split[5];
        this.status = split[6];
        this.issueDate = split[7];
        this.expirationDate = split[8];
        this.boardAction = split[9];
    }

    public License() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBoardAction() {
        return boardAction;
    }

    public void setBoardAction(String boardAction) {
        this.boardAction = boardAction;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof License )) return false;
        return licenseNumber != null && licenseNumber.equals(((License) o).getLicenseNumber());
    }
}
