package com.example.listtoexcel.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.listtoexcel.R
import com.example.listtoexcel.databinding.FragmentAddBinding
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {
    private var date = ""
    private var dailyJob = ""
    private var workers = ""
    private var price = ""
    private var totalPrice = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentAddBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)

        binding.btnAdd.setOnClickListener {
            testfun(it)
        }

        return binding.root
    }

    fun testfun(view: View) {
        date = editTextDate.text.toString()
        dailyJob = editTextDailyJob.text.toString()
        workers = editTextWorkers.text.toString()
        price = editTextPrice.text.toString()

        totalPrice = workers.toDouble() * price.toDouble()

        Toast.makeText(
            context, "Date:$date\n" +
                    "Daily Job:$dailyJob\n" +
                    "Workers:$workers\n" +
                    "Price:$price\n" +
                    "Total price:$totalPrice\n",
            Toast.LENGTH_LONG
        ).show()
    }
}