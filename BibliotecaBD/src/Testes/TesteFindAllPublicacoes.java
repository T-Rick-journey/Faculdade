package Testes;

import dao.PublicacaoDAO;

public class TesteFindAllPublicacoes {
    
    public static void main(String[] args){
        testFindAllPublicacaoes();
    }

    public static void testFindAllPublicacaoes(){
        PublicacaoDAO dao = new PublicacaoDAO();
        dao.findAll().forEach(publicacao -> {
            System.out.println("ID: " + publicacao.getId());
            System.out.println("Título: " + publicacao.getTitulo());
            System.out.println("Autor: " + publicacao.getAutor());
            System.out.println("Ano de Publicação: " + publicacao.getAno());
            System.out.println("Tipo: " + publicacao.getTipo());
            System.out.println("-----------------------------");
        });
    }
}
