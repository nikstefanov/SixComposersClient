package com.lmc.der.sixComposers.client.widgets.tables;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;

public class AMA2TableCitations extends AMA2FlexTable {

	public AMA2TableCitations(){
		initRows = 1;columns=2;headerRows=1;headerColumns=0;
		BasePath = "AMA||GeneralInfo>>TableCitations";
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Citation");
		this.setHTML(0, 1, "MRID");
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
//		ColumnFormatter CFormatter = this.getColumnFormatter();
//		CFormatter.setWidth(0, "40%");
	}
	
	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		DERTextBoxLength TextBox = new DERTextBoxLength(70);
		TextBox.setName(getWidgetPath(rowIndex,0,null));
		this.setWidget(rowIndex,0,TextBox);
		TextBox = new DERTextBoxLength(6);
		TextBox.setName(getWidgetPath(rowIndex,1,null));
		this.setWidget(rowIndex,1, TextBox);

	}
}
