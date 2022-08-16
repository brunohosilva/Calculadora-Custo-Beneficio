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
                custoBeneficio()
            })
        }

        private fun custoBeneficio() {
            val nomeUsuario = input_nome.text.toString()
            val marcaProduto1 = marca_produto_1.text.toString()
            val precoProduto1 = preco_produto_1.text.toString()
            val tamanhoProduto1 = tamanho_produto_1.text.toString()

            val marcaProduto2 = marca_produto_2.text.toString()
            val precoProduto2 = preco_produto_2.text.toString()
            val tamanhoProduto2 = tamanho_produto_2.text.toString()

            val validaProduto1 = validaCamposProduto(marcaProduto1, precoProduto1, tamanhoProduto1)
            val validaProduto2 = validaCamposProduto(marcaProduto2, precoProduto2, tamanhoProduto2)


            if(validaProduto1 && validaProduto2) {
                calculaCustoBeneficio(marcaProduto1, marcaProduto2, precoProduto1, precoProduto2, tamanhoProduto1, tamanhoProduto2, nomeUsuario)
            } else {
                renderAlert("Atenção", "Existe campos vazios, preecha por favor!","Ok")
            }
        }

        private fun calculaCustoBeneficio(
            marcaProduto1: String,
            marcaProduto2: String,
            precoProduto1: String,
            precoProduto2: String,
            tamanhoProduto1: String,
            tamanhoProduto2: String,
            nomeUsuario: String
        ){

            val valorLitroProduto1 = calculaValorLitro(precoProduto1, tamanhoProduto1)
            val valorLitroProduto2 = calculaValorLitro(precoProduto2, tamanhoProduto2)


            if (valorLitroProduto1 > valorLitroProduto2) {
                val custoBeneficio = String.format("%.2f", valorLitroProduto1 - valorLitroProduto2)
                renderAlert("Muito bem $nomeUsuario", "O produto: $marcaProduto2 tem o melhor custo beneficio.\n\nVocê irá economizar R$ $custoBeneficio/L","Ok")
            }

            if (valorLitroProduto2 > valorLitroProduto1) {
                val custoBeneficio = String.format("%.2f", valorLitroProduto2 - valorLitroProduto1)
                renderAlert("Muito bem $nomeUsuario", "O produto: $marcaProduto1 tem o melhor custo beneficio.\n\nVocê irá economizar R$ $custoBeneficio/L","Ok")
            }

            if (valorLitroProduto1 === valorLitroProduto2) {
                renderAlert("Muito bem $nomeUsuario", "Ambos produtos equivalem no valor","Ok")
            }
        }

        private fun calculaValorLitro(precoProduto: String, tamanhoProduto: String): Float {
            val preco = precoProduto.toFloat()
            val tamanho = tamanhoProduto.toFloat()

            return preco.times(1000) / tamanho
        }

        private fun validaCamposProduto(marcaProduto: String, precoProduto: String, tamanhoProduto: String): Boolean{
            var camposValidados: Boolean = true
            if(marcaProduto == "") {
                camposValidados = false
            } else if (precoProduto == ""){
                camposValidados = false
            } else if(tamanhoProduto == ""){
                camposValidados = false
            }

            return camposValidados
        }

        private fun renderAlert (title: String, description: String, textButton: String) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(title)
            builder.setMessage(description)
            builder.setPositiveButton(textButton){dialog, which -> null}
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

    }