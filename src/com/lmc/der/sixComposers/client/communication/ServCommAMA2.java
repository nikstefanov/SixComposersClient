package com.lmc.der.sixComposers.client.communication;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.lmc.der.sixComposers.client.entrypoint.IntegerSC;
import com.lmc.der.sixComposers.client.ui.AMA_UI;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

//Not finished not in use.
public class ServCommAMA2 implements RequestCallback{
	
	private final String			Path;
	private final AMA_UI.AMA_ButtonName		Constant;
	private final IntegerSC			AddValue;
	private final AMA2FlexTable[]	TableArray;
	private final int			DefaultVal;
	
	
	public ServCommAMA2(String DERName,AMA_UI.AMA_ButtonName constant,IntegerSC addValue,AMA2FlexTable... tables) {		
		Constant = constant;
		AddValue = addValue;
		TableArray = tables;
		
		switch(Constant){
		case REV_ADD			:Path = DERName + "||InterfaceInfo>>ReviewersNumber";DefaultVal=0;break;
		case CIT_ADD			:Path = DERName + "||InterfaceInfo>>CitationsNumber";DefaultVal=0;break;	
		case TBL5_ADD			:Path = DERName + "||InterfaceInfo>>ParametersNumber";DefaultVal=0;break;
		case TBL8_ADD			:Path = DERName + "||InterfaceInfo>>TCNumber";DefaultVal=0;break;
		case INDEX_PC_BOX		:Path = DERName + "||InterfaceInfo>>IndexPC";DefaultVal=1;break;
		case TYPE_ADD			:Path = DERName + "||InterfaceInfo>>NumberOfTypes";DefaultVal=4;break;
		default					:Path = DERName;DefaultVal=0;break;
		}
		
		callFetchServlet();
	}
	
	private final void callFetchServlet(){
		ServCommFSTRA2.FetchRequestBuilder.setRequestData(Path + "#DEFAULT_VALUE#" + DefaultVal);
		ServCommFSTRA2.FetchRequestBuilder.setCallback(this);
		try {
			ServCommFSTRA2.FetchRequestBuilder.send();			
		}catch (RequestException e) {
			Window.alert("Failed to send the request: " + e.getMessage());
		}
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		String svrResponse = response.getText();
		if (svrResponse.equals("##RETRY##")) 
			callFetchServlet();
		else{
			AddValue.set(Integer.parseInt(svrResponse));
			int start = DefaultVal,end = AddValue.get();
			if (Constant==AMA_UI.AMA_ButtonName.INDEX_PC_BOX && !AddValue.isPositive()){
				start = AddValue.get();end = DefaultVal;
			}			
			for(int i = start; i < end; i++)
				for (AMA2FlexTable tbl:TableArray)
					switch(Constant){
					case REV_ADD	:
					case CIT_ADD	:
					case TBL5_ADD	:
					case INDEX_PC_BOX:tbl.addRow(0);break;
					case TBL8_ADD	:break;
					case TYPE_ADD	:break;
					default			:
					}
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert("Fail to receive the response from DERServer/FetchServelet\r\n"+
				"Requested by ServCommAMA2\r\n"+
				exception.getMessage() + "\r\n" +
				exception.toString());		
		
	}

}
