package ws.restful.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ws.restful.models.Banda;

import com.google.gson.Gson;

@Path("/bandas")
public class BandaResource {
	static private Map<Integer, Banda> bandasMap;
	
	static{
		bandasMap = new HashMap<Integer, Banda>();
		
		Banda b1 = new Banda();
		
		b1.setNome("Led Zeppelin");
		b1.setId(1);
		b1.setAnoFormacao(1968);
		
		bandasMap.put(b1.getId(), b1);
		
		Banda b2 = new Banda();
		b2.setNome("AC/DC");
		b2.setId(2);
		b2.setAnoFormacao(1968);
		
		bandasMap.put(b2.getId(), b2);
		
		Banda b3 = new Banda();
		b3.setNome("Guns'n roses");
		b3.setId(3);
		b3.setAnoFormacao(1980);
		
		bandasMap.put(b3.getId(), b3);
		
		Banda b4 = new Banda();
		b4.setNome("Bon Jovi");
		b4.setId(4);
		b4.setAnoFormacao(1970);
		
		bandasMap.put(b4.getId(), b4);
	}
	
	@GET
	@Produces("text/xml")
	public List<Banda> getBandas(){
		return new ArrayList<Banda>(bandasMap.values());
	}
	@Path("{id}")
	@GET
	@Produces("text/xml")
	public Banda getBanda(@PathParam("id") int id){
		return bandasMap.get(id);
	}
	
	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	public String adicionaBanda(Banda banda) {
		banda.setId(bandasMap.size() + 1);
		bandasMap.put(banda.getId(), banda);
		return banda.getNome() + " adicionado.";
	}

	@Path("{id}")
	@PUT
	@Consumes("text/xml")
	@Produces("text/plain")
	public String atualizaBanda(Banda banda, @PathParam("id") int id) {
		Banda atual = bandasMap.get(id);
		atual.setNome(banda.getNome());
		atual.setAnoFormacao(banda.getAnoFormacao());
		return banda.getNome() + " atualizada.";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeBanda(@PathParam("id") int id) {
		bandasMap.remove(id);
		return "Banda removida.";
	}
	
	public String adicionaBanda(String banda) {
		Gson gson = new Gson();
		Banda b = gson.fromJson(banda, Banda.class);
		b.setId(bandasMap.size() + 1);
		bandasMap.put(b.getId(), b);
		return b.getNome() + " adicionado.";
	}
	
}
