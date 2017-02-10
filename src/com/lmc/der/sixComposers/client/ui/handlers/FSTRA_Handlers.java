package com.lmc.der.sixComposers.client.ui.handlers;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.lmc.der.sixComposers.client.communication.ServersCommunication;
import com.lmc.der.sixComposers.client.entrypoint.Utils;
import com.lmc.der.sixComposers.client.ui.AMA_UI;
import com.lmc.der.sixComposers.client.ui.AMA_UI.AMA_ButtonName;
import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNoReferenced;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table8;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable1;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable10;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable11;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable12;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable13;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable14;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable15;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable16;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable17;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable18;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable19;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable20;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable21;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable22;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable23;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable24;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable5;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable9;

public class FSTRA_Handlers extends DER_Handlers implements ChangeHandler{
	
	
	private int addRev,addCit,addPar,addTC,indexPC,numberOfTypes;
	public 	DERListBoxYesNoReferenced PositiveControlBox;
	public final AMA2TableReviewers TblRev;
	public final AMA2TableCitations TblCit;
	public final FSTRATable1  Tbl1;
	public final FSTRATable5  Tbl5;
	public final AMA2Table8  Tbl8;
	public final FSTRATable9  Tbl9;
	public final FSTRATable10  Tbl10;
	public final FSTRATable11  Tbl11;
	public final FSTRATable12  Tbl12;
	public final FSTRATable13  Tbl13;
	public final FSTRATable14  Tbl14;
	public final FSTRATable15  Tbl15;
	public final FSTRATable16  Tbl16;
	public final FSTRATable17  Tbl17;
	public final FSTRATable18  Tbl18;
	public final FSTRATable19  Tbl19;
	public final FSTRATable20  Tbl20;
	public final FSTRATable21  Tbl21;
	public final FSTRATable22  Tbl22;
	public final FSTRATable23  Tbl23;
	public final FSTRATable24  Tbl24;
	public final Button BtnRevAdd,BtnRevRem,BtnCitAdd,BtnCitRem,
	BtnParAdd,BtnParRem,BtnTCAdd,BtnTCRem,BtnTypeAdd,BtnTypeRem;
	
	public FSTRA_Handlers(){
		addRev=0;addCit=0;addPar=0;addTC=0;indexPC=1;
		numberOfTypes=4;
		TblRev = new AMA2TableReviewers();
		TblCit = new AMA2TableCitations();
		Tbl1  = new FSTRATable1 ();
		Tbl5  = new FSTRATable5 ();
		Tbl8  = new AMA2Table8  ("FSTRA||MaterialsAndMethods>>StudyDesign>>Table8");
		Tbl9  = new FSTRATable9 ();
		Tbl10  = new FSTRATable10 ();
		Tbl11  = new FSTRATable11 ();
		Tbl12  = new FSTRATable12 ();
		Tbl13  = new FSTRATable13 ();
		Tbl14  = new FSTRATable14 ();
		Tbl15  = new FSTRATable15 ();
		Tbl16  = new FSTRATable16 ();
		Tbl17  = new FSTRATable17 ();
		Tbl18  = new FSTRATable18 ();
		Tbl19  = new FSTRATable19 ();
		Tbl20  = new FSTRATable20 ();
		Tbl21  = new FSTRATable21 (numberOfTypes);
		Tbl22  = new FSTRATable22 ();
		Tbl23  = new FSTRATable23 ();
		Tbl24  = new FSTRATable24 ();
		
		TblRev.setBasePath("FSTRA||GeneralInfo>>TableReviewers");
		TblCit.setBasePath("FSTRA||GeneralInfo>>TableCitations");
		
		PositiveControlBox = new DERListBoxYesNoReferenced();
		PositiveControlBox.setSelectedIndex(1);//No
		PositiveControlBox.addChangeHandler(this);	
		
		BtnRevAdd	= new Button("Add Reviewer",	this);
		BtnRevRem	= new Button("Remove Reviewer",	this);
		BtnCitAdd	= new Button("Add Citation",	this);
		BtnCitRem	= new Button("Remove Citation",	this);
		BtnParAdd	= new Button("Add Parameter",	this);
		BtnParRem	= new Button("Remove Parameter",	this);
		BtnTCAdd	= new Button("Add Test concentration",	this);
		BtnTCRem	= new Button("Remove Test concentration",	this);
//		BtnAttAdd	= new Button("Add Attachment",	this);
//		BtnAttRem	= new Button("Remove Attachment",	this);
		BtnTypeAdd	= new Button("Add Type",	this);
		BtnTypeRem	= new Button("Remove Type",	this);
		
	}

