package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class MPATable4 extends FSTRA2FlexTable {

	public MPATable4(){
		initRows = 3;columns=5;headerRows=1;headerColumns=1;		
		fixedHeaderColumnsRows=initRows;
		BasePath = "MPA||Results>>GeneralGrowth>>Table4";
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setText(0, 0, "");
		this.setText(0, 1, "Vehicle Control");
		this.setText(0, 2, "Low Dose");
		this.setText(0, 3, "Medium Dose");
		this.setText(0, 4, "High Dose");
		
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");				
		
		
		fillRowTextBoxes(1, "Number of Animals Examined");
		fillRowTextBoxes(2, "Incidence");		
	}
	
	
	@Override
	protected void fillRow(int rowIndex) {
		// TODO Auto-generated method stub
		
	}

}
