package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class FSTRATable14 extends AMA2FlexTable {
	
	public FSTRATable14(){
		initRows = 4;columns=5;headerRows=2;headerColumns=1;
		BasePath="FSTRA||ResultsAndDiscussion>>GondalStage>>ResultsTable";
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Males");
		this.setText(0, 2, "Females");		
		
		this.setText(1, 0, "n");
		this.setHTML(1, 1, "Median<br/>Stage<sup>1</sup>");
		this.setText(1, 2, "n");
		this.setHTML(1, 3, "Median<br/>Stage<sup>2</sup>");		
		
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 2);
		CFormatter.setColSpan(0, 2, 2);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		
		
		fillRow(2, "Control (dilution water only), if used");
		fillRow(3, "Solvent control, if used");
		
		
		
	}	

	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		fillRowTextBoxes(rowIndex,headerHTML);

	}

}
