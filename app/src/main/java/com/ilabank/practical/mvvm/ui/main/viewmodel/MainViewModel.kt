package com.ilabank.practical.mvvm.ui.main.viewmodel

import android.text.TextUtils
import androidx.lifecycle.*
import com.ilabank.practical.mvvm.R
import com.ilabank.practical.mvvm.data.model.Animal
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val animalList = ArrayList<Animal>()
    private val _animal = MutableLiveData<List<Animal>>()
    val animal: LiveData<List<Animal>>
        get() = _animal

    private val animalBreedsList = ArrayList<Animal>()
    private val _animalBreeds = MutableLiveData<List<Animal>>()
    val animalBreeds: LiveData<List<Animal>>
        get() = _animalBreeds

    init {
        fetchAnimals()
    }

    private fun fetchAnimals() {
        viewModelScope.launch {
            animalList.add(Animal("Dog", R.drawable.dog))
            animalList.add(Animal("Cat", R.drawable.cat))
            animalList.add(Animal("Horse", R.drawable.horse))
            animalList.add(Animal("Dog", R.drawable.dog))
            animalList.add(Animal("Cat", R.drawable.cat))
            animalList.add(Animal("Horse", R.drawable.horse))
            animalList.add(Animal("Dog", R.drawable.dog))
            animalList.add(Animal("Cat", R.drawable.cat))
            animalList.add(Animal("Horse", R.drawable.horse))
            animalList.add(Animal("Dog", R.drawable.dog))
            animalList.add(Animal("Cat", R.drawable.cat))
            animalList.add(Animal("Horse", R.drawable.horse))
            animalList.add(Animal("Dog", R.drawable.dog))
            animalList.add(Animal("Cat", R.drawable.cat))
            animalList.add(Animal("Horse", R.drawable.horse))
            _animal.postValue(animalList)
        }
    }

    fun fetchAnimalBreeds(animal: String) {
        viewModelScope.launch {
            animalBreedsList.clear()
            if (TextUtils.equals(animal, "Dog")) {
                animalBreedsList.add(Animal("Dog 1", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 2", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 3", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 4", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 5", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 6", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 7", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 8", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 9", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 10", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 11", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 12", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 13", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 14", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 15", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 16", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 17", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 18", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 19", R.drawable.dog))
                animalBreedsList.add(Animal("Dog 20", R.drawable.dog))
            }
            if (TextUtils.equals(animal, "Cat")) {
                animalBreedsList.add(Animal("Cat 1", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 2", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 3", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 4", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 5", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 6", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 7", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 8", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 9", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 10", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 11", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 12", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 13", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 14", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 15", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 16", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 17", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 18", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 19", R.drawable.cat))
                animalBreedsList.add(Animal("Cat 20", R.drawable.cat))
            }
            if (TextUtils.equals(animal, "Horse")) {
                animalBreedsList.add(Animal("Horse 1", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 2", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 3", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 4", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 5", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 6", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 7", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 8", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 9", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 10", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 11", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 12", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 13", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 14", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 15", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 16", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 17", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 18", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 19", R.drawable.horse))
                animalBreedsList.add(Animal("Horse 20", R.drawable.horse))
            }
            _animalBreeds.postValue(animalBreedsList)
        }
    }
}