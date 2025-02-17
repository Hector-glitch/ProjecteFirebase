package com.hector.projectefirebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hector.projectefirebase.R
import com.hector.projectefirebase.adapter.MobleAdapter
import com.hector.projectefirebase.databinding.FragmentMoblesBinding
import com.hector.projectefirebase.viewModel.RecyclerFurnitureViewModel

class MoblesFragment : Fragment() {
    private lateinit var binding: FragmentMoblesBinding
    private val viewModel: RecyclerFurnitureViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoblesBinding.inflate(inflater)

        val alumnRecyclerView = binding.recyclerView
        alumnRecyclerView.layoutManager = LinearLayoutManager(context)
        alumnRecyclerView.setHasFixedSize(true)

        binding.AfegirBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMobles_to_fragmentAfegir, null)
        }

        var moblesAdapter = MobleAdapter(requireContext(), emptyList()) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Name: " + selectedItem.name
                        + " | Preu: " + selectedItem.price,
                Toast.LENGTH_LONG).show()
        }

        viewModel.getAllFurniture(requireContext())
        viewModel.mobles.observe(viewLifecycleOwner) { moblesList ->
            moblesAdapter.dataset = moblesList
            alumnRecyclerView.adapter = moblesAdapter
        }
        return binding.root
    }
}