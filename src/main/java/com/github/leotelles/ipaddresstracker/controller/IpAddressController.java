package com.github.leotelles.ipaddresstracker.controller;

import com.github.leotelles.ipaddresstracker.model.IpAddress;
import com.github.leotelles.ipaddresstracker.service.IpAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ip-addresses")
public class IpAddressController {

    private final IpAddressService service;

    public IpAddressController(IpAddressService service) {
        this.service = service;
    }

    @PostMapping("/request-handled")
    public ResponseEntity<Void> requestHandled(@RequestParam String ipAddress) {
        service.requestHandled(ipAddress);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top-100")
    public ResponseEntity<List<IpAddress>> getTop100() {
        List<IpAddress> top100 = service.getTop100();
        return ResponseEntity.ok().body(top100);
    }

    @PostMapping("/clear")
    public ResponseEntity<Void> clear() {
        service.clear();
        return ResponseEntity.ok().build();
    }
}
