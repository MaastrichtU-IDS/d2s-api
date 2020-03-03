package org.semanticscience.d2s.api.model;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@ApiResponse( 
	description = "Reasoner API Query Graph, containing nodes and edges"
)
public class QueryGraph {
	// public ReasonerQuery(String message, int max_results) {
	// 	this.message = message;
	// 	this.max_results = max_results;
	// }
	
	// @NotNull(message = "Message cannot be null")
	@Parameter(name = "Nodes to query",
		required= false)
	private Node nodes;
		public Node getNodes() {
			return nodes;
		}
	// public void setMessage(String message) {
	// 	this.message = message;
	// }
	
	@Parameter(name = "Edges to query.", 
		required = false)
	private int edges;
	public int getEdges() {
		return edges;
	}

}