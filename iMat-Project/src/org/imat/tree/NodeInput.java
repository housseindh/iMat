package org.imat.tree;

import java.io.Serializable;

import org.imat.utile.owl.*;

public class NodeInput implements Serializable,Comparable<NodeInput>{

	private InputParam inputParam;
	private OutputParam outputParam;
	private String value;
	
	private NodeService chiledNodeService;
	
	int weight;

	public NodeInput() {
		super();
	}

	public NodeInput(InputParam inputParam, int weight) {
		super();
		this.inputParam = inputParam;
		this.weight = weight;
	}

	public InputParam getInputParam() {
		return inputParam;
	}

	public void setInputParam(InputParam inputParam) {
		this.inputParam = inputParam;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public NodeService getChiledNodeService() {
		return chiledNodeService;
	}

	public void setChiledNodeService(NodeService chiledNodeService) {
		this.chiledNodeService = chiledNodeService;
	}

	public OutputParam getOutputParam() {
		return outputParam;
	}

	public void setOutputParam(OutputParam outputParam) {
		this.outputParam = outputParam;
	}

	@Override
	public String toString() {
		return "NodeInput [inputParam=" + inputParam.getOwlIndividual().getIRI().getFragment() + ", value=" + value + ", chiledNodeService=" + chiledNodeService + ", weight=" + weight + "]";
	}


	public NodeInput copyObject(){
		NodeInput nodeInput = new NodeInput();
		nodeInput.setInputParam(getInputParam());
		nodeInput.setOutputParam(getOutputParam());;
		//if(getChiledNodeService()!=null) 
		//	nodeInput.setChiledNodeService(getChiledNodeService().copyObject(nodeInput));
		nodeInput.setWeight(weight);
		return nodeInput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inputParam == null) ? 0 : inputParam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeInput other = (NodeInput) obj;
		if (inputParam == null) {
			if (other.inputParam != null)
				return false;
		} else if (!inputParam.equals(other.inputParam))
			return false;
		return true;
	}

	@Override
	public int compareTo(NodeInput other) {
		return inputParam.compareTo(other.getInputParam());
	}
	
	
}
