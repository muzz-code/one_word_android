package com.ebookfrenzy.one_word.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ebookfrenzy.one_word.util.CustomProgressDialog
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

//class BaseFragment {
//}

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    lateinit var progressDialog: CustomProgressDialog

    @Inject
    lateinit var mainRetrofit: Retrofit

    @Inject
    lateinit var imageRetrofit: Retrofit

//    @Inject
//    lateinit var sessionManager: SessionManager
//
//    @Inject
//    lateinit var database: CladsDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = CustomProgressDialog(requireContext())
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
