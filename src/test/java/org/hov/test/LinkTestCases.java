package org.hov.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.enums.LinkType;
import org.hov.model.Link;
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
	public void addLinkValid1() {
		Link l = new Link();
		l.setLinkValue("LOREM IPSUM1");
		l.setLinkType(LinkType.EMAIL_VERIFICATION);
		assertTrue(linkService.generateLink(l));
	}
	
	@Test
	@Ignore
	public void removeLinkValid1() {
		assertTrue(linkService.removeLink(UUID.fromString("ebe96165-b7c9-492b-96b4-d3570e1c27a8")));
		
	}
	
	@Test
	@Ignore
	public void regenLinkValid1() {
		assertTrue(linkService.regenerateLink(UUID.fromString("7a612644-30f2-4a1f-a236-bda391f2b5c0")));
	}
	
	@Test
	@Ignore
	public void getLinkByIdValid1() {
		assertNotNull(linkService.getLinkById(UUID.fromString("3bb8abbe-9955-407f-aa06-abf9a8d2709e")));
	}
}

