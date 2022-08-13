package com.thuanpx.mvvm_architecture.feature.home.header

import android.view.*
import com.thuanpx.mvvm_architecture.R
import com.thuanpx.mvvm_architecture.base.fragment.BaseFragment
import com.thuanpx.mvvm_architecture.databinding.FragmentHeaderBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by ThuanPx on 8/8/20.
 */

@AndroidEntryPoint
class HeaderFragment :
    BaseFragment<HeaderViewModel, FragmentHeaderBinding>(HeaderViewModel::class) {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHeaderBinding {
        return FragmentHeaderBinding.inflate(inflater, container, false)
    }

    override fun initialize() {
        registerForContextMenu(viewBinding.btnSort)
    }

    override fun onSubscribeObserver() {
        super.onSubscribeObserver()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        activity?.menuInflater?.inflate(R.menu.sort_menu, menu)
    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.relevance -> {
//                //viewBinding.btnSort.text = "Relevance"
//                return true
//            }
//            R.id.rating -> {
//                //viewBinding.btnSort.text = "Rating"
//                return true
//            }
//            R.id.coupons -> {
//                //viewBinding.btnSort.text = "Coupons"
//                return true
//            }
//            R.id.numberOfFollow -> {
//                //viewBinding.btnSort.text = "Number of Follow"
//                return true
//            }
//            else -> return super.onContextItemSelected(item)
//        }
//    }
}
