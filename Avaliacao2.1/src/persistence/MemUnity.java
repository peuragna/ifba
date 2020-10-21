package persistence;

import java.util.ArrayList;
import monitorsystem.*;

public class MemUnity implements UnidadeDAO {
	private ArrayList<UnidadeMonitora> unidades = new ArrayList<UnidadeMonitora>();

	@Override
	public void salvar(UnidadeMonitora unidade) {
		this.unidades.add(unidade);
	};

	@Override
	public UnidadeMonitora buscar(String id) {
		for(UnidadeMonitora unidade : this.unidades)
			if(unidade.getId().equals(id))
				return unidade;
		
		return null;
	};

	@Override
	public void moveTo(UnidadeMonitora unidade, float x, float y) {
		unidade.moveTo(x, y);
	};

	@Override
	public ArrayList<UnidadeMonitora> getColecaoRestrita(Equipamentos eqp) {
		ArrayList<UnidadeMonitora> nova = new ArrayList<UnidadeMonitora>();
    	
    	for(UnidadeMonitora u : this.unidades)
    		if(eqp.isContido(u.getConfiguracao()))
    			nova.add(u);
    		
    	return nova;
	};
}
 	