package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNo;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;
public class FSTRATable1 extends AMA2FlexTable {
//	private final int initRows = 2;
	public FSTRATable1(){
		initRows = 2;columns=15;headerRows=2;headerColumns=1;
		BasePath="FSTRA||GeneralInfo>>Table1";
		this.addStyleName("double_bordered");
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Fecundity");
		this.setHTML(0, 2, "Fert.<br/>Success");
		this.setHTML(0, 3, "Tubercle Score");
		this.setHTML(0, 4, "GSI");
		this.setHTML(0, 5, "Gondal Histo.");
		this.setHTML(0, 6, "Plasma VTG");
		this.setHTML(0, 7, "Plasma T");
		this.setHTML(0, 8, "Plasma E2");
		FlexCellFormatter T1CFormatter = this.getFlexCellFormatter();
		RowFormatter T1RFormatter = this.getRowFormatter();
		T1CFormatter.setRowSpan(0, 0, 2);
		T1CFormatter.setRowSpan(0, 1, 2);
		T1CFormatter.setRowSpan(0, 2, 2);
		T1CFormatter.setColSpan(0, 3, 2);
		T1CFormatter.setColSpan(0, 4, 2);
		T1CFormatter.setColSpan(0, 5, 2);
		T1CFormatter.setColSpan(0, 6, 2);
		T1CFormatter.setColSpan(0, 7, 2);
		T1CFormatter.setColSpan(0, 8, 2);
		T1RFormatter.addStyleName(0, "centered");
		T1RFormatter.addStyleName(0, "bolded");
		
		this.setText(1, 0, "M");
		this.setText(1, 1, "F");
		this.setText(1, 2, "M");
		this.setText(1, 3, "F");
		this.setText(1, 4, "M");
		this.setText(1, 5, "F");
		this.setText(1, 6, "M");
		this.setText(1, 7, "F");
		this.setText(1, 8, "M");
		this.setText(1, 9, "F");
		this.setText(1,10, "M");
		this.setText(1,11, "F");	
		T1RFormatter.addStyleName(1, "centered");
		T1RFormatter.addStyleName(1, "bolded");
		
	}
	/*
	@Override
	public void addRow() {
		int rowIndex = this.insertRow(this.getRowCount());
		fillRow(rowIndex,"Positive control");
		
//		this.setText(rowIndex, 0, "Positive control");
//		this.setWidget(rowIndex, 1, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 2, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 3, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 4, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 5, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 6, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 7, new DERListBoxYesNo());
		
	}

	@Override
	public void remRow() {
		int rowCount = this.getRowCount();
//		if (rowCount>initRows){
			this.removeRow(rowCount-1);
//		}		
	}
	
	public void addTCRow(int PCindex){
		int rowIndex = this.getRowCount()-( 1 - PCindex );
		this.insertRow(rowIndex);
		fillRow(rowIndex,"Test Concentration "+(rowIndex - initRows + 1));
		
//		this.setText(rowIndex, 0, "Test Concentration "+(rowIndex - initRows + 1));
//		this.setWidget(rowIndex, 1, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 2, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 3, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 4, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 5, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 6, new DERListBoxYesNo());
//		this.setWidget(rowIndex, 7, new DERListBoxYesNo());
		
	}
	
	public void remTCRow(int PCindex){
		int rowIndex = this.getRowCount()-( 1 - PCindex );
		if (rowIndex>initRows){
			this.removeRow(rowIndex-1);
		}		
	}
	*/
	public void fillRow(int rowIndex,String headerHTML/*,int number*/){
//		String headerHTML = (number==0)?"Positive control":"Test Concentration "+number;
		DERListBoxYesNo lb;
		this.setHTML(rowIndex, 0, headerHTML);
		for(int cIndex=1;cIndex<15;cIndex++){
			lb = new DERListBoxYesNo();
			lb.setName(this.getWidgetPath(rowIndex,cIndex,headerHTML));
			this.setWidget(rowIndex, cIndex, lb);
		}		
	}
}
