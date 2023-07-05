package g2.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g2.entities.Produto;
import g2.services.GenericService;
import g2.services.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto> {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        super();
        this.produtoService = produtoService;
    }

    @Override
    GenericService<Produto> getService() {
        return produtoService;
    }

}