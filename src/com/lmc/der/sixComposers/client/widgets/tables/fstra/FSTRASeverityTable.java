package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;
public class FSTRASeverityTable extends AMA2FlexTable {

	public FSTRASeverityTable(){
		initRows = 13;headerRows=3;headerColumns=2;subrows=5;
		this.addStyleName("double_bordered");
	}
	
	protected void completeTable(){
		
		int mCols = columns/2-2;
		int reverseCol = 0;
		while(mCols>=0){
			CFormatter.setColSpan(1, mCols+1, 2);
			if (reverseCol++<8)
				this.setWidget(1, mCols+1, new DERTextBoxLength(16,getWidgetPath(1,mCols+1,"Severity")));
			this.setText(2, mCols*2,	"n");
			this.setText(2, mCols*2+1,	"Incidence");
			mCols--;
		}
		
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, columns-1);
		CFormatter.setRowSpan(1, 0, 2);
		
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		RFormatter.addStyleName(2, "centered");
		RFormatter.addStyleName(2, "bolded");
		
		fillRow(3, "Control (dilution water only), if used");
		fillRow(3+subrows, "Solvent control, if used");
	}
	
	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		int k=0;
		this.setHTML	(rowIndex, 0, headerHTML);
		CFormatter.setRowSpan(rowIndex, 0, subrows);
		for (int j=0;j<subrows;j++){
			k = (j==0) ? 0 : 1;
			this.setText(rowIndex+j, 1-k, j+"");
			CFormatter.addStyleName(rowIndex+j, 1-k, "centered");
			for(int col=2-k;col<columns-k;col++){
				this.setWidget(rowIndex+j, col, new DERTextBoxLength(4,getWidgetPath(rowIndex+j,col,headerHTML)));
//				if (j!=0) CFormatter.setStylePrimaryName(rowIndex+j, col, "severity_cell");
			}
		}

	}

}
