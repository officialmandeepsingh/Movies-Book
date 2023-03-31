package com.mandeep.moviesbook.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * App Name: Movies Book
 * Package Name: com.mandeep.moviesbook.util.base
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Sat 01 Apr, 2023
 *
 **/
abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    abstract var binding: VB?
    abstract fun initUI()
    abstract fun observers()
    abstract fun listeners()
    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = createBinding(inflater, container)
        return binding?.root
    }
}