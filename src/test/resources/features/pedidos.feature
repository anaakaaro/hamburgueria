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
    Quando eu faço um pedido de 2 x-bacon
    Então o valor total deve ser 50.00
    E o pedido deve ser aceito

  @inexistente
  Cenário: Pedido de item inexistente
    Quando eu faço um pedido de 1 x-burguer
    Então o pedido deve ser rejeitado
    E a mensagem de erro deve ser "Item indisponível no cardápio"

  @quantidade
  Cenário: Pedido com quantidade inválida
    Quando eu faço um pedido de 0 x-bacon
    Então o pedido deve ser rejeitado
    E a mensagem de erro deve ser "Quantidade inválida"

  @desconto
  Cenário: Pedido com desconto de 10 por cento
    Quando eu faço um pedido de 1 x-salada
    E aplico um desconto de 10 por cento
    Então o valor total deve ser 19.80

  @sla
  Cenário: Calcular tempo estimado de preparo
    Quando eu faço um pedido de 3 itens
    Então o tempo estimado deve ser 14 minutos