package com.lmc.der.sixComposers.client.widgets.tables.fstra;

public class FSTRATable17 extends FSTRASeverityTable {
	
	public FSTRATable17(){
//		initRows = 13;columns=10;headerRows=3;headerColumns=2;subrows=5;
		columns=24;HeaderedCols=8;//16 added		
//		this.addStyleName("double_bordered");
		BasePath="FSTRA||ResultsAndDiscussion>>FemaleHistopatology>>ResultsSeverityTable";
		this.setHTML(0, 0, "Treatment<br/>(mg a.i../L)<br/>[measured]");		
		this.setHTML(0, 1, "Diagnostic Observations<SUP>1</SUP>");
		
		this.setHTML(1, 0, "Sev<br/>erity");
		this.setHTML(1, 1, "Increased<br/>Oocyte Atresia");
		this.setHTML(1, 2, "Perifollicular Cell Hy-<br/>perplasia/Hypertrophy");
		this.setHTML(1, 3, "Decreased Yolk<br/>Formation");
		
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
