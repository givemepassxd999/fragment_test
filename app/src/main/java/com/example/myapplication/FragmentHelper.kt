package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentHelper {
    companion object{
        fun startFragment(manager: FragmentManager, targetFragment: Fragment, widgetId: Int, addFragmentToStack: Boolean){
            try {
                val transaction = manager.beginTransaction()
                transaction.replace(widgetId, targetFragment, targetFragment.javaClass.name)
                if(addFragmentToStack){
                    transaction.addToBackStack(targetFragment.javaClass.name)
                }
                transaction.commit()
            }catch(e:Exception){
                e.printStackTrace()
            }
        }
    }
}