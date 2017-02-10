package com.lmc.der.sixComposers.client.widgets.tables.fstra;

public class FSTRATable18 extends FSTRASeverityTable {
	
	public FSTRATable18(){

		columns=26;HeaderedCols=10;//16 added
		BasePath="FSTRA||ResultsAndDiscussion>>AddlFemaleHistopatology>>ResultsSeverityTable";
		this.setHTML(0, 0, "Treatment<br/>(mg a.i../L)<br/>[measured]");		
		this.setHTML(0, 1, "Additional Diagnostic Observations<SUP>1</SUP>");
		
		this.setHTML(1, 0, "Sev<br/>erity");
		this.setHTML(1, 1, "Interstitial<br/>Fibrosis");
		this.setHTML(1, 2, "Egg Debris<br/>in Oviduct");
		this.setHTML(1, 3, "Granulomatous<br/>Inflammation");
		this.setHTML(1, 4, "Decreased Post-<br/>Ovulatory Follicles");
		
		completeTable();
	}
/*
	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		int k=0;
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		this.setHTML	(rowIndex, 0, headerHTML);
		CFormatter.setRowSpan(rowIndex, 0, subrows);
		for (int j=0;j<subrows;j++){
			k = (j==0) ? 0 : 1;				
			this.setText(rowIndex+j, 1-k, j+"");
			CFormatter.addStyleName(rowIndex+j, 1-k, "centered");
			for(int col=2-k;col<columns-k;col++){
				this.setWidget(rowIndex+j, col, new DERTextBoxLength(4));
//				if (j!=0) CFormatter.setStylePrimaryName(rowIndex+j, col, "severity_cell");
			}
		}

	}*/

}
