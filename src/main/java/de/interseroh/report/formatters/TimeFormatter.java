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
package de.interseroh.report.formatters;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class TimeFormatter extends AbstractDateFormatter
		implements Formatter<Time> {

	@Override
	public Time parse(String text, Locale locale) throws ParseException {
		java.util.Date parsed = getDateFormat(locale).parse(text);
		return new Time(parsed.getTime());
	}

	@Override
	public String print(Time date, Locale locale) {
		return getDateFormat(locale).format(new java.util.Date(date.getTime()));
	}

	protected DateFormat getFormatterInstance(Locale locale) {
		return DateFormat.getTimeInstance(DateFormat.SHORT, locale);
	}

}
