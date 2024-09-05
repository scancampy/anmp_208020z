package com.ubayadev.week1anmp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubayadev.week1anmp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener {
            val name = binding.editName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(name)
            Navigation.findNavController(it).navigate(action)
        }
    }
}