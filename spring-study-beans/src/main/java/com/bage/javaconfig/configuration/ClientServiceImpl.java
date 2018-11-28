package com.bage.javaconfig.configuration;

public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;
	
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public String toString() {
		return "ClientServiceImpl [clientDao=" + clientDao + "]";
	}

}
