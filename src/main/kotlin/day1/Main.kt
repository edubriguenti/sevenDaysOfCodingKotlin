package day1

import java.security.InvalidParameterException

/**
 * O desafio para o dia é implementar uma versão simplificada de uma lista de compras usando arrays.
 * A lista deve permitir adicionar novos itens, remover itens e listar todos os itens.
 *
 * Ao adicionar um novo item, o usuário deve inserir o nome do produto e a quantidade desejada.
 * Ao remover um item, o usuário deve especificar o nome do produto.
 * Por fim, ao listar todos os itens, a lista deve exibir o nome do produto e a quantidade
 * em um formato legível.
 *
 */
fun main() {
    val listaDeCompras = ListaDeCompras()
    listaDeCompras.adicionar("camiseta", 2)
    listaDeCompras.adicionar("shorts", 1)
    listaDeCompras.adicionar("camiseta", 1)
    listaDeCompras.adicionar("camiseta", 1)

    listaDeCompras.listar()

    listaDeCompras.remover("shorts")

    listaDeCompras.listar()
}


class ListaDeCompras {
    private var produtos = mutableListOf<String>()
    private var quantidades = mutableListOf<Int>()

    fun adicionar(produto: String, quantidade: Int) {
        validar(produto, quantidade)

        if (produtos.contains(produto)) {
            val indice = produtos.indexOf(produto)
            quantidades[indice] = quantidades[indice] + quantidade
        } else {
            produtos.add(produto)
            quantidades.add(quantidade)
        }
    }

    private fun validar(produto: String, quantidade: Int) {
        if (produto.isEmpty())
            throw InvalidParameterException("Preencha o nome do produto")

        if (quantidade < 1)
            throw InvalidParameterException("Quantidade Inválida")
    }

    fun remover(produto: String) {
        if (produtos.contains(produto)) {
            val indice = produtos.indexOf(produto)
            produtos.removeAt(indice)
            quantidades.removeAt(indice)
        }
    }

    fun listar() {
        println("################")
        for((index, produto) in produtos.withIndex()) {
            println("$produto com quantidade ${quantidades[index]}")
        }
    }
}