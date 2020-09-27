package com.example.listtoexcel.add

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listtoexcel.R
import com.example.listtoexcel.databinding.FragmentAddBinding
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {
    private lateinit var adddViewModel: AddViewModel

    private var date = ""
    private var dailyJob = ""
    private var workers = ""
    private var price = ""
    private var totalPrice = 0.0
    private val arrayList = ArrayList<WorkDetails>(5)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentAddBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        adddViewModel = ViewModelProvider(this).get(AddViewModel::class.java)

        binding.lifecycleOwner = this
        binding.addViewModel = adddViewModel

        binding.btnAdd.setOnClickListener {
            add()
        }

        return binding.root
    }

    private fun add() {
        date = editTextDate.text.toString()
        dailyJob = editTextDailyJob.text.toString()
        workers = editTextWorkers.text.toString()
        price = editTextPrice.text.toString()

        if (date.isNotBlank() && dailyJob.isNotBlank() && workers.isNotBlank() && price.isNotBlank()) {
            totalPrice = workers.toDouble() * price.toDouble()

            val a1 = WorkDetails(date, dailyJob, workers, price.toInt(), totalPrice.toInt())
            arrayList.add(a1)
            adddViewModel.setWorkDetails(arrayList)

            Log.i("AddFragment", "AddViewModel.workDetails: ${adddViewModel.workDetails.value}")

            showAddedToast()
            clearAllEditText()

        } else {
            showFailToast()
        }
    }

    private fun showAddedToast() {
        Toast.makeText(
            context,
            context?.resources?.getString(
                R.string.toast_message,
                date,
                dailyJob,
                workers,
                price,
                totalPrice
            ),
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showFailToast() {
        Toast.makeText(context, getString(R.string.warning_message_fulfill), Toast.LENGTH_LONG)
            .show()
    }

    private fun clearAllEditText() {
        editTextDate.text.clear()
        editTextDailyJob.text.clear()
        editTextWorkers.text.clear()
        editTextPrice.text.clear()
    }
}