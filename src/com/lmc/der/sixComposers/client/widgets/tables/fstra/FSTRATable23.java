package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNo;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;
public class FSTRATable23 extends AMA2FlexTable {

	public FSTRATable23(){
		initRows = 5;columns=16;headerRows=2;headerColumns=1;
		BasePath="FSTRA||ResultsAndDiscussion>>FemaleHPGEndpoints>>EndpointsTable";
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment<br/>(mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Fecundity");
		this.setText(0, 2, "Fert. Success");
		this.setText(0, 3, "Tubercle Score");
		this.setText(0, 4, "GSI");
		this.setHTML(0, 5, "Gonadal Staging<br>and Histo. Effect?");
		this.setText(0, 6, "Plasma VTG");
		this.setText(0, 7, "Plasma T");
		this.setText(0, 8, "Plasma E2");
		
		
		this.setText(1, 0, "% Diff");
		this.setText(1, 1, "p");
		this.setText(1, 2, "% Diff");
		this.setText(1, 3, "p");		
		this.setText(1, 4, "Median");
		this.setText(1, 5, "p");		
		this.setText(1, 6, "% Diff");
		this.setText(1, 7, "p");		
		this.setText(1, 8, "% Diff");
		this.setText(1, 9, "p");
		this.setText(1,10, "% Diff");
		this.setText(1,11, "p");
		this.setText(1,12, "% Diff");
		this.setText(1,13, "p");
		
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 2);
		CFormatter.setColSpan(0, 2, 2);
		CFormatter.setColSpan(0, 3, 2);
		CFormatter.setColSpan(0, 4, 2);
		CFormatter.setRowSpan(0, 5, 2);
		CFormatter.setColSpan(0, 6, 2);
		CFormatter.setColSpan(0, 7, 2);
		CFormatter.setColSpan(0, 8, 2);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");			
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");		
		
		fillRow(2, "Control (dilution water only), if used");
		fillRow(3, "Solvent control, if used");
		fillRow(4, "Statistical Test for Significant Differences");		
		
	}	

	@Override
	public void fillRow(int rowIndex, String headerHTML) {
		this.setHTML	(rowIndex, 0, headerHTML);
		if (headerHTML.length() == 44){//Statistical Test row I mean.
			fillSTCell(rowIndex,1);fillSTCell(rowIndex,2);
			fillSTCell(rowIndex,3);fillSTCell(rowIndex,4);
			this.setWidget(rowIndex,5, new DERTextBoxLength(4,getWidgetPath(rowIndex,4,"Statistical")));
			CFormatter.addStyleName(rowIndex, 5, "centered");
			fillSTCell(rowIndex,6);fillSTCell(rowIndex,7);fillSTCell(rowIndex,8);	
		}else{
			int col = columns;
			while(col-->1){
				if(col == 9){
					DERListBoxYesNo lb= new DERListBoxYesNo();
					lb.setName(getWidgetPath(rowIndex,col,headerHTML));
					this.setWidget(rowIndex, col, lb);
					this.getCellFormatter().addStyleName(rowIndex, col, "centered");
				}else
					this.setWidget(rowIndex, col, new DERTextBoxLength(4,getWidgetPath(rowIndex,col,headerHTML)));			
			}
		}
	}
	
	private void fillSTCell(int rowIndex,int col){
		this.setWidget(rowIndex, col, new DERTextBoxLength(16,getWidgetPath(rowIndex,col,"Statistical")));
		CFormatter.setColSpan(rowIndex, col, 2);
		CFormatter.addStyleName(rowIndex, col, "centered");
	}

}
