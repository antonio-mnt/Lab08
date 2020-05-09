package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.creaGrafo(400);
		
		System.out.println("vertici: "+model.nVertici()+" archi: "+model.nArchi());

	}

}
