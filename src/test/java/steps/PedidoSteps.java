package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import peppa.hamburgueria.CardapioService;
import peppa.hamburgueria.PedidoService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
//Test
public class PedidoSteps {
    private CardapioService cardapioService;
    private PedidoService pedidoService;
    private double valorTotal;
    private int tempoEstimado;
    private String mensagemErro;
    private boolean pedidoAceito;

    @Dado("que o cardápio contém os itens:")
    public void que_o_cardapio_contem_os_itens(DataTable dataTable) {
        cardapioService = new CardapioService();
        pedidoService = new PedidoService(cardapioService);

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : rows) {
                String nome = row.get("item");
                double precoReais = Double.parseDouble(row.get("preco"));
                double precoCentavos = precoReais * 100;

                cardapioService.cadastrarItem(nome, precoCentavos);
            }

    }

    @Quando("^eu faço um pedido de (\\d+) (?=[\\w-]*-)([\\w-]+)$")
    public void eu_faco_um_pedido_de_quantidade_item(int quantidade, String item) {
        try {
            valorTotal = pedidoService.calcularTotal(item, quantidade);
            pedidoAceito = true;
            mensagemErro = null;
        } catch (IllegalArgumentException e) {
            pedidoAceito = false;
            mensagemErro = e.getMessage();
        }
    }

    @Quando("eu faço um pedido de {int} itens")
    public void eu_faco_um_pedido_de_itens(int quantidade) {
        tempoEstimado = pedidoService.calcularTempoEstimado(quantidade);
    }

    @Quando("aplico um desconto de {int} por cento")
    public void aplico_um_desconto_de_por_cento(int percentual) {
        double desconto = (valorTotal * percentual) / 100.0;
        valorTotal = valorTotal - desconto;
        // NÃO ARREDONDAR — valorTotal continua em centavos
    }

    @Então("o valor total deve ser {double}")
    public void o_valor_total_deve_ser(double valorEsperado) {
        assertEquals(valorEsperado, valorTotal, 0.01);
    }

    @Então("o pedido deve ser aceito")
    public void o_pedido_deve_ser_aceito() {
        assertTrue(pedidoAceito, "O pedido deveria ter sido aceito");
    }
    
    @Então("o pedido deve ser rejeitado")
    public void o_pedido_deve_ser_rejeitado() {
        assertFalse(pedidoAceito, "O pedido deveria ter sido rejeitado");
    }

    @Então("a mensagem de erro deve ser {string}")
    public void a_mensagem_de_erro_deve_ser(String mensagemEsperada) {
        assertEquals(mensagemEsperada, mensagemErro);
    }

    @Então("o tempo estimado deve ser {int} minutos")
    public void o_tempo_estimado_deve_ser(int minutosEsperados) {
        assertEquals(minutosEsperados, tempoEstimado);
    }
}
