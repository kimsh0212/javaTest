package com.ksh.common.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PropertiesPersister;

import java.io.*;
import java.util.Properties;

/**
 * Created by becko on 2017-02-07.
 */
@Slf4j
public class KshPropertiesPersister implements org.springframework.util.PropertiesPersister {
	private PropertiesPlaceHolderHandler propertiesPlaceHolderChanger;

	public void setPropertiesPlaceHolderChanger(PropertiesPlaceHolderHandler propertiesPlaceHolderChanger) {
		this.propertiesPlaceHolderChanger = propertiesPlaceHolderChanger;
	}

	@Override
	public void load(Properties props, InputStream is) throws IOException {
		props.load(is);

		if (propertiesPlaceHolderChanger != null) {
			propertiesPlaceHolderChanger.handleOptionalPlaceHolder(props);
		}
	}

	@Override
	public void load(Properties props, Reader reader) throws IOException {
		props.load(reader);

		if (propertiesPlaceHolderChanger != null) {
			propertiesPlaceHolderChanger.handleOptionalPlaceHolder(props);
		}
	}

	@Override
	public void store(Properties props, OutputStream os, String header) throws IOException {
		props.store(os, header);
	}

	@Override
	public void store(Properties props, Writer writer, String header) throws IOException {
		props.store(writer, header);
	}

	@Override
	public void loadFromXml(Properties props, InputStream is) throws IOException {
		props.loadFromXML(is);
	}

	@Override
	public void storeToXml(Properties props, OutputStream os, String header) throws IOException {
		props.storeToXML(os, header);
	}

	@Override
	public void storeToXml(Properties props, OutputStream os, String header, String encoding) throws IOException {
		props.storeToXML(os, header, encoding);
	}
}