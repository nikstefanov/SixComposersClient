package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class MPATable2 extends AMA2FlexTable {

	public MPATable2(){//Dismissed
		initRows = 3;columns=9;headerRows=3;headerColumns=0;
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setText(0, 0, "Observation");
		this.setText(0, 1, "Dose Level");
		
		this.setText(1, 0, "Vehicle Control");
		this.setText(1, 1, "Low");
		this.setText(1, 2, "Medium");
		this.setText(1, 3, "High");
		
		this.setText(2, 0, "# Observed");
		this.setText(2, 1, "# Examined");
		this.setText(2, 2, "# Observed");
		this.setText(2, 3, "# Examined");
		this.setText(2, 4, "# Observed");
		this.setText(2, 5, "# Examined");
		this.setText(2, 6, "# Observed");
		this.setText(2, 7, "# Examined");
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 8);
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
		
	}
	
	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		fillRowTextBoxes(rowIndex);

	}

}
