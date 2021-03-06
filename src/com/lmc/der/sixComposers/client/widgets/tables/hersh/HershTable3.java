package com.lmc.der.sixComposers.client.widgets.tables.hersh;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class HershTable3 extends FSTRA2FlexTable {

	public HershTable3(){
		initRows =  3;columns=13;headerRows=3;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		
		this.setText(0, 0, "Observations");		
		this.setText(0, 1, "Dose (mg/kg bw/day)");
		CFormatter.setRowSpan(0, 0,  3);
		CFormatter.setColSpan(0, 1, 12);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		this.setText(1, 0, "Vehicle Control");
		this.setText(1, 1, "TP Negative Control");
		this.setText(1, 2, "TP + FT Positive Control");
		this.setText(1, 3, "Low");
		this.setText(1, 4, "Mid");
		this.setText(1, 5, "High");
		CFormatter.setColSpan(1, 0, 2);
		CFormatter.setColSpan(1, 1, 2);
		CFormatter.setColSpan(1, 2, 2);
		CFormatter.setColSpan(1, 3, 2);
		CFormatter.setColSpan(1, 4, 2);
		CFormatter.setColSpan(1, 5, 2);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		this.setText(2, 0, "# Observed");
		this.setText(2, 1, "# Examined");
		this.setText(2, 2, "# Observed");
		this.setText(2, 3, "# Examined");
		this.setText(2, 4, "# Observed");
		this.setText(2, 5, "# Examined");
		this.setText(2, 6, "# Observed");
		this.setText(2, 7, "# Examined");
		this.setText(2, 8, "# Observed");
		this.setText(2, 9, "# Examined");
		this.setText(2,10, "# Observed");
		this.setText(2,11, "# Examined");
		RFormatter.addStyleName(2, "centered");
		
	}

	@Override
	protected void fillRow(int rowIndex) {
//		fillRowTextBoxes(rowIndex,new String[0],1);
		fillRowTextBoxes(rowIndex);
	}

}
