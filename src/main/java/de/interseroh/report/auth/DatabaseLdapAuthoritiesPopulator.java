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
package de.interseroh.report.auth;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

/**
 * Database for Authorization.
 *
 * @author Lofi Dewanto (Interseroh)
 */
@Component
public class DatabaseLdapAuthoritiesPopulator implements
		LdapAuthoritiesPopulator {

	@Autowired
	private UserService userService;

	@Autowired
	private ReportService reportService;

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(
			DirContextOperations userData, String userName) {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		// Username == email
		Collection<Report> reports = reportService.findReportsByUser(userName);

		// Authorities == the report name
		for (Report currentReport : reports) {
			authorities
					.add(new SimpleGrantedAuthority(currentReport.getName()));
		}

		return authorities;
	}
}
