package ru.skillbranch.loginandrapp.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.login_fragment) {

    private val viewModel by inject<LoginViewModel>()
    private lateinit var binding: LoginFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.error.observe(viewLifecycleOwner, { message ->
            if (message != null) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}