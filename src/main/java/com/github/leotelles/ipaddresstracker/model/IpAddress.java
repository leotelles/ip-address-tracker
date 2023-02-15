package com.github.leotelles.ipaddresstracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class IpAddress {
    @Id
    private String address;

    private int count;

    public IpAddress() {}

    public IpAddress(String address, int count) {
        this.address = address;
        this.count = count;
    }
}
