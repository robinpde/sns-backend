package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.enums.RequestStatus;
import org.hov.model.Request;
import org.hov.service.RequestService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class RequestTestCases {
	@Autowired
	RequestService requestService;
	
	@Test
	@Ignore
	public void addRequestValid1() {
		Request r = new Request();
		r.setRequestTitle("Request Title 2");
		r.setRequestStatus(RequestStatus.ASSIGNED);
		assertTrue(requestService.createRequest(r));
	}
	
	@Test
	@Ignore
	public void updateRequestValid1() {
		Request r = requestService.getRequestById(UUID.fromString("71cc4139-966a-4cc3-af9b-fe9e5ed61f6c"));
		r.setRequestTitle("Request Title 2");
		assertTrue(requestService.updateRequest(r));
	}
	
	@Test
	@Ignore
	public void removeRequestValid1() {
		assertTrue(requestService.removeRequest(UUID.fromString("71cc4139-966a-4cc3-af9b-fe9e5ed61f6c")));
	}
	
	@Test
	@Ignore
	public void getRequestListByStatus() {
		List<Request> rlist = requestService.getRequestListByStatus(RequestStatus.ASSIGNED);
		for(Request r : rlist) {
			System.out.println(r.getRequestTitle());
		}
	}
}