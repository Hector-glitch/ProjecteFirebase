package com.hector.projectefirebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.hector.projectefirebase.R
import com.hector.projectefirebase.model.Moble
import com.hector.projectefirebase.databinding.FragmentAfegirBinding

class AfegirFragment : Fragment() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var binding: FragmentAfegirBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAfegirBinding.inflate(inflater)

        binding.BtnAfegir.setOnClickListener {
            val name = binding.NomEditarText.text.toString()
            val stock = binding.SotckEditarText.text.toString().toInt()
            val price = binding.PreuEditarText.text.toString().toInt()

            val moble = hashMapOf(
                "nom" to name,
                "stock" to stock,
                "preu" to price
            )

            db.collection("mobles").document(name).set(moble)
        }

        binding.BtnReturn.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAfegir_to_fragmentMobles, null)
        }

        return binding.root
    }
}

