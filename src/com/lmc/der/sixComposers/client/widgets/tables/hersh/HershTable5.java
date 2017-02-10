package com.lmc.der.sixComposers.client.widgets.tables.hersh;

import com.lmc.der.sixComposers.client.widgets.TextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class HershTable5 extends FSTRA2FlexTable {
	
	public HershTable5(){
		initRows =  3;columns=19;headerRows=initRows;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		
		this.setText(0, 0, "Study Day #");		
		this.setText(0, 1, "Dose (mg/kg bw/day)");
		CFormatter.setRowSpan(0, 0,  3);
		CFormatter.setColSpan(0, 1, 18);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		this.setText(1, 0, "Vehicle Control");
		this.setText(1, 1, "TP Negative Control");
		this.setText(1, 2, "TP + FT Positive Control");
		this.setText(1, 3, "Low");
		this.setText(1, 4, "Mid");
		this.setText(1, 5, "High");
		CFormatter.setColSpan(1, 0, 3);
		CFormatter.setColSpan(1, 1, 3);
		CFormatter.setColSpan(1, 2, 3);
		CFormatter.setColSpan(1, 3, 3);
		CFormatter.setColSpan(1, 4, 3);
		CFormatter.setColSpan(1, 5, 3);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		this.setText(2, 0, "N");
		this.setText(2, 1, "Mean");
		this.setText(2, 2, "SD");
		this.setText(2, 3, "N");
		this.setText(2, 4, "Mean");
		this.setText(2, 5, "SD");
		this.setText(2, 6, "N");
		this.setText(2, 7, "Mean");
		this.setText(2, 8, "SD");
		this.setText(2, 9, "N");
		this.setText(2,10, "Mean");
		this.setText(2,11, "SD");
		this.setText(2,12, "N");
		this.setText(2,13, "Mean");
		this.setText(2,14, "SD");
		this.setText(2,15, "N");
		this.setText(2,16, "Mean");
		this.setText(2,17, "SD");
		RFormatter.addStyleName(2, "centered");
	}
	
	@Override
	protected void fillRow(int rowIndex) {
		fillRowTextBoxes(rowIndex);

	}
	@Override
	protected void fillRowTextBoxes(int rowIndex,String[] headerHTML,int rowSpanFirstCell){
//		System.out.println("Fill in the table 4.");
		int getColumns = (rowIndex<fixedHeaderColumnsRows) ? columns - headerColumns : columns;
//		int i=0;
//		for(;i < headerHTML.length;i++)
//			this.setHTML(rowIndex, i, headerHTML[i]);
		TextBoxLength TBox;
		while(getColumns-->1){
			TBox = new TextBoxLength(1); TBox.setWidth("5ex");
			this.setWidget(rowIndex, getColumns+headerHTML.length, TBox);
		}
		this.setWidget(rowIndex, getColumns+headerHTML.length, new TextBoxLength(6));
//		for(;i < columns;i++)
//			this.setWidget(rowIndex, i, new TextBoxLength(4));
		CFormatter.setRowSpan(rowIndex, 0, rowSpanFirstCell);
	}

}
