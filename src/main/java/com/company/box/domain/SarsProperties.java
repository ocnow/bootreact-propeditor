package com.company.box.domain;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "sars_properties")
@SequenceGenerator(name = "sars_prop_seq",sequenceName = "SARS_PROP_SEQ",allocationSize = 1)
public class SarsProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sars_prop_seq")
    @Column(name = "PROP_ID")
    private Integer propertyId;

    @Column(name = "PROP_NAME",unique = true)
    private String propName;

    @Column(name = "PROP_VALUE")
    private String propValue;

    public SarsProperties() {
    }

    public SarsProperties(Integer propertyId, String propName, String propValue) {
        this.propertyId = propertyId;
        this.propName = propName;
        this.propValue = propValue;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }
}
