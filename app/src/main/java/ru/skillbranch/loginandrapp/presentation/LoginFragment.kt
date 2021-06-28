package ru.skillbranch.loginandrapp.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import ru.skillbranch.loginandrapp.model.LoginViewModel
import ru.skillbranch.loginandrapp.MainActivity
import ru.skillbranch.loginandrapp.R
import kotlin.system.exitProcess

//import kotlinx.android.synthetic.main.login_fragment.*

@Suppress("DEPRECATION")
class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<Button>(R.id.btn_sign_in)?.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        view?.findViewById<ImageButton>(R.id.btn_exit)?.setOnClickListener{
            exitProcess (0);
        }
    }
}