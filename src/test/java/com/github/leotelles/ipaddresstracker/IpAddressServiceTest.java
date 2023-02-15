package com.github.leotelles.ipaddresstracker;

import com.github.leotelles.ipaddresstracker.model.IpAddress;
import com.github.leotelles.ipaddresstracker.repository.IpAddressRepository;
import com.github.leotelles.ipaddresstracker.service.IpAddressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class IpAddressServiceTest {

	@Mock
	private IpAddressRepository repository;

	@InjectMocks
	private IpAddressService service;

	@Test
	public void testRequestHandled_existingIpAddress() {
		String ipAddress = "127.0.0.1";
		IpAddress existingIpAddress = new IpAddress(ipAddress, 2);
		when(repository.findById(ipAddress)).thenReturn(Optional.of(existingIpAddress));
		service.requestHandled(ipAddress);
		verify(repository).findById(ipAddress);
		verify(repository).save(existingIpAddress);
		assertEquals(3, existingIpAddress.getCount());
	}

	@Test
	public void testRequestHandled_newIpAddress() {
		String ipAddress = "127.0.0.1";
		when(repository.findById(ipAddress)).thenReturn(Optional.empty());
		service.requestHandled(ipAddress);
		verify(repository).findById(ipAddress);
		ArgumentCaptor<IpAddress> argument = ArgumentCaptor.forClass(IpAddress.class);
		verify(repository).save(argument.capture());
		assertEquals(ipAddress, argument.getValue().getAddress());
		assertEquals(1, argument.getValue().getCount());
	}

}


