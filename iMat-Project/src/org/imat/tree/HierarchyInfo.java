package org.imat.tree;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.imat.utile.owl.*;



public class HierarchyInfo {

	MethodCall methodCall;
	
	Map<InputParam, TreeSet<OutputParam>> map;

	Hashtable<TreeSet<InputParam>, NodeService> inputsPaths = new Hashtable<TreeSet<InputParam>, NodeService>();
	
	public HierarchyInfo() {

		map = new HashMap<InputParam, TreeSet<OutputParam>>();
		// Set<OutputParam> list = new HashSet<>();//must be unique
		inputsPaths = new Hashtable<TreeSet<InputParam>, NodeService>();
	}

	public MethodCall getMethodCall() {
		return methodCall;
	}

	public void setMethodCall(MethodCall methodCall) {
		this.methodCall = methodCall;
	}

	public Map<InputParam, TreeSet<OutputParam>> getMap() {
		return map;
	}

	public void setMap(Map<InputParam, TreeSet<OutputParam>> map) {
		this.map = map;
	}

	
	
	public Hashtable<TreeSet<InputParam>,NodeService> getInputsPaths() {
		return inputsPaths;
	}

	public void setInputsPaths(Hashtable<TreeSet<InputParam>, NodeService> inputsPaths) {
		this.inputsPaths = inputsPaths;
	}

	@Override
	public String toString() {

		String returnv = "";
		returnv +=  (  " --" + methodCall + "\n");
		for (Entry<InputParam, TreeSet<OutputParam>> entry : this.map.entrySet()) {
			returnv +=    (" ---" + entry.getKey() + "\n");
			for (OutputParam outputParam : entry.getValue()) {
				returnv += (" ----" + outputParam+ "\n");
			}

		}
		return returnv;
	}
}
