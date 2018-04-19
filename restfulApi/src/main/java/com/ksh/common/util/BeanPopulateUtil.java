package com.ksh.common.util;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by becko on 2017-02-22.
 */
public class BeanPopulateUtil {
	/**
	 * Rename params key.
	 * service_target_id와 같은 parameter 명을 serviceTargetId와 같은 형태로 변경해 populate하기 위한 목적.
	 *
	 * @param params the params
	 * @return the map
	 */
	public static Map<String, Object> renameParamsKey(Map<String, Object> params) {
		Map<String, Object> renameParams = new HashMap<String, Object>();
		String newKey = "";
		for (String key : params.keySet()) {
			String[] temp = key.split("_");
			StringBuilder sb = new StringBuilder();
			String str = "";
			for (int i = 0; i < temp.length; i++) {
				str = temp[i];
				if (i == 0) {
					sb.append(str);
				} else {
					sb.append(str.substring(0, 1).toUpperCase() + str.substring(1, str.length()));
				}
			}
			newKey = sb.toString();
			renameParams.put(newKey, params.get(key));
		}

		return renameParams;
	}

	/**
	 * Apache BeanUtil Populate로 map to bean.
	 *
	 * @param params the params
	 * @return the penalty id model
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	public static <T extends Map<String, Object>, C> C populate(Map<String, Object> params, Class<C> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		if (clazz == null) {
			throw new IllegalArgumentException("Class is necessary Information to convert Map to Bean");
		}

		C bean = null;

		bean = clazz.newInstance();
		params = renameParamsKey(params);
		BeanUtils.populate(bean, params);

		return bean;
	}

	/**
	 * Convert map to bean by using properties
	 *
	 * @param <T> the generic type
	 * @param <C> the generic type
	 * @param params the params
	 * @param clazz the clazz
	 * @return the c
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static <T extends Map<String, Object>, C> C convertMapToBean(Map<String, Object> params, Class<C> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (clazz == null) {
			throw new IllegalArgumentException("Class is necessary Information to convert Map to Bean");
		}

		C bean = null;

		bean = clazz.newInstance();
		params = renameParamsKey(params);
		PropertyDescriptor[] targetPds = PropertyUtils.getPropertyDescriptors(clazz);

		for (PropertyDescriptor desc : targetPds) {
			Object value = params.get(desc.getName());
			if (value != null) {
				Method writeMethod = desc.getWriteMethod();
				if (writeMethod != null) {
					writeMethod.invoke(bean, new Object[] {value});
				}
			}
		}

		return bean;
	}

	public static Map<String, Object> convertBeanToMap(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (obj == null) {
			throw new IllegalArgumentException("There is no bean to convert map....");
		}

		Map<String, Object> result = new HashMap<String, Object>();
		PropertyDescriptor[] targetPds = PropertyUtils.getPropertyDescriptors(obj);

		for (PropertyDescriptor desc : targetPds) {
			result.put(desc.getName(), PropertyUtils.getProperty(obj, desc.getName()));
		}

		return result;
	}
}
