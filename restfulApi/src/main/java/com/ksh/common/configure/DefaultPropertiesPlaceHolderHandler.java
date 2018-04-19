package com.ksh.common.configure;

import com.ksh.common.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by becko on 2017-02-12.
 */
@Slf4j
@Component("defaultPropertiesPlaceHolderHandler")
public class DefaultPropertiesPlaceHolderHandler implements PropertiesPlaceHolderHandler {

	public void handleOptionalPlaceHolder(Properties props) {
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			String zone = StringUtils.defaultIfBlank(System.getProperty("zone"), CommonConstants.ZONE_WEST);
			String originalKey = (String) keys.nextElement();
			if (StringUtils.startsWith(originalKey, WINVENTION_PROPERTY_PRE_FIX)) {
				//[...]
				String prefix = StringUtils.substringBefore(originalKey, WINVENTION_PROPERTY_SEPERATOR);
				//case 1. [west,east,midwest]|wcmsDataSource.driverClassName
				if (StringUtils.contains(prefix, ",")) {
					//west,east,midwest
					String candidates = StringUtils.substringAfter(StringUtils.substringBefore(originalKey, WINVENTION_PROPERTY_POST_FIX), WINVENTION_PROPERTY_PRE_FIX);
					if (candidates.contains(zone)) {
						changePlaceHolder(props, originalKey);
					}
				}

				//case 2. [west]|wcmsDataSource.driverClassName
				if (StringUtils.contains(originalKey, zone)) {
					changePlaceHolder(props, originalKey);
				}
			}
		}
	}

	void changePlaceHolder(Properties props, String originalKey) {
		String value = props.getProperty(originalKey);
		log.debug("InputStream [properties originalKey] : {} , [properties value] : {}", originalKey, value);
		props.remove(originalKey);
		String key = StringUtils.substringAfter(originalKey, WINVENTION_PROPERTY_SEPERATOR);
		props.put(key, value);
		log.debug("InputStream [properties key] : {} , [properties value] : {} , [value of original key] : {}", key, value, props.get(originalKey));
	}
}