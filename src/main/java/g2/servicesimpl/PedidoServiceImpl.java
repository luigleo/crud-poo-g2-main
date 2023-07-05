package g2.servicesimpl;

import org.springframework.stereotype.Service;

import g2.entities.Pedido;
import g2.repositories.GenericRepository;
import g2.repositories.PedidoRepository;
import g2.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        super();
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public GenericRepository<Pedido> getRepository() {
        return pedidoRepository;
    }

}
