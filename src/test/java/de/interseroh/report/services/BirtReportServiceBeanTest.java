/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * (c) 2015 - Interseroh and Crowdcode
 */
package de.interseroh.report.services;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

import org.eclipse.birt.report.engine.api.DocumentUtil;
import org.eclipse.birt.report.engine.api.IBookmarkInfo;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.interseroh.report.controller.SecurityServiceMock;
import de.interseroh.report.webconfig.ReportConfig;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ReportConfig.class, SecurityServiceMock.class})
@PropertySource("classpath:config.properties")
public class BirtReportServiceBeanTest {

	@Autowired
	private BirtReportServiceBean reportService;

	@Test
	public void testPrintParameterTests() throws Exception {
		reportService.getParameterGroups("custom");

	}

	@Test
	@DirtiesContext
	public void testRenderHtml() throws Exception {
//		Authentication authentication = new UsernamePasswordAuthenticationToken(
//				"unit", "pass");
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
		ByteArrayOutputStream out = new ByteArrayOutputStream(4000000);
		reportService.renderHtmlReport("chart", new HashMap<String, Object>(),
				out, 2, false);
		// out.writeTo(System.out);
	}

//	@Test
//	public void testReportDocument() throws Exception {
//		ByteArrayOutputStream out = new ByteArrayOutputStream(40000000);
//		IReportDocument document = reportService.openReportDocument("chart",
//				out);
//		 out.writeTo(System.out);
//
//		Collection<IBookmarkInfo> bookmarks = DocumentUtil
//				.getBookmarks(document, Locale.GERMANY);
//		for (IBookmarkInfo bookmark : bookmarks) {
//			System.out.println("DisplayName  :" + bookmark.getDisplayName());
//			System.out.println("ElementType  :" + bookmark.getElementType());
//			System.out.println("Bookmark     :" + bookmark.getBookmark());
//			System.out.println("BookmarkType :" + bookmark.getBookmarkType());
//			System.out.println("PageNumber   :"
//					+ document.getPageNumber(bookmark.getBookmark()));
//		}
//	}

}