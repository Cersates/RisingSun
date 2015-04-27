package com.dataart.risingsun.app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean checkIfAllowed(String string)
    {
	final Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
	Matcher match = pattern.matcher(string);
	return match.find();
    }
}
