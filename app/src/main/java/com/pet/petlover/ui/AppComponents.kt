package com.pet.petlover.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pet.petlover.R
import com.pet.petlover.Utils
import com.pet.petlover.data.UserDataUiEvents

@Composable
fun TopBar(value: String) {
Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically) {
    Text(text = value,
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium
    )
    Spacer(modifier = Modifier.weight(1f))
    Image(
        modifier = Modifier.size(60.dp),
        painter = painterResource(id = R.drawable.logo),
        contentDescription ="Native Mobile Bits" )

}
}
@Preview
@Composable
fun TopBarPreview(){
 TopBar("Hi there \uD83D\uDE0A")
}

@Composable
fun TextComponent(textValue:String,
                  textSize: TextUnit,
                  colorValue: Color = Color.Black) {
    Text(text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}
@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(textValue = "\"Native Mobile Bits\"", textSize = 24.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponnet(
    onTextChanged : (name:String)-> Unit )
{
    var currentValue by remember {
        mutableStateOf("")
    }
    val localfocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier= Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions{
                localfocusManager.clearFocus()
        }

    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponnetPreview() {
    TextFieldComponnet(onTextChanged = {
    })
}

@Composable
fun AnimalCard(image: Int,
               animalSelected: (animalName: String) -> Unit, selected : Boolean,) {
    val localfocusManager = LocalFocusManager.current

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Blue else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ){
        Image(modifier= Modifier
            .padding(16.dp)
            .fillMaxSize()
            .wrapContentHeight()
            .wrapContentWidth()
            .clickable {
                val animalName = if (image == R.drawable.cat) "Cat" else "Dog"
                animalSelected(animalName)
                localfocusManager.clearFocus()
            },
            painter = painterResource(image),
            contentDescription ="Cat image")
    }
    }
}

@Preview
@Composable
fun AnimalCardPreview(){
    AnimalCard(R.drawable.cat, {"Dog"},false )
}

@Composable
fun ButtonComponent(goToDetailsScreen : () -> Unit)
{
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailsScreen()
        }){
        TextComponent(textValue = "Go to Details Screen",
            textSize = 18.sp,
            colorValue = Color.White
        )
    }
}

@Composable
fun TextWithShadow(value: String)
{
    val shadowOffset = Offset(x = 1f, y = 2f)
    Text(text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomColor(), shadowOffset, 2f))
        )
}

@Composable
fun FactComposable(value: String) {
    Card(modifier = Modifier
        .padding(32.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column(modifier = Modifier.padding(18.dp,24.dp)) {
            Image(painter = painterResource(id = R.drawable.quation),
                contentDescription ="Quote Image",
                modifier = Modifier.rotate(180f)
            )
            Spacer(modifier = Modifier.size(24.dp))
            TextWithShadow(value = value)
            Spacer(modifier = Modifier.size(24.dp))
            Image(painter = painterResource(id = R.drawable.quation),
                contentDescription ="Quote Image",

            )
        }
    }
}

@Preview
@Composable
fun FactComposablePreview(){
    FactComposable(value = "String")
}