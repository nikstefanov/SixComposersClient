package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table14 extends AMA2FlexTable {

	public AMA2Table14(){
		initRows = 11;columns=HeaderedCols=12;headerRows=3;headerColumns=2;subrows=4;
		BasePath = "AMA||ResultsAndDiscussion>>AddlHistopathology>>ResultsSeverityTable";
//		ColumnFormatter ColFormatter = this.getColumnFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setHTML(0, 1, "Additional Qualitative Observations<sup>1</sup>");
		
		this.setText(1, 0, "Severity");
		this.setHTML(1, 1, "Follicular Lumen<br/>Area (Increase)");
		this.setHTML(1, 2, "Follicular Lumen<br/>Area (Decrease)");
		this.setHTML(1, 3, "Follicular Cell<br/>Height (Increase)");
		this.setHTML(1, 4, "Follicular Cell<br/>Height (Decrease)");
		this.setHTML(1, 5, "Follicular Cell Shape");
		
		this.setText(2, 0, "n");
		this.setText(2, 1, "Incidence");
		this.setText(2, 2, "n");
		this.setText(2, 3, "Incidence");
		this.setText(2, 4, "n");
		this.setText(2, 5, "Incidence");
		this.setText(2, 6, "n");
		this.setText(2, 7, "Incidence");
		this.setText(2, 8, "n");
		this.setText(2, 9, "Incidence");
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1,11);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		CFormatter.setRowSpan(1, 0, 2);
		CFormatter.setColSpan(1, 1, 2);
		CFormatter.setColSpan(1, 2, 2);
		CFormatter.setColSpan(1, 3, 2);
		CFormatter.setColSpan(1, 4, 2);
		CFormatter.setColSpan(1, 5, 2);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		RFormatter.addStyleName(2, "centered");
		RFormatter.addStyleName(2, "bolded");		
//		ColFormatter.addStyleName(1, "centered");
//		ColFormatter.addStyleName(1, "severity");
		
		fillRow(3, "Control (dilution water only), if used");
		fillRow(3+subrows, "Solvent control, if used");
	}
/*
	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		this.setHTML	(rowIndex, 0, headerHTML);
		int col = columns;
		while(col-->2)	this.setWidget(rowIndex, col, new AMA2BlockTextBox(4,4));	
		this.setWidget(rowIndex, 1, new HTML("0<br/>1<br/>2<br/>3"));
		
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		CFormatter.addStyleName(rowIndex, 1, "centered");
		CFormatter.addStyleName(rowIndex, 1, "severity");
	}
*/
	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		int k=0;
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		this.setHTML	(rowIndex, 0, headerHTML);
		CFormatter.setRowSpan(rowIndex, 0, subrows);
		DERTextBoxLength TextBox;
		for (int j=0;j<subrows;j++){
			k = (j==0) ? 0 : 1;				
			this.setText(rowIndex+j, 1-k, j+"");
			CFormatter.addStyleName(rowIndex+j, 1-k, "centered");
			for(int col=2-k;col<columns-k;col++){
				TextBox = new DERTextBoxLength(4);
				TextBox.setName(getWidgetPath(rowIndex+j,col));
				this.setWidget(rowIndex+j, col, TextBox);
//				if (j!=0) CFormatter.setStylePrimaryName(rowIndex+j, col, "severity_cell");
			}
		}

	}

}
