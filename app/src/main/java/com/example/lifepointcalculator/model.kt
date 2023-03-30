package com.example.lifepointcalculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<String>()
    val jugador = MutableLiveData<String?>()
     val player1 = MutableLiveData<Int>(8000)
    val player2 = MutableLiveData<Int>(8000)
    val quantity: LiveData<Int> = player1
    val quantity2: LiveData<Int> = player2
    var life: Int? = player1.value
    private val _flavor = MutableLiveData<String>("")
    val flavor: LiveData<String> = _flavor

    private val _date = MutableLiveData<String>("")
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>(0.0)
    val price: LiveData<Double> = _price

    fun selectedItem(item: String) {
        selected.value = item
    }
    fun setQuantity(numberCupcakes: Int) {
        player1.value = numberCupcakes
    }
    fun setPlayer(Player: String?){
        jugador.value = Player
    }
    //Funciones de aritmetica
    fun suma( jugador: String?,cantidad: Int?){
        when(jugador){
            "jugador1" -> player1.value = cantidad!! + player1.value!!
            "jugador2" -> player2.value = cantidad!! + player2.value!!

        }



    }
    fun resta(jugador: String? ,cantidad: Int?){
        when(jugador){
            "jugador1" -> player1.value = player1.value!! - cantidad!!
            "jugador2" -> player2.value = player2.value!! - cantidad!!

        }

        if (player1.value!! <0){
            player1.value =0
        }
        if (player2.value!! <0){
            player2.value =0
        }

    }
    fun mitad(jugador: String?){
        when(jugador){
            "jugador1" -> player1.value = player1.value!!/2
            "jugador2" -> player2.value = player2.value!!/2

        }


    }

    fun restart(){
        player1.value = 8000
        player2.value = 8000
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }
    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }
    fun getFlavor(): String{
        return _flavor.value.toString()
    }
    fun getPlayer(): String{
        return jugador.value.toString()
    }
    fun getQuantity(jugador: String?): String{
        var cantidad :Int? = 0
        when(jugador){
            "jugador1" -> cantidad = player1.value
            "jugador2" ->  cantidad = player2.value

        }


        Log.d("tag", quantity.value.toString())

        return cantidad.toString()
    }



}
