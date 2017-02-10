package com.lmc.der.sixComposers.client.widgets.tables.fstra;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNo;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;
public class FSTRATable22 extends AMA2FlexTable {

	public FSTRATable22(){
		initRows = 5;columns=12;headerRows=2;headerColumns=1;
		BasePath="FSTRA||ResultsAndDiscussion>>MaleHPGEndpoints>>EndpointsTable";
		FlexCellFormatter CFormatter = this.getFlexCellFormatter();
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "Tubercle Score");
		this.setText(0, 2, "GSI");
		this.setHTML(0, 3, "Gonadal Staging<br>and Histo. Effect?");
		this.setText(0, 4, "Plasma VTG");
		this.setText(0, 5, "Plasma T");
		this.setText(0, 6, "Plasma E2");		
		
		this.setText(1, 0, "Median");
		this.setText(1, 1, "p");
		this.setText(1, 2, "% Diff");
		this.setText(1, 3, "p");		
		this.setText(1, 4, "% Diff");
		this.setText(1, 5, "p");		
		this.setText(1, 6, "% Diff");
		this.setText(1, 7, "p");		
		this.setText(1, 8, "% Diff");
		this.setText(1, 9, "p");		
		
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 2);
		CFormatter.setColSpan(0, 2, 2);
		CFormatter.setRowSpan(0, 3, 2);
		CFormatter.setColSpan(0, 4, 2);
		CFormatter.setColSpan(0, 5, 2);
		CFormatter.setColSpan(0, 6, 2);
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
		int col = columns;
		if (headerHTML.length() == 44){//Statistical Test row I mean.
			fillSTCell(rowIndex,1);fillSTCell(rowIndex,2);
			this.setWidget(rowIndex,3, new DERTextBoxLength(4,getWidgetPath(rowIndex,3,"Statistical")));
			CFormatter.addStyleName(rowIndex, 3, "centered");
			fillSTCell(rowIndex,4);fillSTCell(rowIndex,5);fillSTCell(rowIndex,6);			
		}else{
			while(col-->1){
				if(col == 5){
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
