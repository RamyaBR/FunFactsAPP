package com.pet.petlover.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pet.petlover.ui.FactComposable
import com.pet.petlover.ui.FactsViewModel
import com.pet.petlover.ui.TextComponent
import com.pet.petlover.ui.TextWithShadow
import com.pet.petlover.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?)
{
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(value = "Weelcome $username \uD83D\uDE0D")
            TextComponent(textValue = "Thank you! for sharing your data", textSize = 24.sp)

            Spacer(modifier = Modifier.size(60.dp))
            val finalText = if(animalSelected == "Cat") "You are a Cat Lover \uD83D\uDE3E" else "You are a Dog Lover \uD83D\uDC36"
            TextWithShadow(finalText)

            val factsViewModel : FactsViewModel = viewModel()
            FactComposable(
                value = factsViewModel.generateRandomFact(animalSelected!!))

        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("Ramya", "Cat")
}