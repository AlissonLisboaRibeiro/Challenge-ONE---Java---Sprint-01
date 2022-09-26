# Challenge-ONE---Java---Sprint-01

Este projeto faz parte do desafio da Allura em conjunto com a Oracle que tem como contexto a alusão a um pedido de um cliente que necessita que seja desenvolvido um programa em java capaz de converter moedas e como uma funcionalidade a mais para que o cliente acredita ser ter lido os pensamentos dele: um conversor de temperaturas.

Como o programa funciona?
O programa foi desenvolvido em java utilizando o swing, para criar a interface visual para o utilizador. Através de operações matemáticas ele converte o valor inserido para a moeda mundialmente conhecida, o dollar americano; e posteriormente converte para a moeda desejada. 

Funcionalidades:
O programa permite a conversão de moedas e unidades de temperaturas.

Após a escolha de conversor a ser utilizado:

![tela_escolha_conversor](https://user-images.githubusercontent.com/104919477/192040554-03ebc7cf-417c-4ff7-ae8c-a069cff8d551.png)



<h2>Limitações:</h2>

![tela_conversor_moeda](https://user-images.githubusercontent.com/104919477/192039004-f691aecc-1457-48f5-b85b-180dd460487a.png)

O programa contém índices de cotação do dia da implementação, logo ali no "telaConversaoMoeda.java":

![tela_indices_conversao](https://user-images.githubusercontent.com/104919477/192036233-c8dbb931-76f5-426e-bc29-b503f5811892.png)

Pode-se alterar estes índices seguindo a ordem determinada:
<ul>
<li>US$ - Dólar Americano</li>
<li>€ - Euro</li>
<li>£ - Libra esterlina</li>
<li>¥ - Iene</li>
<li>$ - Dólar Australiano</li>
<li>Fr - Franco Suíço</li>
<li>$ - Dólar Canadense</li>
<li>元 - Renminbi (Yuan)</li>
<li>$ - Peso Argentino</li>
<li>₺ - Lira Turca</li>
<li>R$ - Real Brasileiro</li>
</ul>

Para adicionar itens nessa lista basta alterar nos componentes <b>JCombobox</b> e no código com o devido índice monetário.
<hr></hr>

<h2>Conversão de temperatura</h2>

O conversor de temperatura converte em graus Celsius, Kelvin e Fahrenheit. Funcionando de mesma maneira que o conversor de moeda, você pode escolher as unidades que quer converter após informar o valor.

![tela_conversor_temperatura](https://user-images.githubusercontent.com/104919477/192263275-d2ba640d-2e55-4f8c-b5ae-1902f4089cda.png)


As métricas utilizadas para conversão:

<b>De Celsius para:</b>
<li>Kelvin = °Celsius + 273.15;</li>
<li>Fahrenheit = ((9.0/5.0) * °Celsius) + 32.0;</li>
<br>
<b>De Kelvin para:</b>
<li>Celsius = °Kelvin - 273.15;</>
<li>Fahrenheit = ((°Kelvin - 273.15) * (9.0/5.0)) + 32.0;</li>
<br>
<b>De Fahrenheit para:</b>
<li>Celsius = (°Fahrenheit - 32.0) * (5.0/9.0);</li>
<li>kelvin =  (°Fahrenheit - 32) * (5.0/9.0) + 273.15;</li>

