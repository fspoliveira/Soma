package br.com.fiap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class SomaServices {
	
	private static final String NAMEESPACE = "http://jaxws.fiap.com/";
	private static final String METHOD_NAME = "soma";
	//localhost para android nao � 127.0.0.1 
	private static final String URL = "http://10.0.2.2:8080/calculo";
	//private static final String URL = "http://127.0.0.1:9000/calculo";
	private static final String SOAP_ACTION = "CalculoImplService";

	public int soma(SomaTO somaTO){
		
		Log.w("Minha app", "Metodo busca Endereço");
		
		int resultado = 0;
		
		SoapObject soap = new SoapObject (NAMEESPACE, METHOD_NAME);
		soap.addProperty("arg0", somaTO.x);
		soap.addProperty("arg1", somaTO.y);
		
		SoapSerializationEnvelope envelope =
			new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		envelope.setOutputSoapObject(soap);
		
		HttpTransportSE transport = new HttpTransportSE(URL);
		
		try {
			transport.call(SOAP_ACTION, envelope);
			SoapPrimitive msg = (SoapPrimitive) envelope.getResponse();
			resultado = Integer.parseInt(msg.toString());
			Log.w("Minha app", "Invocou Web Service");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}	
		
		return resultado;
	}
}
