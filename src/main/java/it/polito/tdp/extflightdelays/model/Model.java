package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;


public class Model {
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer,Airport> idMap;
	private List<Volo> voli;
	
	public Model() {
		
		idMap = new HashMap<Integer,Airport>();
		
	}
	
	public void creaGrafo(int media) {
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		
		dao.loadAllAirports(idMap);
		
		//System.out.println(idMap);
		
		Graphs.addAllVertices(this.grafo, idMap.values());
		
		voli = new ArrayList<>(dao.getVoli());
		
		for(Volo v: voli) {
			if(v.getPeso()>=media) {
				Graphs.addEdge(this.grafo, idMap.get(v.getIdPartenza()), idMap.get(v.getIdArrivo()), v.getPeso());
			}
		}
		
		//System.out.println(this.grafo);
		
	}
	
	
	public Graph<Airport, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}
	

	public List<Volo> getVoli() {
		return voli;
	}

	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	

}
