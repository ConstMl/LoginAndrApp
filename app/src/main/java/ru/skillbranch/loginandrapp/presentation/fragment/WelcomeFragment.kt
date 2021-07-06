package ru.skillbranch.loginandrapp.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import ru.skillbranch.loginandrapp.presentation.activity.MainActivity
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.databinding.WelcomeFragmentBinding
import ru.skillbranch.loginandrapp.model.viewmodel.WelcomeViewModel

class WelcomeFragment : Fragment(R.layout.welcome_fragment) {

    private val viewModel by inject<WelcomeViewModel> {
        parametersOf(arguments?.getString("login"))
    }
    private lateinit var binding: WelcomeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WelcomeFragmentBinding.bind(view)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<Button>(R.id.btn_sign_out)?.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

}