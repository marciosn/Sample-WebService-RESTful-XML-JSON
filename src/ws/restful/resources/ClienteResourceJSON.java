package ws.restful.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ws.restful.models.Cliente;
import ws.restful.persistencia.AcessaBanco;

@Path("/clientesJson")
public class ClienteResourceJSON {
	
	private AcessaBanco acessBD;
	
	public ClienteResourceJSON() {
		acessBD = new AcessaBanco();
	}
	
	@GET
	@Produces("application/json")
	public List<Cliente> getClientes(){
		return acessBD.getClientes();
	}
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Cliente getClienteByID(@PathParam("id") int id){
		return acessBD.getClienteById(id);
	}
	
	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	public String inseriCliente(Cliente cliente){
		acessBD.inseriClienteBanco(cliente);
		
		return cliente.getNome() + " inserido com sucesso";
	}
	
	@Path("{id}")
	@PUT
	@Consumes("text/xml")
	@Produces("text/plain")
	public String atualizarCliente(Cliente cliente, @PathParam("id") int id){
		Cliente old = acessBD.getClienteById(id);
		
		old.setNome(cliente.getNome());
		old.setNomeDaMae(cliente.getNomeDaMae());
		old.setNomeDoPai(cliente.getNomeDoPai());
		old.setDataNascimento(cliente.getDataNascimento());
		old.setEndereco(cliente.getEndereco());
		old.setEstado(cliente.getEstado());
		old.setCidade(cliente.getCidade());
		old.setCpf(cliente.getCpf());
		old.setEstadoCivil(cliente.getEstadoCivil());
		
		acessBD.inseriClienteBanco(old);
		
		return old.getNome() + " atualizado com sucesso";
	}
	
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removerCliente(@PathParam("id") int id){
		acessBD.deletarCliente(id);
		return "Cliente removido";
	}

}
