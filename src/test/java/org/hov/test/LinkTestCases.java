package org.hov.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.enums.LinkType;
import org.hov.model.OTPLink;
import org.hov.service.LinkService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(AppConfig.class)
public class LinkTestCases {
	@Autowired
	LinkService linkService;
	
	@Test
	@Ignore
	public void getLinkByIdValid1() {
		assertNotNull(linkService.getLinkById(UUID.fromString("3bb8abbe-9955-407f-aa06-abf9a8d2709e")));
	}
}

