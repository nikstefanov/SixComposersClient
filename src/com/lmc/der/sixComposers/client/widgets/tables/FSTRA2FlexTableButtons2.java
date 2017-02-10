package com.lmc.der.sixComposers.client.widgets.tables;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.lmc.der.sixComposers.client.communication.ServCommFSTRA2;
import com.lmc.der.sixComposers.client.entrypoint.IntegerSC;


public class FSTRA2FlexTableButtons2 extends FlexTable implements ClickHandler {
	
	private final FSTRA2FlexTable Table;
	private final Button BtnAdd,BtnRem;
	private final String HalfTitle,ConstantPath;
	private 	  IntegerSC AddRow;
	
	public FSTRA2FlexTableButtons2(FSTRA2FlexTable Tbl,String title,String constantPath){
		Table = Tbl;
		HalfTitle = title;
		AddRow = new IntegerSC();
		BtnAdd = new Button("Add "+HalfTitle,this);
		BtnRem = new Button("Remove "+HalfTitle,this);
		ConstantPath = constantPath;
		
		this.setWidget(0, 0, Table);
		this.setWidget(1, 0, BtnAdd);
		this.setWidget(1, 1, BtnRem);
		this.getFlexCellFormatter().setColSpan(0, 0, 2);
		
	}
	public FSTRA2FlexTable getTable(){return Table;}/*
	public int getAddRow(){return AddRow;}
	public void setAddRow(int newVal){
		int clicks = newVal-AddRow;
		if (clicks>0)
			for (;clicks>0;clicks--)
				Table.addRow(0);
		else {clicks=-clicks;
			for (;clicks>0;clicks--)
				Table.remRow(0);
		}
		AddRow=newVal;
	}*/
	public void setNote(String noteHtml){
		this.getFlexCellFormatter().setColSpan(0, 0, 3);
		this.setHTML(1, 2, noteHtml);
	}
	

	@Override
	public void onClick(ClickEvent event) {
		Button BtnSource = (Button)event.getSource();
		if (BtnSource.equals(BtnAdd)){
			Table.addRow(0);AddRow.increase1();
			ServerRequestsFactory.updateField(ConstantPath, AddRow.toString());
		}else
		if (BtnSource.equals(BtnRem)&&AddRow.isPositive()){
			Table.remRow(0);AddRow.decrease1();
			ServerRequestsFactory.updateField(ConstantPath, AddRow.toString());
		}
	}
	
	public void updateConstants(){
//		ServersCommunication.callFetchServlet(
//				new ServersCommunication.TableRequestCallback(ConstantPath,addRow,BtnAdd,BtnRem));
		new ServCommFSTRA2(ConstantPath, AddRow, Table);		
	}
}
