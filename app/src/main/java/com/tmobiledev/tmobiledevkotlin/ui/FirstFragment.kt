package com.tmobiledev.tmobiledevkotlin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tmobiledev.tmobiledevkotlin.R
import com.tmobiledev.tmobiledevkotlin.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private val TAG = FirstFragment::class.java.simpleName
    private val firstViewModel: FirstViewModel by viewModel()
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            firstViewModel.getUserMe()
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        initObserverUserMe()
    }

    private fun initObserverUserMe() {
        firstViewModel.userModel.observe(viewLifecycleOwner, Observer { userModel ->
            Log.w(TAG, userModel.checkin_user_email)
        })
        firstViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.w(TAG, it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}