package com.pet.petlover.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pet.petlover.R
import com.pet.petlover.data.UserDataUiEvents
import com.pet.petlover.ui.AnimalCard
import com.pet.petlover.ui.ButtonComponent
import com.pet.petlover.ui.TextComponent
import com.pet.petlover.ui.TextFieldComponnet
import com.pet.petlover.ui.TopBar
import com.pet.petlover.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, showWelcomeScreen: (pair : Pair<String, String> ) -> Unit){
Surface(modifier = Modifier
    .fillMaxSize()) {
  Column(
      modifier = Modifier
          .fillMaxSize()
          .padding(18.dp)
  ) {
      TopBar("Hi there \uD83D\uDE0A")

      TextComponent(textValue = "Let's learn about you !", textSize =24.sp )

      Spacer(modifier = Modifier.size(20.dp))

      TextComponent(textValue = "This app will prepare a details page based on input provided by you !",
          textSize =18.sp )

      Spacer(modifier = Modifier.size(60.dp))

      TextComponent(textValue = "Name", textSize = 18.sp )
      Spacer(modifier = Modifier.size(10.dp))

      TextFieldComponnet(onTextChanged = {
          userInputViewModel.onEvent(
              UserDataUiEvents.UserNameEntered(it)
          )
      })

      Spacer(modifier = Modifier.size(20.dp))

      TextComponent(textValue = "What do you like", textSize = 18.sp )

      Row(
          modifier = Modifier.fillMaxWidth()
      ) {
            AnimalCard(image = R.drawable.cat, animalSelected = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.AnimalSelected(it)
                )
            }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")
          AnimalCard(image = R.drawable.dog, animalSelected = {
              userInputViewModel.onEvent(
                  UserDataUiEvents.AnimalSelected(it)
              )
          }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")

      }

      Spacer(modifier = Modifier.weight(1f))
      if (userInputViewModel.isValidState())
      {
          ButtonComponent(goToDetailsScreen = {
              showWelcomeScreen(Pair(
               userInputViewModel.uiState.value.nameEntered,
                  userInputViewModel.uiState.value.animalSelected
              ))
            //WelcomeScreen(username ="Ramya" , animalSelected ="Dog" )
         })
     }
  }
}
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(UserInputViewModel()) {
       // navController.navigate(Routes.WELCOME_SCREEN + "/${it.first}/${it.second}")
    }
}