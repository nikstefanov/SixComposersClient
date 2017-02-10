package com.lmc.der.sixComposers.client.widgets.tables.hersh;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class HershTable4 extends FSTRA2FlexTable {
	
	public HershTable4(){
		initRows =  3;columns=16;headerRows=initRows;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		
		this.setText(0, 0, "Study Day #");
		this.setText(0, 1, "Dose (mg/kg bw/day)");
		CFormatter.setRowSpan(0, 0,  3);
		CFormatter.setColSpan(0, 1, 15);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		this.setText(1, 0, "Vehicle Control");
		this.setText(1, 1, "TP");
		this.setText(1, 2, "Low");
		this.setText(1, 3, "Mid");
		this.setText(1, 4, "High");
		CFormatter.setColSpan(1, 0, 3);
		CFormatter.setColSpan(1, 1, 3);
		CFormatter.setColSpan(1, 2, 3);
		CFormatter.setColSpan(1, 3, 3);
		CFormatter.setColSpan(1, 4, 3);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		this.setText(2, 0, "N");
		this.setText(2, 1, "Mean");
		this.setText(2, 2, "SD");
		this.setText(2, 3, "N");
		this.setText(2, 4, "Mean");
		this.setText(2, 5, "SD");
		this.setText(2, 6, "N");
		this.setText(2, 7, "Mean");
		this.setText(2, 8, "SD");
		this.setText(2, 9, "N");
		this.setText(2,10, "Mean");
		this.setText(2,11, "SD");
		this.setText(2,12, "N");
		this.setText(2,13, "Mean");
		this.setText(2,14, "SD");
		RFormatter.addStyleName(2, "centered");		
	}
	@Override
	protected void fillRow(int rowIndex) {
		fillRowTextBoxes(rowIndex,new String[0],1,"15ex","5ex");
	}
}
