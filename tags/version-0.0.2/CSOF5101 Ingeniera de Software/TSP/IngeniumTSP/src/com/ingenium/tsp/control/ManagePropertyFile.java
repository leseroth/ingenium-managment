package com.ingenium.tsp.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.ingenium.tsp.model.PropertyRecord;

public class ManagePropertyFile {
    private static String PROPERTIES_PATH = "src/com/ingenium/tsp/properties/";
    public static final String TASK_FILE = "task.properties";
    public static final String INT_FILE = "int.properties";
    public static final String PERSON_FILE = "person.properties";
    public static final String QUALITY_FILE = "quality.properties";

    private String name;
    private File file;
    protected Properties propertiesFile;

    private static final Map<String, ManagePropertyFile> LOADED_FILES;

    static {
	LOADED_FILES = new HashMap<String, ManagePropertyFile>();
    }

    public static ManagePropertyFile getInstance(String name) {
	ManagePropertyFile propertyFile = null;
	propertyFile = LOADED_FILES.get(name);
	if (propertyFile == null) {
	    propertyFile = new ManagePropertyFile(name);
	    LOADED_FILES.put(name, propertyFile);
	}
	return propertyFile;
    }

    private ManagePropertyFile(String fileName) {
	try {
	    name = fileName;
	    file = new File(PROPERTIES_PATH + fileName);
	    FileInputStream fis = new FileInputStream(file);
	    propertiesFile = new Properties();
	    propertiesFile.load(fis);
	} catch (FileNotFoundException ex) {
	    ex.printStackTrace();
	} catch (IOException io) {
	    io.printStackTrace();
	}
    }

    public void persist() {
	try {
	    FileOutputStream out = new FileOutputStream(file);
	    propertiesFile.store(out, "-- Archivo de propiedades [" + name.toUpperCase() + "] --");
	    out.flush();
	    out.close();
	} catch (FileNotFoundException ex) {
	    ex.printStackTrace();
	} catch (IOException io) {
	    io.printStackTrace();
	}
    }

    public String getProperty(String key) {
	return propertiesFile.getProperty(key);
    }

    public void put(PropertyRecord record) {
	propertiesFile.put(record.getId(), record.encodeData());
    }

    public void update(PropertyRecord record) {
	propertiesFile.setProperty(record.getId(), record.encodeData());
    }

    public void remove(PropertyRecord record) {
	propertiesFile.remove(record.getId());
    }

    public Properties getPropertiesFile() {
	return propertiesFile;
    }
}
