package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class MPATable6 extends FSTRA2FlexTable {
	
	public MPATable6(){
		columns=17;headerRows=2;headerColumns=1;
		
		this.setText(0, 0, "Parameter Evaluated");		
		this.setText(0, 1, "Vehicle Control");
		this.setText(0, 2, "Low Dose");
		this.setText(0, 3, "Medium Dose");
		this.setText(0, 4, "High Dose");
		CFormatter.setRowSpan(0, 0, 2);
//		CFormatter.setColSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 4);
		CFormatter.setColSpan(0, 2, 4);
		CFormatter.setColSpan(0, 3, 4);
		CFormatter.setColSpan(0, 4, 4);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		this.setText(1, 0, "Number of Animals Examined");
		this.setText(1, 1, "Mean");
		this.setText(1, 2, "SD");
		this.setText(1, 3, "CV");
		this.setText(1, 4, "Number of Animals Examined");
		this.setText(1, 5, "Mean");
		this.setText(1, 6, "SD");
		this.setText(1, 7, "CV");
		this.setText(1, 8, "Number of Animals Examined");
		this.setText(1, 9, "Mean");
		this.setText(1,10, "SD");
		this.setText(1,11, "CV");
		this.setText(1,12, "Number of Animals Examined");
		this.setText(1,13, "Mean");
		this.setText(1,14, "SD");
		this.setText(1,15, "CV");
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		
	}

	@Override
	protected void fillRow(int rowIndex) {	
		fillRowTextBoxes(rowIndex,new String[0],1);
	}

}
