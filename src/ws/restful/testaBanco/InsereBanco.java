package ws.restful.testaBanco;

import java.util.List;

import ws.restful.dao.ClienteJPADAO;
import ws.restful.models.Cliente;
import ws.restful.persistencia.AcessaBanco;

public class InsereBanco {
	
	static ClienteJPADAO clienteDAO = new ClienteJPADAO();
	static AcessaBanco acessaBanco = new AcessaBanco();
	
	
	public static void main(String[] args) {
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		Cliente c3 = new Cliente();
		
		c1.setNome("Carlos Eduardo");
		c1.setNomeDoPai("nome do pai");
		c1.setNomeDaMae("nome da mae");
		c1.setDataNascimento("01/01/1900");
		c1.setCpf("12457744555");
		c1.setCidade("Senador Pompeu");
		c1.setEndereco("Jose cardoso");
		c1.setEstado("Ceara");
		c1.setEstadoCivil("Solteiro");
		
		c2.setNome("Marcinho");
		c2.setNomeDoPai("nome do pai");
		c2.setNomeDaMae("nome da mae");
		c2.setDataNascimento("01/01/1900");
		c2.setCpf("12457744555");
		c2.setCidade("Fortaleza");
		c2.setEndereco("Jose cardoso");
		c2.setEstado("Ceara");
		c2.setEstadoCivil("Solteiro");
		
		c3.setNome("katy");
		c3.setNomeDoPai("nome do pai");
		c3.setNomeDaMae("nome da mae");
		c3.setDataNascimento("01/01/1900");
		c3.setCpf("12457744555");
		c3.setCidade("Quixeramobim");
		c3.setEndereco("Jose cardoso");
		c3.setEstado("Ceara");
		c3.setEstadoCivil("Solteiro");
		
		salvar(c1);
		salvar(c2);
		salvar(c3);
		
		for(Cliente c : acessaBanco.getClientes()){
			System.out.println(c.getNome());
		}
	}

	public static void salvar(Cliente c){
		try {
			clienteDAO.beginTransaction();
			clienteDAO.save(c);
			clienteDAO.commit();
		} catch (Exception e) {
			clienteDAO.rollback();
			e.printStackTrace();
		}
	}
	
	public static void exibirClientesBanco(){
		List<Cliente> clientes = clienteDAO.find();
		for(Cliente c : clientes){
			System.out.println("Nome "+ c.getNome());
			System.out.println("Nome mae "+c.getNomeDaMae());
			System.out.println("Nome pai "+c.getNomeDoPai());
			System.out.println("Nascimento "+c.getDataNascimento());
			System.out.println("Cidade "+c.getCidade());
			System.out.println("CPF "+c.getCpf());
			System.out.println("Endereco "+c.getEndereco());
			System.out.println("Estado civil "+c.getEstadoCivil());
			System.out.println("Estado "+c.getEstado());
		}
	}
}
