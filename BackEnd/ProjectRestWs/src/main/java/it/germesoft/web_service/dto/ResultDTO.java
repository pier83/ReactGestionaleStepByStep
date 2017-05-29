package it.germesoft.web_service.dto;

import java.io.Serializable;
import java.util.Map;

import com.google.common.collect.Maps;

public class ResultDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Map<String, Object>  map = Maps.newHashMap();

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
