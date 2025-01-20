package com.hector.examenhector.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hector.examenhector.R
import com.hector.examenhector.databinding.FragmentContactesBinding

class ContactesFragment : Fragment() {

    private lateinit var binding: FragmentContactesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactesBinding.inflate(inflater)
        
        return binding.root
    }
}
