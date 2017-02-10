package com.lmc.der.sixComposers.client.widgets.tables.ama;


import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;


public class AMA2Table8 extends AMA2FlexTable {
//	private final int initRows = 3;
	public AMA2Table8(String basePath){
		initRows = 3;columns=5;headerRows=1;headerColumns=1;
		BasePath = basePath;//;
		this.addStyleName("double_bordered");
		this.setHTML(0, 0, "Treatment ID");
		this.setHTML(0, 1, "Nominal Concentration<br/>(mg a.i./L)");
		this.setHTML(0, 2, "Measured Concentration<br/>(mg a.i./L)");
		this.setHTML(0, 3, "Mean CV (%)");
		this.setHTML(0, 4, "Details or Remarks");	
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
//		this.setHTML	(1,0,"Control (dilution<br/>water only), if used");
//		this.setWidget	(1,1,new DERTextBoxLength());
//		this.setWidget	(1,2,new DERTextBoxLength());
//		this.setWidget	(1,3,new DERTextBoxLength());
//		this.setWidget	(1,4,new DERTextBoxLength());
		fillRow(1, "Control (dilution<br/>water only), if used");
		
//		this.setHTML	(2,0,"Solvent control, if used");
//		this.setWidget	(2,1,new DERTextBoxLength());
//		this.setWidget	(2,2,new DERTextBoxLength());
//		this.setWidget	(2,3,new DERTextBoxLength());
//		this.setWidget	(2,4,new DERTextBoxLength());
		fillRow(2, "Solvent control, if used");
		
		
		
	}
/*
	@Override
	public void addRow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remRow() {
		// TODO Auto-generated method stub
		
	}

	public void addTCRow(int PCindex){
		int rowIndex = this.getRowCount();//-( 1 - PCindex );
		this.insertRow(rowIndex);
		this.setText(rowIndex, 0, "Test Concentration "+(rowIndex - initRows + 1));
		this.setWidget(rowIndex, 1, new DERTextBoxLength());
		this.setWidget(rowIndex, 2, new DERTextBoxLength());
		this.setWidget(rowIndex, 3, new DERTextBoxLength());
		this.setWidget(rowIndex, 4, new DERTextBoxLength());		
	}
	
	public void remTCRow(int PCindex){
		int rowIndex = this.getRowCount();//-( 1 - PCindex );
		if (rowIndex>initRows){
			this.removeRow(rowIndex-1);
		}		
	}
*/	
	public void fillRow(int rowIndex,String headerHTML/*,int number*/){
		fillRowTextBoxes(rowIndex,headerHTML,16);
		
	}
}
