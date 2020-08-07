package com.example.listtoexcel.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.listtoexcel.R
import com.example.listtoexcel.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentAddBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)

        return binding.root
    }
}