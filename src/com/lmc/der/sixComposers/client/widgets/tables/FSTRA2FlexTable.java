package com.lmc.der.sixComposers.client.widgets.tables;

import com.google.gwt.user.client.ui.FlexTable;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;


public abstract class FSTRA2FlexTable extends FlexTable {

	protected int initRows,columns,headerRows,headerColumns,fixedHeaderColumnsRows;//footerColumns=0
//	protected int initCols
	protected final FlexCellFormatter CFormatter;
	protected final RowFormatter RFormatter;
	protected String BasePath;
	
	protected FSTRA2FlexTable(){
//		fixedHeaderColumnsRows = Integer.MAX_VALUE;
		CFormatter = this.getFlexCellFormatter();
		RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		BasePath="";
//		fixedHeaderColumnsRows=initRows;
	}
//	
//	protected FSTRA2FlexTable(String basePath){
////		fixedHeaderColumnsRows = Integer.MAX_VALUE;
//		CFormatter = this.getFlexCellFormatter();
//		RFormatter = this.getRowFormatter();
//		this.addStyleName("double_bordered");
//		BasePath=basePath;
////		fixedHeaderColumnsRows=initRows;
//	}
	
	public void addRow(int mode){
		fillRow(this.insertRow(this.getRowCount()));
		
	}
	
	public void remRow(int mode){// mode is ignored.Although 0 will be used for add/remove at bottom.
		int rowIndex = this.getRowCount() - 1;
		String rowPath = ((ValueWidget)this.getWidget(rowIndex, 1)).getName();
		rowPath = rowPath.substring(0, rowPath.length()-8);
		ServerRequestsFactory.deleteField(rowPath);
		this.removeRow(rowIndex);
	}

	protected abstract void fillRow(int rowIndex);	
	
	
	/*	
	private boolean isFieldCell(int iRow,int iCol){
//		java.util.Locale is not compatible with GWT 2.5
//		String cellHTMLBeg = this.getHTML(iRow, iCol).substring(0, 7).toLowerCase(Locale.getDefault());
		String cellHTML = this.getHTML(iRow, iCol);
		if (cellHTML.length()>7){
			String cellHTMLBeg = cellHTML.substring(0, 7).toLowerCase();
			if (cellHTMLBeg.equals("<input ")) return true;
			if (cellHTMLBeg.equals("<select")) return true;
			if (cellHTMLBeg.equals("<span c")) return true;
		}
		return false;
	}*/
	
	protected void fillRowTextBoxes(int rowIndex,String[] headerHTML,int rowSpanFirstCell){
		int getColumns = (rowIndex<fixedHeaderColumnsRows) ? columns - headerColumns : columns;
		int i=0;
		for(;i < headerHTML.length;i++)
			this.setHTML(rowIndex, i, headerHTML[i]);
		while(getColumns-->0)
			this.setWidget(rowIndex, getColumns+headerHTML.length,
					new DERTextBoxLength(4,BasePath+">>["+ (rowIndex - headerRows) +"]Row>>["+ (getColumns + headerHTML.length) +"]Col"));
		CFormatter.setRowSpan(rowIndex, 0, rowSpanFirstCell);
	}
	
	protected void fillRowTextBoxes(int rowIndex,String... headerHTML){
		fillRowTextBoxes(rowIndex,headerHTML,1);
	}
	
	protected void fillRowTextBoxes(int rowIndex,String[] headerHTML,int rowSpanFirstCell,String headSize,String cellSize){
//		System.out.println("Fill in the table 4.");
		int getColumns = (rowIndex<fixedHeaderColumnsRows) ? columns - headerColumns : columns;
		int i=0;
		for(;i < headerHTML.length;i++)
			this.setHTML(rowIndex, i, headerHTML[i]);
		DERTextBoxLength TBox;
		while(getColumns-->0){
			TBox = new DERTextBoxLength(0,BasePath+">>["+ (rowIndex - headerRows) +"]Row>>["+ (getColumns + headerHTML.length) +"]Col");
			TBox.setWidth( ( getColumns + headerHTML.length == 0 ) ? headSize : cellSize );
			this.setWidget(rowIndex, getColumns+headerHTML.length, TBox);
		}		
		CFormatter.setRowSpan(rowIndex, 0, rowSpanFirstCell);
	}
	
	public void setBasePath(String basePath){
		BasePath = basePath;
	}
}
