package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table11 extends AMA2FlexTable {

	public AMA2Table11(){
		initRows = 5;columns=9;headerRows=3;headerColumns=1;
		BasePath = "AMA||ResultsAndDiscussion>>HLL>>ResultsTable";
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setHTML(0, 1, "Hind Limb Length (HLL)<sup>1</sup>");
		
		this.setHTML(1, 0, "Day 7");
		this.setText(1, 1, "Day 21");
		
		this.setText(2, 0, "n");
		this.setText(2, 1, "Mean (mm)");
		this.setHTML(2, 2, "&plusmn;SD");
		this.setHTML(2, 3, "HLL:SVL<sup>2</sup>");
		this.setText(2, 4, "n");
		this.setText(2, 5, "Mean (mm)");
		this.setHTML(2, 6, "&plusmn;SD");
		this.setHTML(2, 7, "HLL:SVL<sup>2</sup>");
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 8);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		CFormatter.setColSpan(1, 0, 4);
		CFormatter.setColSpan(1, 1, 4);		
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
