package com.framework.Utilies;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonData {

	private static JSONParser parser = new JSONParser();
	private JSONObject jsonObject;

	public JsonData(String path) throws FileNotFoundException {
		FileReader fileReader = new FileReader(System.getProperty("user.dir") + path);
		Object obj;

		try {
			obj = parser.parse(fileReader);
			jsonObject = (JSONObject) obj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JSONObject getObject() {
		return jsonObject;
	}

	public JSONObject getObjectByKey(String key) {
		return (JSONObject) jsonObject.get(key);
	}

	// returns value of a specified key
	public String getValue(String key) {
		return (String) jsonObject.get(key);
	}

	// returns all keys of JSON object
	public Set getAllKeys() {
		return jsonObject.keySet();
	}

	// returns all values of JSON object
	public Collection<?> getAllValues() {
		return jsonObject.values();
	}

	// returns true if a specified key exists in JSON else false
	public boolean checkIfKeyExists(String key) {
		return jsonObject.containsKey((key));
	}

	// returns true if a specified value exists in JSON else false
	public boolean checkIfValueExists(String value) {
		return jsonObject.containsValue((value));
	}

	// returns length of the Object
	public int getLength() {
		return jsonObject.size();
	}

}
