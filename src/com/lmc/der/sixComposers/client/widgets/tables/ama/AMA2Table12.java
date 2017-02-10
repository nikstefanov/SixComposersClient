package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table12 extends AMA2FlexTable {

	public AMA2Table12(){
		initRows = 5;columns=13;headerRows=3;headerColumns=1;
		BasePath = "AMA||ResultsAndDiscussion>>Growth>>ResultsTable";
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Snout-Vent Length (SVL)");
		this.setHTML(0, 2, "Body Weight<sup>1</sup>");
		
		this.setText(1, 0, "Day 7");
		this.setText(1, 1, "Day 21");
		this.setText(1, 2, "Day 7");
		this.setText(1, 3, "Day 21");
		
		this.setText(2, 0, "n");
		this.setText(2, 1, "Mean (mm)");
		this.setHTML(2, 2, "&plusmn;SD");	
		this.setText(2, 3, "n");
		this.setText(2, 4, "Mean (mm)");
		this.setHTML(2, 5, "&plusmn;SD");
		this.setText(2, 6, "n");
		this.setText(2, 7, "Mean (mm)");
		this.setHTML(2, 8, "&plusmn;SD");	
		this.setText(2, 9, "n");
		this.setText(2,10, "Mean (mm)");
		this.setHTML(2,11, "&plusmn;SD");
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 6);
		CFormatter.setColSpan(0, 2, 6);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		CFormatter.setColSpan(1, 0, 3);
		CFormatter.setColSpan(1, 1, 3);
		CFormatter.setColSpan(1, 2, 3);
		CFormatter.setColSpan(1, 3, 3);	
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
