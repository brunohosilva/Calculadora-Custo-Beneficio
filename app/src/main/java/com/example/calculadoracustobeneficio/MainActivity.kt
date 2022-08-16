package com.example.calculadoracustobeneficio

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcular.setOnClickListener(View.OnClickListener{
            CustoBeneficio()
        })
    }

    fun CustoBeneficio() {
        val marcaProduto1 = marca_produto_1.text.toString()
        val precoProduto1 = preco_produto_1.text.toString()
        val tamanhoProduto1 = tamanho_produto_1.text.toString()

        val marcaProduto2 = marca_produto_2.text.toString()
        val precoProduto2 = preco_produto_2.text.toString()
        val tamanhoProduto2 = tamanho_produto_2.text.toString()

        val validaProduto1 = validaCamposProduto1(marcaProduto1, precoProduto1, tamanhoProduto1)
        val validaProduto2 = validaCamposProduto1(marcaProduto2, precoProduto2, tamanhoProduto2)


        if(validaProduto1 && validaProduto2) {
            calculaCustoBeneficio(marcaProduto1, marcaProduto2, precoProduto1, precoProduto2, tamanhoProduto1, tamanhoProduto2)
        } else {
            renderAlert("Atenção", "Existe campos vazios, preecha por favor!","Ok")
        }
    }

    fun calculaCustoBeneficio(marcaProduto1: String,marcaProduto2: String,precoProduto1: String,precoProduto2: String,tamanhoProduto1: String,tamanhoProduto2: String){
        println("AQUI VAI FAZER O CALCULO E IBOA")
    }

    fun validaCamposProduto1(marcaProduto: String, precoProduto: String, tamanhoProduto: String): Boolean{
        var camposValidados: Boolean = true
        if(marcaProduto.equals("")) {
            camposValidados = false
        } else if (precoProduto.equals("")){
            camposValidados = false
        } else if(tamanhoProduto.equals("")){
            camposValidados = false
        }

        return camposValidados
    }

    fun validaCamposProduto2(marcaProduto: String, precoProduto: String, tamanhoProduto: String): Boolean{
        var camposValidados: Boolean = true
        if(marcaProduto.equals("")) {
            camposValidados = false
        } else if (precoProduto.equals("")){
            camposValidados = false
        } else if(tamanhoProduto.equals("")){
            camposValidados = false
        }

        return camposValidados
    }

    fun renderAlert (title: String, description: String, textButton: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(description)
        builder.setPositiveButton(textButton){dialog, which -> null}
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}