package mx.edu.ittepic.ladm_u2_practica1_renteriareyes_tarjetanavidena

class Hilo(p:MainActivity): Thread(){
    var puntero = p
    override fun run() {
        super.run()
        sleep(4000)
        while (true){
            sleep(100)
            puntero.runOnUiThread {
                //todo lo que cambia se pone aqui
                puntero.miLienzo!!.nevarCopitos()
            }
        }
    }
}//class