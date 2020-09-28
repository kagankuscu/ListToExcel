package com.example.listtoexcel.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.listtoexcel.R
import com.example.listtoexcel.databinding.FragmentListBinding
import com.example.listtoexcel.share.SharedViewModel

class ListFragment : Fragment() {
    private lateinit var shareViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )
        val listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        shareViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.lifecycleOwner = this
        binding.listViewModel = listViewModel

        binding.share.text = shareViewModel.workDetails.value.toString()

        return binding.root
    }

}