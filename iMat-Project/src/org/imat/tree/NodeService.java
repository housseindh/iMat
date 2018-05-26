package org.imat.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.imat.utile.owl.*;


public class NodeService implements Serializable,Comparable<NodeService>{

	OutputParam outputParam;
	String outputValue;
	MethodCall methodCall;
	NodeInput parentNode;
	public NodeService() {
		 inputs = new ArrayList<NodeInput>();
	}
	List<NodeInput> inputs = new ArrayList<NodeInput>();

	public OutputParam getOutputParam() {
		return outputParam;
	}

	public void setOutputParam(OutputParam outputParam) {
		this.outputParam = outputParam;
	}

	public String getOutputValue() {
		return outputValue;
	}

	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}

	public MethodCall getMethodCall() {
		return methodCall;
	}

	public void setMethodCall(MethodCall methodCall) {
		this.methodCall = methodCall;
	}

	public List<NodeInput> getInputs() {
		return inputs;
	}

	public void setInputs(List<NodeInput> inputs) {
		this.inputs = inputs;
	}
	
	public void addInputs(NodeInput input) {
		this.inputs.add(input);
	}

	public NodeInput getParentNode() {
		return parentNode;
	}

	public void setParentNode(NodeInput parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
		return "NodeService [outputParam=" + outputParam.getOwlIndividual().getIRI().getFragment() + ", outputValue=" + outputValue + ", methodCall=" + methodCall.getOwlIndividual().getIRI().getFragment()
				+ ", inputs=" + inputs + "]";
	}
	
	public NodeService copyObject(NodeInput parNodeInput) {
		
		NodeService copyNodeService = new NodeService();
		copyNodeService.setMethodCall(getMethodCall());
		copyNodeService.setOutputParam(getOutputParam());
		copyNodeService.setParentNode(parNodeInput);
		
		for (NodeInput nodeInput : this.inputs) {
			NodeInput copyNodeInput = nodeInput.copyObject();
			copyNodeService.getInputs().add(copyNodeInput);
			if (nodeInput.getChiledNodeService() != null) {				
				copyNodeInput.setChiledNodeService(nodeInput.getChiledNodeService().copyObject(copyNodeInput));
							
			}
		}
		
		
		/*NodeService copyNodeService = new NodeService();		
		copyNodeService.setMethodCall(getMethodCall());
		copyNodeService.setOutputParam(getOutputParam());
		copyNodeService.setParentNode(nodeInput);
		for (NodeInput nodeInput1 : inputs) {
			if(nodeInput1!=null){
				NodeInput copyNodeInput = nodeInput1.copyObject();
				copyNodeService.getInputs().add(copyNodeInput);
				
			}
				
		}*/
		return copyNodeService;
    }

	@Override
	public int compareTo(NodeService o) {
		
		if(methodCall.compareTo(o.getMethodCall()) != 0)
			return methodCall.compareTo(o.getMethodCall());
		else {
			for (int i = 0; i < inputs.size(); i++) {
				if(inputs.get(i).getInputParam().compareTo(o.getInputs().get(i).getInputParam())!=0)
					return inputs.get(i).getInputParam().compareTo(o.getInputs().get(i).getInputParam());
			}				
		}

		return 0;
	}
}

