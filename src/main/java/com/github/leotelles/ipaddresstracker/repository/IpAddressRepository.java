package com.github.leotelles.ipaddresstracker.repository;

import com.github.leotelles.ipaddresstracker.model.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IpAddressRepository extends JpaRepository<IpAddress, String> {
    List<IpAddress> findTop100ByOrderByCountDesc();
    void deleteAll();
}

