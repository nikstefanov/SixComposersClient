package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;
public class FSTRATable24 extends AMA2FlexTable {

	public FSTRATable24(){
		initRows = 6;columns=9;headerRows=3;headerColumns=1;
		BasePath="FSTRA||ResultsAndDiscussion>>GrowthEndpoints>>EndpointsTable";
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 2, "Length");
		this.setHTML(0, 1, "Body Weight");
		
		this.setText(1, 0, "Males");
		this.setText(1, 1, "Females");
		this.setText(1, 2, "Males");
		this.setText(1, 3, "Females");
		
		this.setText(2, 0, "% Diff.");
		this.setText(2, 1, "p");
		this.setText(2, 2, "% Diff.");
		this.setText(2, 3, "p");
		this.setText(2, 4, "% Diff.");
		this.setText(2, 5, "p");
		this.setText(2, 6, "% Diff.");
		this.setText(2, 7, "p");
		
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 4);
		CFormatter.setColSpan(0, 2, 4);
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
		
		fillRow(3, "Control (dilution water only), if used");
		fillRow(4, "Solvent control, if used");
		fillRow(5, "Statistical Test for Significant Differences");		
	}	

	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		if (headerHTML.length() == 44){//Statistical Test row I mean.
			this.setHTML	(rowIndex, 0, headerHTML);
			for(int col=0;col<4;) fillSTCell(rowIndex,++col);
		}else{
			fillRowTextBoxes(rowIndex,headerHTML);
		}
	}
	
	private void fillSTCell(int rowIndex,int col){
		this.setWidget(rowIndex, col, new DERTextBoxLength(16,getWidgetPath(rowIndex,col)));
		CFormatter.setColSpan(rowIndex, col, 2);
		CFormatter.addStyleName(rowIndex, col, "centered");
	}
}
