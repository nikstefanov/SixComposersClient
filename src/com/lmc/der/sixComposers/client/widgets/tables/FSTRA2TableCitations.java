package com.lmc.der.sixComposers.client.widgets.tables;

public class FSTRA2TableCitations extends FSTRA2FlexTable {

	public FSTRA2TableCitations() {
		initRows =  1;
		columns=2;headerRows=initRows;headerColumns=0;
		fixedHeaderColumnsRows=initRows;
		
		this.addStyleName("double_bordered");		
		this.setHTML(0, 0, "Citation");
		this.setHTML(0, 1, "MRID");
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
	}

	@Override
	protected void fillRow(int rowIndex) {
		fillRowTextBoxes(rowIndex,new String[0],1,"70ex","10ex");
	}

}
