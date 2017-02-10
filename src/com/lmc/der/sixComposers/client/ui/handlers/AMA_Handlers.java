package com.lmc.der.sixComposers.client.ui.handlers;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.lmc.der.sixComposers.client.communication.ServersCommunication;
import com.lmc.der.sixComposers.client.entrypoint.Utils;
import com.lmc.der.sixComposers.client.ui.AMA_UI;
import com.lmc.der.sixComposers.client.ui.AMA_UI.AMA_ButtonName;
import com.lmc.der.sixComposers.client.widgets.DERAutoSuggestBox;
import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNoReferenced;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxReferenced;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table1;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table10;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table11;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table12;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table13;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table14;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table15;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table16;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table17;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table5;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table8;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table9;

public class AMA_Handlers extends DER_Handlers implements ChangeHandler,
	SelectionHandler<Suggestion>,ValueChangeHandler<String> {
	
	private int addTC,addPar,addRev,indexPC,numberOfTypes,addCit,addCol13,addCol14;
	public final AMA2TableReviewers TblRev;
	public final AMA2TableCitations TblCit;
	public final AMA2Table1  Tbl1;
	public final AMA2Table5  Tbl5;
	public final AMA2Table8  Tbl8;
	public final AMA2Table9  Tbl9;
	public final AMA2Table10 Tbl10;
	public final AMA2Table11 Tbl11;
	public final AMA2Table12 Tbl12;
	public final AMA2Table13 Tbl13;
	public final AMA2Table14 Tbl14;
	public final AMA2Table15 Tbl15;
	public final AMA2Table16 Tbl16;
	public final AMA2Table17 Tbl17;
	public 	DERListBoxYesNoReferenced PositiveControlBox;
	public 	DERAutoSuggestBox ExpoType1,ExpoType2;
	public  DERTextBoxReferenced TMat1,TMat2,Cas1,Cas2,Pur1,Pur2;
	public final Button BtnRevAdd,BtnRevRem,Btn5Add,Btn5Rem,
	Btn8Add,Btn8Rem,BtnTypeAdd,BtnTypeRem,BtnCitAdd,BtnCitRem,
	Btn13Add,Btn13Rem,Btn14Add,Btn14Rem;	
	

	public AMA_Handlers() {
		
		addRev=0;addCit=0;addPar=0;addTC=0;indexPC=1;numberOfTypes=4;addCol13=0;addCol14=0;
		
		TblRev = new AMA2TableReviewers();
		TblCit = new AMA2TableCitations();
		Tbl1  = new AMA2Table1 ();
		Tbl5  = new AMA2Table5 ();
		Tbl8  = new AMA2Table8 ("AMA||MaterialsAndMethods>>StudyDesign>>Table8");
		Tbl9  = new AMA2Table9 ();
		Tbl10 = new AMA2Table10();
		Tbl11 = new AMA2Table11();
		Tbl12 = new AMA2Table12();
		Tbl13 = new AMA2Table13();
		Tbl14 = new AMA2Table14();
		Tbl15 = new AMA2Table15(numberOfTypes);
		Tbl16 = new AMA2Table16();
		Tbl17 = new AMA2Table17();
		
		PositiveControlBox = new DERListBoxYesNoReferenced();
		PositiveControlBox.setSelectedIndex(1);//No
		PositiveControlBox.addChangeHandler(this);		
		ExpoType1=null;ExpoType2=null;
		TMat1 = new DERTextBoxReferenced();
		TMat2 = new DERTextBoxReferenced();
		Cas1 = new DERTextBoxReferenced();
		Cas2 = new DERTextBoxReferenced();
		Pur1 = new DERTextBoxReferenced();
		Pur2 = new DERTextBoxReferenced();
		TMat1.addValueChangeHandler(this);
		TMat2.addValueChangeHandler(this);
		Cas1.addValueChangeHandler(this);
		Cas2.addValueChangeHandler(this);
		Pur1.addValueChangeHandler(this);
		Pur2.addValueChangeHandler(this);
		
	BtnRevAdd	= new Button("Add Reviewer",	this);
	BtnRevRem	= new Button("Remove Reviewer",	this);
	BtnCitAdd	= new Button("Add Citation",	this);
	BtnCitRem	= new Button("Remove Citation",	this);
	Btn5Add		= new Button("Add Parameter",	this);
	Btn5Rem		= new Button("Remove Parameter",	this);
	Btn8Add		= new Button("Add Test concentration",	this);
	Btn8Rem		= new Button("Remove Test concentration",	this);
//	BtnAttAdd	= new Button("Add Attachment",	this);
//	BtnAttRem	= new Button("Remove Attachment",	this);
	BtnTypeAdd	= new Button("Add Type",	this);
	BtnTypeRem	= new Button("Remove Type",	this);	
	Btn13Add	= new Button("Add Columns",this);
	Btn13Rem	= new Button("Remove Columns",this);
	Btn14Add	= new Button("Add Columns",this);
	Btn14Rem	= new Button("Remove Columns",this);
	
	
	}	
	
	@Override
	public void onClick(ClickEvent event) {
		Button BtnSource = (Button)event.getSource();
//		System.out.println(BtnSource.getHTML());
		Element activeElem = Utils.findActiveElement();
		String htmlBtnSource =activeElem.getInnerHTML();// BtnSource.getHTML();
//		System.out.println(htmlBtnSource);
		boolean remButton = htmlBtnSource.length()>6 && htmlBtnSource.substring(0, 6).equals("Remove"); 
		boolean addButton = htmlBtnSource.length()>4 && htmlBtnSource.substring(0, 4).equals("Add ");

			if (BtnSource.equals(BtnRevAdd)){TblRev.addRow(0);addRev++;
				if(addButton)ServerRequestsFactory.updateField("AMA||InterfaceInfo>>ReviewersNumber", addRev+"");}
			if (BtnSource.equals(BtnRevRem) &&addRev>0 && (!remButton  || Window.confirm("Please,confirm deletion")))
				{TblRev.remRow(0);addRev--;
				ServerRequestsFactory.updateField("AMA||InterfaceInfo>>ReviewersNumber", addRev+"");}
			if (BtnSource.equals(BtnCitAdd)){TblCit.addRow(0);addCit++;
				if(addButton)ServerRequestsFactory.updateField("AMA||InterfaceInfo>>CitationsNumber", addCit+"");}
			if (BtnSource.equals(BtnCitRem)&&addCit>0 && (!remButton  || Window.confirm("Please,confirm deletion")))	
				{TblCit.remRow(0);addCit--;
				ServerRequestsFactory.updateField("AMA||InterfaceInfo>>CitationsNumber", addCit+"");}
			if (BtnSource.equals(Btn5Add))	{Tbl5.addRow(0);addPar++;
				if(addButton)ServerRequestsFactory.updateField("AMA||InterfaceInfo>>ParametersNumber", addPar+"");}
			if (BtnSource.equals(Btn5Rem)&&addPar>0 && (!remButton  || Window.confirm("Please,confirm deletion")))	
				{Tbl5.remRow(0);addPar--;
				ServerRequestsFactory.updateField("AMA||InterfaceInfo>>ParametersNumber", addPar+"");}
			
			if (BtnSource.equals(Btn8Add))			{addTC++;
													int mode = (indexPC==0)?-addTC:addTC;
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
													if(addButton)ServerRequestsFactory.updateField("AMA||InterfaceInfo>>TCNumber", addTC+"");}
			if (BtnSource.equals(Btn8Rem)&&addTC>0 && (!remButton  || Window.confirm("Please,confirm deletion")))	
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
													addTC--;
													ServerRequestsFactory.updateField("AMA||InterfaceInfo>>TCNumber", addTC+"");}
	//		if (BtnSource.equals(BtnAttAdd))			{
	//													((AMA2TableAttachments)DOCFormPanel.getWidget()).addRow(0);addAtt++;
	//													//((AMA2TableAttachments)WidList.get(170)).addRow(0);addAtt++;
	//													}
	//		if (BtnSource.equals(BtnAttRem)&&addAtt>0)	{
	//													//((AMA2TableAttachments)WidList.get(170)).remRow(0);addAtt--;
	//													((AMA2TableAttachments)DOCFormPanel.getWidget()).remRow(0);addAtt--;
	//													}
	//		if (BtnSource.equals(BtnLoad))				{
	//													((Hidden)((ComplexPanel)LoadFormPanel.getWidget()).getWidget(0)).setValue("loadAction");
	//													LoadFormPanel.submit();
	//													}
	//		if (BtnSource.equals(BtnSave))				{if (validate()){
	//														DOCFormPanel.setAction(GWT.getModuleBaseURL()+"AMA2XMLServer3");
	//														DOCFormPanel.submit();//System.out.println("SaveFormPanel.submit();");
	//													}
	//													}
	//		if (BtnSource.equals(BtnClear))				{
	//													((Hidden)((ComplexPanel)LoadFormPanel.getWidget()).getWidget(0)).setValue("clearAction");
	//													LoadFormPanel.submit();
	////													ClearFormPanel.submit();
	//													}
	//		if (BtnSource.equals(BtnDoc))				{if (validate()){
	//														DOCFormPanel.setAction(GWT.getModuleBaseURL()+"AMA2Server");
	//														DOCFormPanel.submit();
	//													}
	//													}
			if (BtnSource.equals(BtnTypeAdd)){Tbl15.addType();numberOfTypes++;
				if(addButton)ServerRequestsFactory.updateField("AMA||InterfaceInfo>>NumberOfTypes", numberOfTypes+"");}
			if (BtnSource.equals(BtnTypeRem)&&numberOfTypes>4 && (!remButton || Window.confirm("Please,confirm deletion"))){
				Tbl15.remType();numberOfTypes--;
				ServerRequestsFactory.updateField("AMA||InterfaceInfo>>NumberOfTypes", numberOfTypes+"");}
			if (BtnSource.equals(Btn13Add)&&addCol13<8)	{Tbl13.addColHisto();addCol13++;
				if(addButton)ServerRequestsFactory.updateField("AMA||InterfaceInfo>>AddedColumnsHisto", addCol13+"");}
			if (BtnSource.equals(Btn13Rem)&&addCol13>0 && (!remButton || Window.confirm("Please,confirm deletion"))){
				Tbl13.remColHisto();addCol13--;
				ServerRequestsFactory.updateField("AMA||InterfaceInfo>>AddedColumnsHisto", addCol13+"");}
			if (BtnSource.equals(Btn14Add)&&addCol14<8)	{Tbl14.addColHisto();addCol14++;
				if(addButton)ServerRequestsFactory.updateField("AMA||InterfaceInfo>>AddedColumnsAddlHisto", addCol14+"");}
			if (BtnSource.equals(Btn14Rem)&&addCol14>0 && (!remButton || Window.confirm("Please,confirm deletion"))){	
				Tbl14.remColHisto();addCol14--;
				ServerRequestsFactory.updateField("AMA||InterfaceInfo>>AddedColumnsAddlHisto", addCol14+"");
			}
//		}
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
				ServerRequestsFactory.updateField("AMA||InterfaceInfo>>IndexPC", indexPC+"");
			}
		}	
	}
	
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
		}		
	}
	
	protected void updateConstants(){
//		System.out.println("Trying to fetch constants.");
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>ReviewersNumber",addRev+"",new AMA_RequestCallback(AMA_ButtonName.REV_ADD));
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>CitationsNumber",addCit+"",new AMA_RequestCallback(AMA_ButtonName.CIT_ADD));	
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>ParametersNumber",addPar+"",new AMA_RequestCallback(AMA_ButtonName.TBL5_ADD));	
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>TCNumber",addTC+"",new AMA_RequestCallback(AMA_ButtonName.TBL8_ADD));	
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>IndexPC",indexPC+"",new AMA_RequestCallback(AMA_ButtonName.INDEX_PC_BOX));
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>NumberOfTypes",numberOfTypes+"",new AMA_RequestCallback(AMA_ButtonName.TYPE_ADD));	
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>AddedColumnsHisto",addCol13+"",new AMA_RequestCallback(AMA_ButtonName.TBL13_ADD_COL));	
		ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>AddedColumnsAddlHisto",addCol14+"",new AMA_RequestCallback(AMA_ButtonName.TBL14_ADD_COL));
		
		}
	
	private class AMA_RequestCallback implements RequestCallback {
		private AMA_UI.AMA_ButtonName Value;		
		private AMA_RequestCallback(AMA_UI.AMA_ButtonName valueOut){
			Value = valueOut;
		}
		@SuppressWarnings("incomplete-switch")
		@Override
		public void onResponseReceived(Request request, Response response) {
			String SvrResponse = response.getText();
			if (SvrResponse.equals("##RETRY##"))
				switch(Value){
				case REV_ADD			:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>ReviewersNumber",addRev+"",this);break;
				case CIT_ADD			:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>CitationsNumber",addCit+"",this);break;	
				case TBL5_ADD			:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>ParametersNumber",addPar+"",this);break;
				case TBL8_ADD			:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>TCNumber",addTC+"",this);break;
				case INDEX_PC_BOX		:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>IndexPC",indexPC+"",this);break;
				case TYPE_ADD			:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>NumberOfTypes",numberOfTypes+"",this);break;	
				case TBL13_ADD_COL		:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>AddedColumnsHisto",addCol13+"",this);break;
				case TBL14_ADD_COL		:ServersCommunication.callFetchServlet("AMA||InterfaceInfo>>AddedColumnsAddlHisto",addCol14+"",this);break;
				}
			else
			switch(Value){
			case REV_ADD			:setAddValues(addRev,Integer.parseInt(SvrResponse),BtnRevAdd,BtnRevRem);break;
			case CIT_ADD			:setAddValues(addCit,Integer.parseInt(SvrResponse),BtnCitAdd,BtnCitRem);break;
			case TBL5_ADD			:setAddValues(addPar,Integer.parseInt(SvrResponse),Btn5Add,Btn5Rem);break;
			case TBL8_ADD			:setAddValues(addTC,Integer.parseInt(SvrResponse),Btn8Add,Btn8Rem);break;
			case INDEX_PC_BOX		:if (indexPC!=Integer.parseInt(SvrResponse)) setIndexPC(1-indexPC);break;
			case TYPE_ADD			:setAddValues(numberOfTypes,Integer.parseInt(SvrResponse),BtnTypeAdd,BtnTypeRem);break;		
			case TBL13_ADD_COL		:setAddValues(addCol13,Integer.parseInt(SvrResponse),Btn13Add,Btn13Rem);break;
			case TBL14_ADD_COL		:setAddValues(addCol14,Integer.parseInt(SvrResponse),Btn14Add,Btn14Rem);break;			
			}			
		}
		@Override
		public void onError(Request request, Throwable exception) {
			Window.alert("Fail to receive the response from DERServer/FetchServelet\r\n"+
					exception.getMessage() + "\r\n" +
					exception.toString());			
		}		
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		Object source = event.getSource();
		if (source.equals(ExpoType1)){
			ExpoType2.setValue(ExpoType1.getValue());
			ServerRequestsFactory.updateField((DERTextBoxLength)ExpoType2.getValueBox());
		}else
		if  (source.equals(ExpoType2)){
			ExpoType1.setValue(ExpoType2.getValue());
			ServerRequestsFactory.updateField((DERTextBoxLength)ExpoType1.getValueBox());
		}else
		if (source.equals(TMat1)){
			TMat2.setValue(TMat1.getValue());ServerRequestsFactory.updateField((DERTextBoxReferenced)TMat2);
		}else
		if (source.equals(TMat2)){
			TMat1.setValue(TMat2.getValue());ServerRequestsFactory.updateField((DERTextBoxReferenced)TMat1);
		}else
		if (source.equals(Cas1)){
			Cas2.setValue(Cas1.getValue());ServerRequestsFactory.updateField((DERTextBoxReferenced)Cas2);
		}else
		if (source.equals(Cas2)){
			Cas1.setValue(Cas2.getValue());ServerRequestsFactory.updateField((DERTextBoxReferenced)Cas1);
		}else
		if (source.equals(Pur1)){
			Pur2.setValue(Pur1.getValue());ServerRequestsFactory.updateField((DERTextBoxReferenced)Pur2);
		}else
		if (source.equals(Pur2)){
			Pur1.setValue(Pur2.getValue());ServerRequestsFactory.updateField((DERTextBoxReferenced)Pur1);
		}
	}

	@Override
	public void onSelection(SelectionEvent<Suggestion> event) {
		DERAutoSuggestBox source = (DERAutoSuggestBox)event.getSource();
		if (source.equals(ExpoType1)){
			ExpoType2.setValue(ExpoType1.getValue());
			ServerRequestsFactory.updateField((DERTextBoxLength)ExpoType2.getValueBox());
		}else
			if (source.equals(ExpoType2)){
				ExpoType1.setValue(ExpoType2.getValue());
				ServerRequestsFactory.updateField((DERTextBoxLength)ExpoType1.getValueBox());
			}
	}	

}
