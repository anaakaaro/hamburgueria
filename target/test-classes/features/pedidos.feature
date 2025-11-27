# language: pt
@hamburgueria
Funcionalidade: Pedidos na hamburgueria Peppa Lanches
  Para realizar pedidos corretos
  Como cliente
  Eu quero saber se o item pode ser pedido, o valor total e o tempo estimado

  Contexto:
    Dado que o cardápio contém os itens:
      | item         | preco |
      | x-bacon      | 25.00 |
      | x-salada     | 22.00 |
      | batata frita | 12.00 |

  @feliz
  Cenário: Pedido simples de item existente
  ...

  @inexistente
  Cenário: Pedido de item inexistente
  ...

  @quantidade
  Cenário: Pedido com quantidade inválida
  ...

  @desconto
  Cenário: Pedido com desconto de 10 por cento
  ...
  
  @sla
  Cenário: Calcular tempo estimado de preparo
  ...