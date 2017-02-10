package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;


public class MPATable5 extends FSTRA2FlexTable {
	
	public MPATable5(char Gender){		
		if (Gender=='M'){
			initRows = 40;BasePath="MPA||Results>>OrganWeights>>Table5";
		}else{
			initRows = 28;BasePath="FPA||Results>>OrganWeights>>Table4";
		}
		columns=18;headerRows=2;headerColumns=2;
		fixedHeaderColumnsRows=Integer.MAX_VALUE;//All rows
		int currentRow;
		
		this.setText(0, 0, "Organ");		
		this.setText(0, 1, "Vehicle Control");
		this.setText(0, 2, "Low Dose");
		this.setText(0, 3, "Medium Dose");
		this.setText(0, 4, "High Dose");
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 4);
		CFormatter.setColSpan(0, 2, 4);
		CFormatter.setColSpan(0, 3, 4);
		CFormatter.setColSpan(0, 4, 4);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		this.setText(1, 0, "Number of Animals Examined");
		this.setText(1, 1, "Mean");
		this.setText(1, 2, "SD");
		this.setText(1, 3, "CV");
		this.setText(1, 4, "Number of Animals Examined");
		this.setText(1, 5, "Mean");
		this.setText(1, 6, "SD");
		this.setText(1, 7, "CV");
		this.setText(1, 8, "Number of Animals Examined");
		this.setText(1, 9, "Mean");
		this.setText(1,10, "SD");
		this.setText(1,11, "CV");
		this.setText(1,12, "Number of Animals Examined");
		this.setText(1,13, "Mean");
		this.setText(1,14, "SD");
		this.setText(1,15, "CV");
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		
		final String[] headerHTML2 = {"Liver (g)","U"};
		fillRowTextBoxes(2,headerHTML2,3);
		final String[] headerHTML3 = {"A"};
		fillRowTextBoxes(3,headerHTML3,1);
		final String[] headerHTML4 = {"R"};
		fillRowTextBoxes(4,headerHTML4,1);
		final String[] headerHTML5 = {"Kidneys (g)","U"};
		fillRowTextBoxes(5,headerHTML5,3);
		final String[] headerHTML6 = {"A"};
		fillRowTextBoxes(6,headerHTML6,1);
		final String[] headerHTML7 = {"R"};
		fillRowTextBoxes(7,headerHTML7,1);
		final String[] headerHTML8 = {"Pituitary (mg)","U"};
		fillRowTextBoxes(8,headerHTML8,3);
		final String[] headerHTML9 = {"A"};
		fillRowTextBoxes(9,headerHTML9,1);
		final String[] headerHTML10 = {"R"};
		fillRowTextBoxes(10,headerHTML10,1);
		final String[] headerHTML11 = {"Adrenals (mg)","U"};
		fillRowTextBoxes(11,headerHTML11,3);
		final String[] headerHTML12 = {"A"};
		fillRowTextBoxes(12,headerHTML12,1);
		final String[] headerHTML13 = {"R"};
		fillRowTextBoxes(13,headerHTML13,1);
		
