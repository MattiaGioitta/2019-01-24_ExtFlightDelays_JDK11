package it.polito.tdp.extflightdelays.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Simulator {
	
	//coda
	private PriorityQueue<Event> queue;
	
	private Graph<String,DefaultWeightedEdge> graph;
	private int T;
	private int G;
	private Map<String,Stato> stati;
	
	
	public void init(int T,int G, Graph<String,DefaultWeightedEdge> graph, String source) {
		this.T = T;
		this.G = G;
		this.graph = graph;
		this.queue = new PriorityQueue<>();
		this.stati = new HashMap<>();
		
		for(String s : this.graph.vertexSet()) {
			this.stati.put(s,new Stato(s,0));
		}
		
		for(int i = 1;i<=T;i++) {
			Event e = new Event(1,source);
			this.queue.add(e);
		}
		
	}
	
	public void run() {
		while(!this.queue.isEmpty()) {
			Event e = this.queue.poll();
			processEvent(e);
		}
	}

	private void processEvent(Event e) {
		if(!(e.getG()>this.G)) {
			String prossimo = cercaProssimo(e);
			if(prossimo!=null) {
				Event eve = new Event(e.getG()+1,prossimo);
				this.stati.get(prossimo).setNum(this.stati.get(prossimo).getNum()+1);
				this.queue.add(eve);
			}
			
		}
		
	}

	private String cercaProssimo(Event e) {
		String s = null;
		double somma = sommaUscenti(e);
		Random r = new Random();
		for(DefaultWeightedEdge st : this.graph.outgoingEdgesOf(e.getNameState())) {
			double prob = this.graph.getEdgeWeight(st)/somma;
			double p = r.nextDouble();
			if(p<prob) {
				s=this.graph.getEdgeTarget(st);
				return s;
			}
		}
		if(s==null) {
			s=e.getNameState();
		}
		return s;
	}

	private double sommaUscenti(Event e) {
		double somma = 0.0;
		for(DefaultWeightedEdge s : this.graph.outgoingEdgesOf(e.getNameState())) {
			somma+=this.graph.getEdgeWeight(s);
		}
		return somma;
	}

	public Collection<Stato> getStati() {
		// TODO Auto-generated method stub
		return this.stati.values();
	}
	

}
