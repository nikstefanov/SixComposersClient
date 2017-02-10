package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class MPATable7 extends FSTRA2FlexTable {

	public MPATable7(char genChar){
		BasePath = genChar+"PA||Results>>Histopathology1>>Table7";
		initRows = 23;columns=10;headerRows=3;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		this.setText(0, 0, "Treatment Groups");
		this.setHTML(0, 1, "Severity<sup>b</sup>");	
		this.setText(0, 2, "Parameter Evaluated");
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setRowSpan(0, 1, 3);
		CFormatter.setColSpan(0, 2, 8);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		
		this.setText(1, 0, "Colloid Quality");
		this.setHTML(1, 1, "Follicular Cell<br/>Height (Increase)");
		this.setHTML(1, 2, "Follicular Cell<br/>Height (Decrease)");
		this.setText(1, 3, "Follicular Cell Shape");
		CFormatter.setColSpan(1, 0, 2);
		CFormatter.setColSpan(1, 1, 2);
		CFormatter.setColSpan(1, 2, 2);
		CFormatter.setColSpan(1, 3, 2);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		
		this.setText(2, 0, "O");
		this.setText(2, 1, "E");
		this.setText(2, 2, "O");
		this.setText(2, 3, "E");
		this.setText(2, 4, "O");
		this.setText(2, 5, "E");
		this.setText(2, 6, "O");
		this.setText(2, 7, "E");
		RFormatter.addStyleName(2, "centered");
		RFormatter.addStyleName(2, "bolded");
		
		final String[] empty = {};		
		final String[] headerHTML3 = {"Vehicle control"};
		fillRowTextBoxes(3,headerHTML3,5);
		fillRowTextBoxes(4,empty,1);
		fillRowTextBoxes(5,empty,1);
		fillRowTextBoxes(6,empty,1);
		fillRowTextBoxes(7,empty,1);
		final String[] headerHTML8 = {"Low Dose"};
		fillRowTextBoxes(8,headerHTML8,5);
		fillRowTextBoxes(9,empty,1);
		fillRowTextBoxes(10,empty,1);
		fillRowTextBoxes(11,empty,1);
		fillRowTextBoxes(12,empty,1);
		final String[] headerHTML13 = {"Medium Dose"};
		fillRowTextBoxes(13,headerHTML13,5);
		fillRowTextBoxes(14,empty,1);
		fillRowTextBoxes(15,empty,1);
		fillRowTextBoxes(16,empty,1);
		fillRowTextBoxes(17,empty,1);
		final String[] headerHTML18 = {"High Dose"};
		fillRowTextBoxes(18,headerHTML18,5);
		fillRowTextBoxes(19,empty,1);
		fillRowTextBoxes(20,empty,1);
		fillRowTextBoxes(21,empty,1);
		fillRowTextBoxes(22,empty,1);
	}
	
	@Override
	protected void fillRow(int rowIndex) {
		// TODO Auto-generated method stub

	}

}
