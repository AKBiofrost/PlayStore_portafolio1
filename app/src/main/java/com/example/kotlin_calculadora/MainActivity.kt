package com.example.kotlin_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultado: TextView
    private lateinit var botonCero: Button
    private lateinit var botonUno: Button
    private lateinit var botonDos: Button
    private lateinit var botonTres: Button
    private lateinit var botonCuatro: Button
    private lateinit var botonCinco: Button
    private lateinit var botonSeis: Button
    private lateinit var botonSiete: Button
    private lateinit var botonOcho: Button
    private lateinit var botonNueve: Button
    private lateinit var botonSumar: Button
    private lateinit var botonRestar: Button
    private lateinit var botonMultiplicar: Button
    private lateinit var botonDividir: Button
    private lateinit var botonBorrar: Button
    private lateinit var botonIgual: Button
    private lateinit var botonDecimal: Button


    private var num1: Double=0.0
    private var num2: Double=0.0
    private var operacion: Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getActionBar().hide();

        resultado = this.findViewById(R.id.resultadoFinal)
        resultado.text = " "

        botonDecimal = this.findViewById(R.id.decimal)
        botonCero = this.findViewById(R.id.cero)
        botonUno = this.findViewById(R.id.uno)
        botonDos=this.findViewById(R.id.dos)
        botonTres=this.findViewById(R.id.tres)
        botonCuatro=this.findViewById(R.id.cuatro)
        botonCinco=this.findViewById(R.id.cinco)
        botonSeis=this.findViewById(R.id.seis)
        botonSiete=this.findViewById(R.id.siete)
        botonOcho=this.findViewById(R.id.ocho)
        botonNueve=this.findViewById(R.id.nueve)
        botonSumar=this.findViewById(R.id.mas)
        botonRestar=this.findViewById(R.id.menos)
        botonMultiplicar=this.findViewById(R.id.multiplicar)
        botonDividir=this.findViewById(R.id.dividir)
        botonBorrar=this.findViewById(R.id.borrar)
        botonIgual=this.findViewById(R.id.igual)

//***************************************************************
        botonDecimal.setOnClickListener { numeroPresionado(".") }
        botonCero.setOnClickListener { numeroPresionado("0") }
        botonUno.setOnClickListener { numeroPresionado("1") }
        botonDos.setOnClickListener{ numeroPresionado("2")  }
        botonTres.setOnClickListener{ numeroPresionado("3")  }
        botonCuatro.setOnClickListener{ numeroPresionado("4")  }
        botonCinco.setOnClickListener{ numeroPresionado("5")  }
        botonSeis.setOnClickListener{ numeroPresionado("6")  }
        botonSiete.setOnClickListener{ numeroPresionado("7")  }
        botonOcho.setOnClickListener{ numeroPresionado("8")  }
        botonNueve.setOnClickListener{ numeroPresionado("9")  }

//***************************************************************

        botonSumar.setOnClickListener {  operadorPresionado(SUMA)   }
        botonRestar.setOnClickListener{ operadorPresionado(RESTA)}
        botonMultiplicar.setOnClickListener{ operadorPresionado(MULTIPLICACION)}
        botonDividir.setOnClickListener{operadorPresionado(DIVIDIR)   }

//**************************************************************

        botonBorrar.setOnClickListener{
            num1=0.0
            num2=0.0
            resultado.text=" "
            operacion=NO_Operacion


        }

        botonIgual.setOnClickListener{


            val respuesta= when(operacion){

                SUMA-> num1+num2
                RESTA-> num1-num2
                MULTIPLICACION-> num1*num2
                DIVIDIR-> num1/num2

                else ->0


            }
            resultado.text = respuesta.toString()
            num1=resultado.text.toString().toDouble();


        }


    }


    private fun numeroPresionado(digito: String) {

        resultado.text = "${resultado.text}${digito}"



        if (operacion == NO_Operacion) {

            num1 = resultado.text.toString().toDouble()

        } else {
            num2 = resultado.text.toString().toDouble()
        }




    }




    private fun operadorPresionado(operador:Int){

        operacion = operador

        resultado.text=" "



    }





    companion object{

        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVIDIR=4
        const val NO_Operacion=0
    }





}





