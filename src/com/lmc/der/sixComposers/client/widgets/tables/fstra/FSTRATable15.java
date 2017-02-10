package com.lmc.der.sixComposers.client.widgets.tables.fstra;

public class FSTRATable15 extends FSTRASeverityTable {
	
	public FSTRATable15(){
		columns=26;HeaderedCols=10;
		BasePath="FSTRA||ResultsAndDiscussion>>MaleHistopatology>>ResultsSeverityTable";
		this.setHTML(0, 0, "Treatment<br/>(mg a.i../L)<br/>[measured]");		
		this.setHTML(0, 1, "Diagnostic Observations<SUP>1</SUP>");
		
		this.setHTML(1, 0, "Sev<br/>erity");
		this.setHTML(1, 1, "Increased Proportion<br/>of Spermatogonia");
		this.setHTML(1, 2, "Presence of<br/>Testis-Ova");
		this.setHTML(1, 3, "Increased Testicular<br/>Degeneration");
		this.setHTML(1, 4, "Interstitial Cell Hyper<br/>trophy / Hyperplasia");		
		
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
