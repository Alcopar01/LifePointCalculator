package com.example.lifepointcalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.lifepointcalculator.databinding.ModalBinding
/*
class Modal : AppCompatActivity(){
    private lateinit var binding: ModalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.modal)
        binding.Life.text = "90"
        binding.cambiar.setOnClickListener {
            puntos()
        }
    }

    private fun puntos(){
        binding.Life.text= "Nuevo"
        Toast.makeText(this, "Modal", Toast.LENGTH_SHORT).show()
        Log.d("TAG", "message")
        println("other message")
    }

}*/
class Modal : Fragment(R.layout.modal) {
    private lateinit var binding: ModalBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ModalBinding = DataBindingUtil.inflate(
            inflater, R.layout.modal, container, false)
        Log.d("tag", "Prueba")
        binding.cambiar.setOnClickListener {
            puntos()
        }
        return inflater.inflate(R.layout.modal, container, false)
    }
    private fun puntos(){
        binding.Life.text= "Nuevo"
        //Toast.makeText(this, "Modal", Toast.LENGTH_SHORT).show()
        Log.d("TAG", "message")
        println("other message")
    }
}
