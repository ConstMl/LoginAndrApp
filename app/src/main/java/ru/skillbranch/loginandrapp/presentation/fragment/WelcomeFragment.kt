package ru.skillbranch.loginandrapp.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.koin.android.ext.android.inject
import ru.skillbranch.loginandrapp.presentation.activity.MainActivity
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.databinding.WelcomeFragmentBinding
import ru.skillbranch.loginandrapp.model.viewmodel.WelcomeViewModel

@Suppress("DEPRECATION")
class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private val viewModel by inject<WelcomeViewModel>()
    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WelcomeFragmentBinding.bind(view)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val login = arguments?.getString("login")
        if (login != null) {
            viewModel.login.value = login
        }
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<Button>(R.id.btn_sign_out)?.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

}