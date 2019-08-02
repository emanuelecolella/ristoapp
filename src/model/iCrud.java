package model;

import java.sql.SQLException;
import model.Piatto;

public interface iCrud {

	public void inserimento(Piatto p) throws SQLException;
	
}
