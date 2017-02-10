package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table9 extends AMA2FlexTable {
	
	public AMA2Table9(){
		initRows = 5;columns=7;headerRows=3;headerColumns=1;
		BasePath = "AMA||ResultsAndDiscussion>>Mortality>>ResultsTable";
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Larval Mortality");
		
		this.setHTML(1, 0, "Day 7<sup>1</sup>");
		this.setText(1, 1, "Day 21");
		
		this.setText(2, 0, "n");
		this.setText(2, 1, "Mortality #");
		this.setText(2, 2, "Mortality %");
		this.setText(2, 3, "n");
		this.setText(2, 4, "Mortality #");
		this.setText(2, 5, "Mortality %");
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 6);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		CFormatter.setColSpan(1, 0, 3);
		CFormatter.setColSpan(1, 1, 3);		
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		RFormatter.addStyleName(2, "centered");
		RFormatter.addStyleName(2, "bolded");
		
		fillRow(3, "Control (dilution water only), if used");
		fillRow(4, "Solvent control, if used");
	}	

	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		fillRowTextBoxes(rowIndex,headerHTML);
	}
}
