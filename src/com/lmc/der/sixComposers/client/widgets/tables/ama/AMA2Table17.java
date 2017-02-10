package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table17 extends AMA2FlexTable {	
	
	public AMA2Table17(){
		initRows = 6;columns=9;headerRows=3;headerColumns=1;
		BasePath = "AMA||ResultsAndDiscussion>>GrowthEndpoints>>EndpointsTable";
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Snout-Vent Length (SVL)");
		this.setHTML(0, 2, "Body Weight");
		
		this.setText(1, 0, "Day 7");
		this.setText(1, 1, "Day 21");
		this.setText(1, 2, "Day 7");
		this.setText(1, 3, "Day 21");
		
		this.setText(2, 0, "% Diff.");
		this.setText(2, 1, "p");
		this.setText(2, 2, "% Diff.");	
		this.setText(2, 3, "p");
		this.setText(2, 4, "% Diff.");
		this.setText(2, 5, "p");
		this.setText(2, 6, "% Diff.");
		this.setText(2, 7, "p");
		
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 4);
		CFormatter.setColSpan(0, 2, 4);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		CFormatter.setColSpan(1, 0, 2);
		CFormatter.setColSpan(1, 1, 2);
		CFormatter.setColSpan(1, 2, 2);
		CFormatter.setColSpan(1, 3, 2);	
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		RFormatter.addStyleName(2, "centered");
		RFormatter.addStyleName(2, "bolded");		
		
		fillRow(3, "Control (dilution water only), if used");
		fillRow(4, "Solvent control, if used");
		fillRowST(5, "Statistical Test for Significant Differences");
	}	

	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		fillRowTextBoxes(rowIndex,headerHTML);
	}
	
	private void fillRowST(int rowIndex, String headerHTML){
		DERTextBoxLength DERTextBox;
		this.setHTML	(rowIndex, 0, headerHTML);
		int col = columns / 2 + 1;		
		while(col-->1){
			DERTextBox = new DERTextBoxLength(16);
			DERTextBox.setName(this.getWidgetPath(rowIndex,col,headerHTML));
			this.setWidget(rowIndex, col, DERTextBox);
			CFormatter.setColSpan(rowIndex, col, 2);
			CFormatter.addStyleName(rowIndex, col, "centered");
		}		
	}
}
