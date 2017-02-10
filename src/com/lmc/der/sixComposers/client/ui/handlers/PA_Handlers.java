package com.lmc.der.sixComposers.client.ui.handlers;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.lmc.der.sixComposers.client.communication.ServersCommunication;
import com.lmc.der.sixComposers.client.entrypoint.Utils;
import com.lmc.der.sixComposers.client.ui.PA_UI;
import com.lmc.der.sixComposers.client.ui.PA_UI.MPA_UIButtonName;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable1;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable3;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable5;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable6ClChemistry;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable6Hormones;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable7;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable8;

public class PA_Handlers extends DER_Handlers {
	
	
	private int addRev,addCit,addObs,addOrg,addHor,addCCh,addObs8;
	private final char Gender;
	public final AMA2TableReviewers TblRev;
	public final AMA2TableCitations TblCit;
	public final MPATable1 Tbl1;
	//public	  MPATableCheckBoxes TblParChB,TblTisChB;
	public final MPATable8 TblObs2;
	public final MPATable3 Tbl3;
	public final MPATable5 TblOrg;
	public final MPATable6Hormones TblHor;
	public final MPATable6ClChemistry TblCCh;
	public final MPATable7 Tbl7;
	public final MPATable8 TblObs8;
	//public final AMA2TableAttachedFiles TblAttPic;
	public Button BtnRevAdd,BtnRevRem,BtnCitAdd,BtnCitRem,BtnObsAdd,BtnObsRem,
	BtnOrgAdd,BtnOrgRem,BtnHorAdd,BtnHorRem,BtnCChAdd,BtnCChRem,BtnObs8Add,BtnObs8Rem;
	
	public PA_Handlers(char GenChar){
		addRev=0;addCit=0;//addPar=0;addTis=0;
		addObs=0;addOrg=0;addHor=0;addCCh=0;addObs8=0;
		Gender = GenChar;
		TblRev = new AMA2TableReviewers();
		TblRev.setBasePath(GenChar+"PA||GeneralInfo>>TableReviewers");
		TblCit = new AMA2TableCitations();
		TblCit.setBasePath(GenChar+"PA||GeneralInfo>>TableCitations");
		Tbl1 = new MPATable1(Gender);
		TblObs2 = new MPATable8();
		TblObs2.setBasePath(GenChar+"PA||Results>>Toxicity>>Table2");
		Tbl3 = new MPATable3(Gender);
		TblOrg = new MPATable5(GenChar);
		TblHor = new MPATable6Hormones(GenChar);
		TblCCh = new MPATable6ClChemistry(GenChar);
		Tbl7   = new MPATable7(GenChar);
		TblObs8 = new MPATable8();
		TblObs8.setBasePath(GenChar+"PA||Results>>Histopathology2>>Table8");
//		TblAttPic = new AMA2TableAttachedFiles(1);

		BtnRevAdd	= new Button("Add Reviewer",	this);
		BtnRevRem	= new Button("Remove Reviewer",	this);
		BtnCitAdd	= new Button("Add Citation",	this);
		BtnCitRem	= new Button("Remove Citation",	this);	
		BtnObsAdd	= new Button("Add Observation",	this);
		BtnObsRem	= new Button("Remove Observation",	this);
		BtnOrgAdd	= new Button("Add Organ",	this);
		BtnOrgRem	= new Button("Remove Organ",	this);
		BtnHorAdd	= new Button("Add Parameter",	this);
		BtnHorRem	= new Button("Remove Parameter",	this);
		BtnCChAdd	= new Button("Add Parameter",	this);
		BtnCChRem	= new Button("Remove Parameter",	this);
		BtnObs8Add	= new Button("Add Observation",	this);
		BtnObs8Rem	= new Button("Remove Observation",	this);
		
	}	

