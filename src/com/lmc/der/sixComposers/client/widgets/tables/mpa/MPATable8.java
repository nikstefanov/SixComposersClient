package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class MPATable8 extends FSTRA2FlexTable {

	public MPATable8(){
		initRows = 2;columns=9;headerRows=2;headerColumns=0;
		fixedHeaderColumnsRows=headerRows;
		
		this.setText(0, 0, "Findings");
		this.setHTML(0, 1, "Vechicle Control");	
		this.setText(0, 2, "Low Dose");
		this.setText(0, 3, "Medium Dose");
		this.setText(0, 4, "High Dose");
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 2);
		CFormatter.setColSpan(0, 2, 2);
		CFormatter.setColSpan(0, 3, 2);
		CFormatter.setColSpan(0, 4, 2);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		this.setText(1, 0, "#Observed");
		this.setText(1, 1, "#Examined");
		this.setText(1, 2, "#Observed");
		this.setText(1, 3, "#Examined");
		this.setText(1, 4, "#Observed");
		this.setText(1, 5, "#Examined");
		this.setText(1, 6, "#Observed");
		this.setText(1, 7, "#Examined");
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
	}
	
	@Override
	protected void fillRow(int rowIndex) {
		fillRowTextBoxes(rowIndex,new String[0],1);
	}
}
