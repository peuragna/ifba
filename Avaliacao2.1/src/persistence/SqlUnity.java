package persistence;

import monitorsystem.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlUnity implements UnidadeDAO {
	private static final int EU = 0;
	private static final int MAN = 1;
	
	public static final String DRIVE = "org.hsqldb.jdbc.JDBCDriver";
	public static final String URI = "jdbc:hsqldb:hsql://localhost/";
	public static final String USER = "SA";
	public static final String PWD = "";
	
	private static String SAVE_SQL = "INSERT INTO UNIDADE(ID, X, Y, V, T, CO, CH, TIPO)\r\n" + 
            " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static String RECOVERY_BY_ID = "SELECT ID, X, Y, V, T, CO, CH, TIPO\r\n" + 
	     	   " FROM UNIDADE \r\n" +
	     	   " WHERE ID = ? \r\n";	
	private static String RECOVERY_BY_CONFIG = "SELECT ID, X, Y, V, T, CO, CH, TIPO\r\n" +
				" FROM UNIDADE \r\n" +
				" WHERE (V = ? OR V = ?) AND (T = ? OR T = ?) AND (CO = ? OR CO = ?) AND (CH = ? OR CH = ?) \r\n";	
	private static String UPDATE = "UPDATE UNIDADE \r\n" +
				" SET X = ?, Y = ? \r\n" +
				" WHERE ID = ? \r\n";

	@SuppressWarnings("deprecation")
	public SqlUnity() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DriverManager.registerDriver((Driver) Class.forName(SqlUnity.DRIVE).newInstance());
	};
	
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URI, USER, PWD);
		return conn;
	};
	
	public void salvarEuclidiana(UnidadeMonitora unidade) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SqlUnity.SAVE_SQL);
		ps.setString(1, unidade.getId());
		ps.setDouble(2, unidade.getX());
		ps.setDouble(3, unidade.getY());
		ps.setBoolean(4, unidade.getConfiguracao().isVideo());
		ps.setBoolean(5, unidade.getConfiguracao().isTermometro());
		ps.setBoolean(6, unidade.getConfiguracao().isCo2());
		ps.setBoolean(7, unidade.getConfiguracao().isCh4());
		ps.setInt(8, SqlUnity.EU);
		ps.executeUpdate();
	};
	
	public void salvarManhattan(UnidadeMonitora unidade) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SqlUnity.SAVE_SQL);
		ps.setString(1, unidade.getId());
		ps.setDouble(2, unidade.getX());
		ps.setDouble(3, unidade.getY());
		ps.setBoolean(4, unidade.getConfiguracao().isVideo());
		ps.setBoolean(5, unidade.getConfiguracao().isTermometro());
		ps.setBoolean(6, unidade.getConfiguracao().isCo2());
		ps.setBoolean(7, unidade.getConfiguracao().isCh4());
		ps.setInt(8, SqlUnity.MAN);
		ps.executeUpdate();
	};

	@Override
	public UnidadeMonitora buscar(String id) throws SQLException {
		UnidadeMonitora unidade = null;
		
		PreparedStatement ps = this.getConnection().prepareStatement(SqlUnity.RECOVERY_BY_ID);
		ps.setString(1, id);
		ResultSet rSet = ps.executeQuery();
		
		if(!rSet.next())
			throw new SQLException();
		int tipo = rSet.getInt("TIPO");
		if(tipo == SqlUnity.EU) {
			unidade = new UnidadeEuclidiana(rSet.getString("ID"), new Equipamentos(rSet.getBoolean("V"), rSet.getBoolean("T"), rSet.getBoolean("CO"), rSet.getBoolean("CH")), rSet.getFloat("X"), rSet.getFloat("Y"));	
		}else if(tipo == SqlUnity.MAN) unidade = new UnidadeManhattan(rSet.getString("ID"), new Equipamentos(rSet.getBoolean("V"), rSet.getBoolean("T"), rSet.getBoolean("CO"), rSet.getBoolean("CH")), rSet.getFloat("X"), rSet.getFloat("Y"));
		
		return unidade;
	};

	@Override
	public void salvar(UnidadeMonitora unidade) throws Exception {
		if(unidade instanceof UnidadeEuclidiana) {
			this.salvarEuclidiana(unidade);
		}else if(unidade instanceof UnidadeManhattan) {
			this.salvarManhattan(unidade);
		}
	};

	@Override
	public void moveTo(UnidadeMonitora unidade, float x, float y) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SqlUnity.UPDATE);
		ps.setDouble(1, x);
		ps.setDouble(2, y);
		ps.setString(3, unidade.getId());
		ps.executeUpdate();
	};

	@Override
	public ArrayList<UnidadeMonitora> getColecaoRestrita(Equipamentos eqp) throws SQLException {

		ArrayList<UnidadeMonitora> unidades = new ArrayList<UnidadeMonitora>();
		UnidadeMonitora unidade = null;
		PreparedStatement ps = this.getConnection().prepareStatement(SqlUnity.RECOVERY_BY_CONFIG);
		boolean V = eqp.isVideo();
		boolean T = eqp.isTermometro();
		boolean CO = eqp.isCo2();
		boolean CH = eqp.isCh4();
		
		if(!V) {
			ps.setBoolean(1, true);
			ps.setBoolean(2, false);
		}
		else {
			ps.setBoolean(1, true);
			ps.setBoolean(2, true);
		}
		
		if(!T) {
			ps.setBoolean(3, true);
			ps.setBoolean(4, false);
		}
		else {
			ps.setBoolean(3, true);
			ps.setBoolean(4, true);
		}
		
		if(!CO) {
			ps.setBoolean(5, true);
			ps.setBoolean(6, false);
		}
		else {
			ps.setBoolean(5, true);
			ps.setBoolean(6, true);
		}
		
		if(!CH) {
			ps.setBoolean(7, true);
			ps.setBoolean(8, false);
		}
		else {
			ps.setBoolean(7, true);
			ps.setBoolean(8, true);
		}
		
		ResultSet rSet = ps.executeQuery();
		while(rSet.next()) {
			unidade = null;
			int tipo = rSet.getInt("TIPO");
			if(tipo == SqlUnity.EU)
				unidade = new UnidadeEuclidiana(rSet.getString("ID"), new Equipamentos(rSet.getBoolean("V"), rSet.getBoolean("T"), rSet.getBoolean("CO"), rSet.getBoolean("CH")), rSet.getFloat("X"), rSet.getFloat("Y"));
			else if(tipo == SqlUnity.MAN)
				unidade = new UnidadeManhattan(rSet.getString("ID"), new Equipamentos(rSet.getBoolean("V"), rSet.getBoolean("T"), rSet.getBoolean("CO"), rSet.getBoolean("CH")), rSet.getFloat("X"), rSet.getFloat("Y"));
			
			unidades.add(unidade);
		}
		return unidades;
	};
}

