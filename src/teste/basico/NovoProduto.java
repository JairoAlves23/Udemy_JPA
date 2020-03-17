package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		Produto prod1 = new Produto("Mouse", 8.95);
		//dao.abrirT().incluirT(prod1).fecharT().Fechar();
		dao.incluirAtomico(prod1);
		
	}
}
