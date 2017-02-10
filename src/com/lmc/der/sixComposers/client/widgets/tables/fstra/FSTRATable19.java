package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class FSTRATable19 extends AMA2FlexTable {
	
	public FSTRATable19(){
		initRows = 5;columns=7;headerRows=3;headerColumns=1;
		BasePath="FSTRA||ResultsAndDiscussion>>VTG>>ResultsTable";
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setHTML(0, 1, "Plasma Vitellogenin (VTG)");
		
		this.setText(1, 0, "Males");
		this.setText(1, 1, "Females");
		
		this.setText(2, 0, "n");
		this.setHTML(2, 1, "Mean<br/>(ng/mL<br/>plasma)");
		this.setHTML(2, 2, "&plusmn;SD");
		this.setText(2, 3, "n");
		this.setHTML(2, 4, "Mean<br/>(ng/mL<br/>plasma)");
		this.setHTML(2, 5, "&plusmn;SD");
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 6);
		CFormatter.setColSpan(1, 0, 3);
		CFormatter.setColSpan(1, 1, 3);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");		
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
