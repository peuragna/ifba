package monitorsystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import monitorsystem.dto.UnidadeDTO;
import persistence.*;

public class Sistema {
    UnidadeDAO data;	
	
    public Sistema(UnidadeDAO data) {
    	this.setPersistencia(data);
    };
    
    public String monitorar(float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
        Equipamentos eqp = new Equipamentos(video, termometro, co2, ch4);
        UnidadeMonitora correta = getMaisProxima(data.getColecaoRestrita(eqp), abcissa, ordenada);
        
        data.moveTo(correta, abcissa, ordenada);
        return correta.getId();
    };
    
    private UnidadeMonitora getMaisProxima(ArrayList<UnidadeMonitora> lista, float x, float y) throws Exception {
    	/*float dMin = lista.get(0).getDistancia(x, y);
    	UnidadeMonitora item = null;
          
    	for(UnidadeMonitora u : lista)
    		if(u.getDistancia(x, y) <= dMin) {
    			item = u;
          		dMin = item.getDistancia(x, y);
          	}
    	return item;*/
    	Collections.sort(lista, new OrderUnidadeByDistancia(x, y)); 
    	UnidadeMonitora unidade = lista.get(0);
    	
    	return unidade;
  	};
    
    public void addUnidadeEuclidiana(String id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
    	Equipamentos eqp = new Equipamentos(video, termometro, co2, ch4);
    	
    	UnidadeEuclidiana nova = new UnidadeEuclidiana(id, eqp, abcissa, ordenada);
    	data.salvar(nova);
    };
    
    public void addUnidadeManhattan(String id, float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
    	Equipamentos eqp = new Equipamentos(video, termometro, co2, ch4);
    	
    	UnidadeManhattan nova = new UnidadeManhattan(id, eqp, abcissa, ordenada);
    	data.salvar(nova);
    };
    
    public UnidadeDTO getPosByID(String id) throws SQLException {
    	UnidadeMonitora unidade = this.data.buscar(id); 
    	if(unidade instanceof UnidadeEuclidiana)
    		return new UnidadeDTO(unidade.getId(), unidade.getConfiguracao(), unidade.getX(), unidade.getY(), 0);
    	else 
    		return new UnidadeDTO(unidade.getId(), unidade.getConfiguracao(), unidade.getX(), unidade.getY(), 1);
    };

	public void setPersistencia(UnidadeDAO persistencia) {
		this.data = persistencia;
	};
}
