package ru.skillbranch.loginandrapp.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.skillbranch.loginandrapp.presentation.activity.MainActivity
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.model.viewmodel.WelcomeViewModel

@Suppress("DEPRECATION")
class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<Button>(R.id.btn_sign_out)?.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

}