	@Override
	public void onClick(ClickEvent event) {
		Button BtnSource = (Button)event.getSource();
		Element activeElem = Utils.findActiveElement();
		String htmlBtnSource =activeElem.getInnerHTML();
		boolean addButton = htmlBtnSource.length()>4 && htmlBtnSource.substring(0, 4).equals("Add ");
		
		if (BtnSource.equals(BtnRevAdd)){
			TblRev.addRow(0);addRev++;
			if(addButton)ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>ReviewersNumber", addRev+"");}
		if (BtnSource.equals(BtnRevRem)&&addRev>0){
			TblRev.remRow(0);addRev--;
			ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>ReviewersNumber", addRev+"");}
		if (BtnSource.equals(BtnCitAdd)){
			TblCit.addRow(0);addCit++;
			if(addButton)ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>CitationsNumber", addCit+"");}
		if (BtnSource.equals(BtnCitRem)&&addCit>0){
			TblCit.remRow(0);addCit--;
			ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>CitationsNumber", addCit+"");}
		if (BtnSource.equals(BtnObsAdd)){
			TblObs2.addRow(0);addObs++;
			if(addButton)ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>Observations", addObs+"");}
		if (BtnSource.equals(BtnObsRem)&&addObs>0){
			TblObs2.remRow(0);addObs--;
			ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>Observations", addObs+"");}
		if (BtnSource.equals(BtnOrgAdd)){
			TblOrg.addRow(0);addOrg++;
			if(addButton)ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>AddlOrgans", addOrg+"");}
		if (BtnSource.equals(BtnOrgRem)&&addOrg>0){
			TblOrg.remRow(0);addOrg--;
			ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>AddlOrgans", addOrg+"");}
		if (BtnSource.equals(BtnHorAdd)){
			TblHor.addRow(0);addHor++;
			if(addButton)ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>HormoneParameters", addHor+"");}
		if (BtnSource.equals(BtnHorRem)&&addHor>0){
			TblHor.remRow(0);addHor--;
			ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>HormoneParameters", addHor+"");}
		if (BtnSource.equals(BtnCChAdd)){
			TblCCh.addRow(0);addCCh++;
			if(addButton)ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>CChParameters", addCCh+"");}
		if (BtnSource.equals(BtnCChRem)&&addCCh>0){
			TblCCh.remRow(0);addCCh--;
			ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>CChParameters", addCCh+"");}
		if (BtnSource.equals(BtnObs8Add)){
			TblObs8.addRow(0);addObs8++;
			if(addButton)ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>HistopathologicalLesions", addObs8+"");}
		if (BtnSource.equals(BtnObs8Rem)&&addObs8>0){
			TblObs8.remRow(0);addObs8--;
			ServerRequestsFactory.updateField(Gender+"PA||InterfaceInfo>>HistopathologicalLesions", addObs8+"");}
	}

	protected void updateConstants(){	
		ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>ReviewersNumber",addRev+"",new PA_RequestCallback(MPA_UIButtonName.REV_ADD));
		ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>CitationsNumber",addCit+"",new PA_RequestCallback(MPA_UIButtonName.CIT_ADD));	
		ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>Observations",addObs+"",new PA_RequestCallback(MPA_UIButtonName.OBS_ADD));	
		ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>AddlOrgans",addOrg+"",new PA_RequestCallback(MPA_UIButtonName.ORG_ADD));	
		ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>HormoneParameters",addHor+"",new PA_RequestCallback(MPA_UIButtonName.HOR_ADD));
		ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>CChParameters",addCCh+"",new PA_RequestCallback(MPA_UIButtonName.CCH_ADD));	
		ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>HistopathologicalLesions",addObs8+"",new PA_RequestCallback(MPA_UIButtonName.OBS8_ADD));
		}
	
	private class PA_RequestCallback implements RequestCallback {
		private PA_UI.MPA_UIButtonName Value;		
		private PA_RequestCallback(PA_UI.MPA_UIButtonName valueOut){
			Value = valueOut;
		}
		@SuppressWarnings("incomplete-switch")
		@Override
		public void onResponseReceived(Request request, Response response) {
//			System.out.println("Button "+Value.toString());
			String SvrResponse = response.getText();
			if (SvrResponse.equals("##RETRY##"))
				switch(Value){
				case REV_ADD			:ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>ReviewersNumber",addRev+"",this);break;
				case CIT_ADD			:ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>CitationsNumber",addCit+"",this);break;	
				case OBS_ADD			:ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>Observations",addObs+"",this);break;
				case ORG_ADD			:ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>AddlOrgans",addOrg+"",this);break;
				case HOR_ADD			:ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>HormoneParameters",addHor+"",this);break;
				case CCH_ADD			:ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>CChParameters",addCCh+"",this);break;
				case OBS8_ADD			:ServersCommunication.callFetchServlet(Gender+"PA||InterfaceInfo>>HistopathologicalLesions",addObs8+"",this);break;
				
				}
			else
			switch(Value){
			case REV_ADD		:setAddValues(addRev,Integer.parseInt(SvrResponse),BtnRevAdd,BtnRevRem);break;
			case CIT_ADD		:setAddValues(addCit,Integer.parseInt(SvrResponse),BtnCitAdd,BtnCitRem);break;
			case OBS_ADD		:setAddValues(addObs,Integer.parseInt(SvrResponse),BtnObsAdd,BtnObsRem);break;
			case ORG_ADD		:setAddValues(addOrg,Integer.parseInt(SvrResponse),BtnOrgAdd,BtnOrgRem);break;
			case HOR_ADD		:setAddValues(addHor,Integer.parseInt(SvrResponse),BtnHorAdd,BtnHorRem);break;	
			case CCH_ADD		:setAddValues(addCCh,Integer.parseInt(SvrResponse),BtnCChAdd,BtnCChRem);break;		
			case OBS8_ADD		:setAddValues(addObs8,Integer.parseInt(SvrResponse),BtnObs8Add,BtnObs8Rem);break;	
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
