package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.DERCheckBoxSC;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class MPATableCheckBoxes extends  FSTRA2FlexTable {
	
	public MPATableCheckBoxes(String[] NameArr,int CBcolumns,int addLines,String basePath){
		initRows = NameArr.length+addLines;
		columns=CBcolumns+1;headerRows=1;headerColumns=1;
		fixedHeaderColumnsRows = NameArr.length;//
		BasePath = basePath;
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, NameArr[0]);		
		
		CFormatter.setColSpan(0, 0, CBcolumns+1);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");				
		
		int row=1;
		for (;row<fixedHeaderColumnsRows;row++)
			fillRow(row, NameArr[row]);
		for (;row<initRows;row++)
			fillRow(row, "");
	}
	

	@Override
	protected void fillRow(int rowIndex){}
	
	public void fillRow(int rowIndex, String headerHTML) {
		if (rowIndex<fixedHeaderColumnsRows)
			this.setHTML	(rowIndex, 0, headerHTML);
		else this.setWidget(rowIndex, 0,
				new DERTextBoxLength(6,BasePath+">>["+(rowIndex-headerRows)+"]Row>>[0]Col"));
		for(int i=1;i<columns;i++)
			this.setWidget(rowIndex, i, new DERCheckBoxSC(BasePath+">>["+(rowIndex-headerRows)+"]Row>>[" + i + "]Col"));
		
	}

}
