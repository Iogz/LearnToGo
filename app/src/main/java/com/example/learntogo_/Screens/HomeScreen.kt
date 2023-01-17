import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learntogo_.Destination
import com.example.learntogo_.R
import com.example.learntogo_.ui.theme.*

@Composable
fun HomeScreen(navHostController: NavHostController,
               color: Color = BlueViolet2
)  {

    //by: a delegated property. You are delegating your method calls to that which is to the right of the by operator
    val bottomState by remember { mutableStateOf("LearnToGo" ) }

    Scaffold(

        content = {
            Box(
                modifier = Modifier
                    .background(BlueViolet1)
                    .fillMaxSize(),
                Alignment.TopStart
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(15.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color)
                        .padding(horizontal = 15.dp, vertical = 20.dp)
                        .fillMaxWidth()) {
                    Column(Modifier.verticalScroll(rememberScrollState())) {

                        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.unnamed), contentDescription = "logo")

                        Text(
                            text = bottomState,
                            style = MaterialTheme.typography.h2,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = learnprio,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = learnCompany1,
                            fontSize = 20.sp
                        )
                        Text (
                            text = learnCompany2,
                            fontSize = 20.sp
                            )
                        Text (
                            text = learnCompany3,
                            fontSize = 20.sp,
                        )
                        Text (
                            text = learnCompany4,
                            fontSize = 20.sp,
                        )
                    }
                }
            }
        },

        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                backgroundColor = BlueViolet1
            ) {

                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { navHostController.navigate(Destination.Home.route) },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Account",
                    onClick = { navHostController.navigate(Destination.Account.route) },
                    label = { Text(text = "Account") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    }
                )

                BottomNavigationItem(
                    selected = bottomState == "Location",
                    onClick = { navHostController.navigate(Destination.Location.route) },
                    label = { Text(text = "Location") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    )
}

