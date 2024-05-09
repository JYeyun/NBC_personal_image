package com.example.nbc_personal_image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nbc_personal_image.databinding.FragmentSearchBinding
import com.example.nbc_personal_image.retrofit.Repository
import com.example.nbc_personal_image.viewmodel.MainViewModel
import com.example.nbc_personal_image.viewmodel.MainViewModelFactory

class SearchFragment:Fragment() {
    private var _binding:FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val imageSearchRepository = Repository()
    private val factory = MainViewModelFactory(imageSearchRepository)
    private val viewModel : MainViewModel by viewModels(){factory}

    private lateinit var imageSearchAdapter: ImageRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        imageSearchAdapter = ImageRecyclerViewAdapter(this)
        binding.searchRecycler.adapter = imageSearchAdapter
        binding.searchRecycler.layoutManager = GridLayoutManager(this.context, 2)
        binding.searchBtn.setOnClickListener {
            val input = binding.searchEt.text.toString()
            viewModel.searchImage(input)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}