package com.lmc.der.sixComposers.client.widgets.tables;

import com.google.gwt.user.client.ui.FlexTable;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.handlers.ValueWidget;


public abstract class AMA2FlexTable extends FlexTable {

	protected int initRows,columns,headerRows,headerColumns,subrows=1;//columns are initColumns
	protected int HeaderedCols = columns;
	protected final FlexCellFormatter CFormatter;
	protected final RowFormatter RFormatter;
	protected String BasePath;//,RowElName,ColElName;
	
	protected AMA2FlexTable(){
		CFormatter = this.getFlexCellFormatter();
		RFormatter = this.getRowFormatter();
	}

	public void addRow(int mode){//0 - PC ,>0 - TC last,<0 - TC not last 
		int number = (mode<0)?(-mode):mode;
		int sub = (mode < 0) ? subrows : 0;
		int rowIndex = this.getRowCount() - sub;
		if (initRows-headerRows==3)//Histophathology table detection. 
			rowIndex--;//Now histoph. tables subrows is 1.
		for(int j=0;j<subrows;j++)
			this.insertRow(rowIndex+j);
		String headerHTML = (number==0)?"Positive control":"Test Concentration "+number;
		fillRow(rowIndex,headerHTML);
//		FSTRA2EntryPoint.WidList.add(this);
	}
	
	public void remRow(int mode){//0 - the last,1 - the last-1,Except for histop. tables 0 - the last-1, 1 - the last-2 
		int rowIndex = this.getRowCount() - mode*subrows;
		if (initRows-headerRows==3)//Endpoints table detection. 
			rowIndex--;//Now histoph. tables subrows is 1.	
		String rowPath;
		if (subrows > 1){
			rowPath = ((ValueWidget)this.getWidget(rowIndex-subrows, 2)).getName();
			rowPath = rowPath.substring(0, rowPath.length() - (subrows+"").length() - 15);
		}else{
			rowPath = ((ValueWidget)this.getWidget(rowIndex-subrows, 1)).getName();
			rowPath = rowPath.substring(0, rowPath.length()-8);
		}		
		ServerRequestsFactory.deleteField(rowPath);
//		System.out.println(rowPath);
		for(int j = 0; j < subrows; j++){			
			this.removeRow(rowIndex - j - 1);
		}	
	}
	
	public abstract void fillRow(int rowIndex,String headerHTML);
	
	public void fillRowTextBoxes(int rowIndex,String headerHTML){
		this.setHTML	(rowIndex, 0, headerHTML);
		int col = columns;
		DERTextBoxLength TextBox;
		while(col-->1){
			TextBox = new DERTextBoxLength(4);
			TextBox.setName(this.getWidgetPath(rowIndex, col,headerHTML));
			this.setWidget(rowIndex, col, TextBox);
		}		
	}
	
	public void fillRowTextBoxes(int rowIndex,String headerHTML,int visChars){
		this.setHTML	(rowIndex, 0, headerHTML);
		int col = columns;
		DERTextBoxLength TextBox;
		while(col-->1){
			TextBox = new DERTextBoxLength(visChars);
			TextBox.setName(this.getWidgetPath(rowIndex, col,headerHTML));
			this.setWidget(rowIndex, col, TextBox);
		}		
	}
	
	public void fillRowTextBoxes(int rowIndex){		
		int col = columns;
		while(col-->0)	this.setWidget(rowIndex, col, new DERTextBoxLength(4));
	}
	
	public void addColHisto(){
		DERTextBoxLength TextBox;
		CFormatter.setColSpan(0, 1, CFormatter.getColSpan(0,1) + 2);
		
		int cells1 = this.getCellCount(1);
		this.insertCell(1, cells1);
		CFormatter.setColSpan(1, cells1, 2);
		TextBox = new DERTextBoxLength(16);
		TextBox.setName(getWidgetPath(1,cells1,"Severity"));
		this.setWidget(1, cells1,TextBox);
		
		int cells2 = this.getCellCount(2);
		this.insertCell(2, cells2);
		this.insertCell(2, cells2+1);
		this.setText(2, cells2, "n");this.setText(2, cells2+1, "Incidence");
		
		int cells;
		for(int rowIndex = this.getRowCount() - 1; rowIndex>2; rowIndex--){
			cells = this.getCellCount(rowIndex);
			this.insertCell(rowIndex, cells);
			this.insertCell(rowIndex, cells+1);			
			this.setWidget(rowIndex, cells, new DERTextBoxLength(4,getWidgetPath(rowIndex,cells)));
			this.setWidget(rowIndex, cells+1, new DERTextBoxLength(4,getWidgetPath(rowIndex,cells+1)));			
		}
		columns+=2;
	}
	
	public void remColHisto(){
		CFormatter.setColSpan(0, 1, CFormatter.getColSpan(0,1) - 2);
		ServerRequestsFactory.deleteField(((ValueWidget)this.getWidget(1, this.getCellCount(1)-1)).getName());
		this.removeCells(1, columns/2 - 1, 1);
		this.removeCells(2, columns - 4, 2);
		for(int rowIndex = this.getRowCount() - 1; rowIndex>2; rowIndex--){
			ServerRequestsFactory.deleteField(((ValueWidget)this.getWidget(rowIndex, this.getCellCount(rowIndex)-1)).getName());
			ServerRequestsFactory.deleteField(((ValueWidget)this.getWidget(rowIndex, this.getCellCount(rowIndex)-2)).getName());
			this.removeCells(rowIndex, this.getCellCount(rowIndex)-2, 2);
		}
		columns-=2;
	}
	
