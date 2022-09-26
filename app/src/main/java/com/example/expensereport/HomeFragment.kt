package com.example.expensereport

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class HomeFragment : Fragment() {
    private lateinit var cancelButton: ImageView
    private lateinit var checkBox: ImageView
    private lateinit var categoryText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragmentView = inflater.inflate(R.layout.fragment_home, container, false)
        cancelButton = fragmentView.findViewById(R.id.cancel_button)
        checkBox = fragmentView.findViewById(R.id.check)
        categoryText = fragmentView.findViewById(R.id.category_text)

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancelButton.setOnClickListener { categoryText.text.clear() }
        checkBox.setOnClickListener {
            val input = categoryText.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(context, "Enter Category!", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(context, CategoriesActivity::class.java)
                context?.startActivity(intent)
            }
        }
        if (FakeDatabase.getSavedCategories().isNotEmpty()) {
            val intent = Intent(context, CategoriesActivity::class.java)
            context?.startActivity(intent)
        }
    }
}