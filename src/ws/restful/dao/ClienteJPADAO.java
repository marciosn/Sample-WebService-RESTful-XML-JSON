package ws.restful.dao;

import ws.restful.models.Cliente;

public class ClienteJPADAO extends GenericJPADAO<Cliente> implements ClienteDAO{
	
	public ClienteJPADAO() {
		this.persistentClass = Cliente.class;
	}

}
