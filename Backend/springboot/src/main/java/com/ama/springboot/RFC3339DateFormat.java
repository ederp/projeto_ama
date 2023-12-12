package com.ama.springboot;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class RFC3339DateFormat {

  // Same as ISO8601DateFormat but serializing milliseconds.
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
	DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	df2.setTimeZone(TimeZone.getTimeZone("GMT"));
	String value = df2.format(date);
    toAppendTo.append(value);
    return toAppendTo;
  }

}