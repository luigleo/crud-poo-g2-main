package g2.servicesimpl;

import org.springframework.stereotype.Service;

import g2.entities.Produto;
import g2.repositories.GenericRepository;
import g2.repositories.ProdutoRepository;
import g2.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        super();
        this.produtoRepository = produtoRepository;
    }

    @Override
    public GenericRepository<Produto> getRepository() {
        return produtoRepository;
    }

}
