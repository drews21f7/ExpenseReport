package com.example.expensereport

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var categoryButton: Button
    private lateinit var cancelButton: ImageView
    private lateinit var checkBox: ImageView
    private lateinit var categoryText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragmentView = inflater.inflate(R.layout.fragment_home, container, false)
        categoryButton = fragmentView.findViewById(R.id.category_button)
        cancelButton = fragmentView.findViewById(R.id.cancel_button)
        checkBox = fragmentView.findViewById(R.id.check)
        categoryText = fragmentView.findViewById(R.id.category_text)

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryButton.setOnClickListener { println ("Category Click") }
        cancelButton.setOnClickListener { println ("Cancel click") }
        checkBox.setOnClickListener{
            val input = categoryText.text.toString()
            val intent = Intent(context,CategoriesActivity::class.java)
            intent.putExtra("categoryInput",input)
            context?.startActivity(intent)}
    }
}