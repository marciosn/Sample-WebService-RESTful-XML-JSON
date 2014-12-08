package interfaces;

import java.util.List;

import ws.restful.models.Cliente;

public interface AcessaBancoDeDados {
	
	public void inseriClienteBanco(Cliente cliente);
	public void deletarCliente(int id);
	public List<Cliente> getClientes();
	public Cliente getClienteById(int id);

}
