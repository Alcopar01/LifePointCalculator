package com.example.lifepointcalculator

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifepointcalculator.databinding.ActivityMainBinding
import com.example.lifepointcalculator.databinding.ModalBinding

class CustomDialog : DialogFragment(R.layout.modal) {

    private val model: SharedViewModel by activityViewModels()
    private var _binding: ModalBinding? = null
    // This property is only valid between onCreateDialog and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup UI and other stuff ...
        // getting the bundle back from the android
        //Es este metodo si jala
        var jugador: String = "jugador1"
        model.jugador.observe(viewLifecycleOwner, Observer<String?> { data ->
            jugador = model.getPlayer()
        })
        Log.i("tag", model.getPlayer())
        model.quantity.observe(viewLifecycleOwner, Observer<Int> { data ->
            binding.Life.text = model.getQuantity(jugador)
        })
        model.quantity2.observe(viewLifecycleOwner, Observer<Int> { data ->
            binding.Life.text = model.getQuantity(jugador)
        })

        ////

        var numero = 0
        val nameObserver = Observer<Int> { quantity ->
            // Update the UI, in this case, a TextView.
            binding.Life.text = model.getQuantity(jugador)
        }

        binding.lifecycleOwner = viewLifecycleOwner

        binding.cambiar.setOnClickListener(){

            if (binding.editTextNumber.text.isNullOrEmpty()){
                numero = 0
                model.suma(jugador ,numero)
            }else{
                numero = binding.editTextNumber.text.toString().toInt()
                model.suma(jugador ,numero)
            }



        }
        binding.button2.setOnClickListener(){

            if (binding.editTextNumber.text.isNullOrEmpty()){
                numero = 0
                model.resta(jugador ,numero)
            }else{
                numero = binding.editTextNumber.text.toString().toInt()
                model.resta(jugador ,numero)
            }

        }
        binding.mitad.setOnClickListener(){
            model.mitad(jugador)
        }

    }
    ///Usar estas dos clases en Dialog para usar Binding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = ModalBinding.inflate(LayoutInflater.from(context))
        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
    private fun cambiar() {
        Log.d("tag", "cambiar")
            binding.Life.text = "100"

    }
}
