package com.example.mobilecodingexercise.comicDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilecodingexercise.repos.MarvelComicsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ComicDetailViewModel @Inject constructor(
    private val comicsRepo: MarvelComicsRepo
) : ViewModel() {

    private val _comicDetails: MutableStateFlow<ComicDetailUiModel?> = MutableStateFlow(null)
    val comicDetails: StateFlow<ComicDetailUiModel?> = _comicDetails.asStateFlow()

    fun fetchInfo(){
        viewModelScope.launch{
            try {
                Timber.d("YOOOOL: ${comicsRepo.getComic()}")
                _comicDetails.value = comicToUiModel(comicsRepo.getComic().body())
            } catch (e: Exception){
                Timber.d("ERROR: ${e.toString()}")
            }
        }
    }
}