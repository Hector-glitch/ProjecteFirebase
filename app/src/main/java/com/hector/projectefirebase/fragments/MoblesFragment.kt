package com.hector.projectefirebase.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hector.projectefirebase.R
import com.hector.projectefirebase.adapter.MobleAdapter
import com.hector.projectefirebase.databinding.FragmentMoblesBinding
import com.hector.projectefirebase.model.Moble
import com.google.firebase.firestore.FirebaseFirestore

class MoblesFragment : Fragment() {

    private lateinit var binding: FragmentMoblesBinding
    private val db = FirebaseFirestore.getInstance()
    private lateinit var adapter: MobleAdapter
    private val moblesList = mutableListOf<Moble>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoblesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        carregarMobles()

        binding.BtnAfegir.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMobles_to_fragmentAfegir)
        }
    }

    private fun setupRecyclerView() {
        adapter = MobleAdapter(moblesList)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun carregarMobles() {
        db.collection("mobles")
            .get()
            .addOnSuccessListener { documents ->
                moblesList.clear()
                for (document in documents) {
                    val moble = document.toObject(Moble::class.java)
                    moblesList.add(moble)
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore", "Error carregant mobles", exception)
            }
    }
}
