package com.example.lifepointcalculator

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels

import com.example.lifepointcalculator.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var binding1: ActivityMainBinding
    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // view model instance

        val nameObserver = Observer<Int> { quantity ->
            // Update the UI, in this case, a TextView.
             binding.player1.text = quantity.toString()
        }
        val nameObserver1 = Observer<Int> { quantity ->
            // Update the UI, in this case, a TextView.
            binding.player2.text = quantity.toString()
        }
        viewModel.player1.observe(this, Observer<Int> { data ->
            binding.player1.text = viewModel.getQuantity("jugador1")
        })
        viewModel.player2.observe(this, Observer<Int> { data ->
            binding.player2.text = viewModel.getQuantity("jugador2")
        })
        viewModel.player1.observe(this, nameObserver)
        viewModel.player2.observe(this, nameObserver1)

        //  binding1 = DataBindingUtil.setContentView(this, R.layout.modal)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Androidly Alert")
        builder.setMessage("We have a message")
        builder.setView(R.layout.modal)


        builder.apply {
            setPositiveButton(R.string.Player1,
                DialogInterface.OnClickListener { dialog, id ->
                    // User clicked OK button
                    binding.player1.text = "90"
                    viewModel.selectedItem("Nuevo")
                })
            setNegativeButton(R.string.Player2,
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        }

        /*
        findViewById<TextView>(R.id.player1).setOnClickListener {
            player1(it)
        }*/
        binding.player1.setOnClickListener {
            //player1(it)
            viewModel.setPlayer("jugador1")
            confirmStartGame()

        }
        binding.player2.setOnClickListener {
            //alertDialogBuilder.show()
            //player1(it)
            viewModel.setPlayer("jugador2")
            Log.i("tag",viewModel.getPlayer())
            confirmStartGame()
           // builder.show()
            //viewModel.setQuantity(1000)


        }
        binding.restart.setOnClickListener(){
            viewModel.restart()
        }
        binding.Coin.setOnClickListener(){
            val randomInt = (1..2).random()
            when(randomInt){
                1 -> Toast.makeText(this, "HEAD", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "TAILS", Toast.LENGTH_SHORT).show()
            }
        }
        binding.Dado.setOnClickListener(){
            val randomInt = (1..6).random()
            when(randomInt){
                1 -> Toast.makeText(this, "DADO 1", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "DADO 2", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "DADO 3", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this, "DADO 4", Toast.LENGTH_SHORT).show()
                5 -> Toast.makeText(this, "DADO 5", Toast.LENGTH_SHORT).show()
                6 -> Toast.makeText(this, "DADO 6", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("tag", "onDestroy")

    }

    private fun player1(view: View) {
        binding.player1.text = "900"

    }

    fun confirmStartGame() {
        val newFragment = CustomDialog()
        newFragment.show(supportFragmentManager, "game")

    }

}
