package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;
public class FSTRATable11 extends AMA2FlexTable {

	public FSTRATable11(){
		initRows = 3;columns=3;headerRows=1;headerColumns=1;
		BasePath="FSTRA||ResultsAndDiscussion>>FFS>>ResultsTable";
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setHTML(0, 1, "Fecundity<sup>1</sup>");
		this.setHTML(0, 2, "Fertilization</br>Success(%)<sup>2</sup>");
		
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		fillRow(1, "Control (dilution water only), if used");
		fillRow(2, "Solvent control, if used");
	}	

	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		fillRowTextBoxes(rowIndex,headerHTML);

	}


}
