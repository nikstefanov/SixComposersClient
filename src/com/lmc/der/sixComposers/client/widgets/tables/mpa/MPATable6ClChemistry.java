package com.lmc.der.sixComposers.client.widgets.tables.mpa;

public class MPATable6ClChemistry extends MPATable6 {

	public MPATable6ClChemistry(char genChar){
		super();
		initRows = 4;
		fixedHeaderColumnsRows=initRows;
		BasePath = genChar+"PA||Results>>HormoneLevels>>Table6B";
		final String[] headerHTML2 = {"Creatinine (&micro;mol/L)"};
		fillRowTextBoxes(2,headerHTML2,1);
		final String[] headerHTML3 = {"Blood urea nitrogen (mmol/L)"};
		fillRowTextBoxes(3,headerHTML3,1);
	}
}