		if (Gender=='M'){		
			final String[] headerHTML14 = {"Seminal vesicle + coagulating gland, with fluid (mg)","U"};
			fillRowTextBoxes(14,headerHTML14,2);
			final String[] headerHTML15 = {"A"};
			fillRowTextBoxes(15,headerHTML15,1);
			final String[] headerHTML16 = {"Seminal vesicle + coagulating gland, without fluid (mg)","U"};
			fillRowTextBoxes(16,headerHTML16,2);
			final String[] headerHTML17 = {"A"};
			fillRowTextBoxes(17,headerHTML17,1);
			final String[] headerHTML18 = {"Ventral prostate (mg)","U"};
			fillRowTextBoxes(18,headerHTML18,2);
			final String[] headerHTML19 = {"A"};
			fillRowTextBoxes(19,headerHTML19,1);
			final String[] headerHTML20 = {"Dorsolateral prostate (mg)","U"};
			fillRowTextBoxes(20,headerHTML20,2);
			final String[] headerHTML21 = {"A"};
			fillRowTextBoxes(21,headerHTML21,1);
			final String[] headerHTML22 = {"LABC (mg)","U"};
			fillRowTextBoxes(22,headerHTML22,2);
			final String[] headerHTML23 = {"A"};
			fillRowTextBoxes(23,headerHTML23,1);
			final String[] headerHTML24 = {"Epididymis, left (mg)","U"};
			fillRowTextBoxes(24,headerHTML24,2);
			final String[] headerHTML25 = {"A"};
			fillRowTextBoxes(25,headerHTML25,1);
			final String[] headerHTML26 = {"Epididymis, right (mg)","U"};
			fillRowTextBoxes(26,headerHTML26,2);
			final String[] headerHTML27 = {"A"};
			fillRowTextBoxes(27,headerHTML27,1);
			final String[] headerHTML28 = {"Testis, left (mg)","U"};
			fillRowTextBoxes(28,headerHTML28,2);
			final String[] headerHTML29 = {"A"};
			fillRowTextBoxes(29,headerHTML29,1);
			final String[] headerHTML30 = {"Testis, right (mg)","U"};
			fillRowTextBoxes(30,headerHTML30,2);
			final String[] headerHTML31 = {"A"};
			fillRowTextBoxes(31,headerHTML31,1);
			currentRow = 32;
		}else{
			final String[] headerHTML14 = {"Ovaries (mg)","U"};
			fillRowTextBoxes(14,headerHTML14,2);
			final String[] headerHTML15 = {"A"};
			fillRowTextBoxes(15,headerHTML15,1);
			final String[] headerHTML16 = {"Uterus, wet (mg)","U"};
			fillRowTextBoxes(16,headerHTML16,2);
			final String[] headerHTML17 = {"A"};
			fillRowTextBoxes(17,headerHTML17,1);
			final String[] headerHTML18 = {"Uterus, blotted (mg)","U"};
			fillRowTextBoxes(18,headerHTML18,2);
			final String[] headerHTML19 = {"A"};
			fillRowTextBoxes(19,headerHTML19,1);
			currentRow = 20;
		}
		
		final String[] headerHTML32 = {"Thyroid, fixed(mg)","U"};
		fillRowTextBoxes(currentRow++,headerHTML32,2);
		final String[] headerHTML33 = {"A"};
		fillRowTextBoxes(currentRow++,headerHTML33,1);
		/*
		this.setWidget(currentRow, 0, new TextBoxLength(4));
		CFormatter.setRowSpan(currentRow, 0, 3);
		fillExtraRow(currentRow++,1,'U');
		fillExtraRow(currentRow++,0,'A');
		fillExtraRow(currentRow++,0,'R');
		this.setWidget(currentRow, 0, new TextBoxLength(4));
		CFormatter.setRowSpan(currentRow, 0, 3);
		fillExtraRow(currentRow++,1,'U');
		fillExtraRow(currentRow++,0,'A');
		fillExtraRow(currentRow++,0,'R');
		*/
	}

	@Override
	protected void fillRow(int rowIndex) {		
		final String[] headerHTML34 = {null,"U"};
		fillRowTextBoxes(rowIndex,headerHTML34,3);		
		this.setWidget(rowIndex++, 0,
				new DERTextBoxLength(4, BasePath + ">>[" + (rowIndex - headerRows) +"]Row>>[0]Col"));
		final String[] headerHTML35 = {"A"};
		fillRowTextBoxes(rowIndex++,headerHTML35,1);
		final String[] headerHTML36 = {"R"};
		fillRowTextBoxes(rowIndex++,headerHTML36,1);
	}
	@Override
	public void addRow(int mode){
		fillRow(this.insertRow(this.getRowCount()));		
	}
	@Override
	public void remRow(int mode){// mode is ignored.Although 0 will be used for add/remove at bottom.
		int index = 3;
		String rowPath;
		int rowIndex = this.getRowCount() - 1;
		while (index-->0){
			rowPath = ((ValueWidget)this.getWidget(rowIndex, 2)).getName();
			rowPath = rowPath.substring(0, rowPath.length()-8);
			ServerRequestsFactory.deleteField(rowPath);
			this.removeRow(rowIndex--);
		}
	}
	/*
	private void fillExtraRow(int rowIndex,int colIndex,char header){
		this.setWidget(rowIndex, colIndex, new TextBoxLength(1));
		((UIObject)this.getWidget(rowIndex, colIndex)).setWidth("1.5ex");
		((FocusWidget)this.getWidget(rowIndex, colIndex)).setEnabled(false);
		((TextBoxBase)this.getWidget(rowIndex, colIndex)).setValue(header+"");		
		for(int i=colIndex+1;i<columns + colIndex - 1;i++)
			//We inspect the colSpan through -(colIndex-1)!!! 
			this.setWidget(rowIndex, i, new TextBoxLength(4));
	}*/

}