	public void setBasePath(String basePath){
		BasePath = basePath;
	}
	/*
	public void setPaths(){

		for(int cIndex = 1; cIndex < columns; cIndex++)
			((ValueWidget)this.getWidget(headerRows, cIndex)).setName(BasePath+">>Control>>["+(cIndex-1)+"]Col");
		for(int cIndex = 1; cIndex < columns; cIndex++)
			((ValueWidget)this.getWidget(headerRows+1, cIndex)).setName(BasePath+">>SolventControl>>["+(cIndex-1)+"]Col");
	}
	
	protected void setRowPaths(int rowIndex, String header){
		int number;		
		if (header==null){
			for(int cIndex = 0; cIndex < columns; cIndex++)
				((ValueWidget)this.getWidget(rowIndex, cIndex)).setName(BasePath+">>["+ (rowIndex-10) +"]AdditionalParameter>>["+(cIndex)+"]Col");
		}else
		if (header.length()>=7 && header.substring(0, 7).equals("Control")){
			for(int cIndex = 1; cIndex < columns; cIndex++)
				((ValueWidget)this.getWidget(rowIndex, cIndex)).setName(BasePath+">>Control>>["+(cIndex-1)+"]Col");
		}else
		if (header.length()>=7 && header.substring(0, 7).equals("Solvent")){
			for(int cIndex = 1; cIndex < columns; cIndex++)
				((ValueWidget)this.getWidget(rowIndex, cIndex)).setName(BasePath+">>SolventControl>>["+(cIndex-1)+"]Col");
		}else
		if (header.length()>=18 && header.substring(0, 18).equals("Test Concentration")){
			number = Integer.parseInt(header.substring(19));
			for(int cIndex = 1; cIndex < columns; cIndex++)
				((ValueWidget)this.getWidget(rowIndex, cIndex)).setName(BasePath+">>["+ (number-1) +"]TestConcentration>>["+(cIndex-1)+"]Col");
		}else
		if (header.length()>=8 && header.substring(0, 8).equals("Positive")){
			for(int cIndex = 1; cIndex < columns; cIndex++)
				((ValueWidget)this.getWidget(rowIndex, cIndex)).setName(BasePath+">>[0]PositiveControl>>["+(cIndex-1)+"]Col");
		}else
		if (header.length()>=11 && header.substring(0, 11).equals("Statistical")){//AMA case
			for(int cIndex = 1; cIndex < (columns+1)/2; cIndex++)
				((ValueWidget)this.getWidget(rowIndex, cIndex)).setName(BasePath+">>StatisticalTest>>["+(cIndex-1)+"]Col");
		}
	}*/
	
	protected String getWidgetPath(int rIndex, int cIndex, String header){
		int number=0;
		if (header==null)
			return BasePath+">>["+(rIndex-headerRows)+"]Row>>["+(cIndex)+"]Col";
		else
		if (header.length()>=7 && header.substring(0, 7).toLowerCase().equals("<select"))
			return BasePath+">>["+(rIndex-headerRows)+"]Row>>["+(cIndex)+"]Col";
		else
		if (header.length()>=7 && header.substring(0, 7).toLowerCase().equals("<input "))
			return BasePath+">>["+(rIndex-headerRows)+"]Row>>["+(cIndex)+"]Col";
		else
		if (header.length()>=8 && header.substring(0, 8).equals("Severity"))
			return BasePath+">>ColumnHeaders>>["+(cIndex-HeaderedCols/2)+"]Col";///13,14 only
		else
		if (header.length()>=7 && header.substring(0, 7).equals("Control"))
			return BasePath+">>Control>>["+
				((subrows > 1) ? (number=((rIndex - headerRows)%subrows)) +"]Row>>[" : "")+
				(cIndex-headerColumns + ((subrows>1&&number>0)?1:0))+"]Col";
		else
		if (header.length()>=7 && header.substring(0, 7).equals("Solvent"))
			return BasePath+">>SolventControl>>["+
				((subrows > 1) ? (number=((rIndex - headerRows)%subrows)) +"]Row>>[" : "")+
				(cIndex-headerColumns + ((subrows>1&&number>0)?1:0))+"]Col";
		else
		if (header.length()>=18 && header.substring(0, 18).equals("Test Concentration")){
			number = Integer.parseInt(header.substring(19));			
			return BasePath+">>["+ (number-1) +"]TestConcentration>>["+
				((subrows > 1) ? (number=((rIndex - headerRows)%subrows)) +"]Row>>[" : "")+
				(cIndex-headerColumns + ((subrows>1&&number>0)?1:0))+"]Col";
		}else
		if (header.length()>=8 && header.substring(0, 8).equals("Positive"))			
			return BasePath+">>PositiveControl>>["+
				((subrows > 1) ? (number=((rIndex - headerRows)%subrows)) +"]Row>>[" : "")+
				(cIndex-headerColumns + ((subrows>1&&number>0)?1:0))+"]Col";
		else
		if (header.length()>=11 && header.substring(0, 11).equals("Statistical"))//AMA case
			return BasePath+">>StatisticalTest>>["+(cIndex-headerColumns)+"]Col";
		else return "";
	}
	
	protected String getWidgetPath(int rIndex, int cIndex){
		int headerRow = (rIndex >= headerRows)? ((rIndex - headerRows) / subrows ) * subrows + headerRows : rIndex ;
		String headerTitle = this.getHTML(headerRow, 0);
		return getWidgetPath(rIndex,cIndex,headerTitle);
	}
	
}
