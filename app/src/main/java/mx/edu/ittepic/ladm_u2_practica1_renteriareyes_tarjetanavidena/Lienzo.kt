package mx.edu.ittepic.ladm_u2_practica1_renteriareyes_tarjetanavidena

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

public class Lienzo(p:MainActivity) : View(p){
    var puntero = p
    var copitos : Array<Copos> =
        Array(150){  //tamaño del arreglo
            Copos((0..1080).random(),(-980..0).random(),2) //mandar x,y,r a Copos
        }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        //fondo
        p.color = Color.rgb(4,39,126)
        c.drawRect(0f,0f,1080f,1920f,p)

        //pasto
        //p.color = Color.rgb(82,155,93)
        p.color = Color.rgb(0,0,0)
        c.drawRect(0f,1900f,1080f,1100f,p)

        //------------------------- CASA ------------------------
            //-- Cimiento ---//
        p.color = Color.rgb(0,0,0)
        c.drawRect(400f,1200f,900f,900f,p)
            //--- Ventana ---//
        p.color = Color.rgb(255,255,255)
        c.drawCircle(500f,980f,30f,p)
            //-- Puerta --//
        p.color = Color.rgb(255,255,255)
        c.drawRect(620f,1100f,670f,1010f,p)
            //-- Techo --//
        var linea = Path()
        linea.moveTo(950f, 900f); //derecha abajo
        linea.lineTo(350f, 900f); //izquierda abajo
        linea.lineTo(650f, 750f); //punta superior
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.parseColor("#000000"));
        c.drawPath(linea, p); //Pintar el triangulo

        //---------------------------------------------------//
            //-- Arbol ---/
        // -- base --
        //p.color = Color.rgb(83,77,48)
        p.color = Color.rgb(0,0,0)
        c.drawRect(150f,1200f,200f,1000f,p)
        // -- hojas --
        p.color = Color.rgb(0,0,0)
        c.drawCircle(175f,950f,80f,p)
        c.drawCircle(175f,860f,75f,p)
        c.drawCircle(250f,900f,75f,p)
        c.drawCircle(105f,900f,75f,p)

            // -- Luna -- //
        p.color = Color.rgb(255,255,255)
        c.drawCircle(280f,200f,150f,p)
        p.color = Color.rgb(4,39,126)
        c.drawCircle(290f,190f,150f,p)


        //----------- PINTAR COPITOS DE NIEVE ----//
        p.color = Color.rgb(255,255,255)
        (0..copitos.size-1).forEach {
            copitos[it].dibujar(c,p)
        }
    }//onDraw

    ///////////////---------------------------- NEVAR -----------------------///////////
    fun nevarCopitos() {
        (copitos.indices).forEach() {
            copitos[it].nevar(width) //pasarle el ancho a la funcion
        }
        invalidate()
    }



}//class