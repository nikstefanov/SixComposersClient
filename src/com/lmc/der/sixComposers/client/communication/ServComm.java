package com.lmc.der.sixComposers.client.communication;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.lmc.der.sixComposers.client.ui.handlers.DER_Handlers;

public class ServComm {

	
		private final RequestBuilder FetchRequestBuilder;
		
		public ServComm()
		{
			FetchRequestBuilder = new RequestBuilder(RequestBuilder.POST , "/DERServer/" + "FetchServlet");		
		}
		
		public final void callFetchServlet(String path,String defaultValue,RequestCallback callbackObj){
			FetchRequestBuilder.setRequestData(path + "#DEFAULT_VALUE#" + defaultValue);
			FetchRequestBuilder.setCallback(callbackObj);
			try {
				FetchRequestBuilder.send();			
			}catch (RequestException e) {
				Window.alert("Failed to send the request: " + e.getMessage());
			}	
//			return FetchResult;
		}
		
		public final void callFetchServlet(TableRequestCallback callbackObj){
			callFetchServlet(callbackObj.Path,callbackObj.AddValue+"",callbackObj);
		}
		/*
		public static final int getFieldValueInt(String path,int defaultValue){
			String NumberStr = getFieldValueString(path,defaultValue+"");
			System.out.println("NumberStr: "+NumberStr);
			return Integer.parseInt(NumberStr);
		}
		
		private static class FetchRequestCallback implements RequestCallback{
			@Override public void onResponseReceived(Request request, Response response) {
				FetchResult = response.getText();
				System.out.println("FetchResult: "+FetchResult);
			}
			@Override public void onError(Request request, Throwable exception) {
				Window.alert("Fail to receive the response from DERServer/FetchServelet\r\n"+
							exception.getMessage() + "\r\n" +
							exception.toString());
				FetchResult = null;
			}		
		}*/
		
		public class TableRequestCallback implements RequestCallback{
			
			private final String	Path;
			private final int		AddValue;
			private final Button	AddButton,RemoveButton;
			
			public TableRequestCallback(String path,int addNumber,Button addButton,Button remButton){
				Path = path;AddValue = addNumber;AddButton = addButton;RemoveButton = remButton;
			}

			@Override
			public void onResponseReceived(Request request, Response response) {
				String svrResponse = response.getText();
				if (svrResponse.equals("##RETRY##")) 
					callFetchServlet(this);
				else{
					System.out.println(Path+" "+svrResponse);
					DER_Handlers.setAddValues(AddValue,Integer.parseInt(svrResponse),AddButton,RemoveButton);					
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
