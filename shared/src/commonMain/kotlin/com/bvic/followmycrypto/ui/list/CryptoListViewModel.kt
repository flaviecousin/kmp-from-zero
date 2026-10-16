package com.bvic.followmycrypto.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bvic.followmycrypto.data.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CryptoListViewModel(
    private val repository: CryptoRepository,
) : ViewModel() {

    // Version modifiable, privée : seul le ViewModel peut changer l'état
    private val _uiState = MutableStateFlow<CryptoListUiState>(CryptoListUiState.Loading)

    // Version en lecture seule, exposée à l'interface
    val uiState: StateFlow<CryptoListUiState> = _uiState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    init {
        load(initial = true)
    }

    fun refresh() {
        load(initial = false)
    }

    private fun load(initial: Boolean) {
        if(_isRefreshing.value) return
        if (!initial){
            _isRefreshing.value =true
        }
        viewModelScope.launch {
            if(initial){
                _uiState.value = CryptoListUiState.Loading
            }
            try {
                _uiState.value = CryptoListUiState.Success(repository.getCryptos())
            } catch (e: Exception) {
                _uiState.value = CryptoListUiState.Error("Impossible de charger les cours.")
            }
            finally {
                _isRefreshing.value = false
            }
        }
    }
}
