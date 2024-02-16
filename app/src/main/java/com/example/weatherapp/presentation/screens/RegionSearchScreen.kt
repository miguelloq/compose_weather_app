package com.example.weatherapp.presentation.screens

import android.annotation.SuppressLint
import android.graphics.Region
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.presentation.components.region.PossibleRegionsList
import com.example.weatherapp.presentation.viewmodel.RegionViewmodel



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegionSearchScreen(
    navController: NavController,
    viewModel: RegionViewmodel = hiltViewModel<RegionViewmodel>()
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            SearchBar(
                query = "a",
                onQueryChange = {},
                onSearch = {},
                active = true,
                onActiveChange = {},
                leadingIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Return to Weather Screen" )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search possible regions")
                    }
                }
            ) {
                if(state.isLoading){
                    Column {
                        CircularProgressIndicator(Modifier.align(CenterHorizontally))
                    }
                } else if (state.error.isNotBlank()){
                    Column {
                        Text("Erro encontrado. Erro: ${state.error}", Modifier.align(CenterHorizontally))
                    }
                }else{
                    PossibleRegionsList(regions = state.regions)
                }
            }
        }
    ){}
}



