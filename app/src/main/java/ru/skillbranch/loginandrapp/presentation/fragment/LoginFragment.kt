package ru.skillbranch.loginandrapp.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.ext.android.inject
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.databinding.LoginFragmentBinding
import kotlin.system.exitProcess

//import kotlinx.android.synthetic.main.login_fragment.*

@Suppress("DEPRECATION")
class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding
    private val service: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
    }


    override fun onStart() {
        super.onStart()
        binding.btnSignIn.setOnClickListener{
            Log.d("----->", "{ ${binding.viewModel?.email?.value}, ${binding.viewModel?.password?.value} }")
            Log.d("----->", "{ ${viewModel.email.value}, ${viewModel.password.value} }")
            service.signIn()
//            (activity as MainActivity).navController.navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.btnExit.setOnClickListener{
            exitProcess (0);
        }
    }
}