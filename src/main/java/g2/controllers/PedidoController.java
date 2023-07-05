package g2.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g2.entities.Pedido;
import g2.services.GenericService;
import g2.services.PedidoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedidos")
public class PedidoController extends GenericController<Pedido> {

    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        super();
        this.pedidoService = pedidoService;
    }

    @Override
    GenericService<Pedido> getService() {
        return pedidoService;
    }

}