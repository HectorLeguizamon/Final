package com.accenture.crud.ws;

import javax.xml.ws.Endpoint;

public class ServerApp {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/StudentCrudWS", new StudentCrudWS());
		System.out.println("WebService StudentCrud Started");
	}

}
// StudentCrudWS
//http://localhost:8888/StudentCrudWS?wsdl