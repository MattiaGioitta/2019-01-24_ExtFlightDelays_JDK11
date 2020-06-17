package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<String,DefaultWeightedEdge> graph;
	private ExtFlightDelaysDAO dao;
	private Simulator sim;
	
	public Model() {
		this.dao = new ExtFlightDelaysDAO();
	}
	
	public void createGraph() {
		this.graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		List<Adiacenza> adiacenze = this.dao.getAdiacenze();
		for(Adiacenza a : adiacenze) {
			if(!this.graph.containsVertex(a.getS1())) {
				this.graph.addVertex(a.getS1());
			}
			if(!this.graph.containsVertex(a.getS2())) {
				this.graph.addVertex(a.getS2());
			}
			if(this.graph.getEdge(a.getS1(), a.getS2()) == null) {
				Graphs.addEdgeWithVertices(this.graph,a.getS1(),a.getS2(),a.getPeso());
			}
		}	
		
	}

	public Integer nVertici() {
		return this.graph.vertexSet().size();
	}

	public Integer nArchi() {
		return this.graph.edgeSet().size();
	}

	public List<String> getVertici() {
		List<String> lista = new ArrayList<>();
		for(String s: this.graph.vertexSet()) {
			lista.add(s);
		}
		Collections.sort(lista);
		return lista;
	}

	public List<Vicino> getVicini(String s) {
		List<Vicino> lista = new ArrayList<>();
		for(DefaultWeightedEdge st : this.graph.outgoingEdgesOf(s)) {
			lista.add(new Vicino(this.graph.getEdgeTarget(st),this.graph.getEdgeWeight(st)));
		}
		Collections.sort(lista);
		return lista;
	}

	public void simula(String s, int T, int G) {
		// TODO Auto-generated method stub
		this.sim = new Simulator();
		this.sim.init(T, G, graph, s);
		this.sim.run();
	}

	public Collection<Stato> getStati() {
		// TODO Auto-generated method stub
		return this.sim.getStati();
	}

}
