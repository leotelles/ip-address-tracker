package com.github.leotelles.ipaddresstracker.service;

import com.github.leotelles.ipaddresstracker.model.IpAddress;
import com.github.leotelles.ipaddresstracker.repository.IpAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IpAddressService {

    private final IpAddressRepository repository;

    public IpAddressService(IpAddressRepository repository) {
        this.repository = repository;
    }

    public void requestHandled(String ipAddress) {
        Optional<IpAddress> optionalIpAddress = repository.findById(ipAddress);
        if (optionalIpAddress.isPresent()) {
            IpAddress existingIpAddress = optionalIpAddress.get();
            existingIpAddress.setCount(existingIpAddress.getCount() + 1);
            repository.save(existingIpAddress);
        } else {
            IpAddress newIpAddress = new IpAddress(ipAddress, 1);
            repository.save(newIpAddress);
        }
    }

    public List<IpAddress> getTop100() {
        return repository.findTop100ByOrderByCountDesc();
    }

    public void clear() {
        repository.deleteAll();
    }
}
