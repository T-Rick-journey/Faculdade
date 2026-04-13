package exemplo1.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FabricaConexao {
	private static final String UNIDADE_PERSISTENCIA = "atividade";

	public static EntityManager getConexao() {
	   return	Persistence
		.createEntityManagerFactory(UNIDADE_PERSISTENCIA)
		.createEntityManager();		
	}

}
