package com.shinstealer.blog.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectMapper {

	// singleton instance
	private static final JsonObjectMapper instance = new JsonObjectMapper();
	private static ObjectMapper mapper = new ObjectMapper();

	public static JsonObjectMapper getInstance() {
		return instance;
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

	// private constructor for singleton
	private JsonObjectMapper() {
	}

	public void initMapper(Boolean flag) {
		if (flag) {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		} else {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
	}

	/**
	 * @param json
	 * @param type object
	 * @param <T>  return java object type
	 * @return java object
	 * @throws exception
	 *
	 */
	public <T> T fromJson(String jsonString, Class<T> valueType) throws Exception {
		return mapper.readValue(jsonString, valueType);
	}

	/**
	 * @param json
	 * @param type object
	 * @param <T>  return java object type
	 * @return java object <List>
	 * @throws exception
	 *
	 */
	public <T> List<T> fromJsonList(String jsonString, TypeReference<List<T>> valueType) throws Exception {
		return mapper.readValue(jsonString, valueType);
	}

	public HashMap<String, Object> fromJsonHashMap(String jsonString) throws Exception {
		return mapper.readValue(jsonString, new TypeReference<HashMap<String, Object>>() {
		});
	}

	public LinkedHashMap<String, Object> fromJsonLinkedHashMap(String jsonString) throws Exception {
		return mapper.readValue(jsonString, new TypeReference<LinkedHashMap<String, Object>>() {
		});
	}

	public String toJson(Object ob) throws Exception {
		return mapper.writeValueAsString(ob);
	}

	/**
	 * @param josonNode
	 * @param psth
	 */
	public static void printNode(JsonNode node, String path) {
		if (node.isObject()) {
			Iterator<String> iter = node.fieldNames();
			while (iter.hasNext()) {
				String name = iter.next();
				printNode(node.get(name), path + "." + name);
			}
			
			/* possible to user pairs of name and node
			 if(node.isObject()) { 
			 Iterator<Map.Entry<String, JsonNode>> iter2 = node.fields(); 
			 	while(iter2.hasNext()) { 
			 	 Map.Entry<String, JsonNode> entry = iter2.next(); 
			 	 printNode(entry.getValue(), path + "," +entry.getKey()); } 
			 }
			 */
		} else if (node.isArray()) {
			Iterator<JsonNode> iter = node.elements();
			int index = 0;
			while (iter.hasNext()) {
				printNode((JsonNode) iter.next(), path + String.format("[%s]", index++));
			}
		} else {
			System.out.println(String.format("%s: %s", path, node));
		}

	}
}
