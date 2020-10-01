package com.example.listtoexcel.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listtoexcel.R
import com.example.listtoexcel.add.WorkDetails
import com.example.listtoexcel.databinding.FragmentListBinding
import com.example.listtoexcel.recyclerview.RecyclerViewAdapter
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

        var works = shareViewModel.workDetails.value

        val adapter = works?.let { RecyclerViewAdapter(it) }
        binding.rvWorkDetails.adapter = adapter
        binding.rvWorkDetails.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }

}