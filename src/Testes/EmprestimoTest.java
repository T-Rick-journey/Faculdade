package Testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class EmprestimoTest {

    private static EntityManager entityManager;

    public static void main(String[] args) {
        testConexão();
    }

    public static void testConexão() {
        try {
            System.out.println("Testando Conexão com o Banco de Dados");

            entityManager = Persistence.createEntityManagerFactory("atividade").createEntityManager();

            if (entityManager != null && entityManager.isOpen()) {
                System.out.println("Conexão com o banco Ok");
            } else {
                System.out.println("Falha conectar ao banco");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
                System.out.println("✓ EntityManager fechado\n");
            }
        }
    }

}
