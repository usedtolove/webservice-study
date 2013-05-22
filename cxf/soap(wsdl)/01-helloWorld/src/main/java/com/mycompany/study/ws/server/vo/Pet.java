package com.mycompany.study.ws.server.vo;

import javax.xml.bind.annotation.XmlType;

/**
 * User: Hu Jing Ling
 * Date: 2013-05-22
 */
@XmlType(propOrder = {"petName","petAge"})
public class Pet {
    private String petName;
    private Integer petAge;

    public Pet() {
    }

    public Pet(String petName, Integer petAge) {
        this.petName = petName;
        this.petAge = petAge;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", petAge=" + petAge +
                '}';
    }
}

