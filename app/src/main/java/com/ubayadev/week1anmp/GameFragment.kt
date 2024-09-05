package com.ubayadev.week1anmp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubayadev.week1anmp.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding:FragmentGameBinding
    var jawaban = 0
    var soal = ""
    var score =0

    fun generateSoal() {
        jawaban = 0
        soal = ""
        val jmlbilangan = (2..5).random()
        for(bil in 1..jmlbilangan) {
            val angka = (1..10).random()
            jawaban += angka
            if(bil != 1) { soal += " + " }
            soal += "$angka"
        }
        binding.txtSoal.text = soal
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }

        binding.btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnAnswer.setOnClickListener {
            if(binding.editAnswer.text.toString() == jawaban.toString()) {
                score++
                generateSoal()
            } else {
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }

        generateSoal()
    }
}