	@Override
	public void onClick(ClickEvent event) {
		int mode;
		Button BtnSource = (Button)event.getSource();		
		Element activeElem = Utils.findActiveElement();
		String htmlBtnSource =activeElem.getInnerHTML();// BtnSource.getHTML();
		boolean remButton = htmlBtnSource.length()>6 && htmlBtnSource.substring(0, 6).equals("Remove"); 
		boolean addButton = htmlBtnSource.length()>4 && htmlBtnSource.substring(0, 4).equals("Add ");
		
			if (BtnSource.equals(BtnRevAdd)){
				TblRev.addRow(0);addRev++;
				if(addButton)ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>ReviewersNumber", addRev+"");}			
			if (BtnSource.equals(BtnRevRem) && addRev>0 && (!remButton || Window.confirm("Please,confirm deletion")))	
				{TblRev.remRow(0);addRev--;
				ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>ReviewersNumber", addRev+"");}
			
			if (BtnSource.equals(BtnCitAdd))
				{TblCit.addRow(0);addCit++;
				if(addButton)ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>CitationsNumber", addCit+"");}
			if (BtnSource.equals(BtnCitRem)&&addCit>0 && (!remButton || Window.confirm("Please,confirm deletion")))
				{TblCit.remRow(0);addCit--;
				ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>CitationsNumber", addCit+"");}
			
			if (BtnSource.equals(BtnParAdd))
				{Tbl5.addRow(0);addPar++;
				if(addButton)ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>ParametersNumber", addPar+"");}			
			if (BtnSource.equals(BtnParRem)&&addPar>0 && (!remButton || Window.confirm("Please,confirm deletion")))	
				{Tbl5.remRow(0);addPar--;
				ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>ParametersNumber", addPar+"");}
			
			if (BtnSource.equals(BtnTCAdd))				{addTC++;
														mode = (indexPC==0)?-addTC:addTC;
														Tbl1 .addRow(mode);
												 		Tbl8 .addRow(addTC);
												 		Tbl9 .addRow(mode);
														Tbl10.addRow(mode);
														Tbl11.addRow(mode);
														Tbl12.addRow(mode);
														Tbl13.addRow(mode);
														Tbl14.addRow(mode);
														Tbl15.addRow(mode);
														Tbl16.addRow(mode);
														Tbl17.addRow(mode); 
														Tbl18.addRow(mode);
														Tbl19.addRow(mode);
														Tbl20.addRow(mode);
														Tbl21.addRow(mode);
														Tbl22.addRow(mode);
														Tbl23.addRow(mode);
														Tbl24.addRow(mode);
														if(addButton)ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>TCNumber", addTC+"");
			}
			if (BtnSource.equals(BtnTCRem)&&addTC>0 && (!remButton || Window.confirm("Please,confirm deletion")))	
														{Tbl1.remRow(1-indexPC);
												 		Tbl8 .remRow(0);
												 		Tbl9 .remRow(1-indexPC);
														Tbl10.remRow(1-indexPC);
														Tbl11.remRow(1-indexPC);
														Tbl12.remRow(1-indexPC);
														Tbl13.remRow(1-indexPC);
														Tbl14.remRow(1-indexPC);
														Tbl15.remRow(1-indexPC);
														Tbl16.remRow(1-indexPC);
														Tbl17.remRow(1-indexPC);
														Tbl18.remRow(1-indexPC);
														Tbl19.remRow(1-indexPC);
														Tbl20.remRow(1-indexPC);
														Tbl21.remRow(1-indexPC);
														Tbl22.remRow(1-indexPC);
														Tbl23.remRow(1-indexPC);
														Tbl24.remRow(1-indexPC);
														addTC--;
														ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>TCNumber", addTC+"");}
					
			if (BtnSource.equals(BtnTypeAdd))
				{Tbl21.addType();numberOfTypes++;
				if(addButton)ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>NumberOfTypes", numberOfTypes+"");}
			if (BtnSource.equals(BtnTypeRem)&&numberOfTypes>4 && (!remButton || Window.confirm("Please,confirm deletion")))	
				{Tbl21.remType();numberOfTypes--;
				ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>NumberOfTypes", numberOfTypes+"");}					
	}
	
	@Override
	public void onChange(ChangeEvent event) {
		DERListBoxYesNoReferenced WidSource = (DERListBoxYesNoReferenced)event.getSource();
//		System.out.println(WidSource.getClass().toString());
		if (WidSource.equals(PositiveControlBox)){			
			if (WidSource.getSelectedIndex()==1 &&
					!Window.confirm("Please,confirm deletion!"))
						WidSource.setSelectedIndex(0);
			else{
				setIndexPC(WidSource.getSelectedIndex());
				ServerRequestsFactory.updateField("FSTRA||InterfaceInfo>>IndexPC", indexPC+"");
			}
		}	
	}
	/*
	@Override
	public void onChange(ChangeEvent event) {
		AMA2Widget WidSource = (AMA2Widget)event.getSource();
//		System.out.println(WidSource.getClass().toString());
		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(173))){
			if (((AMA2ListBoxYesNo)WidSource).getSelectedIndex()==1 &&
					!Window.confirm("Please,confirm deletion!"))
				((AMA2ListBoxYesNo)WidSource).setSelectedIndex(0);
			else
				setIndexPC(((AMA2ListBoxYesNo)WidSource).getSelectedIndex());						
			return;
		}
//		if (WidSource.equals(WidList.get(15))){
//			if (((AMA2ListBoxYesNo)WidSource).getSelectedIndex()==0)
//				((UIObject)WidList.get(16)).addStyleName("notDisplayed");
//			else
//				((UIObject)WidList.get(16)).removeStyleName("notDisplayed");			
//			return;
//		}
		if (WidSource.equals(FSTRA2EntryPoint.WidList.get( 0)))
			FSTRA2EntryPoint.WidList.get(27).setValueString(WidSource.getValueString());
		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(27)))
			FSTRA2EntryPoint.WidList.get( 0).setValueString(WidSource.getValueString());
		
		if (WidSource.equals(FSTRA2EntryPoint.WidList.get( 9)))
			FSTRA2EntryPoint.WidList.get(28).setValueString(WidSource.getValueString());
		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(28)))
			FSTRA2EntryPoint.WidList.get( 9).setValueString(WidSource.getValueString());
		
		if (WidSource.equals(FSTRA2EntryPoint.WidList.get( 1)))
			FSTRA2EntryPoint.WidList.get(39).setValueString(WidSource.getValueString());
		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(39)))
			FSTRA2EntryPoint.WidList.get( 1).setValueString(WidSource.getValueString());
	
//		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(23)))
//			((AMA2ListBox)FSTRA2EntryPoint.WidList.get(95)).setSelectedIndex(((AMA2ListBox)WidSource).getSelectedIndex());
//		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(95)))
//			((AMA2ListBox)FSTRA2EntryPoint.WidList.get(23)).setSelectedIndex(((AMA2ListBox)WidSource).getSelectedIndex());
	}*/
//	public void onValueChange(ValueChangeEvent<String> event) {
//		AMA2Widget WidSource = (AMA2Widget)event.getSource();
//		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(23)))	FSTRA2EntryPoint.WidList.get(95).setValueString(WidSource.getValueString());
//		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(95)))	FSTRA2EntryPoint.WidList.get(23).setValueString(WidSource.getValueString());
//	}
//	@Override
//	public void onSelection(SelectionEvent<Suggestion> event) {
//		AMA2Widget WidSource = (AMA2Widget)event.getSource();
//		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(23)))	FSTRA2EntryPoint.WidList.get(95).setValueString(WidSource.getValueString());
//		if (WidSource.equals(FSTRA2EntryPoint.WidList.get(95)))	FSTRA2EntryPoint.WidList.get(23).setValueString(WidSource.getValueString());
//	}
	
	private void setIndexPC(int iPC){		
		indexPC = iPC;
		if (indexPC==0){//Yes
			Tbl1 .addRow(0);
			Tbl9 .addRow(0);
			Tbl10.addRow(0);
			Tbl11.addRow(0);
			Tbl12.addRow(0);
			Tbl13.addRow(0);
			Tbl14.addRow(0);
			Tbl15.addRow(0);
			Tbl16.addRow(0);
			Tbl17.addRow(0);
			Tbl18.addRow(0);
			Tbl19.addRow(0);
			Tbl20.addRow(0);
			Tbl21.addRow(0);
			Tbl22.addRow(0);
			Tbl23.addRow(0);
			Tbl24.addRow(0);			 
		}else{//No
			Tbl1 .remRow(0);
			Tbl9 .remRow(0);
			Tbl10.remRow(0);
			Tbl11.remRow(0);
			Tbl12.remRow(0);
			Tbl13.remRow(0);
			Tbl14.remRow(0);
			Tbl15.remRow(0);
			Tbl16.remRow(0);
			Tbl17.remRow(0);
			Tbl18.remRow(0);
			Tbl19.remRow(0);
			Tbl20.remRow(0);
			Tbl21.remRow(0);
			Tbl22.remRow(0);
			Tbl23.remRow(0);
			Tbl24.remRow(0);
		}		
	}
	
	protected void updateConstants(){	
		ServersCommunication.callFetchServlet("FSTRA||InterfaceInfo>>ReviewersNumber",addRev+"",new FSTRA_RequestCallback(AMA_ButtonName.REV_ADD));
		ServersCommunication.callFetchServlet("FSTRA||InterfaceInfo>>CitationsNumber",addCit+"",new FSTRA_RequestCallback(AMA_ButtonName.CIT_ADD));	
		ServersCommunication.callFetchServlet("FSTRA||InterfaceInfo>>ParametersNumber",addPar+"",new FSTRA_RequestCallback(AMA_ButtonName.TBL5_ADD));	
		ServersCommunication.callFetchServlet("FSTRA||InterfaceInfo>>TCNumber",addTC+"",new FSTRA_RequestCallback(AMA_ButtonName.TBL8_ADD));	
		ServersCommunication.callFetchServlet("FSTRA||InterfaceInfo>>IndexPC",indexPC+"",new FSTRA_RequestCallback(AMA_ButtonName.INDEX_PC_BOX));
		ServersCommunication.callFetchServlet("FSTRA||InterfaceInfo>>NumberOfTypes",numberOfTypes+"",new FSTRA_RequestCallback(AMA_ButtonName.TYPE_ADD));	
		
		}
	
	private class FSTRA_RequestCallback implements RequestCallback {
		private final AMA_UI.AMA_ButtonName Value;
		private final String Path;
		private final int DefaultVal;
		private final Button AddButton,RemButton;
		private FSTRA_RequestCallback(AMA_UI.AMA_ButtonName valueOut){
			Value = valueOut;
			switch(Value){
			case REV_ADD	:Path = "FSTRA||InterfaceInfo>>ReviewersNumber"; DefaultVal = 0; AddButton = BtnRevAdd; RemButton =BtnRevRem;break;
			case CIT_ADD	:Path = "FSTRA||InterfaceInfo>>CitationsNumber"; DefaultVal = 0;AddButton = BtnCitAdd; RemButton =BtnCitRem;break;	
			case TBL5_ADD	:Path = "FSTRA||InterfaceInfo>>ParametersNumber"; DefaultVal = 0;AddButton = BtnParAdd; RemButton =BtnParRem;break;
			case TBL8_ADD	:Path = "FSTRA||InterfaceInfo>>TCNumber"; DefaultVal = 0;AddButton = BtnTCAdd; RemButton =BtnTCRem;break;
			case INDEX_PC_BOX	:Path = "FSTRA||InterfaceInfo>>IndexPC"; DefaultVal = 1; AddButton = RemButton = null;break;
			case TYPE_ADD	:Path = "FSTRA||InterfaceInfo>>NumberOfTypes"; DefaultVal = 4;AddButton = BtnTypeAdd; RemButton =BtnTypeRem;break;
			default			:Path = ""; DefaultVal=0;AddButton = RemButton = null;break;
			}
		}

		@Override
		public void onResponseReceived(Request request, Response response) {
			String SvrResponse = response.getText();
			if (SvrResponse.equals("##RETRY##")){				
				ServersCommunication.callFetchServlet(Path,DefaultVal+"",this);
			}else{			
				if (Value==AMA_UI.AMA_ButtonName.INDEX_PC_BOX && Integer.parseInt(SvrResponse)==0)
					setIndexPC(0);
				else
					setAddValues(DefaultVal,Integer.parseInt(SvrResponse),AddButton,RemButton);
			}
		}
		@Override
		public void onError(Request request, Throwable exception) {
			Window.alert("Fail to receive the response from DERServer/FetchServelet\r\n"+
					exception.getMessage() + "\r\n" +
					exception.toString());			
		}		
	}

}
