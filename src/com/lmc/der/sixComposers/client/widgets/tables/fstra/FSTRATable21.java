package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;

public class FSTRATable21 extends FSTRASeverityTable {
	
	public FSTRATable21(int not){
		initRows = 11;columns=7;headerRows=3;headerColumns=1;subrows=not;
		columns=7;
		BasePath="FSTRA||ResultsAndDiscussion>>ClinicalSigns>>ResultsSeverityTable";
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
//		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment<br/>(mg a.i../L)<br/>[measured]");		
		this.setHTML(0, 1, "Secondary Sex Characteristics and Clinical Signs<SUP>1</SUP>");
		
		this.setHTML(1, 0, "Male");
		this.setHTML(1, 1, "Female");		
		
		this.setText(2, 0, "Type");
		this.setText(2, 1, "n");
		this.setHTML(2, 2, "Incidence");	
		this.setText(2, 3, "Type");
		this.setText(2, 4, "n");
		this.setHTML(2, 5, "Incidence");		
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 6);		
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		CFormatter.setColSpan(1, 0, 3);
		CFormatter.setColSpan(1, 1, 3);		
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		RFormatter.addStyleName(2, "centered");
		RFormatter.addStyleName(2, "bolded");
		
		fillRow(3, "Control (dilution water only), if used");
		fillRow(3+subrows, "Solvent control, if used");
	}

	@Override
	public void fillRow(int rowIndex, String headerHTML) {
//		int k=0;
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		this.setHTML	(rowIndex, 0, headerHTML);
		CFormatter.setRowSpan(rowIndex, 0, subrows);
		for (int j=0;j<subrows;j++){
//			k = (j==0) ? 0 : 1;				
//			this.setText(rowIndex+j, 1-k, j+"");
//			CFormatter.addStyleName(rowIndex+j, 1-k, "centered");
//			for(int col=1-k;col<columns-k;col++){
				fillSubrow(rowIndex+j,(j==0));
//				if (j!=0) CFormatter.setStylePrimaryName(rowIndex+j, col, "severity_cell");
//			}
		}

	}
	public void addType(){
		subrows++;
		int mainRows = (this.getRowCount()-headerRows)/(subrows-1);
		int rowNumb=0;
		for(int j =0;j<mainRows;j++){
			rowNumb = (j+1)*(subrows-1)+headerRows+j;
			this.insertRow(rowNumb);
			this.getFlexCellFormatter().setRowSpan(rowNumb-(subrows-1),0,subrows);
			fillSubrow(rowNumb,false);
		}
		
	}
	
	private void fillSubrow(int rIndex,boolean headerInRow){
		int k = (headerInRow) ? 0 : 1;		
		this.setWidget(rIndex, 1-k, new DERTextBoxLength(0,getWidgetPath(rIndex,1-k)));
		this.setWidget(rIndex, 2-k, new DERTextBoxLength(4,getWidgetPath(rIndex,2-k)));
		this.setWidget(rIndex, 3-k, new DERTextBoxLength(4,getWidgetPath(rIndex,3-k)));
		this.setWidget(rIndex, 4-k, new DERTextBoxLength(0,getWidgetPath(rIndex,4-k)));
		this.setWidget(rIndex, 5-k, new DERTextBoxLength(4,getWidgetPath(rIndex,5-k)));
		this.setWidget(rIndex, 6-k, new DERTextBoxLength(4,getWidgetPath(rIndex,6-k)));
	}
	
	public void remType(){
		int mainRows = (this.getRowCount()-headerRows)/subrows;
		int rowNumb=0;String rowPath;
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
