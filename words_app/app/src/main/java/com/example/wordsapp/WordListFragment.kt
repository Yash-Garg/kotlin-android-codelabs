package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.adapters.WordAdapter
import com.example.wordsapp.databinding.FragmentWordListBinding

/**
 * A simple [Fragment] subclass.
 */
class WordListFragment : Fragment() {
    private var _binding: FragmentWordListBinding? = null
    private var binding = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val letterId = activity?.intent?.extras?.getString(LETTER).toString()
        val recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = WordAdapter(letterId, this.requireContext())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this.requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        activity?.title = getString(R.string.detail_prefix) + " " + letterId
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
}