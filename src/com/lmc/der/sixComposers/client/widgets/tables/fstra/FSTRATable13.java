package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class FSTRATable13 extends AMA2FlexTable {
	
	public FSTRATable13(){
		initRows = 4;columns=7;headerRows=2;headerColumns=1;
		BasePath="FSTRA||ResultsAndDiscussion>>GSI>>ResultsTable";
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Males");
		this.setText(0, 2, "Females");		
		
		this.setText(1, 0, "n");
		this.setHTML(1, 1, "Mean<br/>GSI<sup>1</sup>(%)");
		this.setHTML(1, 2, "&plusmn;SD");
		this.setText(1, 3, "n");
		this.setHTML(1, 4, "Mean<br/>GSI<sup>1</sup>(%)");
		this.setHTML(1, 5, "&plusmn;SD");
		
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 3);
		CFormatter.setColSpan(0, 2, 3);
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
