package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import monitorsystem.*;

public interface UnidadeDAO {
	
	public void salvar(UnidadeMonitora unidade) throws SQLException, Exception;
	public UnidadeMonitora buscar(String id) throws SQLException;
	public void moveTo(UnidadeMonitora unidade, float x, float y) throws SQLException;
	public ArrayList<UnidadeMonitora> getColecaoRestrita(Equipamentos eqp) throws SQLException;
};
