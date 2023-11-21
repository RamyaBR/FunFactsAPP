package com.pet.petlover.ui

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    fun generateRandomFact(selectedAnimal: String) : String{
        return if(selectedAnimal == "Dog") {
            getDogFacts().random()
        }else{
            getCatFacts().random()
        }
    }

    fun getDogFacts(): List<String>{
        val dogFacts = listOf(
            "Dogs are the most popular pet on the planet! A third of ALL households around the world have a dog. ",
            "Their sense of smell is at least 40x better than ours",
            "Some have such good noses they can sniff out medical problems",
            "Dogs can sniff at the same time as breathing",
            "Some dogs are incredible swimmers",
            "They can learn over 100 words and gestures!. Dogs are thought to be as smart as two-year-old children (and much easier to train!), so many owners teach them commands and tricks."
        )
        return dogFacts
    }

    fun getCatFacts(): List<String>{
        val catFacts = listOf("Cats can see up to 120 feet away. Their peripheral vision is about 280 degrees" ,
                "The largest breed of cat is the Ragdoll. Males weigh 12-20 pounds, with females weighing 10-15 pounds",
                "Compared to a dog’s 10 vocalisation sounds (approx), cats have 100 different vocalization sounds",
                "Cats are the sleepiest of all mammals. They spend an average of 16 hours sleeping each day",
                "A cat will almost never “meow”\u009D at another cat. This sound is mostly reserved for humans",
                "Cats can see in colour – they are partially colour blind")
        return catFacts
    }
}