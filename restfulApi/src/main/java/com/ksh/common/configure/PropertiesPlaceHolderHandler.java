package com.ksh.common.configure;

import java.util.Properties;

/**
 * Created by becko on 2017-02-12.
 */
public interface PropertiesPlaceHolderHandler {
	public static final String WINVENTION_PROPERTY_PRE_FIX = "[";
	public static final String WINVENTION_PROPERTY_POST_FIX = "]";
	public static final String WINVENTION_PROPERTY_SEPERATOR = "|";

	void handleOptionalPlaceHolder(Properties props);
}
