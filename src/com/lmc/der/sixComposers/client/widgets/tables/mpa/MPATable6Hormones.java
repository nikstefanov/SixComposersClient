package com.lmc.der.sixComposers.client.widgets.tables.mpa;

public class MPATable6Hormones extends MPATable6 {

	public MPATable6Hormones(char Gender){
		super();
		initRows = (Gender=='M') ? 5 : 4 ;
		fixedHeaderColumnsRows=initRows;
		BasePath = Gender+"PA||Results>>HormoneLevels>>Table6A";
		final String[] headerHTML2 = {"Serum T<sub>4</sub>, Total (&micro;g/dL)"};
		fillRowTextBoxes(2,headerHTML2,1);
		final String[] headerHTML3 = {"Serum TSH (ng/mL)"};
		fillRowTextBoxes(3,headerHTML3,1);
		if (Gender=='M'){
			final String[] headerHTML4 = {"Serum testosterone (ng/mL)"};
			fillRowTextBoxes(4,headerHTML4,1);
		}
		
//		for (int i=0;i<columns;i++)
//			System.out.println("Cell:"+i+"  Text:"+this.getText(2, i)+"_HTML:"+this.getHTML(2,i));
	}
}
