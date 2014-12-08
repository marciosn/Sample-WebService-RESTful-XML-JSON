package ws.restful.persistencia;

import interfaces.AcessaBancoDeDados;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import ws.restful.dao.ClienteJPADAO;
import ws.restful.models.Cliente;

public class AcessaBanco implements AcessaBancoDeDados{
	
	private ClienteJPADAO clienteDAO;
	private List<Cliente> clientes;
	private Cliente cliente;
	
	public AcessaBanco() {
		clienteDAO = new ClienteJPADAO();
	}
	
	public void inseriClienteBanco(Cliente cliente){
		try {
			clienteDAO.beginTransaction();
			clienteDAO.save(cliente);
			clienteDAO.commit();
		} catch (Exception e) {
			clienteDAO.rollback();
			e.printStackTrace();
		}
		
	}
	public List<Cliente> getClientes(){
		clientes = new ArrayList<Cliente>();
		try {
			clientes = clienteDAO.find();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(arrayToXml(clientes));
		return clientes; 
	}
	
	public Cliente getClienteById(int id){
		try {
			cliente = clienteDAO.find(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public void deletarCliente(int id){
		System.out.println("Apagar cliente de id " + id);
		try {
			clienteDAO.beginTransaction();
			clienteDAO.delete(getClienteById(id));
			clienteDAO.commit();
		} catch (Exception e) {
			clienteDAO.rollback();
			e.printStackTrace();
		}
	}

	public Object arrayToXml(List<Cliente> clientes){
		XStream stream = new XStream();
		return stream.toXML(clientes);
	}
}
