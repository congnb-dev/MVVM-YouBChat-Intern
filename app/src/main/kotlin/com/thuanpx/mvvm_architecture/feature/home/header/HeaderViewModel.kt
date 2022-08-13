package com.thuanpx.mvvm_architecture.feature.home.header

import com.thuanpx.mvvm_architecture.base.viewmodel.BaseViewModel
import com.thuanpx.mvvm_architecture.data.repository.AppRepository
import com.thuanpx.mvvm_architecture.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by ThuanPx on 4/3/22.
 */
@HiltViewModel
class HeaderViewModel @Inject constructor(
    private val appRepository: AppRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : BaseViewModel() {
}
