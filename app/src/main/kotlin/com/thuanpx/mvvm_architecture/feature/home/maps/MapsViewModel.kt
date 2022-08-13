package com.thuanpx.mvvm_architecture.feature.home.maps

import com.thuanpx.mvvm_architecture.base.viewmodel.BaseViewModel
import com.thuanpx.mvvm_architecture.data.repository.AppRepository
import com.thuanpx.mvvm_architecture.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val appRepository: AppRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : BaseViewModel() {
}