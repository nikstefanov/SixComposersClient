package com.lmc.der.sixComposers.client.widgets.tables;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.lmc.der.sixComposers.client.widgets.DERRichTextAreaPUT;


public class FSTRA2FlexTableButtons extends Grid implements ClickHandler{
	//not used
	protected FSTRA2FlexTable Table;
	protected Button BtnAdd,BtnRem;
	protected int addRow;
	protected final DERRichTextAreaPUT footRTA;
	
	protected FSTRA2FlexTableButtons(String footHTML){
		super((footHTML==null)?2:3,1);
		this.setWidget(0, 0, Table);
		Grid btnGrid = new Grid(1,2);
		btnGrid.setWidget(0, 0, BtnAdd);
		btnGrid.setWidget(0, 1, BtnRem);
		this.setWidget(0, 1, btnGrid);		
		if (footHTML!=null){
			footRTA = new DERRichTextAreaPUT();
			footRTA.addStyleName("tableCommentRTA");
			footRTA.setHTML(footHTML);
			btnGrid.setWidget(0, 2, footRTA);
		}else
			footRTA = null;
	}


	@Override
	public void onClick(ClickEvent event) {
		Button BtnSource = (Button)event.getSource();
		if (BtnSource.equals(BtnAdd))			{Table.addRow(0);addRow++;}
		if (BtnSource.equals(BtnRem)&&addRow>0)	{Table.remRow(0);addRow--;}		
	}

}
