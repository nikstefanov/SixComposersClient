package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table15 extends AMA2FlexTable {
	
//	private int numberOfTypes;
	
	public AMA2Table15(int nT){
//		numberOfTypes = nT;
		columns=4;headerRows=2;headerColumns=1;subrows=nT;initRows = subrows*2+headerRows;
		BasePath="AMA||ResultsAndDiscussion>>ClinicalSigns>>ResultsSeverityTable";
		this.addStyleName("double_bordered");		
		this.setHTML(0, 0, "Treatment (mg<br/>a.i../L) [measured]");
		this.setHTML(0, 1, "Clinical Signs<sup>1</sup>");		
		this.setText(1, 0, "Type");
		this.setText(1, 1, "n");
		this.setText(1, 2, "Incidence");		
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 3);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");		
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
				
		fillRow(2, "Control (dilution water only), if used");
		fillRow(2+subrows, "Solvent control, if used");
	}
	
	public AMA2Table15(){
		this(4);
	}
	/*
	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		this.setHTML	(rowIndex, 0, headerHTML);
		int col = columns;
		while(col-->1)	this.setWidget(rowIndex, col, new AMA2BlockTextBox(numberOfTypes));
	}
	
	public void addType(){
		numberOfTypes++;
		for(int i=headerRows;i<this.getRowCount();i++)
			for (int j = headerColumns;j<columns;j++)
				((AMA2BlockTextBox)(this.getWidget(i, j))).addRow(0);
	}
	
	public void remType(){
		if (numberOfTypes>4){
			numberOfTypes--;
		for(int i=headerRows;i<this.getRowCount();i++)
			for (int j = headerColumns;j<columns;j++)
				((AMA2BlockTextBox)(this.getWidget(i, j))).remRow(0);
		}
	}*/
	public void fillRow(int rowIndex, String headerHTML) {
		int k=0;
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		this.setHTML	(rowIndex, 0, headerHTML);
		CFormatter.setRowSpan(rowIndex, 0, subrows);
		DERTextBoxLength TextBox; 
		for (int j=0;j<subrows;j++){
			k = (j==0) ? 0 : 1;				
				TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowIndex+j, 1-k));
				this.setWidget(rowIndex+j, 1-k, TextBox);
				TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowIndex+j, 2-k));
				this.setWidget(rowIndex+j, 2-k, TextBox);
				TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowIndex+j, 3-k));
				this.setWidget(rowIndex+j, 3-k, TextBox);

		}
	}
	
	public void addType(){
		int pre_subrows = subrows;subrows++;
		int mainRows = (this.getRowCount()-headerRows)/pre_subrows;
		int rowNumb=0;
		DERTextBoxLength TextBox;String headerTitle;
		for(int j =0;j<mainRows;j++){
			headerTitle = this.getHTML(j*(pre_subrows+1)+headerRows, 0);
			rowNumb = (j+1)*pre_subrows+headerRows+j;
			this.insertRow(rowNumb);
			this.getFlexCellFormatter().setRowSpan(rowNumb-pre_subrows,0,pre_subrows+1);
			TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowNumb, 0,headerTitle));
			this.setWidget(rowNumb, 0, TextBox);
			TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowNumb, 1,headerTitle));
			this.setWidget(rowNumb, 1, TextBox);
			TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowNumb, 2,headerTitle));
			this.setWidget(rowNumb, 2, TextBox);

		}
//		subrows++;
	}
	
	public void remType(){
		int mainRows = (this.getRowCount()-headerRows)/subrows;
		int rowNumb=0;
		String rowPath;
		for(int j =mainRows;j>0;j--){
			rowNumb = j*subrows+headerRows;
			rowPath = ((ValueWidget)this.getWidget(rowNumb-1,1)).getName();
			rowPath = rowPath.substring(0, rowPath.length()-8);
			ServerRequestsFactory.deleteField(rowPath);
			this.getFlexCellFormatter().setRowSpan(rowNumb-subrows,0,subrows-1);
			this.removeRow(rowNumb-1);
		}
		subrows--;
	}
}
